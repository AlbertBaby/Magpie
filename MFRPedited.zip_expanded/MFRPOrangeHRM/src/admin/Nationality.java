package admin;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import baseDriverClass.BaseWebDriver;
import pom.NatPageObject;

public class Nationality extends BaseWebDriver{
	
	static Logger logger=Logger.getLogger(Nationality.class);

	@Test
	public void NatIcons() {
		
		//Loading  the properties file
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
		String nationName=properties.getProperty("Add_Nationality");
		PropertyConfigurator.configure("log4j.properties");
		  
		PageFactory.initElements(driver,NatPageObject.class);
        //Adding Nationality
		NatPageObject.nat.click();
		NatPageObject.addd.click();
		NatPageObject.ntname.sendKeys(nationName);
		NatPageObject.save1.click();
		logger.info("Nationality added successfully");
	}
}
