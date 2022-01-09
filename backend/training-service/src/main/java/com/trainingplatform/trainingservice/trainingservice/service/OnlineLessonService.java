package com.trainingplatform.trainingservice.trainingservice.service;

import com.trainingplatform.trainingservice.trainingservice.model.entity.OnlineLessonModel;
import com.trainingplatform.trainingservice.trainingservice.model.mapper.OnlineLessonModelMapper;
import com.trainingplatform.trainingservice.trainingservice.model.response.onlinelesson.OnlineLessonResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.repository.OnlineLessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OnlineLessonService {
    private final OnlineLessonRepository onlineLessonRepo;
    private final OnlineLessonModelMapper onlineLessonModelMapper;

    public List<OnlineLessonResponseDTO> getOnlineLessons(Long trainingID){
        List<OnlineLessonModel> onlineLessonModels = onlineLessonRepo.findAllByTrainingID(trainingID);
        List<OnlineLessonResponseDTO> onlineLessonResponseDTOS = new ArrayList<>();

        onlineLessonModels.forEach(onlineLessonModel -> {
            OnlineLessonResponseDTO responseDTO = onlineLessonModelMapper.mapToDto(onlineLessonModel);
            onlineLessonResponseDTOS.add(responseDTO);
        });

        return onlineLessonResponseDTOS;
    }

    public OnlineLessonResponseDTO createOnlineLesson(OnlineLessonModel onlineLessonModel){
        OnlineLessonModel savedOnlineLesson = onlineLessonRepo.save(onlineLessonModel);
        OnlineLessonResponseDTO onlineLessonResponseDTO = onlineLessonModelMapper.mapToDto(savedOnlineLesson);
        onlineLessonResponseDTO.setTraining_id(savedOnlineLesson.getTraining().getId());
        return onlineLessonResponseDTO;
    }

    public void deleteOnlineLesson(Long offlineLessonId) {
        //TODO CATCH EXCEPTION
        onlineLessonRepo.deleteById(offlineLessonId);
    }

    public OnlineLessonModel getOnlineLessonById(Long lessonId) {
        return onlineLessonRepo.findById(lessonId)
                .orElseThrow(()-> new EntityNotFoundException(String.format("No online lesson found by id %d", lessonId)));
    }

    public void updateOnlineLesson(OnlineLessonModel onlineLesson) {
        OnlineLessonModel existingOnlineLesson = onlineLessonRepo.findById(onlineLesson.getId())
                .orElseThrow(() -> new EntityNotFoundException(String.format("No online lesson found by id %d", onlineLesson.getId())));

        onlineLessonModelMapper.updateFields(existingOnlineLesson, onlineLesson);
        onlineLessonRepo.save(existingOnlineLesson);
    }
}
