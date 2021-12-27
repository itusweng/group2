package com.trainingplatform.trainingservice.trainingservice.controller;

import com.trainingplatform.trainingservice.trainingservice.model.OfflineLessonModel;
import com.trainingplatform.trainingservice.trainingservice.model.mapper.OfflineLessonModelMapper;
import com.trainingplatform.trainingservice.trainingservice.model.request.OfflineLessonRequestDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.OfflineLessonResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.repository.OfflineLessonRepository;
import com.trainingplatform.trainingservice.trainingservice.repository.TrainingRepository;
import com.trainingplatform.trainingservice.trainingservice.service.OfflineLessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/training/offlineLesson")
public class OfflineLessonController extends BaseController{

    private final OfflineLessonService offlineLessonService;
    private final OfflineLessonModelMapper offlineLessonModelMapper;
    private final OfflineLessonRepository offlineLessonRepo;
    private final TrainingRepository trainingRepo;

    @GetMapping("/getAllLessons/{trainingId}")
    public ResponseEntity<HashMap<String, Object>> getAllTrainings(@PathVariable Long trainingId) {
        try {
            List<OfflineLessonResponseDTO> offlineLessons = offlineLessonService.getOfflineLessons(trainingId);
            return ResponseEntity.ok(createReturnObj("Offline lessons fetched successfully!", offlineLessons));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @PostMapping("/")
    public ResponseEntity<HashMap<String, Object>> createOfflineLesson(@RequestBody OfflineLessonRequestDTO offlineLessonRequestDTO) {
        OfflineLessonModel offlineLesson = offlineLessonModelMapper.mapToEntity(offlineLessonRequestDTO);
        offlineLesson.setTraining(trainingRepo.getById(offlineLessonRequestDTO.getTraining_id()));
        try {
            // TODO: test error cases
            OfflineLessonResponseDTO new_offlineLesson = offlineLessonService.createOfflineLesson(offlineLesson);
            return ResponseEntity.ok(createReturnObj("Offline Lesson created successfully!", new_offlineLesson));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @PostMapping("/update/{offlineLessonId}")
    public void updateOfflineLesson(@PathVariable Long offlineLessonId, @RequestBody OfflineLessonRequestDTO offlineLesson){
        try{
            OfflineLessonModel existingOfflineLesson = offlineLessonRepo.findById(offlineLessonId).get();
            offlineLessonModelMapper.updateFields(existingOfflineLesson, offlineLesson);
            offlineLessonRepo.save(existingOfflineLesson);
        }
        catch (Exception e){
            System.out.println(exceptionHandler(e));
        }
    }

    @DeleteMapping("/{offlineLessonId}")
    public ResponseEntity<HashMap<String, Object>> deleteOfflineLesson(@PathVariable Long offlineLessonId) {
        try {
            offlineLessonService.deleteOfflineLesson(offlineLessonId);
            return ResponseEntity.ok(createReturnObj("Offline Lesson deleted successfully!", null));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }
}
