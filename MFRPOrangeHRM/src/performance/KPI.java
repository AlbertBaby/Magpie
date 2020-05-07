package performance;

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

import pom.KPInTrackerObj;

public class KPI {

	static Logger logger=Logger.getLogger(KPI.class);
	@Test
	public void kpi(WebDriver driver) {

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

		PageFactory.initElements(driver, KPInTrackerObj.class);

		//PERFORMANCE MODULE
		//CONFIGURE PART

		//To click on perfromance button
		KPInTrackerObj.perf.click();

		//To click on configure button
		KPInTrackerObj.con.click();

		//To click on KPI buttom
		KPInTrackerObj.kpis.click();


		//To Add employees
		KPInTrackerObj.add.click();


		//Propety file Configurations 
		String KPI=properties.getProperty("kpi");
		String MAX=properties.getProperty("maxrating");
		String MIN=properties.getProperty("minrating");


		//To select the value in "Job Title"
		Select select1=new Select(KPInTrackerObj.job);
		select1.selectByVisibleText("Sales Executive");


		//To enter Key Performance Indicator value
		KPInTrackerObj.kpi.sendKeys(KPI);

		//To enter Minimum Rating value
		KPInTrackerObj.minrating.clear();
		KPInTrackerObj.minrating.sendKeys(MIN);

		//To enter Minimum Rating value
		KPInTrackerObj.maxrating.clear();
		KPInTrackerObj.maxrating.sendKeys(MAX);
		KPInTrackerObj.mdc.click();

		// To save
		KPInTrackerObj.save.click();


		//To search after saving the detils
		KPInTrackerObj.search.click();

		//To Delete the requried field
		KPInTrackerObj.del.click();


		//To select the field to be deleted
		KPInTrackerObj.delete.click();
		KPInTrackerObj.ok.click();
		logger.info("Deleted");

	}
}