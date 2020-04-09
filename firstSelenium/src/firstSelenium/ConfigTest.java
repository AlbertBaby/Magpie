package firstSelenium;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfigTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = null;
		FileInputStream path= new FileInputStream("config.properties");
		Properties prop=new Properties();
		prop.load(path);
		
		String browser=prop.getProperty("browser");
		String driverLocation=prop.getProperty("driverLocation");
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",driverLocation );
			driver= new ChromeDriver();
			
		} else {
			System.out.println("Other browsers not supported");
		}
		
		driver.navigate().to("http://google.co.in/");
	}

}
