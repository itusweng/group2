package com.trainingplatform.trainingservice.trainingservice.model.mapper;

import com.trainingplatform.trainingservice.trainingservice.model.TrainingModel;
import com.trainingplatform.trainingservice.trainingservice.model.response.TrainingResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TrainingModelMapper {

    TrainingResponseDTO mapToDto(TrainingModel trainingModel);

    List<TrainingResponseDTO> mapToDto(List<TrainingModel> trainingModelResponseDTOList);

    TrainingModel mapToEntity(TrainingResponseDTO trainingModelResponseDTO);

    List<TrainingModel> mapToEntity(List<TrainingResponseDTO> trainingModelResponseDTOList);

}
