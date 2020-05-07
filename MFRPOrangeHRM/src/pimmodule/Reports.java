package pimmodule;

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

import pom.ReportObject;

public class Reports {
	static Logger logger=Logger.getLogger(Reports.class);
	@Test
	public void reportMod(WebDriver driver) {

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
		PageFactory.initElements(driver,ReportObject.class);
		PropertyConfigurator.configure("config.properties");

		ReportObject.pimbutton.click();
		ReportObject.report.click();
		ReportObject.addbutton1.click();
		ReportObject.reportname.sendKeys("Report1");
		Select report=new Select(ReportObject.reportcriteria);
		report.selectByVisibleText("Employee Name");
		Select repcomparision=new Select(ReportObject.repcomp);
		repcomparision.selectByValue("1");
		Select groups=new Select(ReportObject.disgrps);
		groups.selectByVisibleText("Personal");
		ReportObject.adddis.click();
		logger.info("Successfully Added");

		ReportObject.checkbox1.click();
		ReportObject.savebttn.click();
		logger.info("Saved Successfully");

	}


}
