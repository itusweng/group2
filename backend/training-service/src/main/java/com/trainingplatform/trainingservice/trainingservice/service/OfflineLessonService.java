package com.trainingplatform.trainingservice.trainingservice.service;

import com.trainingplatform.trainingservice.trainingservice.model.entity.OfflineLessonModel;
import com.trainingplatform.trainingservice.trainingservice.model.mapper.OfflineLessonModelMapper;
import com.trainingplatform.trainingservice.trainingservice.model.response.OfflineLessonResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.repository.OfflineLessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OfflineLessonService {

    private final OfflineLessonRepository offlineLessonRepo;
    private final OfflineLessonModelMapper offlineLessonModelMapper;

    public List<OfflineLessonResponseDTO> getOfflineLessons(Long trainingID){
        List<OfflineLessonModel> offlineLessonModels = offlineLessonRepo.findAllByTrainingID(trainingID);
        List<OfflineLessonResponseDTO> offlineLessonResponseDTOS = new ArrayList<>();

        offlineLessonModels.forEach(offlineLessonModel -> {
            OfflineLessonResponseDTO responseDTO = offlineLessonModelMapper.mapToDto(offlineLessonModel);
            offlineLessonResponseDTOS.add(responseDTO);
        });

        return offlineLessonResponseDTOS;
    }

    public OfflineLessonResponseDTO createOfflineLesson(OfflineLessonModel offlineLessonModel){
        OfflineLessonModel savedOfflineLesson = offlineLessonRepo.save(offlineLessonModel);
        OfflineLessonResponseDTO offlineLessonResponseDTO = offlineLessonModelMapper.mapToDto(savedOfflineLesson);
        offlineLessonResponseDTO.setTraining_id(savedOfflineLesson.getTraining().getId());
        return offlineLessonResponseDTO;
    }

    public void deleteOfflineLesson(Long offlineLessonId) {
        //TODO CATCH EXCEPTION
       offlineLessonRepo.deleteById(offlineLessonId);
    }

}
