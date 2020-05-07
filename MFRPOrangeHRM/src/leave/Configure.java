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

import pom.ConfigLeaveObj;
import pom.LeavePOM;

public class Configure {
	static Logger logger=Logger.getLogger(Configure.class);
	@Test
	public void login(WebDriver driver) {
		
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
	
		String lpStartMonth=properties.getProperty("StartMonth(LP)");
		String lpStartDate=properties.getProperty("EndDate");
		String ltName=properties.getProperty("LeaveTypeName");
		String MondayVal=properties.getProperty("Monday");
		String TuesdayVal=properties.getProperty("Tuesday");
		String WednesdayVal=properties.getProperty("Wednesday");
		String ThursdayVal=properties.getProperty("Thursday");
		String FridayVal=properties.getProperty("Friday");
		String SaturdayVal=properties.getProperty("Saturday");
		String SundayVal=properties.getProperty("Sunday");
		
		String holidayName=properties.getProperty("HolidayName");
		String holidayDate=properties.getProperty("HolidayDate");
		String repeatsOrNot=properties.getProperty("Repeats");
		String fullHalf=properties.getProperty("FullOrHalf");
		
		String startDate=properties.getProperty("StartDate");
		String endDate=properties.getProperty("EndDate");
		
		PropertyConfigurator.configure("config.properties");
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		PageFactory.initElements(driver,ConfigLeaveObj.class);
		PageFactory.initElements(driver, LeavePOM.class);
		
		//Leave Period
		ConfigLeaveObj.Leave.click();
		ConfigLeaveObj.Leave_config.click();
		ConfigLeaveObj.Leave_period.click();
		
		Select month=new Select(ConfigLeaveObj.L_startmonth);
		month.selectByVisibleText(lpStartMonth);
		ConfigLeaveObj.L_startmonth.click();

		Select date=new Select(ConfigLeaveObj.L_startdate);
		date.selectByVisibleText(lpStartDate);
		ConfigLeaveObj.L_startdate.click();
		ConfigLeaveObj.L_save.click();
		logger.info("leave period added successfully");
		
		//Leave types
		ConfigLeaveObj.Leave_config.click();
		ConfigLeaveObj.Leavetype.click();
		ConfigLeaveObj.LT_add.click();
		ConfigLeaveObj.LT_name.sendKeys(ltName);
		ConfigLeaveObj.LT_save.click();
		logger.info("leave type added successfully");
		//deleteing the leave type
		ConfigLeaveObj.Leave_config.click();
		ConfigLeaveObj.Leavetype.click();
		ConfigLeaveObj.LT_deltitem.click();
		ConfigLeaveObj.LT_delete.click();
		logger.info("deleted leave type successfully");
		ConfigLeaveObj.LTdelt_cancel.click();
		logger.info("cancel button is working");
		
		//WorkWeek Part
		LeavePOM.leaveButton.click();
		LeavePOM.configureButton.click();
		LeavePOM.workWeekButton.click();
		
		//Check if all elements are disabled
		Boolean mondayEnabled=LeavePOM.forMonday.isEnabled();
		logger.info(mondayEnabled);
		Boolean tuesdayEnabled=LeavePOM.forTuesday.isEnabled();
		logger.info(tuesdayEnabled);
		Boolean wednesdayEnabled=LeavePOM.forWednesday.isEnabled();
		logger.info(wednesdayEnabled);
		Boolean thursdayEnabled=LeavePOM.forThursday.isEnabled();
		logger.info(thursdayEnabled);
		Boolean fridayEnabled=LeavePOM.forFriday.isEnabled();
		logger.info(fridayEnabled);
		Boolean saturdayEnabled=LeavePOM.forSaturday.isEnabled();
		logger.info(saturdayEnabled);
		Boolean sundayEnabled=LeavePOM.forSunday.isEnabled();
		logger.info(sundayEnabled);
		String buttonStatus=LeavePOM.editAndSave.getAttribute("value");
		logger.info("The button is " +buttonStatus);
		
		//Editing the work days
		LeavePOM.editAndSave.click();
		String buttonStatusAfterClick=LeavePOM.editAndSave.getAttribute("value");
		logger.info("The button after clicking is " +buttonStatusAfterClick);
		
		Select monday=new Select(LeavePOM.forMonday);
		monday.selectByVisibleText(MondayVal);
		Select tuesday=new Select(LeavePOM.forTuesday);
		tuesday.selectByVisibleText(TuesdayVal);
		Select wednesday=new Select(LeavePOM.forWednesday);
		wednesday.selectByVisibleText(WednesdayVal);
		Select thursday=new Select(LeavePOM.forThursday);
		thursday.selectByVisibleText(ThursdayVal);
		Select friday=new Select(LeavePOM.forFriday);
		friday.selectByVisibleText(FridayVal);
		Select saturday=new Select(LeavePOM.forSaturday);
		saturday.selectByVisibleText(SaturdayVal);
		Select sunday=new Select(LeavePOM.forSunday);
		sunday.selectByVisibleText(SundayVal);
		
		LeavePOM.editAndSave.click();
		logger.info("Successfully updated");
		
		//Holiday Adding Part
		LeavePOM.configureButton.click();
		LeavePOM.holidayButton.click();
		LeavePOM.holidayAdd.click();
		
		LeavePOM.nameOfHoliday.sendKeys(holidayName);
		LeavePOM.dateOfHoliday.clear();
		LeavePOM.dateOfHoliday.sendKeys(holidayDate+Keys.ENTER);
		if(repeatsOrNot=="Yes") 
			LeavePOM.repeatHoliday.click();
		Select dayLength=new Select(LeavePOM.fullDayHalf);
		dayLength.selectByVisibleText(fullHalf);
		LeavePOM.saveHoliday.click();
		logger.info("Holiday is added");
		
		LeavePOM.holidayAdd.click();
		LeavePOM.cancelAddHoliday.click();
		logger.info("Cancelling the add holiday option is successfull");
			
		LeavePOM.fromDateHoliday.clear();
		LeavePOM.fromDateHoliday.sendKeys(startDate +Keys.ENTER);
		LeavePOM.toDateHoliday.sendKeys(endDate +Keys.ENTER);
		LeavePOM.searchHoliday.click();
		logger.info("Holiday search is successful");
		
		
		//Deleting Holiday list
		LeavePOM.choseToDelete.click();
		LeavePOM.deleteHolidayList.click();
		LeavePOM.confirmDeleteHolidayList.click();
		logger.info("Deleted the Holiday List Successfully");
		

		
		
		
		
		
	}

}
