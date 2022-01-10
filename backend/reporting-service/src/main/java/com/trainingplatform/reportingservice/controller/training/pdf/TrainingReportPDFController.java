package com.trainingplatform.reportingservice.controller.training.pdf;

import com.trainingplatform.reportingservice.controller.BaseController;
import com.trainingplatform.reportingservice.model.training.response.TrainingResponseDTO;
import com.trainingplatform.reportingservice.model.training.response.UserResponseDTO;
import com.trainingplatform.reportingservice.service.TrainingParticipantService;
import com.trainingplatform.reportingservice.util.exporter.ExporterProvider;
import com.trainingplatform.reportingservice.util.trainingexporter.pdf.TrainingParticipantPdfExporter;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reporting/training")
public class TrainingReportPDFController extends BaseController {

    private final TrainingParticipantService participantService;
    private final TrainingParticipantPdfExporter pdfExporter;
    private final ExporterProvider exporterProvider;

    @GetMapping("/{id}/pdf/export/allParticipants")
    public void exportAllParticipantsByTrainingId(HttpServletResponse response, @PathVariable Long id) {
        try{
            List<UserResponseDTO> participants = participantService.getTrainingParticipants(id);
            TrainingResponseDTO training = participantService.getTrainingModel(id);
            exporterProvider.setResponse(response, "denemeTraining.pdf");

            pdfExporter.exportTrainingParticipants(response,participants, training);
            //return ResponseEntity.ok(createReturnObj(String.format("Users are fetched successfully by training id: %d!", id), participants));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}