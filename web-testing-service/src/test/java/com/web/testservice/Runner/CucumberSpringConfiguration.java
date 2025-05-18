package com.web.testservice.Runner;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import com.web.testservice.WebTestServiceApplication;

@CucumberContextConfiguration
@SpringBootTest(
    classes = WebTestServiceApplication.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class CucumberSpringConfiguration {
    // This class configures Cucumber to use Spring's test context
}
