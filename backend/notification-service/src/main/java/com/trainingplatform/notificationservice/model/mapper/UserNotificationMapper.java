package com.trainingplatform.notificationservice.model.mapper;

import com.trainingplatform.notificationservice.model.entity.UserNotificationModel;
import com.trainingplatform.notificationservice.model.response.UserNotificationResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserNotificationMapper {

    UserNotificationResponseDTO mapToDto(UserNotificationModel userNotificationModel);

    List<UserNotificationResponseDTO> mapToDto(List<UserNotificationModel> userNotificationModelList);

    UserNotificationModel mapToEntity(UserNotificationResponseDTO userNotificationResponseDTO);

    List<UserNotificationModel> mapToEntity(List<UserNotificationResponseDTO> userNotificationResponseDTOS);
}
