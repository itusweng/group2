package com.trainingplatform.trainingservice.trainingservice.model.mapper;

import com.trainingplatform.trainingservice.trainingservice.model.entity.OfflineLessonModel;
import com.trainingplatform.trainingservice.trainingservice.model.response.OfflineLessonResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface OfflineLessonModelResponseMapper {

    OfflineLessonResponseDTO mapToDto(OfflineLessonModel offlineLessonModel);

    List<OfflineLessonResponseDTO> mapToDto(List<OfflineLessonModel> offlineLessonModelResponseDTOList);

    OfflineLessonModel mapToEntity(OfflineLessonResponseDTO offlineLessonResponseDTO);

    List<OfflineLessonModel> mapToEntity(List<OfflineLessonResponseDTO> offlineLessonModelResponseDTOList);
}
