package com.web.testservice.models;

import lombok.Data;

@Data
public class TestExecutionRequest {
    private String tags;
    private String environment;
    private Boolean isParallel;
}
