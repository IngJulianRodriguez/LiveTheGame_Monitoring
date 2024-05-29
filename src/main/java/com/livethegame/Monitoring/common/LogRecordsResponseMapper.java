package com.livethegame.Monitoring.common;

import com.livethegame.Monitoring.dto.LogRecordsResponse;
import com.livethegame.Monitoring.entities.LogRecords;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface LogRecordsResponseMapper {
    LogRecordsResponse LogRecordsToLogRecordsResponse(LogRecords source);
    List<LogRecordsResponse> LogRecordsListToLogRecordsResponseList(List<LogRecords> source);
}
