package com.trainingplatform.userservice.service;

import com.trainingplatform.userservice.exceptions.UserNotCreatedException;
import com.trainingplatform.userservice.model.entity.User;
import com.trainingplatform.userservice.model.entity.UserCredentials;
import com.trainingplatform.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UserService {

    // Inject required instances
    private final UserRepository userRepo;
    private final KeycloakService keycloakService;
    private final PasswordEncoder passwordEncoder;

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

    public ResponseEntity<Map> login(UserCredentials userCredentials) {
        OAuth2AccessToken token = keycloakService.loginToKeycloak(userCredentials);
        User user = getUserByUsername(userCredentials.getUsername());
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("user", user);
        return ResponseEntity.ok(response);
    }

    public User getUserByID(UUID uuid) throws EntityNotFoundException {
        return userRepo.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException(uuid.toString()));
    }
}
