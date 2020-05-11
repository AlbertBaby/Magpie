package baseDriverClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseWebDriver {

	public static WebDriver driver;
	public static Properties properties;
	
	public BaseWebDriver(){
		try {
			properties = new Properties();
			FileInputStream ip = new FileInputStream("config.properties");
			properties.load(ip);
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	public static void initialization(){
		
		String browserName = properties.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");	
			
			
		}	
			
	}
	

}
		
