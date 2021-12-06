package com.trainingplatform.userservice.controller;

import com.trainingplatform.userservice.exceptions.UserNotCreatedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.resource.OAuth2AccessDeniedException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Map;

@RestController
public abstract class BaseController {

    public HashMap<String, Object> createReturnObj(String message) {
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("message", message);
        return (HashMap<String, Object>) returnMap;
    }

    public HashMap<String, Object> createReturnObj(String message, Object obj) {
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("message", message);
        returnMap.put("data", obj);
        return (HashMap<String, Object>) returnMap;
    }

    public ResponseEntity exceptionHandler(Exception e) {

        if (e instanceof EntityNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(createReturnObj(e.getMessage()));
        }
        else if(e instanceof UserNotCreatedException){
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(createReturnObj(e.getMessage()));
        }
        else if(e instanceof HttpClientErrorException.Unauthorized){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(createReturnObj(e.getMessage()));
        }
        else if(e instanceof OAuth2AccessDeniedException){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(createReturnObj(e.getMessage()));
        }

        // Return default exception
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(createReturnObj("An error is occured!"));
    }
}
