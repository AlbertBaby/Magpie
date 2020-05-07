package login;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pom.LoginPOM;
import testsuites.OpenSite;

public class Login {

	static Logger logger=Logger.getLogger(Login.class);
	OpenSite drv=new OpenSite();
	public WebDriver driver=drv.driver;
	
	@Test
	public void login( )  {
		
		FileInputStream stream = null;
		try {
			stream = new FileInputStream("config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties properties=new Properties();
		try {
			properties.load(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PropertyConfigurator.configure("log4j.properties");
		
		String Usrname=properties.getProperty("Username");
		String Password=properties.getProperty("Password");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		PageFactory.initElements(driver, LoginPOM.class);

		//LoginPOM.forgotPassword.click();
		//LoginPOM.cancelButton.click();

		LoginPOM.userName.sendKeys(Usrname);
		LoginPOM.password.sendKeys(Password);
		LoginPOM.loginButton.click();

		if(LoginPOM.logo.getAttribute("naturalHeight").equals("0")) 
			logger.error("Logo is broken");
		else
			logger.info("Logo is not broken");

	}
}
