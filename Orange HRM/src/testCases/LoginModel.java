package testCases;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import pageObjectModel.AddEmplyee;
import pageObjectModel.LoginObjects;

public class LoginModel {
	
	@Test
	public void login() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe" );
		WebDriver driver= new ChromeDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		
		
		LoginObjects.username(driver).sendKeys("Admin");
		LoginObjects.password(driver).sendKeys("admin123");
		LoginObjects.button(driver).click();
		
		AddEmplyee.Admin(driver).click();
		AddEmplyee.AddButton(driver).click();
		Select select =new Select(AddEmplyee.userRole(driver));
		select.selectByIndex(0);
		
		AddEmplyee.EmployeeName(driver).sendKeys("Hannah Flores");
		//List<WebElement> newList=AddEmplyee.EmployeeName(driver);
		AddEmplyee.UserName(driver).sendKeys("jamesmc");
		Select select1=new Select(AddEmplyee.UserStatus(driver));
		select1.selectByIndex(0);
		
		String password="James123**&&HHgg";
		AddEmplyee.UserPassword(driver).sendKeys(password);
		AddEmplyee.PasswordConfirm(driver).sendKeys(password);
		
		Thread.sleep(4005);
		AddEmplyee.SaveButton(driver).click();
		
		
		driver.close();
	}

}
