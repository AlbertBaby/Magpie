package config;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class TestConfig {
    @BeforeSuite
    @Parameters({"browser", "environment"})
    public void setupTest(@Optional("chrome") String browser, 
                         @Optional("qa") String environment) {
        System.setProperty("browser", browser);
        System.setProperty("environment", environment);
    }
}