package com.web.testservice.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"classpath:features"},
    glue = {"com.web.testservice.steps"},
    plugin = {"pretty", "html:target/cucumber-reports"},
    monochrome = true
)
public class CucumberTestRunner {
}
