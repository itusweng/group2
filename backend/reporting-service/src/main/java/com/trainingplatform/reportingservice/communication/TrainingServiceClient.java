package com.trainingplatform.reportingservice.communication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;


@FeignClient(name="training-service")
public interface TrainingServiceClient {

    @GetMapping("/api/training/participation/{trainingId}/participant/getIds")
    ResponseEntity<List<Long>> getAllParticipantIdsByTrainingId(@PathVariable Long trainingId);

    @GetMapping("/api/training/{id}")
    ResponseEntity<HashMap<String, Object>> getTrainingModelById(@PathVariable Long id);

}
