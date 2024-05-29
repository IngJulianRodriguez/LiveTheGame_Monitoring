package com.livethegame.Monitoring.common;

import com.livethegame.Monitoring.dto.LogRecordRequest;
import com.livethegame.Monitoring.dto.ServicesUrlRequest;
import com.livethegame.Monitoring.entities.LogRecords;
import com.livethegame.Monitoring.entities.ServicesUrl;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ServicesUrlRequestMapper {
    ServicesUrl ServicesUrlRequesToServicesUrl(ServicesUrlRequest source);
}
