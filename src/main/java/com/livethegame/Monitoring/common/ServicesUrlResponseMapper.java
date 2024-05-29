package com.livethegame.Monitoring.common;

import com.livethegame.Monitoring.dto.ServicesUrlResponse;
import com.livethegame.Monitoring.entities.ServicesUrl;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface ServicesUrlResponseMapper {
    ServicesUrlResponse ServicesUrlToServicesUrlResponse(ServicesUrl source);
    List<ServicesUrlResponse> ServicesUrlListToServicesUrlResponseList(List<ServicesUrl> source);
}
