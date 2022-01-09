package com.trainingplatform.trainingservice.trainingservice.model.mapper;

import com.trainingplatform.trainingservice.trainingservice.model.entity.OfflineLessonModel;
import com.trainingplatform.trainingservice.trainingservice.model.request.offlinelesson.OfflineLessonStreamRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OfflineLessonModelStreamRequestMapper {
    OfflineLessonStreamRequestDTO mapToDto(OfflineLessonModel offlineLessonModel);
}
