package com.trainingplatform.trainingservice.trainingservice;

import com.trainingplatform.trainingservice.trainingservice.model.entity.OnlineLessonModel;
import com.trainingplatform.trainingservice.trainingservice.model.entity.TrainingModel;
import com.trainingplatform.trainingservice.trainingservice.model.mapper.OnlineLessonModelMapper;
import com.trainingplatform.trainingservice.trainingservice.model.response.onlinelesson.OnlineLessonResponseDTO;
import com.trainingplatform.trainingservice.trainingservice.repository.OnlineLessonRepository;
import com.trainingplatform.trainingservice.trainingservice.service.OnlineLessonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class OnlineLessonServiceTest {
    @InjectMocks
    OnlineLessonService onlineLessonService;

    @Mock private OnlineLessonRepository onlineLessonRepo;
    @Mock private  OnlineLessonModelMapper onlineLessonModelMapper;

    @Test
    public void it_should_return_onlinelessonresponsedtolist_when_training_found(){
        OnlineLessonModel onlineLessonModel = mock(OnlineLessonModel.class);
        when(onlineLessonRepo.findAllByTrainingID(1L)).thenReturn(List.of(onlineLessonModel));
        List<OnlineLessonResponseDTO> onlineLessonResponseDTOS = new ArrayList<>();
        OnlineLessonResponseDTO onlineLessonResponseDTO = mock(OnlineLessonResponseDTO.class);
        when(onlineLessonModelMapper.mapToDto(onlineLessonModel)).thenReturn(onlineLessonResponseDTO);
        onlineLessonResponseDTOS.add(onlineLessonResponseDTO);
        //act
        List<OnlineLessonResponseDTO> onlineLessonResponseDTOS1 = onlineLessonService.getOnlineLessons(1L);
        //assert
        assertThat(onlineLessonResponseDTOS).isEqualTo(onlineLessonResponseDTOS1);
    }

    @Test
    public void it_should_return_onlinelessonresponsedto_when_lesson_created(){
        //arrange
        OnlineLessonModel onlineLessonModel = mock(OnlineLessonModel.class);
        OnlineLessonModel savedOnlineLessonModel = mock(OnlineLessonModel.class);
        when(onlineLessonRepo.save(onlineLessonModel)).thenReturn(savedOnlineLessonModel);
        TrainingModel trainingModel = mock(TrainingModel.class);
        when(savedOnlineLessonModel.getTraining()).thenReturn(trainingModel);
        when(savedOnlineLessonModel.getTraining().getId()).thenReturn(1L);
        OnlineLessonResponseDTO onlineLessonResponseDTO = mock(OnlineLessonResponseDTO.class);
        when(onlineLessonModelMapper.mapToDto(savedOnlineLessonModel)).thenReturn(onlineLessonResponseDTO);
        onlineLessonResponseDTO.setTraining_id(savedOnlineLessonModel.getTraining().getId());
        //act
        OnlineLessonResponseDTO onlineLessonResponseDTO1 = onlineLessonService.createOnlineLesson(onlineLessonModel);
        //assert
        assertThat(onlineLessonResponseDTO).isEqualTo(onlineLessonResponseDTO1);
    }

    @Test
    public void it_should_delete_lesson_when_lesson_found(){
        //arrange
        //act
        onlineLessonService.deleteOnlineLesson(1L);
        //arrange
        verify(onlineLessonRepo, times(1)).deleteById(any(Long.class));
    }

    @Test
    public void it_should_return_onlinelesson_when_lesson_found(){
        //arrange
        OnlineLessonModel onlineLessonModel = mock(OnlineLessonModel.class);
        when(onlineLessonRepo.findById(1L)).thenReturn(Optional.of(onlineLessonModel));
        //act
        OnlineLessonModel onlineLessonModel1 = onlineLessonService.getOnlineLessonById(1L);
        //assert
        assertThat(onlineLessonModel).isEqualTo(onlineLessonModel1);
    }

    @Test
    public void test_updateOnlineLesson(){
        //arrange
        OnlineLessonModel existingLesson = mock(OnlineLessonModel.class);
        OnlineLessonModel updatedLesson = mock(OnlineLessonModel.class);
        when(updatedLesson.getId()).thenReturn(1L);
        when(onlineLessonRepo.findById(1L)).thenReturn(Optional.of(existingLesson));
        //act
        onlineLessonService.updateOnlineLesson(updatedLesson);
        //assert
        verify(onlineLessonModelMapper, times(1)).updateFields(any(OnlineLessonModel.class), any(OnlineLessonModel.class));
        verify(onlineLessonRepo, times(1)).save(any(OnlineLessonModel.class));
    }
}
