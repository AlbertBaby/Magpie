package com.web.testservice.steps;

import com.web.testservice.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.logging.Logger;

import org.junit.Assert;


public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    Logger logger = Logger.getLogger(LoginSteps.class.getName());

    @Autowired
    private TestRestTemplate restTemplate; // Example of Spring dependency injection

    private ResponseEntity<String> response;

    @Before
    public void setup() {
        // driver = new ChromeDriver();
        // loginPage = new LoginPage(driver);
        logger.info("Setting up the WebDriver and LoginPage instance.");
    }

    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        // driver.get("your_login_page_url");
        logger.info("Navigating to the login page.");
    }

    @When("User enters valid username and password")
    public void userEntersValidUsernameAndPassword() {
        // loginPage.enterCredentials("testuser", "testpass");
        logger.info("Entering valid username and password.");
    }

    @When("User clicks the login button")
    public void userClicksTheLoginButton() {
        // loginPage.clickLoginButton();
        logger.info("Clicking the login button.");
    }

    @Then("User should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {
        // Assert.assertTrue("Login was not successful", loginPage.isLoginSuccessful());
        logger.info("Verifying successful login.");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}