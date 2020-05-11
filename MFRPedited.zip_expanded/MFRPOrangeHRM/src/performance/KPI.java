package performance;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import baseDriverClass.BaseWebDriver;
import pom.KPInTrackerObj;

public class KPI extends BaseWebDriver {

	static Logger logger=Logger.getLogger(KPI.class);
	@Test
	public void kpi() {


		PropertyConfigurator.configure("log4j.properties");

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
		Select select1=new Select(KPInTrackerObj.jobtitle);
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