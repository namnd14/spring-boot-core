package com.spring.core.controller;

import com.spring.core.dto.request.RecordExperimentRequest;
import com.spring.core.dto.response.RecordExperimentResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecordExperimentController {

    @PostMapping("/record-experiment")
    public void recordExperiment(@RequestBody RecordExperimentRequest request) {
        // This method is intentionally left blank to demonstrate the use of Java records in Spring Boot.
        System.out.println("Received RecordExperimentRequest: " + request);
    }

    @GetMapping("/record-experiment")
    public RecordExperimentResponse getRecordResponse() {
        // This method is intentionally left blank to demonstrate the use of Java records in Spring Boot.
        RecordExperimentResponse response = new RecordExperimentResponse(1, 123456789L, "Sample Experiment",
                java.time.LocalDate.now(), java.time.LocalDateTime.now(), true);
        System.out.println("Returning RecordExperimentResponse: " + response);
        return response;
    }
}
