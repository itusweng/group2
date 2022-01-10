package com.trainingplatform.uploadingservice.service;

import com.trainingplatform.uploadingservice.model.request.TrainingThumbnailRequestDTO;
import com.trainingplatform.uploadingservice.model.request.UserProfilePictureRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

@Service
@RequiredArgsConstructor
public class UploadingService {
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String IMAGE_CONTENT = "image/";

    private final S3Client s3;

    @Value("${application.bucket.name}")
    private String bucketName;

    public void uploadImage(UserProfilePictureRequestDTO userProfilePictureRequestDTO){
        byte[] image = userProfilePictureRequestDTO.getProfile_photo();
        Long userID = userProfilePictureRequestDTO.getID();

        String fileName = "profilePictures/"+userID+".jpeg";

        putImage(image, fileName);
    }

    public void putImage(byte[] image, String fileName){
        try {
            PutObjectRequest putOb = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .acl("public-read")
                    .key(fileName)
                    .build();

            s3.putObject(putOb, RequestBody.fromBytes(image));

        } catch (S3Exception e) {
            System.err.println(e.awsErrorDetails().errorMessage());
        }
    }

    public void deleteImage(Long userID){
        String fileName = "profilePictures/"+userID+".jpeg";
        DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest
                .builder()
                .key(fileName)
                .bucket(bucketName)
                .build();
        s3.deleteObject(deleteObjectRequest);
    }

    public void uploadThumbnail(TrainingThumbnailRequestDTO trainingThumbnailRequestDTO){
        byte[] thumbnail = trainingThumbnailRequestDTO.getThumbnail();
        Long trainingID = trainingThumbnailRequestDTO.getID();

        String fileName = "trainingThumbnails/"+trainingID+".jpeg";

        putImage(thumbnail, fileName);
    }

    public void deleteThumbnail(Long trainingID){
        String fileName = "trainingThumbnails/"+trainingID+".jpeg";
        DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest
                .builder()
                .key(fileName)
                .bucket(bucketName)
                .build();
        s3.deleteObject(deleteObjectRequest);
    }
}
