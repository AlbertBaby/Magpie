package com.orchestrator.testservice.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;

import com.orchestrator.testservice.models.TestSuiteRequest;
import com.orchestrator.testservice.models.TestSuiteResult;
import com.orchestrator.testservice.models.TestExecutionRequest;
import com.orchestrator.testservice.models.TestExecutionResult;

@Service
public class OrchestrationService {
    private final RestTemplate restTemplate = new RestTemplate();

    public TestSuiteResult executeTestSuite(TestSuiteRequest request) {
        ExecutorService executor = Executors.newFixedThreadPool(request.getTestRequests().size());
        List<TestExecutionResult> results = new ArrayList<>();

        for (TestExecutionRequest testRequest : request.getTestRequests()) {
            executor.submit(() -> {
                TestExecutionResult result = executeTest(testRequest);
                results.add(result);
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        TestSuiteResult testSuiteResult = new TestSuiteResult();
        testSuiteResult.setResults(results);
        return testSuiteResult;
    }

    private TestExecutionResult executeTest(TestExecutionRequest request) {
        String url = getServiceUrl(request.getServiceType());
        return restTemplate.postForObject(url, request, TestExecutionResult.class);
    }

    private String getServiceUrl(String serviceType) {
        switch (serviceType) {
            case "mobile":
                return "http://mobile-test-service:8081/execute";
            case "web":
                return "http://web-test-service:8082/execute";
            case "api":
                return "http://api-test-service:8083/execute";
            default:
                throw new IllegalArgumentException("Invalid service type");
        }
    }
}