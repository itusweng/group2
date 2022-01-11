package com.trainingplatform.reportingservice.util.exporter;

import javax.servlet.http.HttpServletResponse;

public interface IPDFExporter {

    void setResponse(HttpServletResponse response, String fileName);
}