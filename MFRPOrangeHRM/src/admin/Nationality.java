package admin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pom.NatPageObject;

public class Nationality {
	
	static Logger logger=Logger.getLogger(Nationality.class);

	@Test
	public void NatIcons(WebDriver driver) {
		
		//Loading  the properties file
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
		
		String nationName=properties.getProperty("Add_Nationality");
		PropertyConfigurator.configure("config.properties");
		  
		PageFactory.initElements(driver,NatPageObject.class);
        //Adding Nationality
		NatPageObject.nat.click();
		NatPageObject.addd.click();
		NatPageObject.ntname.sendKeys(nationName);
		NatPageObject.save1.click();
		logger.info("Nationality added successfully");
	}
}
