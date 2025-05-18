package com.web.testservice.services.impl;

import com.web.testservice.services.TestExecutionService;
import com.web.testservice.models.TestExecutionRequest;
import com.web.testservice.models.TestExecutionResponse;
import org.springframework.stereotype.Service;
import java.io.File;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class TestExecutionServiceImpl implements TestExecutionService {
    private final ConcurrentHashMap<String, TestExecutionResponse> executionResults = new ConcurrentHashMap<>();
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Override
    public String executeTests(TestExecutionRequest request) {
        String executionId = UUID.randomUUID().toString();
        TestExecutionResponse response = new TestExecutionResponse(executionId, "Test execution started", TestExecutionResponse.TestExecutionStatus.RUNNING);
        executionResults.put(executionId, response);

        executorService.submit(() -> {
            try {
                // Set environment variables for tags if provided
                if (request.getTags() != null && request.getTags().length() > 0) {
                    System.setProperty("cucumber.filter.tags", String.join(" and ", request.getTags()));
                }                // Execute tests using system command
                ProcessBuilder processBuilder = new ProcessBuilder("mvn", "test", "-Dcucumber.filter.tags=" + String.join(" and ", request.getTags()));
                processBuilder.directory(new File(System.getProperty("user.dir")));
                Process process = processBuilder.start();
                
                boolean completed = process.waitFor(10, TimeUnit.MINUTES);
                
                TestExecutionResponse result;
                if (completed && process.exitValue() == 0) {
                    result = new TestExecutionResponse(
                        executionId,
                        "Tests executed successfully",
                        TestExecutionResponse.TestExecutionStatus.COMPLETED
                    );
                } else {
                    result = new TestExecutionResponse(
                        executionId,
                        "Test execution failed",
                        TestExecutionResponse.TestExecutionStatus.FAILED
                    );
                }
                executionResults.put(executionId, result);            } catch (Exception e) {
                TestExecutionResponse result = new TestExecutionResponse(
                    executionId,
                    "Error: " + e.getMessage(),
                    TestExecutionResponse.TestExecutionStatus.FAILED
                );
                executionResults.put(executionId, result);
            } finally {
                // Clear any system properties we set
                System.clearProperty("cucumber.filter.tags");
            }
        });

        return executionId;
    }

    @Override
    public TestExecutionResponse getTestStatus(String executionId) {
        return executionResults.getOrDefault(executionId, 
            createErrorResponse("No execution found for ID: " + executionId));
    }    private TestExecutionResponse createErrorResponse(String message) {
        return new TestExecutionResponse(
            UUID.randomUUID().toString(),
            message,
            TestExecutionResponse.TestExecutionStatus.FAILED
        );
    }
}
