package com.livethegame.Monitoring.controller;

import com.livethegame.Monitoring.dto.LogRecordRequest;
import com.livethegame.Monitoring.dto.LogRecordsResponse;
import com.livethegame.Monitoring.services.LogRecordsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Api(tags = "Api Monitoring")
@RestController
@RequestMapping("/monitoring")
public class MonitoringRestController {

    @Autowired
    LogRecordsService logRecordsService;

    @PostMapping("/create-log")
    public ResponseEntity<?> createLog(@RequestBody LogRecordRequest input) {
        try {
            LogRecordsResponse logRecordsResponse = logRecordsService.createLog(input);
            return ResponseEntity.ok(logRecordsResponse);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error interno del servidor");
        }
    }

    @GetMapping("/list-logs")
    public ResponseEntity<?> listLogs(){
        try {
            List<LogRecordsResponse> logRecordsResponse = logRecordsService.listLogs();
            return ResponseEntity.ok(logRecordsResponse);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error interno del servidor");
        }
    }

    @GetMapping("/list-logs-by-type/{id}")
    public ResponseEntity<?> listLogsByType(@PathVariable String id){
        Long idType;
        try {
            idType = Long.parseLong(id);
            List<LogRecordsResponse> logRecordsResponse = logRecordsService.listLogsByType(idType);
            return ResponseEntity.ok(logRecordsResponse);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id tipo inválido: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error interno del servidor");
        }
    }
}
