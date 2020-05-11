package admin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import baseDriverClass.BaseWebDriver;
import net.bytebuddy.utility.RandomString;
import pom.JobPageObjects;

public class Job extends BaseWebDriver{
	static Logger logger=Logger.getLogger(Job.class);
	@Test
	public void JobIcons() {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		PropertyConfigurator.configure("log4j.properties");

		String jobTitle=properties.getProperty("JobTitle");
		String jobDescrip=properties.getProperty("JobDescription");
		String specFileLocation=properties.getProperty("JobSpecificationFileLocation");
		String noteColumn=properties.getProperty("Note");
		//String nameforPaygrade=properties.getProperty("Name");
		String addCurrency=properties.getProperty("Currency");
		//String empNameStatus=properties.getProperty("Name(forEmploymentStatus)");
		PropertyConfigurator.configure("config.properties");

		PageFactory.initElements(driver,JobPageObjects.class);
		JobPageObjects.adminButton.click();
		JobPageObjects.job.click();
		JobPageObjects.jobTitles.click();
		JobPageObjects.Add.click();
		JobPageObjects.jobTitle.sendKeys(jobTitle);
		JobPageObjects.Description.sendKeys(jobDescrip +Keys.TAB);

		Actions mouseAction= new Actions(driver);
		mouseAction.moveToElement(JobPageObjects.specification).click(JobPageObjects.specification).build().perform();

		String file=(specFileLocation);
		StringSelection string= new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(string, null);

		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		JobPageObjects.Note.sendKeys(noteColumn);;
		JobPageObjects.Save.click();
		JobPageObjects.job.click();
		logger.info("Saved Job Title Successfully");

		//For Pay grades part
		JobPageObjects.payGrades.click();
		JobPageObjects.Add.click();
		JobPageObjects.payname.sendKeys(RandomStringUtils.randomAlphabetic(10));
		JobPageObjects.Save.click();
		JobPageObjects.AddCurrency.click();
		JobPageObjects.currency.sendKeys(addCurrency);
		JobPageObjects.SaveCurrency.click();
		logger.info("Saved currency Successfully");

		//For Employment status
		JobPageObjects.job.click();
		JobPageObjects.empstatus.click();
		JobPageObjects.Add.click();
		JobPageObjects.empnme.sendKeys(RandomStringUtils.randomAlphabetic(10));
		//Thread.sleep(1000);
		JobPageObjects.Save.click();
		logger.info("Employment status added successfully");
	}  

}
