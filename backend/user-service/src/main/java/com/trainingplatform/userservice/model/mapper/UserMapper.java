package com.trainingplatform.userservice.model.mapper;

import com.trainingplatform.userservice.model.response.UserResponseDTO;
import com.trainingplatform.userservice.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    UserResponseDTO mapToDto(User user);

    List<UserResponseDTO> mapToDto(List<User> userResponseDTOList);

    Set<UserResponseDTO> mapToDto(Set<User> userResponseDTOList);

    User mapToEntity(UserResponseDTO userResponseDTO);

    List<User> mapToEntity(List<UserResponseDTO> userResponseDTOList);

    Set<User> mapToEntity(Set<UserResponseDTO> userResponseDTOList);

    @Mapping(target = "username", source = "username")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "first_name", source = "first_name")
    @Mapping(target = "last_name", source = "last_name")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "role_id", source = "role_id")
    @Mapping(target = "profile_photo", source = "profile_photo")
    @Mapping(target = "manager_group_id", source = "manager_group_id")
    void updateFields(@MappingTarget User existingUser, User updatedUser);
}
