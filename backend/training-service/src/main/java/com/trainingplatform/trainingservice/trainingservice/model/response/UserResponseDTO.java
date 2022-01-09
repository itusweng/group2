package com.trainingplatform.trainingservice.trainingservice.model.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@ToString
@NoArgsConstructor
public class UserResponseDTO extends BaseResponseDTO {

    private Long id;

    private String first_name;

    private String last_name;

    private Long role_id;

    private String role_name;

    private String profile_photo;

    private String email;
}
