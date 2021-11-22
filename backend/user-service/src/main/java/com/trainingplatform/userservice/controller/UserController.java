package com.trainingplatform.userservice.controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

// localhost:8080/api/user/endpoint1
@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/1")
    @ResponseStatus(HttpStatus.OK)
    public String getVideoStream(){
        return "User1";
    };
}

