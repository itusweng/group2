package com.trainingplatform.trainingservice.trainingservice.communication;

import com.trainingplatform.trainingservice.trainingservice.model.response.UserResponseDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name="user-service")
public interface TrainingClient {

    @PostMapping("/api/user/getTrainingCreatedUsersByID")
    public ResponseEntity<Map<Long, UserResponseDTO>> getTrainingCreatedUsersByID(Map<Long, Long>  userIDs);
}
