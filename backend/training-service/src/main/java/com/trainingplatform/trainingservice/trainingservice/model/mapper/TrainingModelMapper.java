package com.trainingplatform.trainingservice.trainingservice.model.mapper;

import com.trainingplatform.trainingservice.trainingservice.model.entity.TrainingModel;
import com.trainingplatform.trainingservice.trainingservice.model.response.TrainingResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TrainingModelMapper {

    TrainingResponseDTO mapToDto(TrainingModel trainingModel);

    List<TrainingResponseDTO> mapToDto(List<TrainingModel> trainingModelResponseDTOList);

    TrainingModel mapToEntity(TrainingResponseDTO trainingModelResponseDTO);

    List<TrainingModel> mapToEntity(List<TrainingResponseDTO> trainingModelResponseDTOList);

    @Mapping(target = "is_online", source = "is_online")
    @Mapping(target = "user_created_id", source = "user_created_id")
    @Mapping(target = "instructor_id", source = "instructor_id")
    @Mapping(target = "capacity", source = "capacity")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "thumbnail", source = "thumbnail")
    void updateFields(@MappingTarget TrainingModel existingTraining, TrainingModel updatedTraining);
}
