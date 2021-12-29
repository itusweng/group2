package com.trainingplatform.trainingservice.trainingservice.model.mapper;

import com.trainingplatform.trainingservice.trainingservice.model.entity.OfflineLessonModel;
import com.trainingplatform.trainingservice.trainingservice.model.request.OfflineLessonRequestDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.OfflineLessonResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OfflineLessonModelMapper {

    OfflineLessonResponseDTO mapToDto(OfflineLessonModel offlineLessonModel);

    List<OfflineLessonResponseDTO> mapToDto(List<OfflineLessonModel> offlineLessonModelResponseDTOList);

    OfflineLessonModel mapToEntity(OfflineLessonResponseDTO offlineLessonResponseDTO);

    List<OfflineLessonModel> mapToEntity(List<OfflineLessonResponseDTO> offlineLessonModelResponseDTOList);

    OfflineLessonRequestDTO maptoDto(OfflineLessonModel offlineLessonModel);

    OfflineLessonModel mapToEntity(OfflineLessonRequestDTO offlineLessonRequestDTO);

    @Mapping(target = "title", source = "title")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "files", source = "files")
    @Mapping(target = "video_link", source = "video_link")
    void updateFields(@MappingTarget OfflineLessonModel offlineLessonModel, OfflineLessonRequestDTO offlineLessonRequestDTO);
}
