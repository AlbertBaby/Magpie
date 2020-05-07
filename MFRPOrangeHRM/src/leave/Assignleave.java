package leave;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import pom.AssignLeaveObj;

public class Assignleave {
	
	static Logger logger=Logger.getLogger(Assignleave.class);
	@Test
	public void assLeave(WebDriver driver) {
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

		String empName=properties.getProperty("EmployeeName");
		String fromDate=properties.getProperty("LeaveFromDate");
		String toDate=properties.getProperty("LeaveToDate");
		
		PropertyConfigurator.configure("config.properties");
		
		PageFactory.initElements(driver, AssignLeaveObj.class);
		
		//Assigning leave
		AssignLeaveObj.leavebutton.click();
		AssignLeaveObj.assignleave.click();
		AssignLeaveObj.empname.sendKeys(empName+Keys.ENTER);
		        
		Select select=new Select(AssignLeaveObj.leavetype);
		select.selectByValue("3");

		AssignLeaveObj.fromdate.clear();
		AssignLeaveObj.fromdate.click();
		AssignLeaveObj.fromdate.sendKeys(fromDate +Keys.ENTER);

		AssignLeaveObj.todate.clear();
		AssignLeaveObj.todate.click();
		AssignLeaveObj.todate.sendKeys(toDate +Keys.ENTER);
		
		Select select1= new Select(AssignLeaveObj.partialdays);
		select1.selectByVisibleText("None");

		AssignLeaveObj.assignbutton.click();
		AssignLeaveObj.clickok.click();
		logger.info("Leave assigned successfully");

	

	}

}
