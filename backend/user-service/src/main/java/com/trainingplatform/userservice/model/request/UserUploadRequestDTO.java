package com.trainingplatform.userservice.model.request;
import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@ToString
@RequiredArgsConstructor
public class UserUploadRequestDTO implements Serializable{

    private Long ID;
    private String username;
    private byte[] profile_photo;

}
