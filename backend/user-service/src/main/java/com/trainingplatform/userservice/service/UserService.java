package com.trainingplatform.userservice.service;

import com.trainingplatform.userservice.config.RabbitMQMessagingConfig;
import com.trainingplatform.userservice.exception.UserNotCreatedException;
import com.trainingplatform.userservice.model.entity.User;
import com.trainingplatform.userservice.model.entity.UserCredentials;
import com.trainingplatform.userservice.model.mapper.UserMapper;
import com.trainingplatform.userservice.model.mapper.UserRequestMapper;
import com.trainingplatform.userservice.model.request.UserRequestDTO;
import com.trainingplatform.userservice.model.request.UserUploadRequestDTO;
import com.trainingplatform.userservice.model.response.UserResponseDTO;
import com.trainingplatform.userservice.repository.UserRepository;
import com.trainingplatform.userservice.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.*;


@Service
@RequiredArgsConstructor
public class UserService {

    // Inject required instances
    private final UserRepository userRepo;
    private final KeycloakService keycloakService;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final UserRoleRepository userRoleRepo;
    private final UserRequestMapper userRequestMapper;
    private final RabbitTemplate rabbitTemplate;

    public Map<String, Object> getAllUsers(Integer page, Integer size) {
        Map<String, Object> returnMap = new HashMap<>();
        List<User> userList = userRepo.findAll(PageRequest.of(page, size)).getContent();
        long userCount = userRepo.countAllUsers();

        returnMap.put("users", userList);
        returnMap.put("total", userCount);
        return returnMap;
    }

    public ResponseEntity createUser(UserRequestDTO userRequestDTO) throws UserNotCreatedException, IOException {
        User newUser = userRequestMapper.mapToEntity(userRequestDTO);
        UserCredentials userCredentials = new UserCredentials();
        userCredentials.setUsername(newUser.getUsername());
        userCredentials.setPassword(newUser.getPassword());

        ResponseEntity responseWithAccessToken = null;
        Response response = keycloakService.createKeycloakUser(newUser.getUsername(), newUser.getEmail(), newUser.getPassword());
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        switch (response.getStatus()) {
            case 201: // Created case
                userRepo.save(newUser);
                break;
            case 403: // Forbidden case
                throw new UserNotCreatedException("Keycloak user cannot be created!");
            case 409: // Conflict case
                throw new UserNotCreatedException("This username is already in use!");
        }

        UserUploadRequestDTO userUploadRequestDTO = new UserUploadRequestDTO(newUser.getId(), newUser.getUsername(), userRequestDTO.getProfile_photo().getBytes());
        rabbitTemplate.convertAndSend(RabbitMQMessagingConfig.EXCHANGE,RabbitMQMessagingConfig.ROUTING_KEY_UPLOAD_PP, userUploadRequestDTO);

        responseWithAccessToken = ResponseEntity.ok(keycloakService.loginToKeycloak(userCredentials));
        return responseWithAccessToken;
    }

    public User getUserByUsername(String username) throws EntityNotFoundException {
        return userRepo.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException(username));
    }

    public Map<String, Object> login(UserCredentials userCredentials) {
        OAuth2AccessToken token = keycloakService.loginToKeycloak(userCredentials);
        User user = getUserByUsername(userCredentials.getUsername());
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        UserResponseDTO userDTO = userMapper.mapToDto(user);
        userDTO.setRole_name(getUserRoleNameByUserRoleId(user.getRole_id()));
        response.put("user", userDTO);
        return response;
    }

    public User getUserByID(Long id) throws EntityNotFoundException {
        return userRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }

    public boolean checkUserExistsByUserId(Long id) {
        return userRepo.existsById(id);
    }

    public Long getManagerGroupIdByUserId(Long userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new EntityNotFoundException());
        return user.getManager_group_id();
    }

    public String getUserRoleNameByUserRoleId(Long userId) {
        return userRoleRepo.findByRoleId(userId).getRoleName();
    }

    public Set<User> getAllUsersByUserRoleId(Long userRoleId) {
        Set<User> userSet = userRepo.findAllByByRole_id(userRoleId);
        return userSet;
    }

    public User updateUser(User updatedUser) {
        User existingUser = userRepo
                .findById(updatedUser.getId())
                .orElseThrow(() -> new EntityNotFoundException(String.format("No user found by id %d", updatedUser.getId())));
        userMapper.updateFields(existingUser, updatedUser);

        userRepo.save(existingUser);
        return existingUser;
    }
}
