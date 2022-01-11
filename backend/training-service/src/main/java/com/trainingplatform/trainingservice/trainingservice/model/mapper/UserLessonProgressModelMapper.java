package com.trainingplatform.trainingservice.trainingservice.model.mapper;

import com.trainingplatform.trainingservice.trainingservice.model.entity.OfflineLessonModel;
import com.trainingplatform.trainingservice.trainingservice.model.entity.User_LessonProgressModel;
import com.trainingplatform.trainingservice.trainingservice.model.request.UserLessonProgressRequestDTO;
import com.trainingplatform.trainingservice.trainingservice.model.request.offlinelesson.OfflineLessonRequestDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.UserLessonProgressResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserLessonProgressModelMapper {

    UserLessonProgressResponseDTO mapToDto(User_LessonProgressModel onlineLessonModel);

    List<UserLessonProgressResponseDTO> mapToDto(List<User_LessonProgressModel> onlineLessonModelResponseDTOList);

    User_LessonProgressModel mapToEntity(UserLessonProgressResponseDTO onlineLessonResponseDTO);

    User_LessonProgressModel mapToEntity(UserLessonProgressRequestDTO onlineLessonResponseDTO);

    List<User_LessonProgressModel> mapToEntity(List<UserLessonProgressResponseDTO> offlineLessonModelResponseDTOList);

    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "lessonId", source = "lessonId")
    @Mapping(target = "lastWatchedMinute", source = "lastWatchedMinute")
    @Mapping(target = "isStarted", source = "isStarted")
    @Mapping(target = "isCompleted", source = "isCompleted")
    void updateFields(@MappingTarget User_LessonProgressModel existingProgress, User_LessonProgressModel newProgress);
}
