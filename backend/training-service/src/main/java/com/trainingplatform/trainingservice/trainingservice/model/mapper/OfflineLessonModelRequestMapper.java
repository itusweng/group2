package com.trainingplatform.trainingservice.trainingservice.model.mapper;

import com.trainingplatform.trainingservice.trainingservice.model.entity.OfflineLessonModel;
import com.trainingplatform.trainingservice.trainingservice.model.request.OfflineLessonRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OfflineLessonModelRequestMapper {
    OfflineLessonRequestDTO mapToDto(OfflineLessonModel offlineLessonModel);

    OfflineLessonModel mapToEntity(OfflineLessonRequestDTO offlineLessonRequestDTO);

    @Mapping(target = "title", source = "title")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "files", source = "files")
    void updateFields(@MappingTarget OfflineLessonModel offlineLessonModel, OfflineLessonRequestDTO offlineLessonRequestDTO);
}
