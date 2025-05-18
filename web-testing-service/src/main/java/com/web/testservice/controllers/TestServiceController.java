package com.web.testservice.controllers;

import com.web.testservice.models.TestExecutionRequest;
import com.web.testservice.models.TestExecutionResponse;
import com.web.testservice.services.TestExecutionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/web-test")
public class TestServiceController {

    @Autowired
    private TestExecutionService testExecutionService;

    // @PostMapping("/execute")
    // public ResponseEntity<TestExecutionResponse> executeTests(@RequestBody TestExecutionRequest request) {
    //     String executionId = testExecutionService.executeTests(request);
    //     return ResponseEntity.ok(new TestExecutionResponse(executionId, "Test execution started"));
    // }

    @GetMapping("/status/{executionId}")
    public ResponseEntity<TestExecutionResponse> getTestStatus(@PathVariable String executionId) {
        return ResponseEntity.ok(testExecutionService.getTestStatus(executionId));
    }
}
