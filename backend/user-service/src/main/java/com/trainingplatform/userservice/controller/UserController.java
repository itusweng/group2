package com.trainingplatform.userservice.controller;

import com.trainingplatform.userservice.model.UserResponseDTO;
import com.trainingplatform.userservice.model.entity.User;
import com.trainingplatform.userservice.model.entity.UserCredentials;
import com.trainingplatform.userservice.model.mapper.UserMapper;
import com.trainingplatform.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController extends BaseController {

    // Inject services
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/byUsername/{username}")
    public ResponseEntity<Map<String, Object>> getUserByUsername(@PathVariable String username) {
        try {
            User user = userService.getUserByUsername(username);
            return ResponseEntity.ok(createReturnObj("User fetched successfully!", user));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @GetMapping("/byId/{userId}")
    ResponseEntity<Map<String, Object>> getUserByID(@PathVariable Long userId) {
        try {
            User user = userService.getUserByID(userId);
            return ResponseEntity.ok(createReturnObj("User fetched successfully!", user));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }


    @PostMapping("/")
    public ResponseEntity createUser(@RequestBody User user) {
        try {
            ResponseEntity accessToken = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.OK).body(accessToken);
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginWithPassword(@RequestBody UserCredentials userCredentials) {
        try {
            ResponseEntity<Map<String, Object>> responseEntity = ResponseEntity.ok(userService.login(userCredentials));
            return responseEntity;
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @PostMapping("/getTrainingUsersByID")
    public ResponseEntity<Map<Long, Object>> getTrainingUserByID(@RequestBody Map<Long, Long> trainingIdUserIdMap) {
        // Key -> Training Id, Value -> User created the training
        Map<Long, Object> userResponseDTOMap = new HashMap<>();

        trainingIdUserIdMap.forEach((trainingId, userId) -> {
            User user = userService.getUserByID(userId);
            UserResponseDTO userResponseDTO = userMapper.mapToDto(user);
            userResponseDTOMap.put(trainingId, userResponseDTO);
        });
        return ResponseEntity.ok(userResponseDTOMap);
    }

    @GetMapping("/isExists/byId/{userId}")
    public ResponseEntity<Map<String, Object>> checkUserExistsByUserId(@PathVariable Long userId) {
        try {
            boolean response = userService.checkUserExistsByUserId(userId);
            return ResponseEntity.ok(createReturnObj("User exist query performed successfully!", response));
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }
}

