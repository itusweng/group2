package com.trainingplatform.userservice.model.request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@ToString
@RequiredArgsConstructor
public class UserRequestDTO implements Serializable {

    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String email;
    private String role_id;
    private MultipartFile profile_photo;
    private String job_title;

}
