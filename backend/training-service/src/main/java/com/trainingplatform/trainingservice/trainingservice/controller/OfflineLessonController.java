package com.trainingplatform.trainingservice.trainingservice.controller;

import com.trainingplatform.trainingservice.trainingservice.model.request.offlinelesson.OfflineLessonRequestDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.offlinelesson.OfflineLessonResponseDTO;
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
    @ResponseBody
    public ResponseEntity<HashMap<String, Object>> createOfflineLesson(@ModelAttribute OfflineLessonRequestDTO offlineLessonRequestDTO) {
        try {
            // TODO: test error cases
            OfflineLessonResponseDTO new_offlineLesson = offlineLessonService.createOfflineLesson(offlineLessonRequestDTO);
            return ResponseEntity.ok(createReturnObj("Offline Lesson created successfully!", new_offlineLesson));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @PostMapping("/update/{offlineLessonId}")
    public void updateOfflineLesson(@PathVariable Long offlineLessonId, @RequestBody OfflineLessonRequestDTO offlineLessonRequestDTO){
        try{
            offlineLessonService.updateOfflineLesson(offlineLessonId, offlineLessonRequestDTO);
        }
        catch (Exception e){
            System.out.println(exceptionHandler(e));
        }
    }

    @DeleteMapping("/{trainingId}/{offlineLessonId}")
    public ResponseEntity<HashMap<String, Object>> deleteOfflineLesson(@PathVariable Long trainingId, @PathVariable Long offlineLessonId) {
        try {
            offlineLessonService.deleteOfflineLesson(trainingId, offlineLessonId);
            return ResponseEntity.ok(createReturnObj("Offline Lesson deleted successfully!", null));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }
}
