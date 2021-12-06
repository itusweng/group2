package com.trainingplatform.userservice.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserCredentials {

    private String username;
    private String email;
    private String password;

}
