package admin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pom.JobPageObjects;

public class Job {
	static Logger logger=Logger.getLogger(Job.class);
	@Test
	public void JobIcons(WebDriver driver) {
		
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

		String jobTitle=properties.getProperty("JobTitle");
		String jobDescrip=properties.getProperty("JobDescription");
		String specFileLocation=properties.getProperty("JobSpecificationFileLocation");
		String noteColumn=properties.getProperty("Note");
		String nameforPaygrade=properties.getProperty("Name");
		String addCurrency=properties.getProperty("Currency");
		String empNameStatus=properties.getProperty("Name(forEmploymentStatus)");
		PropertyConfigurator.configure("config.properties");

		PageFactory.initElements(driver,JobPageObjects.class);
		JobPageObjects.adminButton.click();
		JobPageObjects.job.click();
		JobPageObjects.jobTitles.click();
		JobPageObjects.add.click();
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
		JobPageObjects.payname.sendKeys(nameforPaygrade);
		JobPageObjects.savebtn.click();
		JobPageObjects.AddCurrency.click();
		JobPageObjects.currency.sendKeys(addCurrency);
		JobPageObjects.SaveCurrency.click();
		logger.info("Saved currency Successfully");

		//For Employment status
		JobPageObjects.job.click();
		JobPageObjects.empstatus.click();
		JobPageObjects.add1.click();
		JobPageObjects.empnme.sendKeys(empNameStatus);
		//Thread.sleep(1000);
		JobPageObjects.save1.click();
		logger.info("Employment status added successfully");
	}  

}
