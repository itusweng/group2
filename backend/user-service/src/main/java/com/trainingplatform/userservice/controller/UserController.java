package com.trainingplatform.userservice.controller;

import com.trainingplatform.userservice.model.User;
import com.trainingplatform.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController extends BaseController {

    // Inject services
    private final UserService userService;

    @GetMapping("/{username}")
    public ResponseEntity getUserByUsername(@PathVariable String username) {
        try {
            User user = userService.getUserByUsername(username);
            return ResponseEntity.ok(createReturnObj("User fetched successfully!", user));
        }
        catch (Exception e){
            return exceptionHandler(e);
        }
    }

}

