package com.trainingplatform.trainingservice.trainingservice.controller;

import com.trainingplatform.trainingservice.trainingservice.model.entity.TrainingModel;
import com.trainingplatform.trainingservice.trainingservice.model.mapper.TrainingModelMapper;
import com.trainingplatform.trainingservice.trainingservice.model.response.TrainingResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.UserResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.service.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/training")
public class TrainingController extends BaseController {

    private final TrainingService trainingService;
    private final TrainingModelMapper trainingMapper;

    @GetMapping("/getAllTrainings")
    public ResponseEntity<HashMap<String, Object>> getAllTrainings() {
        try {
            List<TrainingModel> trainings = trainingService.getAllTrainings();
            List<TrainingResponseDTO> trainingResponseDTOS = new ArrayList<>();

            Map<Long, Long> userCreatedList = trainings.stream()
                    .collect(Collectors.toMap(TrainingModel::getId, TrainingModel::getUser_created_id));

            Map<Long, Long> userInstructorList = trainings.stream()
                    .collect(Collectors.toMap(TrainingModel::getId, TrainingModel::getInstructor_id));

            // Fetch users who are created the trainings
            Map<Long, UserResponseDTO> createdUsersMap = trainingService.getTrainingUsersByID(userCreatedList);

            // Fetch instructors of trainings
            Map<Long, UserResponseDTO> instructorsMap = trainingService.getTrainingUsersByID(userInstructorList);

            // Add instructors & created users into dto model
            trainings.forEach(trainingModel -> {
                TrainingResponseDTO responseDTO = trainingMapper.mapToDto(trainingModel);
                responseDTO.setUser_created(createdUsersMap.get(responseDTO.getId()));
                responseDTO.setInstructor(instructorsMap.get(responseDTO.getId()));
                trainingResponseDTOS.add(responseDTO);
            });

            return ResponseEntity.ok(createReturnObj("Trainings fetched successfully!", trainingResponseDTOS));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @GetMapping("/{trainingId}/isUserParticipated/{userId}")
    public ResponseEntity<Map<String, Object>> isUserParticipated(@PathVariable Long trainingId, @PathVariable Long userId) {
        try {
            Boolean isUserParticipated = trainingService.isUserParticipated(trainingId, userId);
            return ResponseEntity.ok(createReturnObj("", isUserParticipated));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @GetMapping("/byParticipantId/{participantId}/getAll")
    public ResponseEntity<HashMap<String, Object>> getTrainingsByParticipantId(@PathVariable Long participantId) {
        try {
            List<TrainingModel> trainingModels = trainingService.getTrainingsByParticipantId(participantId);
            List<TrainingResponseDTO> trainingResponseDTOS = new ArrayList<>();
            Map<Long, Long> userCreatedList = trainingModels.stream()
                    .collect(Collectors.toMap(TrainingModel::getId, TrainingModel::getUser_created_id));

            Map<Long, Long> userInstructorList = trainingModels.stream()
                    .collect(Collectors.toMap(TrainingModel::getId, TrainingModel::getInstructor_id));

            // Fetch users who are created the trainings
            Map<Long, UserResponseDTO> createdUsersMap = trainingService.getTrainingUsersByID(userCreatedList);

            // Fetch instructors of trainings
            Map<Long, UserResponseDTO> instructorsMap = trainingService.getTrainingUsersByID(userInstructorList);

            // Add instructors & created users into dto model
            trainingModels.forEach(trainingModel -> {
                TrainingResponseDTO responseDTO = trainingMapper.mapToDto(trainingModel);
                responseDTO.setUser_created(createdUsersMap.get(responseDTO.getId()));
                responseDTO.setInstructor(instructorsMap.get(responseDTO.getId()));
                trainingResponseDTOS.add(responseDTO);
            });

            return ResponseEntity.ok(createReturnObj(String.format("Trainings fetched successfully by participant id: %d!", participantId), trainingResponseDTOS));
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

    @GetMapping("/getTraining/byId/{trainingId}")
    public ResponseEntity<HashMap<String, Object>> getTrainingById(@PathVariable Long trainingId) {
        try {
            TrainingModel trainingModel = trainingService.getTrainingById(trainingId);

            // Fetch the user who are created the training
            UserResponseDTO createdUser = trainingService.getSingleTrainingUserByID(trainingModel.getUser_created_id());

            // Fetch the instructor of training
            UserResponseDTO instructor = trainingService.getSingleTrainingUserByID(trainingModel.getInstructor_id());

            // Add instructors & created users into dto model
            TrainingResponseDTO responseDTO = trainingMapper.mapToDto(trainingModel);
            responseDTO.setUser_created(createdUser);
            responseDTO.setInstructor(instructor);

            return ResponseEntity.ok(
                    createReturnObj(String.format("Training fetched by id %d successfully!", trainingId), responseDTO));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }
}

