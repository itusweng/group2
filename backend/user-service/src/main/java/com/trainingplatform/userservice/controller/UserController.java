package com.trainingplatform.userservice.controller;
import com.trainingplatform.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/getAllUsers")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UserRepresentation>> getAllUsers(){

       // TODO: create userDTO and a mapper
        return ResponseEntity.ok(userService.findAll());
    }


}

