package com.trainingplatform.reportingservice.communication;

import com.trainingplatform.reportingservice.model.training.response.TrainingParticipantResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@FeignClient(name="user-service")
public interface UserServiceClient {

    @PostMapping("/api/user/byIdList/getUserModels")
    ResponseEntity<Map<String,Object>> getUserModelsByUserIdList(@RequestBody List<Long> userIds);
}
