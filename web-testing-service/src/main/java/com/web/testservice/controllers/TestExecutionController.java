package com.web.testservice.controllers;

import com.web.testservice.services.TestExecutionService;
import com.web.testservice.models.TestExecutionRequest;
import com.web.testservice.models.TestExecutionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tests")
public class TestExecutionController {

    @Autowired
    private TestExecutionService testExecutionService;

    @PostMapping("/execute")
    public String executeTests(@RequestBody TestExecutionRequest request) {
        return testExecutionService.executeTests(request);
    }

    @GetMapping("/status/{executionId}")
    public TestExecutionResponse getTestStatus(@PathVariable String executionId) {
        return testExecutionService.getTestStatus(executionId);
    }
}
