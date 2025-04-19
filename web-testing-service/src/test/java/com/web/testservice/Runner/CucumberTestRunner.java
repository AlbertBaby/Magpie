package com.web.testservice.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"classpath:features"},
    glue = {"com.web.testservice.steps", "com.web.testservice.Runner"}, // Include the new configuration class
    plugin = {"pretty", "html:target/cucumber-reports"},
    monochrome = true,
    tags = "@smoke" // Default tag; overridden programmatically
)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Test // Add this annotation to ensure TestNG recognizes this as a test class
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
    static {
        // Dynamically set the tags property
        String tags = System.getProperty("cucumber.filter.tags", "@smoke");
        System.setProperty("cucumber.filter.tags", tags);
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
