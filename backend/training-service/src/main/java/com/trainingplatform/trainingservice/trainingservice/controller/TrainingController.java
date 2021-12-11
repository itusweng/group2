package com.trainingplatform.trainingservice.trainingservice.controller;

import com.trainingplatform.trainingservice.trainingservice.communication.TrainingClient;
import com.trainingplatform.trainingservice.trainingservice.model.response.TrainingResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

;import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/training")
public class TrainingController extends BaseController {

    private final TrainingService trainingService;
    private final TrainingClient trainingClient;

    @GetMapping("/getAllTrainings")
    public ResponseEntity<HashMap<String, Object>> getUserByUsername() {
        try {
            List<TrainingResponseDTO> trainings = trainingService.getAllTrainings();
            return ResponseEntity.ok(createReturnObj("Trainings fetched successfully!", trainings));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

}

