package com.trainingplatform.reportingservice.controller.training.excel;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reporting/training")
public class TrainingReportExcelController {

    @GetMapping("/{id}/excel/export/allParticipants")
    public ResponseEntity test(@RequestParam Long trainingId){
        return ResponseEntity.ok("Success");
    }
}