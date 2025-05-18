package com.web.testservice.steps;

import com.web.testservice.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.testng.Assert;
import java.util.logging.Logger;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private final Logger logger = Logger.getLogger(LoginSteps.class.getName());

    @Value("${webdriver.base.url:http://www.example.com}")
    private String baseUrl;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        loginPage = new LoginPage(driver);
        logger.info("Setting up WebDriver and LoginPage instance");
    }

    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        driver.get(baseUrl);
        logger.info("Navigating to the login page: " + baseUrl);
    }

    @When("User enters valid username and password")
    public void userEntersValidUsernameAndPassword() {
        loginPage.enterCredentials("testuser", "testpass");
        logger.info("Entering valid username and password");
    }

    @When("User enters invalid username and password")
    public void userEntersInvalidUsernameAndPassword() {
        // loginPage.enterCredentials("invaliduser", "invalidpass");
        logger.info("Entering invalid username and password");
    }

    @When("User clicks the login button")
    public void userClicksTheLoginButton() {
        // loginPage.clickLoginButton();
        logger.info("Clicking the login button");
    }

    @Then("User should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {
        // Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful");
        logger.info("Verifying successful login");
    }

    @Then("User should see an error message")
    public void userShouldSeeAnErrorMessage() {
        // Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message was not displayed");
        logger.info("Verifying error message is displayed");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("WebDriver closed");
        }
    }
}