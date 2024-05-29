package com.livethegame.Monitoring.services;

import com.livethegame.Monitoring.Utils.Mapper;
import com.livethegame.Monitoring.common.LogRecordsRequestMapper;
import com.livethegame.Monitoring.common.ServicesUrlRequestMapper;
import com.livethegame.Monitoring.common.ServicesUrlResponseMapper;
import com.livethegame.Monitoring.dto.*;
import com.livethegame.Monitoring.entities.ServicesUrl;
import com.livethegame.Monitoring.entities.Types;
import com.livethegame.Monitoring.exception.ServiceNotFoundException;
import com.livethegame.Monitoring.repository.ServicesUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ServicesUrlService {

    @Autowired
    ServicesUrlRepository servicesUrlRepository;
    @Autowired
    ServicesUrlRequestMapper servicesUrlRequestMapper;
    @Autowired
    ServicesUrlResponseMapper servicesUrlResponseMapper;

    public ServicesUrlResponse registerService(ServicesUrlRequest servicesUrlRequest){
        ServicesUrl ServicesUrlRequesToServicesUrl = servicesUrlRequestMapper.ServicesUrlRequesToServicesUrl(servicesUrlRequest);
        ServicesUrlRequesToServicesUrl.initialize();
        ServicesUrl save = servicesUrlRepository.save(ServicesUrlRequesToServicesUrl);
        ServicesUrlResponse ServicesUrlToServicesUrlResponse = servicesUrlResponseMapper.ServicesUrlToServicesUrlResponse(save);
        return ServicesUrlToServicesUrlResponse;
    }

    public ServicesUrlResponse updateService(Long id, ServicesUrlUpdateRequest input) {
        Optional<ServicesUrl> optionalServicesUrl = servicesUrlRepository.findById(id);
        if (optionalServicesUrl.isEmpty()) {
            throw new ServiceNotFoundException("No se encontro el registro con ID: " + id);
        }
        ServicesUrl servicesUrl = optionalServicesUrl.get();
        servicesUrl.setActive(input.getActive());
        servicesUrl.setName(input.getName());
        servicesUrl.setUrl(input.getUrl());
        ServicesUrl save = servicesUrlRepository.save(servicesUrl);
        ServicesUrlResponse ServicesUrlToServicesUrlResponse = servicesUrlResponseMapper.ServicesUrlToServicesUrlResponse(save);
        return ServicesUrlToServicesUrlResponse;
    }

    public List<ServicesUrlResponse> listServices(){
        List<ServicesUrl> ServicesUrlList = servicesUrlRepository.findAll();
        List<ServicesUrlResponse> servicesUrlResponseList
                = servicesUrlResponseMapper.ServicesUrlListToServicesUrlResponseList(ServicesUrlList);
        return servicesUrlResponseList;

    }
    public List<ServicesStatusResponse> testServices(){
        List<ServicesUrl> servicesUrlList = servicesUrlRepository.findByActive(true);
        List<ServicesStatusResponse> servicesStatusResponseList = new ArrayList<>();
        servicesUrlList.forEach(servicesUrl -> {
            String status = testService(servicesUrl.getUrl());
            ServicesStatusResponse servicesStatusResponse= Mapper.serviceUrlToServiceStatusResponse(servicesUrl,status);
            servicesStatusResponseList.add(servicesStatusResponse);
        });
        return servicesStatusResponseList;

    }
    private String testService(String url){
        try {
            WebClient webClient = WebClient.builder()
                    .baseUrl(url)
                    .defaultHeader(HttpHeaders.AUTHORIZATION, "Basic " + encodeCredentials("admin", "admin"))
                    .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .build();
            RequestBodySpec request = webClient.method(HttpMethod.GET);
            ResponseSpec responseSpec = request.retrieve();
            Mono<String> responseBodyMono = responseSpec.bodyToMono(String.class);
            HttpStatus httpStatus = responseSpec.toBodilessEntity().block().getStatusCode();
            String statusCode = httpStatus != null ? String.valueOf(httpStatus.value()) : "Estado desconocido";
            return statusCode;
        }catch (Exception e){
            return "500";
        }

    }
    private String encodeCredentials(String username, String password) {
        return Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
    }
}
