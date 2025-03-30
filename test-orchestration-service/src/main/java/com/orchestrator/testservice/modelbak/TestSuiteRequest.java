package com.orchestrator.testservice.model;

public class TestSuiteRequest {
    private String suiteId;
    private String suiteName;
    
    // Getters and Setters
    public String getSuiteId() {
        return suiteId;
    }

    public void setSuiteId(String suiteId) {
        this.suiteId = suiteId;
    }

    public String getSuiteName() {
        return suiteName;
    }

    public void setSuiteName(String suiteName) {
        this.suiteName = suiteName;
    }
}
