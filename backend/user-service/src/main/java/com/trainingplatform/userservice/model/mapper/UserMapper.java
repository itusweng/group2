package com.trainingplatform.userservice.model.mapper;

import com.trainingplatform.userservice.model.response.UserResponseDTO;
import com.trainingplatform.userservice.model.entity.User;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDTO mapToDto(User user);

    List<UserResponseDTO> mapToDto(List<User> userResponseDTOList);

    Set<UserResponseDTO> mapToDto(Set<User> userResponseDTOList);

    User mapToEntity(UserResponseDTO userResponseDTO);

    List<User> mapToEntity(List<UserResponseDTO> userResponseDTOList);

    Set<User> mapToEntity(Set<UserResponseDTO> userResponseDTOList);
}
