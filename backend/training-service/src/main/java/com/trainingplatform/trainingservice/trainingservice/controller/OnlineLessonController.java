package com.trainingplatform.trainingservice.trainingservice.controller;

import com.trainingplatform.trainingservice.trainingservice.model.OnlineLessonModel;
import com.trainingplatform.trainingservice.trainingservice.model.mapper.OnlineLessonModelMapper;
import com.trainingplatform.trainingservice.trainingservice.model.request.OnlineLessonRequestDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.OnlineLessonResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.repository.OnlineLessonRepository;
import com.trainingplatform.trainingservice.trainingservice.repository.TrainingRepository;
import com.trainingplatform.trainingservice.trainingservice.service.OnlineLessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/training/onlineLesson")
public class OnlineLessonController extends BaseController{
    private final OnlineLessonService onlineLessonService;
    private final OnlineLessonModelMapper onlineLessonModelMapper;
    private final OnlineLessonRepository onlineLessonRepo;
    private final TrainingRepository trainingRepo;

    @GetMapping("/getAllLessons/{trainingId}")
    public ResponseEntity<HashMap<String, Object>> getAllTrainings(@PathVariable Long trainingId) {
        try {
            List<OnlineLessonResponseDTO> onlineLessons = onlineLessonService.getOnlineLessons(trainingId);
            return ResponseEntity.ok(createReturnObj("Online lessons fetched successfully!", onlineLessons));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @PostMapping("/")
    public ResponseEntity<HashMap<String, Object>> createOnlineLesson(@RequestBody OnlineLessonRequestDTO onlineLessonRequestDTO) {
        OnlineLessonModel onlineLesson = onlineLessonModelMapper.mapToEntity(onlineLessonRequestDTO);
        onlineLesson.setTraining(trainingRepo.getById(onlineLessonRequestDTO.getTraining_id()));
        try {
            // TODO: test error cases
            OnlineLessonResponseDTO new_onlineLesson = onlineLessonService.createOnlineLesson(onlineLesson);
            return ResponseEntity.ok(createReturnObj("Online Lesson created successfully!", new_onlineLesson));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @PostMapping("/update/{onlineLessonId}")
    public void updateOnlineLesson(@PathVariable Long onlineLessonId, @RequestBody OnlineLessonRequestDTO onlineLesson){
        try{
            OnlineLessonModel existingOnlineLesson = onlineLessonRepo.findById(onlineLessonId).get();
            onlineLessonModelMapper.updateFields(existingOnlineLesson, onlineLesson);
            onlineLessonRepo.save(existingOnlineLesson);
        }
        catch (Exception e){
            System.out.println(exceptionHandler(e));
        }
    }

    @DeleteMapping("/{onlineLessonId}")
    public ResponseEntity<HashMap<String, Object>> deleteOnlineLesson(@PathVariable Long onlineLessonId) {
        try {
            onlineLessonService.deleteOnlineLesson(onlineLessonId);
            return ResponseEntity.ok(createReturnObj("Online Lesson deleted successfully!", null));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }
}
