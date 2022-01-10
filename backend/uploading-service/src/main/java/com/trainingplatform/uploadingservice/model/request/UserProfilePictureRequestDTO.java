package com.trainingplatform.uploadingservice.model.request;
import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@ToString
@RequiredArgsConstructor
public class UserProfilePictureRequestDTO implements Serializable{
    private Long ID;
    private String username;
    private byte[] profile_photo;
}
