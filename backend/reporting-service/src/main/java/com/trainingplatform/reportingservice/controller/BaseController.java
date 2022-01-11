package com.trainingplatform.reportingservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;

@RestController
public abstract class BaseController {

    public HashMap<String, Object> createReturnObj(String message) {
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("message", message);
        returnMap.put("data", null);
        return (HashMap<String, Object>) returnMap;
    }

    public HashMap<String, Object> createReturnObj(String message, Object obj) {
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("message", message);
        returnMap.put("data", obj);
        return (HashMap<String, Object>) returnMap;
    }

    public ResponseEntity<Map<String, Object>> exceptionHandler(Exception e) {

        if (e instanceof EntityNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(createReturnObj(e.getMessage()));
        }

        // Return default exception
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(createReturnObj("An error is occured!"));
    }
}