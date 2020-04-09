package testCases;

import java.awt.AWTException;
import java.awt.Event;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

//import pageObjectModel.AddEmployee1;
import pageObjectModel.AddUser;
import pageObjectModel.LoginPageObjects;

public class LoginPage {

	@Test
	public void login() throws AWTException {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();

		PageFactory.initElements(driver, LoginPageObjects.class);

		LoginPageObjects.username.sendKeys("Admin");
		LoginPageObjects.password.sendKeys("admin123");
		LoginPageObjects.loginBtn.click();

		//PageFactory.initElements(driver, AddEmployee1.class);
		/*
		 * AddEmployee1.adminPanel.click(); AddEmployee1.addEmployee.click(); Select
		 * select= new Select(AddEmployee1.userRole); select.selectByIndex(1);
		 * 
		 * AddEmployee1.employeeName.sendKeys("Hannah Flores");
		 * AddEmployee1.userName.sendKeys("Franklin Rosevelt"); Select select1= new
		 * Select(AddEmployee1.status); select1.selectByVisibleText("Enabled");
		 * 
		 * String password="IamHannah123$$GGhh";
		 * AddEmployee1.password.sendKeys(password);
		 * AddEmployee1.confirmPassword.sendKeys(password);
		 * AddEmployee1.saveBtn.click();
		 */
		PageFactory.initElements(driver, AddUser.class);

		AddUser.adminPaneL.click(); 
		AddUser.addUseR.click();
		AddUser.userNamE.sendKeys("Sagar"+Keys.TAB+"Alias"+Keys.TAB+"Jacky");
		AddUser.employeeID.clear();
		AddUser.employeeID.sendKeys("2211");
		
		Actions act=new Actions(driver);
		act.click(AddUser.uploadPhoto).build().perform();

		String path="D:\\Temp\\MyPhoto.png";
		StringSelection stringSelection = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_V);
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);

		
		act.click(AddUser.checckBox).build().perform();

		AddUser.userName.sendKeys("Franklin Rosevelt"); 
		String password="IamHannah123$$GGhh";
		AddUser.password.sendKeys(password);
		AddUser.confirmPassword.sendKeys(password);
		Select select1= new Select(AddUser.status);
		select1.selectByVisibleText("Enabled");
		AddUser.saveBtn.click();
	}

}
