package com.trainingplatform.reportingservice.util.exporter;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
public class ExporterProvider implements IPDFExporter {

    @Override
    public void setResponse(HttpServletResponse response, String fileName) {
        response.setContentType("application/pdf");
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=%s", fileName);
        response.setHeader(headerKey, headerValue);
    }
}
