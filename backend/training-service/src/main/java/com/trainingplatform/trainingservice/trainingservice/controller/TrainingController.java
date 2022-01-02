package com.trainingplatform.trainingservice.trainingservice.controller;

import com.trainingplatform.trainingservice.trainingservice.model.entity.TrainingModel;
import com.trainingplatform.trainingservice.trainingservice.model.mapper.TrainingModelMapper;
import com.trainingplatform.trainingservice.trainingservice.model.response.TrainingResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/training")
public class TrainingController extends BaseController {

    private final TrainingService trainingService;
    private final TrainingModelMapper trainingModelMapper;

    @GetMapping("/getAllTrainings")
    public ResponseEntity<HashMap<String, Object>> getAllTrainings() {
        try {
            List<TrainingResponseDTO> trainings = trainingService.getAllTrainings();
            return ResponseEntity.ok(createReturnObj("Trainings fetched successfully!", trainings));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<HashMap<String, Object>> getTrainingModelById(@PathVariable Long id){
        try {
            TrainingModel training = trainingService.getTrainingById(id);
            TrainingResponseDTO trainingDTO = trainingModelMapper.mapToDto(training);
            return ResponseEntity.ok(createReturnObj(String.format("Training fetched successfully by id %d!", id), trainingDTO));
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
}

