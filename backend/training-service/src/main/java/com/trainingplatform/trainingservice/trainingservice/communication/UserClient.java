package com.trainingplatform.trainingservice.trainingservice.communication;

import com.trainingplatform.trainingservice.trainingservice.config.FeignRequestInterceptor;
import com.trainingplatform.trainingservice.trainingservice.model.response.UserResponseDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name="user-service",  configuration= FeignRequestInterceptor.class)
public interface UserClient {

    @PostMapping("/api/user/getTrainingUsersByID")
    ResponseEntity<Map<Long, UserResponseDTO>> getTrainingUsersByID(Map<Long, Long>  userIDs);

    @GetMapping("/api/user/byId/{userId}")
    ResponseEntity<Map<String, Object>> getUserByID(@PathVariable Long userId);

    @GetMapping("/api/user/isExists/byId/{userId}")
    ResponseEntity<Map<String, Object>> checkUserExistsByUserId(@PathVariable Long userId);

}
