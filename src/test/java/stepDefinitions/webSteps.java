package stepDefinitions;

import io.cucumber.java.en.Given;
import utils.DriverManager;
import org.openqa.selenium.WebDriver;

public class webSteps {
    private WebDriver driver;

    public webSteps() {
        this.driver = DriverManager.getDriver();
    }

    @Given("^user navigates to application$")
    public void userApplicationNavigation() {
        driver.get("https://www.linkedin.com/feed/");
    }
}
