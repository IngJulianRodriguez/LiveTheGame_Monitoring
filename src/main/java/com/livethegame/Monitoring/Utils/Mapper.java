package com.livethegame.Monitoring.Utils;
import com.livethegame.Monitoring.dto.LogRecordRequest;
import com.livethegame.Monitoring.dto.ServicesStatusResponse;
import com.livethegame.Monitoring.entities.LogRecords;
import com.livethegame.Monitoring.entities.ServicesUrl;
import com.livethegame.Monitoring.entities.Types;
import com.livethegame.Monitoring.repository.TypesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public  class Mapper {
    public static ServicesStatusResponse serviceUrlToServiceStatusResponse(ServicesUrl source, String state){
        ServicesStatusResponse servicesStatusResponse = new ServicesStatusResponse();
        servicesStatusResponse.setId(source.getId());
        servicesStatusResponse.setName(source.getName());
        servicesStatusResponse.setUrl(source.getUrl());
        servicesStatusResponse.setStatus(state);
        return servicesStatusResponse;
    };
}
