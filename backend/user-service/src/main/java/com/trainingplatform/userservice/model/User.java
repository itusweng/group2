package com.trainingplatform.userservice.model;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private List<String> roles;

}
