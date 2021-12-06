package com.trainingplatform.userservice.controller;

import com.trainingplatform.userservice.model.user.User;
import com.trainingplatform.userservice.model.user.UserCredentials;
import com.trainingplatform.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController extends BaseController {

    // Inject services
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

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

}

