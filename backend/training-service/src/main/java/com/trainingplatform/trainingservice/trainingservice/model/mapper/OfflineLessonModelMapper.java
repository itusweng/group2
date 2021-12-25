package com.trainingplatform.trainingservice.trainingservice.model.mapper;

import com.trainingplatform.trainingservice.trainingservice.model.OfflineLessonModel;
import com.trainingplatform.trainingservice.trainingservice.model.request.OfflineLessonRequestDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.OfflineLessonResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OfflineLessonModelMapper {

    OfflineLessonResponseDTO mapToDto(OfflineLessonModel offlineLessonModel);

    List<OfflineLessonResponseDTO> mapToDto(List<OfflineLessonModel> offlineLessonModelResponseDTOList);

    OfflineLessonModel mapToEntity(OfflineLessonResponseDTO offlineLessonResponseDTO);

    List<OfflineLessonModel> mapToEntity(List<OfflineLessonResponseDTO> offlineLessonModelResponseDTOList);

    OfflineLessonRequestDTO maptoDto(OfflineLessonModel offlineLessonModel);

    OfflineLessonModel mapToEntity(OfflineLessonRequestDTO offlineLessonRequestDTO);
}
