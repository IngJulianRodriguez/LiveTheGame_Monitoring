package com.livethegame.Monitoring.controller;

import com.livethegame.Monitoring.dto.*;
import com.livethegame.Monitoring.services.LogRecordsService;
import com.livethegame.Monitoring.services.ServicesUrlService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Api(tags = "Api TestServices")
@RestController
@RequestMapping("/test-service")
public class TestServicesRestController {


    @Autowired
    ServicesUrlService servicesUrlService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody ServicesUrlRequest input) {
        try {
            ServicesUrlResponse servicesUrlResponse = servicesUrlService.registerService(input);
            return ResponseEntity.ok(servicesUrlResponse);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error interno del servidor");
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> list(){
        try {
            List<ServicesUrlResponse> servicesUrlResponse = servicesUrlService.listServices();
            return ResponseEntity.ok(servicesUrlResponse);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error interno del servidor");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody ServicesUrlUpdateRequest input){
        Long idService;
        try {
            idService = Long.parseLong(id);
            ServicesUrlResponse servicesUrlResponse = servicesUrlService.updateService(idService, input);
            return ResponseEntity.ok(servicesUrlResponse);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id registro inválido: " + id);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error interno del servidor");
        }
    }

    @GetMapping("/test")
    public ResponseEntity<?> test(){
        try {
            List<ServicesStatusResponse> servicesStatusResponse = servicesUrlService.testServices();
            return ResponseEntity.ok(servicesStatusResponse);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error interno del servidor");
        }
    }
}
