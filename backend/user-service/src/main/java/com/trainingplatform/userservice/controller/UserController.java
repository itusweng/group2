package com.trainingplatform.userservice.controller;

import com.trainingplatform.userservice.model.UserResponseDTO;
import com.trainingplatform.userservice.model.entity.User;
import com.trainingplatform.userservice.model.entity.UserCredentials;
import com.trainingplatform.userservice.model.entity.UserMapper;
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
    public ResponseEntity loginWithPassword(@RequestBody UserCredentials userCredentials) {
        try {
            ResponseEntity responseEntity = userService.login(userCredentials);
            return responseEntity;
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

//    @GetMapping("/api/user/getAllUsers")
//    public UserResponseDTO getAllUserDTO(){
//
//    }

    @PostMapping("/api/user/getUsersByID")
    public Map<UUID, UserResponseDTO> getUsersByID(@RequestBody List<UUID> userIDs){
        Map<UUID, UserResponseDTO> userResponseDTOMap = new HashMap<>();
        userIDs.forEach(uuid -> {
            User user = userService.getUserByID(uuid);
            UserResponseDTO userResponseDTO = userMapper.mapToDto(user);
            userResponseDTOMap.put(uuid,userResponseDTO);
        });
        return userResponseDTOMap;
    }


}

