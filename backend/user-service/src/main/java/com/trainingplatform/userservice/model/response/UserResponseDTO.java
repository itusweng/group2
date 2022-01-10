package com.trainingplatform.userservice.model.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserResponseDTO extends BaseResponseDTO{

    private Long id;

    private String first_name;

    private String last_name;

    private Long role_id;

    private String role_name;

    private String profile_photo;

    private String email;

    private Long manager_group_id;

}
