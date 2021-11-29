package com.trainingplatform.userservice.controller;

import com.trainingplatform.userservice.model.User;
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

    @GetMapping("")
    public ResponseEntity createUser() {
        try {
            User user = new User();
            user.setId(2L);
            user.setUsername("test3");
            user.setFirst_name("test name");
            user.setLast_name("test last name");
            user.setEmail("test3@gmail.com");
            user.setRole_id(1L);
            user.setPassword(passwordEncoder.encode("test1"));

            String accessToken = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.OK).body(accessToken);
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

    @GetMapping("/login")
    public ResponseEntity loginWithPassword() {

        // TODO: fix post request problem then delete dummy user below
        User user = new User();
        user.setUsername("test1");
        user.setPassword("test1");

        try {
            ResponseEntity responseEntity = userService.login(user);
            return responseEntity;
        } catch (Exception e) {
            return exceptionHandler(e);
        }
    }

}

