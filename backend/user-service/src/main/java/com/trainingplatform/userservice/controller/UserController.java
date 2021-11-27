package com.trainingplatform.userservice.controller;

import com.trainingplatform.userservice.model.User;
import com.trainingplatform.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> createUser(User user) {

        // TODO: create userDTO and a mapper
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> createUser() {
        System.out.println("Create user ");
        // TODO: create userDTO and a mapper
        return ResponseEntity.ok("Create user");
    }


}

