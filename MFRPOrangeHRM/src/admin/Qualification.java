package admin;

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

import pom.QualificationsObj;

public class Qualification {
	static Logger logger=Logger.getLogger(Qualification.class);
	@Test
	public void qualIcons(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
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
		
		
		String skillGiven=properties.getProperty("SkillName");
		String skillDesc=properties.getProperty("SkillDescription");
		PropertyConfigurator.configure("config.properties");
		
		
		 PageFactory.initElements(driver,QualificationsObj.class);
		 
		 //Adding skills
		 QualificationsObj.qualification.click();
		 QualificationsObj.skills.click();
		 QualificationsObj.add2.click();
		 QualificationsObj.skname.sendKeys(skillGiven);
		 QualificationsObj.skdesc.sendKeys(skillDesc);
		 QualificationsObj.savee.click();
		 logger.info("New Skill added successfully");
		 QualificationsObj.qualification.click();
		 
	}
}
