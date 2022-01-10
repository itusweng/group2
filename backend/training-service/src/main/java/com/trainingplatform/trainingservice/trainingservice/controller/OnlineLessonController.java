package com.trainingplatform.trainingservice.trainingservice.controller;

import com.trainingplatform.trainingservice.trainingservice.model.entity.OnlineLessonModel;
import com.trainingplatform.trainingservice.trainingservice.model.mapper.OnlineLessonModelMapper;
import com.trainingplatform.trainingservice.trainingservice.model.request.offlinelesson.OnlineLessonRequestDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.onlinelesson.OnlineLessonResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.service.OnlineLessonService;
import com.trainingplatform.trainingservice.trainingservice.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/training/onlineLesson")
public class OnlineLessonController extends BaseController {

    private final TrainingService trainingService;
    private final OnlineLessonService onlineLessonService;
    private final OnlineLessonModelMapper onlineLessonModelMapper;

    @GetMapping("/getAllLessons/{trainingId}")
    public ResponseEntity<HashMap<String, Object>> getAllOnlineLessons(@PathVariable Long trainingId) {
        try {
            List<OnlineLessonResponseDTO> onlineLessons = onlineLessonService.getOnlineLessons(trainingId);
            return ResponseEntity.ok(createReturnObj("Online lessons fetched successfully!", onlineLessons));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @GetMapping("/getLesson/byId/{lessonId}")
    public ResponseEntity<HashMap<String, Object>> getOnlineLessonById(@PathVariable Long lessonId) {
        try {
            OnlineLessonModel onlineLessonModel = onlineLessonService.getOnlineLessonById(lessonId);
            OnlineLessonResponseDTO onlineLessonDTO = onlineLessonModelMapper.mapToDto(onlineLessonModel);
            return ResponseEntity.ok(createReturnObj("Online lessons fetched successfully!", onlineLessonDTO));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @PostMapping("/")
    public ResponseEntity<HashMap<String, Object>> createOnlineLesson(@RequestBody OnlineLessonRequestDTO onlineLessonRequestDTO) {
        try {
            OnlineLessonModel onlineLesson = onlineLessonModelMapper.mapToEntity(onlineLessonRequestDTO);
            onlineLesson.setTraining(trainingService.getTrainingById(onlineLessonRequestDTO.getTraining_id()));
            OnlineLessonResponseDTO new_onlineLesson = onlineLessonService.createOnlineLesson(onlineLesson);
            return ResponseEntity.ok(createReturnObj("Online Lesson created successfully!", new_onlineLesson));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @PostMapping("/update/{onlineLessonId}")
    public ResponseEntity<HashMap<String, Object>> updateOnlineLesson(@PathVariable Long onlineLessonId, @RequestBody OnlineLessonRequestDTO onlineLesson) {
        try {
            OnlineLessonModel onlineLessonModel = onlineLessonModelMapper.mapToEntity(onlineLesson);
            onlineLessonModel.setId(onlineLessonId);

            onlineLessonService.updateOnlineLesson(onlineLessonModel);
            return ResponseEntity.ok(
                    createReturnObj(String.format("Offline lesson updated by id successfully!", onlineLessonId), null));
        } catch (Exception e) {
            return exceptionHandler(e);
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
