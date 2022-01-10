package com.trainingplatform.trainingservice.trainingservice;

import com.trainingplatform.trainingservice.trainingservice.model.entity.OfflineLessonModel;
import com.trainingplatform.trainingservice.trainingservice.model.entity.TrainingModel;
import com.trainingplatform.trainingservice.trainingservice.model.mapper.OfflineLessonModelRequestMapper;
import com.trainingplatform.trainingservice.trainingservice.model.mapper.OfflineLessonModelResponseMapper;
import com.trainingplatform.trainingservice.trainingservice.model.request.offlinelesson.OfflineLessonRequestDTO;
import com.trainingplatform.trainingservice.trainingservice.model.request.offlinelesson.OfflineLessonStreamRequestDTO;
import com.trainingplatform.trainingservice.trainingservice.model.response.offlinelesson.OfflineLessonResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.repository.OfflineLessonRepository;
import com.trainingplatform.trainingservice.trainingservice.repository.TrainingRepository;
import com.trainingplatform.trainingservice.trainingservice.service.OfflineLessonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class OfflineLessonServiceTest {

    @InjectMocks
    OfflineLessonService offlineLessonService;

    @Mock private OfflineLessonRepository offlineLessonRepo;
    @Mock private OfflineLessonModelResponseMapper offlineLessonModelMapper;
    @Mock private OfflineLessonModelRequestMapper offlineLessonModelRequestMapper;
    @Mock private TrainingRepository trainingRepo;
    @Mock private RabbitTemplate rabbitTemplate;

    @Test
    void it_should_return_offlinelessonresponsedtlist_when_training_found(){
        //arrange
        OfflineLessonModel offlineLessonModel = mock(OfflineLessonModel.class);
        OfflineLessonResponseDTO offlineLessonResponseDTO = mock(OfflineLessonResponseDTO.class);
        List<OfflineLessonResponseDTO> offlineLessonResponseDTOS = new ArrayList<>();
        when(offlineLessonRepo.findAllByTrainingID(1L)).thenReturn(List.of(offlineLessonModel));
        when(offlineLessonModelMapper.mapToDto(offlineLessonModel)).thenReturn(offlineLessonResponseDTO);
        offlineLessonResponseDTOS.add(offlineLessonResponseDTO);
        //act
        List<OfflineLessonResponseDTO> offlineLessonResponseDTOS1 = offlineLessonService.getOfflineLessons(1L);
        //assert
        assertThat(offlineLessonResponseDTOS1).isEqualTo(offlineLessonResponseDTOS);
    }

    @Test
    void it_should_return_emptylist_when_training_not_found(){
        //arrange
        when(offlineLessonRepo.findAllByTrainingID(1L)).thenReturn(List.of());
        //act
        List<OfflineLessonResponseDTO> offlineLessonResponseDTOS1 = offlineLessonService.getOfflineLessons(1L);
        //assert
        assertThat(offlineLessonResponseDTOS1).isEqualTo(List.of());
    }

    @Test
    void it_should_return_offlinelessonresponsedto_when_lesson_created() throws IOException {
        OfflineLessonRequestDTO offlineLessonRequestDTO = mock(OfflineLessonRequestDTO.class);
        OfflineLessonModel offlineLessonModel = mock(OfflineLessonModel.class);
        when(offlineLessonModelRequestMapper.mapToEntity(offlineLessonRequestDTO)).thenReturn(offlineLessonModel);
        when(offlineLessonRequestDTO.getTraining_id()).thenReturn(1L);
        TrainingModel trainingModel = mock(TrainingModel.class);
        when(trainingRepo.getById(1L)).thenReturn(trainingModel);
        OfflineLessonModel savedOfflineLessonModel = mock(OfflineLessonModel.class);
        when(offlineLessonRepo.save(offlineLessonModel)).thenReturn(savedOfflineLessonModel);
        OfflineLessonResponseDTO offlineLessonResponseDTO = mock(OfflineLessonResponseDTO.class);
        when(offlineLessonModelMapper.mapToDto(savedOfflineLessonModel)).thenReturn(offlineLessonResponseDTO);
        when(savedOfflineLessonModel.getTraining()).thenReturn(trainingModel);
        when(trainingModel.getId()).thenReturn(1L);
        offlineLessonResponseDTO.setTraining_id(savedOfflineLessonModel.getTraining().getId());
        when(offlineLessonResponseDTO.getId()).thenReturn(1L);
        when(offlineLessonRequestDTO.getTraining_id()).thenReturn(1L);
        MultipartFile videoFile = mock(MultipartFile.class);
        when(offlineLessonRequestDTO.getVideoFile()).thenReturn(videoFile);
        OfflineLessonStreamRequestDTO offlineLessonStreamRequestDTO = mock(OfflineLessonStreamRequestDTO.class);
        when(offlineLessonStreamRequestDTO.getOfflineLessonId()).thenReturn(1L);
        when(offlineLessonStreamRequestDTO.getTrainingId()).thenReturn(1L);
        when(offlineLessonStreamRequestDTO.getVideoFile()).thenReturn(any(byte[].class));
        //act
        OfflineLessonResponseDTO offlineLessonResponseDTO1 = offlineLessonService.createOfflineLesson(offlineLessonRequestDTO);
        verify(rabbitTemplate, times(1)).convertAndSend(any(String.class), any(String.class), any(OfflineLessonStreamRequestDTO.class));
        //assert
        assertThat(offlineLessonResponseDTO1).isEqualTo(offlineLessonResponseDTO);
    }

    @Test
    void it_should_delete_lesson(){
        //arrange
        //act
        offlineLessonService.deleteOfflineLesson(1L, 8L);
        //assert
        verify(rabbitTemplate, times(1)).convertAndSend(any(String.class), any(String.class), any(HashMap.class));
        verify(offlineLessonRepo, times(1)).deleteById(any(Long.class));
    }

    @Test
    void it_should_update_lesson(){
        //arrange
        OfflineLessonRequestDTO offlineLessonRequestDTO = mock(OfflineLessonRequestDTO.class);
        OfflineLessonModel offlineLessonModel = mock(OfflineLessonModel.class);
        when(offlineLessonRepo.findById(8L)).thenReturn(Optional.of(offlineLessonModel));
        //act
        offlineLessonService.updateOfflineLesson(8L, offlineLessonRequestDTO);
        //assert
        verify(offlineLessonModelRequestMapper,times(1)).updateFields(any(OfflineLessonModel.class), any(OfflineLessonRequestDTO.class));
        verify(offlineLessonRepo,times(1)).save(any(OfflineLessonModel.class));
    }

}
