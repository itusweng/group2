package com.trainingplatform.userservice.model;

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
