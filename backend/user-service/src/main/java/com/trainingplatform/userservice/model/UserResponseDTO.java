package com.trainingplatform.userservice.model;

import lombok.*;


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

    private String profile_photo;

    private String job_title;

}
