package firstSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestMethods {
	
	WebDriver driver;
	long startTime;
	
	@BeforeSuite
	public void startTest() {
		startTime=System.currentTimeMillis();
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe" );
		driver= new ChromeDriver();
	}
	
	@Test
	public void openGoogle() {
		driver.get("https://www.google.co.in/");
	}
	
	@Test
	public void openBing() {
		driver.get("https://www.bing.com/");
	}
	@AfterSuite
	public void endTest() {
		driver.quit();
		long endTime=System.currentTimeMillis();
		System.out.println("Total time ="+(endTime-startTime) );
	}

}
