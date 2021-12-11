package com.trainingplatform.userservice.controller;

import com.trainingplatform.userservice.model.UserResponseDTO;
import com.trainingplatform.userservice.model.entity.User;
import com.trainingplatform.userservice.model.entity.UserCredentials;
import com.trainingplatform.userservice.model.mapper.UserMapper;
import com.trainingplatform.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;;import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController extends BaseController {

    // Inject services
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @GetMapping("/{username}")
    public ResponseEntity getUserByUsername(@PathVariable String username) {
        try {
            User user = userService.getUserByUsername(username);
            return ResponseEntity.ok(createReturnObj("User fetched successfully!", user));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @PostMapping("")
    public ResponseEntity createUser(User user) {
        try {
            ResponseEntity accessToken = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.OK).body(accessToken);
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Map> loginWithPassword(@RequestBody UserCredentials userCredentials) {
        try {
            ResponseEntity<Map> responseEntity = userService.login(userCredentials);
            return responseEntity;
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @PostMapping("/getTrainingCreatedUsersByID")
    public ResponseEntity<Map<Long, Object>> getTrainingCreatedUserByID(@RequestBody Map<Long, Long> trainingIdUserIdMap) {
        // Key -> Training Id, Value -> User created the training
        Map<Long, Object> userResponseDTOMap = new HashMap<>();

        trainingIdUserIdMap.forEach((trainingId, userId) -> {
            User user = userService.getUserByID(userId);
            UserResponseDTO userResponseDTO = userMapper.mapToDto(user);
            userResponseDTOMap.put(trainingId, userResponseDTO);
        });
        return ResponseEntity.ok(userResponseDTOMap);
    }

}

