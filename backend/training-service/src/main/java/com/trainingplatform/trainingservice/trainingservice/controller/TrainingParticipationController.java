package com.trainingplatform.trainingservice.trainingservice.controller;

import com.trainingplatform.trainingservice.trainingservice.model.request.TrainingParticipationRequestDTO;
import com.trainingplatform.trainingservice.trainingservice.service.TrainingParticipationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/training")
public class TrainingParticipationController extends BaseController {

    private final TrainingParticipationService participationService;

    @PostMapping("/{trainingId}/participant")
    public ResponseEntity<HashMap<String, Object>> addParticipantToTraining(@PathVariable Long trainingId, @RequestBody Map<String, List<Long>> requestDTO) {
        try {
            // TODO: CHECK QUOTA OF TRAINING BEFORE ADDING PARTICIPANT
            Map<Long, Boolean> participationResultMap = participationService.addParticipantToTraining(trainingId, requestDTO.get("users"));
            return ResponseEntity.ok(createReturnObj("Check data to see which users participated successfully! ", participationResultMap));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @PostMapping("/participationRequest")
    public ResponseEntity<Map<String, Object>> requestForParticipation(@RequestBody TrainingParticipationRequestDTO requestDTO) {
        try {
            // TODO: CHECK QUOTA OF TRAINING BEFORE SENDING PARTICIPATION REQUEST
            participationService.requestParticipation(requestDTO.getTrainingId(), requestDTO.getUserId());
            return ResponseEntity.ok(createReturnObj("Participation request is send!", null));
        } catch (Exception e) {
            return  exceptionHandler(e);
        }
    }
}
