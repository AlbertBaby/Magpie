package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverManager;

public class Hooks {
    @Before
    public void setup() {
        // Any setup code
    }

    @After
    public void teardown() {
        DriverManager.quitDriver();
    }
}