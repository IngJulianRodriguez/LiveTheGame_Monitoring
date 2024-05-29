package com.livethegame.Monitoring.services;

import com.livethegame.Monitoring.common.LogRecordsRequestMapper;
import com.livethegame.Monitoring.common.LogRecordsResponseMapper;
import com.livethegame.Monitoring.dto.LogRecordRequest;
import com.livethegame.Monitoring.dto.LogRecordsResponse;
import com.livethegame.Monitoring.entities.LogRecords;
import com.livethegame.Monitoring.entities.Types;
import com.livethegame.Monitoring.repository.LogRecordsRepository;
import com.livethegame.Monitoring.repository.TypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogRecordsService {

    @Autowired
    LogRecordsRepository logRecordsRepository;
    @Autowired
    TypesRepository typesRepository;
    @Autowired
    LogRecordsResponseMapper logRecordsResponseMapper;
    @Autowired
    LogRecordsRequestMapper logRecordsRequestMapper;

    public LogRecordsResponse createLog(LogRecordRequest logRecordRequest){
        LogRecords logRecordsRequesToLogRecord = logRecordsRequestMapper.LogRecordsRequesToLogRecord(logRecordRequest);
        Optional<Types> optionalTypes = typesRepository.findById(logRecordRequest.getType_id());
        logRecordsRequesToLogRecord.setType(optionalTypes.get());
        LogRecords save = logRecordsRepository.save(logRecordsRequesToLogRecord);
        LogRecordsResponse logRecordsToLogRecordsResponse = logRecordsResponseMapper.LogRecordsToLogRecordsResponse(save);
        return logRecordsToLogRecordsResponse;
    }

    public List<LogRecordsResponse> listLogs(){
        List<LogRecords> logRecordsList = logRecordsRepository.findAll();
        List<LogRecordsResponse> logRecordsResponseList
                = logRecordsResponseMapper.LogRecordsListToLogRecordsResponseList(logRecordsList);
        return logRecordsResponseList;

    }
    public List<LogRecordsResponse> listLogsByType(Long typeId){
        List<LogRecords> logRecordsList = logRecordsRepository.findByTypeId(typeId);
        List<LogRecordsResponse> logRecordsResponseList
                = logRecordsResponseMapper.LogRecordsListToLogRecordsResponseList(logRecordsList);
        return logRecordsResponseList;

    }
}
