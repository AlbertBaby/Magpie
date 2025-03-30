package com.orchestrator.testservice.controllers;

import com.orchestrator.testservice.models.TestSuiteRequest;
import com.orchestrator.testservice.models.TestSuiteResult;
import com.orchestrator.testservice.services.OrchestrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrchestrationController {

    @Autowired
    private OrchestrationService orchestrationService;

    @PostMapping("/executeSuite")
    public TestSuiteResult executeTestSuite(@RequestBody TestSuiteRequest request) {
        return orchestrationService.executeTestSuite(request);
    }
}