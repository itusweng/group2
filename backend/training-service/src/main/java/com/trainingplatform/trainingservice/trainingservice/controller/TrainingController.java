package com.trainingplatform.trainingservice.trainingservice.controller;

import com.trainingplatform.trainingservice.trainingservice.model.TrainingModel;
import com.trainingplatform.trainingservice.trainingservice.model.response.TrainingResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/training")
public class TrainingController extends BaseController {

    private final TrainingService trainingService;

    @GetMapping("/getAllTrainings")
    public ResponseEntity<HashMap<String, Object>> getUserByUsername() {
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
}

