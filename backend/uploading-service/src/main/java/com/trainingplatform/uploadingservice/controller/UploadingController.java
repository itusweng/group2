package com.trainingplatform.uploadingservice.controller;

import com.trainingplatform.uploadingservice.config.RabbitMQMessagingConfig;
import com.trainingplatform.uploadingservice.model.request.TrainingThumbnailRequestDTO;
import com.trainingplatform.uploadingservice.model.request.UserProfilePictureRequestDTO;
import com.trainingplatform.uploadingservice.service.UploadingService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/uploading")
@AllArgsConstructor
public class UploadingController extends BaseController {

    @Autowired
    private UploadingService uploadingService;

    @RabbitListener(queues = RabbitMQMessagingConfig.QUEUE_UPLOAD_PP)
    public void uploadUserProfilePicture(UserProfilePictureRequestDTO userProfilePictureRequestDTO){
        uploadingService.uploadImage(userProfilePictureRequestDTO);
    }

    @RabbitListener(queues = RabbitMQMessagingConfig.QUEUE_DELETE_PP)
    public void deleteUserProfilePicture(Long userID){
        uploadingService.deleteImage(userID);
    }

    @RabbitListener(queues = RabbitMQMessagingConfig.QUEUE_UPLOAD_TRAINING_THUMBNAIL)
    public void uploadTrainingThumbnail(TrainingThumbnailRequestDTO trainingThumbnailRequestDTO){
        uploadingService.uploadThumbnail(trainingThumbnailRequestDTO);
    }

    @RabbitListener(queues = RabbitMQMessagingConfig.QUEUE_DELETE_TRAINING_THUMBNAIL)
    public void deleteTrainingThumbnail(Long trainingID){
        uploadingService.deleteThumbnail(trainingID);
    }


}
