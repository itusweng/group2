package com.trainingplatform.userservice.service;

import com.trainingplatform.userservice.model.User;
import com.trainingplatform.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {

    // Inject required instances
    private final UserRepository userRepo;
    private final KeycloakService keycloakService;
    private final PasswordEncoder passwordEncoder;

    public void createUser(User newUser){
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));

        keycloakService.createKeycloakUser(newUser.getUsername(), newUser.getEmail(), newUser.getPassword());
        userRepo.save(newUser);
    }
}
