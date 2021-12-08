package com.trainingplatform.trainingservice.trainingservice.controller;

import com.trainingplatform.trainingservice.trainingservice.model.TrainingModel;
import com.trainingplatform.trainingservice.trainingservice.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

;import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/training")
public class TrainingController extends BaseController {

    private final TrainingService trainingService;

    @GetMapping("/getAllTrainings")
    public ResponseEntity getUserByUsername() {
        try {
            List<TrainingModel> trainings = trainingService.getAllTrainings();
            return ResponseEntity.ok(createReturnObj("Trainings fetched successfully!", trainings));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }


}

