package com.trainingplatform.trainingservice.trainingservice.model.mapper;

import com.trainingplatform.trainingservice.trainingservice.model.entity.TrainingModel;
import com.trainingplatform.trainingservice.trainingservice.model.request.TrainingRequestDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TrainingRequestMapper {

    TrainingRequestDTO mapToDto(TrainingModel trainingModel);

    List<TrainingRequestDTO> mapToDto(List<TrainingModel> trainingModelList);

    TrainingModel mapToEntity(TrainingRequestDTO trainingRequestDTO);

    List<TrainingModel> mapToEntity(List<TrainingRequestDTO> trainingRequestDTOList);

}
