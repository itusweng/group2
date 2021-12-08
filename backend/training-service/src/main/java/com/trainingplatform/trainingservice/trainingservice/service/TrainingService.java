package com.trainingplatform.trainingservice.trainingservice.service;

import com.trainingplatform.trainingservice.trainingservice.model.TrainingModel;
import com.trainingplatform.trainingservice.trainingservice.repository.TrainingRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingService {

    private final TrainingRepository trainingRepo;

    public List<TrainingModel> getAllTrainings(){
        return trainingRepo.findAll();
    }
}
