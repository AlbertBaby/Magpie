package performance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


import pom.PerformancePOM;

public class ManageReviews {
	static Logger logger=Logger.getLogger(ManageReviews.class);
	@Test
	public void manageReviews(WebDriver driver)  {

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

		String EmpName=properties.getProperty("EmployeeName");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		PropertyConfigurator.configure("config.properties");
		PageFactory.initElements(driver, PerformancePOM.class);

		/// PERFORMANCE MODULE

		PerformancePOM.perform.click();
		PerformancePOM.manage.click();
		PerformancePOM.kpival.click();
		PerformancePOM.add.click();
		PerformancePOM.name.sendKeys(EmpName +Keys.ENTER);
		logger.info("Performance module is working");
	}
}