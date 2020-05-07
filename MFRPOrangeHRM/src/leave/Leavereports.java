package leave;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import pom.LeaveReportsObj;

public class Leavereports {

	static Logger logger=Logger.getLogger(Leavereports.class);
	@Test
	public void leaveRep(WebDriver driver) {

		// TODO Auto-generated method stub
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

		PropertyConfigurator.configure("config.properties");	  

		PageFactory.initElements(driver,LeaveReportsObj.class);


		LeaveReportsObj.reports.click();
		LeaveReportsObj.viewleave.click();

		Select select2=new Select(LeaveReportsObj.generate);
		select2.selectByValue("1");
		LeaveReportsObj.typeofleave.click();
		LeaveReportsObj.period.click();
		LeaveReportsObj.pastemp.click();
		LeaveReportsObj.view.click();
		logger.info("Added leave");
	}

}
