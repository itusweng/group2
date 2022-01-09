package com.trainingplatform.userservice.service;

import com.trainingplatform.userservice.exception.UserNotCreatedException;
import com.trainingplatform.userservice.model.entity.User;
import com.trainingplatform.userservice.model.entity.UserCredentials;
import com.trainingplatform.userservice.model.entity.UserRole;
import com.trainingplatform.userservice.repository.UserRepository;
import com.trainingplatform.userservice.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.core.Response;
import java.util.*;


@Service
@RequiredArgsConstructor
public class UserService {

    // Inject required instances
    private final UserRepository userRepo;
    private final KeycloakService keycloakService;
    private final PasswordEncoder passwordEncoder;

    public Map<String, Object> getAllUsers(Integer page, Integer size) {
        Map<String, Object> returnMap=new HashMap<>();
        List<User> userList = userRepo.findAll(PageRequest.of(page, size)).getContent();
        long userCount = userRepo.countAllUsers();

        returnMap.put("users", userList);
        returnMap.put("total", userCount);
        return returnMap;
    }

    public ResponseEntity createUser(User newUser) throws UserNotCreatedException {
        UserCredentials userCredentials = new UserCredentials();
        userCredentials.setUsername(newUser.getUsername());
        userCredentials.setPassword(newUser.getPassword());

        ResponseEntity responseWithAccessToken;
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        Response response = keycloakService.createKeycloakUser(newUser.getUsername(), newUser.getEmail(), newUser.getPassword());

        switch (response.getStatus()) {
            case 200: // Successful case
                userRepo.save(newUser);
                break;
            case 403: // Forbidden case
                throw new UserNotCreatedException("Keycloak user cannot be created!");
            case 409: // Conflict case
                throw new UserNotCreatedException("This username is already in use!");
        }

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
        response.put("user", user);
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

    public Set<User> getAllUsersByUserRoleId(Long userRoleId) {
        Set<User> userSet = userRepo.findAllByByRole_id(userRoleId);
        return userSet;
    }
}
