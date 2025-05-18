package com.web.testservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TestExecutionResponse {
    private String executionId;
    private String message;
    private TestExecutionStatus status;

    public enum TestExecutionStatus {
        INITIATED, RUNNING, COMPLETED, FAILED
    }
}
