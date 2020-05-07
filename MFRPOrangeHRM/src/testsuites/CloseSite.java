package testsuites;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

public class CloseSite {

	@AfterSuite
	public void closeBrowser(WebDriver driver) {
		driver.quit();
	}

}
