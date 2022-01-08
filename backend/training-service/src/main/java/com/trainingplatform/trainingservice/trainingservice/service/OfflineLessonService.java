package com.trainingplatform.trainingservice.trainingservice.service;

import com.trainingplatform.trainingservice.trainingservice.model.entity.OfflineLessonModel;
import com.trainingplatform.trainingservice.trainingservice.config.RabbitMQMessagingConfig;
import com.trainingplatform.trainingservice.trainingservice.model.mapper.OfflineLessonModelRequestMapper;
import com.trainingplatform.trainingservice.trainingservice.model.mapper.OfflineLessonModelResponseMapper;
import com.trainingplatform.trainingservice.trainingservice.model.request.OfflineLessonRequestDTO;
import com.trainingplatform.trainingservice.trainingservice.model.request.OfflineLessonStreamRequestDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.OfflineLessonResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.repository.OfflineLessonRepository;
import com.trainingplatform.trainingservice.trainingservice.repository.TrainingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OfflineLessonService {

    private final OfflineLessonRepository offlineLessonRepo;
    private final OfflineLessonModelResponseMapper offlineLessonModelMapper;
    private final OfflineLessonModelRequestMapper offlineLessonModelRequestMapper;
    private final TrainingRepository trainingRepo;

    //@Autowired
    private final RabbitTemplate rabbitTemplate;

    public List<OfflineLessonResponseDTO> getOfflineLessons(Long trainingID) {
        List<OfflineLessonModel> offlineLessonModels = offlineLessonRepo.findAllByTrainingID(trainingID);
        List<OfflineLessonResponseDTO> offlineLessonResponseDTOS = new ArrayList<>();

        offlineLessonModels.forEach(offlineLessonModel -> {
            OfflineLessonResponseDTO responseDTO = offlineLessonModelMapper.mapToDto(offlineLessonModel);
            offlineLessonResponseDTOS.add(responseDTO);
        });

        return offlineLessonResponseDTOS;
    }

    public OfflineLessonResponseDTO createOfflineLesson(OfflineLessonRequestDTO offlineLessonRequestDTO) throws IOException {
        OfflineLessonModel offlineLesson = offlineLessonModelRequestMapper.mapToEntity(offlineLessonRequestDTO);
        offlineLesson.setTraining(trainingRepo.getById(offlineLessonRequestDTO.getTraining_id()));

        OfflineLessonModel savedOfflineLesson = offlineLessonRepo.save(offlineLesson);

        OfflineLessonResponseDTO offlineLessonResponseDTO = offlineLessonModelMapper.mapToDto(savedOfflineLesson);
        offlineLessonResponseDTO.setTraining_id(savedOfflineLesson.getTraining().getId());

        OfflineLessonStreamRequestDTO offlineLessonStreamRequestDTO = new OfflineLessonStreamRequestDTO(offlineLessonResponseDTO.getId(), offlineLessonRequestDTO.getTraining_id(), offlineLessonRequestDTO.getVideoFile().getBytes());

        rabbitTemplate.convertAndSend(RabbitMQMessagingConfig.EXCHANGE, RabbitMQMessagingConfig.ROUTING_KEY_UPLOAD, offlineLessonStreamRequestDTO);
        return offlineLessonResponseDTO;
    }

    public void deleteOfflineLesson(Long trainingId, Long offlineLessonId) {
        //TODO CATCH EXCEPTION
        Map<String, Long> trainingLessonPairs = new HashMap<>();
        trainingLessonPairs.put("trainingID", trainingId);
        trainingLessonPairs.put("offlineLessonID", offlineLessonId);
        rabbitTemplate.convertAndSend(RabbitMQMessagingConfig.EXCHANGE, RabbitMQMessagingConfig.ROUTING_KEY_DELETE, trainingLessonPairs);
        offlineLessonRepo.deleteById(offlineLessonId);
    }

    public void updateOfflineLesson( Long offlineLessonId, OfflineLessonRequestDTO offlineLessonRequestDTO){
        OfflineLessonModel existingOfflineLesson = offlineLessonRepo.findById(offlineLessonId).get();
        offlineLessonModelRequestMapper.updateFields(existingOfflineLesson, offlineLessonRequestDTO);
        offlineLessonRepo.save(existingOfflineLesson);
    }

}
