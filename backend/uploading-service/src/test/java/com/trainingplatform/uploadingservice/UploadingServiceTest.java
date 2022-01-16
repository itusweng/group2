package com.trainingplatform.uploadingservice;

import com.trainingplatform.uploadingservice.model.request.TrainingThumbnailRequestDTO;
import com.trainingplatform.uploadingservice.model.request.UserProfilePictureRequestDTO;
import com.trainingplatform.uploadingservice.service.UploadingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UploadingServiceTest {
    @InjectMocks
    UploadingService uploadingService;

    @Mock
    private S3Client s3Client;

    @Captor
    private ArgumentCaptor<RequestBody> argumentCaptorImage;

    @Captor
    private ArgumentCaptor<String> argumentCaptorFileName;

    @Test
    public void it_should_upload_image_to_s3_when_picture_given() {
        //arrange
        UserProfilePictureRequestDTO userProfilePictureRequestDTO = mock(UserProfilePictureRequestDTO.class);
        byte[] image = "user profile picture".getBytes();
        ;
        Long userId = 1L;
        when(userProfilePictureRequestDTO.getProfile_photo()).thenReturn(image);
        when(userProfilePictureRequestDTO.getID()).thenReturn(userId);
        RequestBody requestBody = RequestBody.fromBytes(image);
        //act
        uploadingService.uploadImage(userProfilePictureRequestDTO);
        //assert
        verify(s3Client, times(1)).putObject(any(PutObjectRequest.class), argumentCaptorImage.capture());
        assertThat(argumentCaptorImage.getValue().contentLength()).isEqualTo(requestBody.contentLength());
    }

    @Test
    public void it_should_delete_profile_picture_when_user_found() {
        //arrange
        Long userId = 1L;
        //act
        uploadingService.deleteImage(userId);
        //assert
        verify(s3Client, times(1)).deleteObject(any(DeleteObjectRequest.class));
    }

    @Test
    public void it_should_upload_thumbnail_to_s3_when_picture_given() {
        //arrange
        TrainingThumbnailRequestDTO trainingThumbnailRequestDTO = mock(TrainingThumbnailRequestDTO.class);
        byte[] image = "thumbnail".getBytes();
        ;
        Long trainingId = 1L;
        when(trainingThumbnailRequestDTO.getThumbnail()).thenReturn(image);
        when(trainingThumbnailRequestDTO.getID()).thenReturn(trainingId);
        RequestBody requestBody = RequestBody.fromBytes(image);
        //act
        uploadingService.uploadThumbnail(trainingThumbnailRequestDTO);
        //assert
        verify(s3Client, times(1)).putObject(any(PutObjectRequest.class), argumentCaptorImage.capture());
        assertThat(argumentCaptorImage.getValue().contentLength()).isEqualTo(requestBody.contentLength());
    }

    @Test
    public void it_should_delete_thumbnail_when_training_found() {
        //arrange
        Long trainingId = 1L;
        //act
        uploadingService.deleteThumbnail(trainingId);
        //assert
        verify(s3Client, times(1)).deleteObject(any(DeleteObjectRequest.class));
    }
}
