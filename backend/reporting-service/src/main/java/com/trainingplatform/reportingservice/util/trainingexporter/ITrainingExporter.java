package com.trainingplatform.reportingservice.util.trainingexporter;

import com.trainingplatform.reportingservice.model.training.response.UserResponseDTO;
import com.trainingplatform.reportingservice.model.training.response.TrainingResponseDTO;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public abstract class ITrainingExporter {

    protected abstract void exportTrainingParticipants(HttpServletResponse response, List<UserResponseDTO> participants, TrainingResponseDTO training) throws IOException;
}