package com.trainingplatform.userservice.model.mapper;

import com.trainingplatform.userservice.model.UserResponseDTO;
import com.trainingplatform.userservice.model.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDTO mapToDto(User user);

    List<UserResponseDTO> mapToDto(List<User> userResponseDTOList);

    User mapToEntity(UserResponseDTO userResponseDTO);

    List<User> mapToEntity(List<UserResponseDTO> userResponseDTOList);
}
