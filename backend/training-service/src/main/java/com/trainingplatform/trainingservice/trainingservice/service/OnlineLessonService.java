package com.trainingplatform.trainingservice.trainingservice.service;

import com.trainingplatform.trainingservice.trainingservice.model.entity.OnlineLessonModel;
import com.trainingplatform.trainingservice.trainingservice.model.mapper.OnlineLessonModelMapper;
import com.trainingplatform.trainingservice.trainingservice.model.response.onlinelesson.OnlineLessonResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.repository.OnlineLessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
