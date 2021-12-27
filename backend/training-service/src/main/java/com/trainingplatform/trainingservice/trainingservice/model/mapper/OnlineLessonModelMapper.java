package com.trainingplatform.trainingservice.trainingservice.model.mapper;

import com.trainingplatform.trainingservice.trainingservice.model.OnlineLessonModel;
import com.trainingplatform.trainingservice.trainingservice.model.request.OnlineLessonRequestDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.OnlineLessonResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OnlineLessonModelMapper {
    OnlineLessonResponseDTO mapToDto(OnlineLessonModel onlineLessonModel);

    List<OnlineLessonResponseDTO> mapToDto(List<OnlineLessonModel> onlineLessonModelResponseDTOList);

    OnlineLessonModel mapToEntity(OnlineLessonResponseDTO onlineLessonResponseDTO);

    List<OnlineLessonModel> mapToEntity(List<OnlineLessonResponseDTO> offlineLessonModelResponseDTOList);

    OnlineLessonRequestDTO maptoDto(OnlineLessonModel offlineLessonModel);

    OnlineLessonModel mapToEntity(OnlineLessonRequestDTO offlineLessonRequestDTO);

    @Mapping(target = "title", source = "title")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "meeting_date", source = "meeting_date")
    @Mapping(target = "zoom_link", source = "zoom_link")
    void updateFields(@MappingTarget OnlineLessonModel onlineLessonModel, OnlineLessonRequestDTO onlineLessonRequestDTO);
}