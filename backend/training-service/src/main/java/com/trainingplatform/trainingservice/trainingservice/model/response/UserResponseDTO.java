package com.trainingplatform.trainingservice.trainingservice.model.response;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserResponseDTO {

    private Long id;

    private String first_name;

    private String last_name;

    private String role;
}
