package com.livethegame.Monitoring.common;

import com.livethegame.Monitoring.dto.LogRecordRequest;
import com.livethegame.Monitoring.entities.LogRecords;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface LogRecordsRequestMapper {
    LogRecords LogRecordsRequesToLogRecord(LogRecordRequest source);
}
