package com.trainingplatform.trainingservice.trainingservice.model.response;

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
