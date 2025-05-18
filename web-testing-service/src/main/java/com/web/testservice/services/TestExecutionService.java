package com.web.testservice.services;

import com.web.testservice.models.TestExecutionRequest;
import com.web.testservice.models.TestExecutionResponse;

public interface TestExecutionService {
    String executeTests(TestExecutionRequest request);
    TestExecutionResponse getTestStatus(String executionId);
}
