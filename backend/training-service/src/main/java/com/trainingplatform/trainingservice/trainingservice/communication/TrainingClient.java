package com.trainingplatform.trainingservice.trainingservice.communication;

import com.trainingplatform.trainingservice.trainingservice.model.response.UserResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@FeignClient(name="user-service")
public interface TrainingClient {

    @GetMapping("/api/user/getAllUsers")
    public UserResponseDTO getAllUserDTO();

    @PostMapping("/api/user/getUsersByID")
    public Map<UUID, UserResponseDTO> getUsersByID(@RequestBody List<UUID> userIDs);
}
