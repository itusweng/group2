package com.trainingplatform.streamingservice.model.request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@ToString
@RequiredArgsConstructor
public class OfflineLessonStreamRequestDTO implements Serializable {

    private Long offlineLessonId;

    private Long trainingId;

    private byte[] videoFile;
}