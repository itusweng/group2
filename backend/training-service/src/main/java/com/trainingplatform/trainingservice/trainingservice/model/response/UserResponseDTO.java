package com.trainingplatform.trainingservice.trainingservice.model.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserResponseDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String role;
}
