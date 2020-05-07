package testsuites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class OpenSite {
	
	public WebDriver driver=null;
	Logger logger=Logger.getLogger(OpenSite.class);
	
	@BeforeSuite
	public void launchBrowser() {

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

		String driverLocation=properties.getProperty("DriverLocation");
		String Link=properties.getProperty("mainURL");
		
		PropertyConfigurator.configure("log4j.properties");
		
		System.setProperty("webdriver.chrome.driver",driverLocation);

		driver=new ChromeDriver();
		driver.navigate().to(Link);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		logger.info("OrangeHRM is opened");
	}
}
