package com.trainingplatform.userservice.model.mapper;

import com.trainingplatform.userservice.model.entity.User;
import com.trainingplatform.userservice.model.request.UserRequestDTO;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UserRequestMapper {

    UserRequestDTO mapToDto(User user);

    List<UserRequestDTO> mapToDto(List<User> userRequestDTOList);

    User mapToEntity(UserRequestDTO userRequestDTO);

    List<User> mapToEntity(List<UserRequestDTO> userRequestDTOList);
}