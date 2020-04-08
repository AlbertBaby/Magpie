package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ValidUsername {
	
	@Test
	@Parameters({"usrname","pssword"})
	public void test1(String getName, String getPass) {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe" );
		WebDriver driver= new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		WebElement username=driver.findElement(By.id("txtUsername"));
		username.sendKeys(getName);
		
		WebElement password=driver.findElement(By.id("txtPassword"));
		password.sendKeys(getPass);
		
		WebElement logIn=driver.findElement(By.id("btnLogin"));
		logIn.click();
		
		driver.quit();
	}

}
