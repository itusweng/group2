package com.trainingplatform.trainingservice.trainingservice.controller;

import com.trainingplatform.trainingservice.trainingservice.model.response.OfflineLessonResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.TrainingResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.service.OfflineLessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/training/offlineLesson")
public class OfflineLessonController extends BaseController{

    private final OfflineLessonService offlineLessonService;

    @GetMapping("/getAllOfflineLessons/{trainingID}")
    public ResponseEntity<HashMap<String, Object>> getAllTrainings(@PathVariable Long id) {
        try {
            List<OfflineLessonResponseDTO> offlineLessons = offlineLessonService.getOfflineLessons(id);
            return ResponseEntity.ok(createReturnObj("Offline lessons fetched successfully!", offlineLessons));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }


}
