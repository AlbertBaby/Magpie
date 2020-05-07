package performance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pom.KPInTrackerObj;

public class Trackers {
	static Logger logger=Logger.getLogger(Trackers.class);
	@Test
	public void trackers(WebDriver driver)  {


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
		String TRACKERNAME=properties.getProperty("trackername");
		String EMPLOYNAME=properties.getProperty("employname");
		PropertyConfigurator.configure("config.properties");
		PageFactory.initElements(driver, KPInTrackerObj.class);


		KPInTrackerObj.perf.click();
		KPInTrackerObj.con.click();
		KPInTrackerObj.tracks.click();
		KPInTrackerObj.tadd.click();
		KPInTrackerObj.tcancel.click();
		KPInTrackerObj.tadd.click();

		KPInTrackerObj.trackername.sendKeys(TRACKERNAME);
		KPInTrackerObj.employname.sendKeys(EMPLOYNAME);
		KPInTrackerObj.employname.sendKeys(Keys.ENTER);

		KPInTrackerObj.availreviewers.click();
		KPInTrackerObj.aadd.click();
		KPInTrackerObj.ssave.click();
		logger.info("Added tracker name successfully");
	}
}
