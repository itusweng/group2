package com.trainingplatform.userservice.service;

import com.trainingplatform.userservice.exceptions.UserNotCreatedException;
import com.trainingplatform.userservice.model.User;
import com.trainingplatform.userservice.model.UserCredentials;
import com.trainingplatform.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.core.Response;


@Service
@RequiredArgsConstructor
public class UserService {

    // Inject required instances
    private final UserRepository userRepo;
    private final KeycloakService keycloakService;
    private final PasswordEncoder passwordEncoder;

    public String createUser(User newUser) throws UserNotCreatedException {
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Response response = keycloakService.createKeycloakUser(newUser.getUsername(), newUser.getEmail(), newUser.getPassword());
        switch (response.getStatus()) {
            case HttpStatus.SC_CREATED: // Successful case
                userRepo.save(newUser);
                break;
            case HttpStatus.SC_CONFLICT:
                throw new UserNotCreatedException("This username is already in use!");
        }

        return "token";
    }

    public User getUserByUsername(String username) throws EntityNotFoundException {
        return userRepo.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException(username));
    }

    public ResponseEntity login(UserCredentials userCredentials) {
        return keycloakService.loginToKeycloak(userCredentials);
    }
}
