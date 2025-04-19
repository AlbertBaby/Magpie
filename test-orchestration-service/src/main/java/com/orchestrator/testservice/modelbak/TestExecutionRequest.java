package com.orchestrator.testservice.model;

public class TestExecutionRequest {
    private String testId;
    private String testName;
    
    // Getters and Setters
    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }
}
