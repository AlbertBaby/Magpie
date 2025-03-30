package com.orchestrator.testservice.models;

import java.util.List;

public class TestSuiteResult {
    private List<TestExecutionResult> results;

    public List<TestExecutionResult> getResults() {
        return results;
    }

    public void setResults(List<TestExecutionResult> results) {
        this.results = results;
    }
}