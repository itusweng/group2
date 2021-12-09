package com.trainingplatform.userservice.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserResponseDTO {

    private UUID id;

    private String firstName;

    private String lastName;

    private String role;
}
