package com.trainingplatform.trainingservice.trainingservice.controller;

import com.trainingplatform.trainingservice.trainingservice.model.TrainingModel;
import com.trainingplatform.trainingservice.trainingservice.model.response.TrainingResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/training")
public class TrainingController extends BaseController {

    private final TrainingService trainingService;

    @GetMapping("/getAllTrainings")
    public ResponseEntity<HashMap<String, Object>> getAllTrainings() {
        try {
            List<TrainingResponseDTO> trainings = trainingService.getAllTrainings();
            return ResponseEntity.ok(createReturnObj("Trainings fetched successfully!", trainings));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @PostMapping("/")
    public ResponseEntity<HashMap<String, Object>> createTraining(@RequestBody TrainingModel training) {
        try {
            // TODO: test error cases
            TrainingResponseDTO new_training = trainingService.createTraining(training);
            return ResponseEntity.ok(createReturnObj("Training created successfully!", new_training));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @DeleteMapping("/{trainingId}")
    public ResponseEntity<HashMap<String, Object>> deleteTraining(@PathVariable Long trainingId) {
        try {
            trainingService.deleteTraining(trainingId);
            return ResponseEntity.ok(createReturnObj("Training deleted successfully!", null));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @PostMapping("/{trainingId}/participant")
    public ResponseEntity<HashMap<String, Object>> addParticipantToTraining(@PathVariable Long trainingId, @RequestBody Map<String, List<Long>> requestDTO) {
        try {
            Map<Long, Boolean> participationResultMap = trainingService.addParticipantToTraining(trainingId, requestDTO.get("users"));
            return ResponseEntity.ok(createReturnObj("Check data to see which users participated successfully! ", participationResultMap));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }


}

