package com.trainingplatform.trainingservice.trainingservice.controller;

import com.trainingplatform.trainingservice.trainingservice.model.OfflineLessonModel;
import com.trainingplatform.trainingservice.trainingservice.model.TrainingModel;
import com.trainingplatform.trainingservice.trainingservice.model.mapper.OfflineLessonModelMapper;
import com.trainingplatform.trainingservice.trainingservice.model.request.OfflineLessonRequestDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.OfflineLessonResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.TrainingResponseDTO;
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

    @DeleteMapping("/{offlineLessonId}")
    public ResponseEntity<HashMap<String, Object>> deleteOfflineLesson(@PathVariable Long offlineLessonId) {
        try {
            offlineLessonService.deleteOfflineLesson(offlineLessonId);
            return ResponseEntity.ok(createReturnObj("Offline Lesson deleted successfully!", null));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @PostMapping("/{offlineLessonId}/updateTitle")
    @ResponseBody
    public ResponseEntity<HashMap<String, Object>> updateOfflineLessonTitle(@PathVariable Long offlineLessonId, @RequestParam("title") String offlineLessonTitle){
        try {
            // TODO: test error cases
            Integer updatedOfflineLesson = offlineLessonService.updateOfflineLessonTitle(offlineLessonId, offlineLessonTitle);
            return ResponseEntity.ok(createReturnObj(updatedOfflineLesson.toString()));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @PostMapping("/{offlineLessonId}/updateVideoLink")
    @ResponseBody
    public ResponseEntity<HashMap<String, Object>> updateOfflineLessonVideoLink(@PathVariable Long offlineLessonId, @RequestParam("offlineLessonVideoLink") String offlineLessonVideoLink){
        try {
            // TODO: test error cases
            Integer updatedOfflineLesson = offlineLessonService.updateOfflineLessonVideoLink(offlineLessonId, offlineLessonVideoLink);
            return ResponseEntity.ok(createReturnObj(updatedOfflineLesson.toString()));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @PostMapping("/{offlineLessonId}/updateFiles")
    @ResponseBody
    public ResponseEntity<HashMap<String, Object>> updateOfflineLessonFiles(@PathVariable Long offlineLessonId, @RequestParam("offlineLessonFiles") String offlineLessonFiles){
        try {
            // TODO: test error cases
            Integer updatedOfflineLesson = offlineLessonService.updateOfflineLessonFiles(offlineLessonId, offlineLessonFiles);
            return ResponseEntity.ok(createReturnObj(updatedOfflineLesson.toString()));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @PostMapping("/{offlineLessonId}/updateDescription")
    @ResponseBody
    public ResponseEntity<HashMap<String, Object>> updateOfflineLessonDescription(@PathVariable Long offlineLessonId, @RequestParam("offlineLessonDescription") String offlineLessonDescription){
        try {
            // TODO: test error cases
            Integer updatedOfflineLesson = offlineLessonService.updateOfflineLessonDescription(offlineLessonId, offlineLessonDescription);
            return ResponseEntity.ok(createReturnObj( updatedOfflineLesson.toString()));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

}
