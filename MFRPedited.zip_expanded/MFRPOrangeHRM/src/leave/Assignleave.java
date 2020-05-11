package leave;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import baseDriverClass.BaseWebDriver;
import pom.AssignLeaveObj;

public class Assignleave extends BaseWebDriver{
	
	static Logger logger=Logger.getLogger(Assignleave.class);
	@Test
	public void assLeave() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		

		String empName=properties.getProperty("EmployeeName");
		String fromDate=properties.getProperty("LeaveFromDate");
		String toDate=properties.getProperty("LeaveToDate");
		
		PropertyConfigurator.configure("log4j.properties");
		
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
