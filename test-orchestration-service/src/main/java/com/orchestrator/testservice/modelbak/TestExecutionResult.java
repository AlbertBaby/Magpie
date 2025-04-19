package com.orchestrator.testservice.model;

public class TestExecutionResult {
    private String testId;
    private String status;
    private String result;
    
    // Getters and Setters
    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
