package login;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import objectsRepository.LoginPageObjects;
import pimTab.AddEmployee;
import recruitmentTab.Candidates;

public class LoginAndImg {

	public String url = "https://opensource-demo.orangehrmlive.com/";
	public WebDriver driver = null;
	public Logger logger = Logger.getLogger(LoginAndImg.class);

	@Test
	public void intialize() throws IOException, InterruptedException, AWTException {

		FileInputStream path = new FileInputStream("config.properties");
		Properties prop = new Properties();
		prop.load(path);
		String browser = prop.getProperty("browser");
		String driverLocn = prop.getProperty("driverLocation");
		DOMConfigurator.configure("DOM.xml");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverLocn);
			driver = new ChromeDriver();
		} else
			logger.fatal("Invalid browser name");

		driver.navigate().to(url);
		driver.manage().window().maximize();
		String username = prop.getProperty("Username"), password = prop.getProperty("Password");

		PageFactory.initElements(driver, LoginPageObjects.class);

		LoginPageObjects.username.sendKeys(username);
		LoginPageObjects.password.sendKeys(password);
		LoginPageObjects.loginBtn.click();

		String imgHeight = LoginPageObjects.logo.getAttribute("naturalHeight");

		if (imgHeight.equals("0"))
			logger.info("Logo Image is broken");
		else
			logger.info("Logo Image is not broken");

		AdminTests logIn=new AdminTests(); 
		logIn.adminPage(driver);
		
		TestOnJob into=new TestOnJob();
		into.jobTitles(driver);
		
		AddEmployee pim=new AddEmployee();
		pim.employeeDetails(driver);
		
		Candidates cand=new Candidates();
		cand.employeeDetails(driver);

	}

}
