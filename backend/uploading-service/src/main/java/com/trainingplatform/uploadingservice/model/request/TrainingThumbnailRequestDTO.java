package com.trainingplatform.uploadingservice.model.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@RequiredArgsConstructor
public class TrainingThumbnailRequestDTO {
    private Long ID;
    private byte[] thumbnail;
}
