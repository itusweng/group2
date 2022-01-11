package com.trainingplatform.trainingservice.trainingservice.controller;

import com.trainingplatform.trainingservice.trainingservice.model.request.trainingparticipation.ParticipationApproveRequestDTO;
import com.trainingplatform.trainingservice.trainingservice.model.request.trainingparticipation.ParticipationRejectRequestDTO;
import com.trainingplatform.trainingservice.trainingservice.model.request.trainingparticipation.ParticipationRequestDTO;
import com.trainingplatform.trainingservice.trainingservice.model.request.trainingparticipation.ParticipationPendingRequestsListAllRequestDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.trainingparticipation.ParticipationApproveResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.trainingparticipation.ParticipationRejectResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.trainingparticipation.PendingParticipationResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.service.TrainingParticipationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/training")
public class TrainingParticipationController extends BaseController {

    private final TrainingParticipationService participationService;

    @PostMapping("/participation/listAll")
    public ResponseEntity<Map<String, Object>> listAllParticipationRequests(@RequestBody ParticipationPendingRequestsListAllRequestDTO requestDTO) {
        try {
            List<PendingParticipationResponseDTO> requests = participationService.listAllPendingRequests(requestDTO);
            return ResponseEntity.ok(createReturnObj("Participation requests fetched!", requests));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @PostMapping("/{trainingId}/participant")
    public ResponseEntity<Map<String, Object>> addParticipantToTraining(@PathVariable Long trainingId, @RequestBody Map<String, List<Long>> requestDTO) {
        try {
            // TODO: CHECK QUOTA OF TRAINING BEFORE ADDING PARTICIPANT
            Map<Long, Boolean> participationResultMap = participationService.addParticipantsToTraining(trainingId, requestDTO.get("users"));
            return ResponseEntity.ok(createReturnObj("Check data to see which users participated successfully! ", participationResultMap));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @PostMapping("/participation/request")
    public ResponseEntity<Map<String, Object>> requestForParticipation(@RequestBody ParticipationRequestDTO requestDTO) {
        try {
            // TODO: CHECK QUOTA OF TRAINING BEFORE SENDING PARTICIPATION REQUEST
            participationService.requestParticipation(requestDTO.getTrainingId(), requestDTO.getUserId());
            return ResponseEntity.ok(createReturnObj("Participation request is send!", null));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @PostMapping("/participation/approve")
    public ResponseEntity<Map<String, Object>> approveParticipationRequest(@RequestBody List<ParticipationApproveRequestDTO> requestDTOs){
        try {
            List<ParticipationApproveResponseDTO> responseDTOs = participationService.approveParticipation(requestDTOs);

            return ResponseEntity.ok(createReturnObj("Check data to which requests are approved!", responseDTOs));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @GetMapping("/participation/approve/byUserRoleId/{userRoleId}")
    public ResponseEntity<Map<String, Object>> approveParticipationRequestByUserRoleId(@PathVariable Long userRoleId){
        try {
            participationService.approveParticipationRequestsByUserRoleId(userRoleId);
            return ResponseEntity.ok(createReturnObj(String.format("Participation requests are approved by %d", userRoleId), null));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @PostMapping("/participation/reject")
    public ResponseEntity<Map<String, Object>> rejectParticipationRequest(@RequestBody List<ParticipationRejectRequestDTO> requestDTOs){
        try {
            List<ParticipationRejectResponseDTO> responseDTOS = participationService.rejectParticipation(requestDTOs);
            return ResponseEntity.ok(createReturnObj("Check data to which requests are rejected!", responseDTOS));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }


}
