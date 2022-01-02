package com.trainingplatform.reportingservice.util.exporter;

import javax.servlet.http.HttpServletResponse;

public interface IExporter {

    void setResponse(HttpServletResponse response, String fileName);
}
