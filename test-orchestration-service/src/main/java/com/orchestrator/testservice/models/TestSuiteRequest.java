package com.orchestrator.testservice.models;

import java.util.List;

public class TestSuiteRequest {
    private List<TestExecutionRequest> testRequests;

    public List<TestExecutionRequest> getTestRequests() {
        return testRequests;
    }

    public void setTestRequests(List<TestExecutionRequest> testRequests) {
        this.testRequests = testRequests;
    }
}