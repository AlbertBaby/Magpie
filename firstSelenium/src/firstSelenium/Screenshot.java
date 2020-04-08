package firstSelenium;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {

	public static void main(String[] args) throws IOException, AWTException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe" );
		WebDriver driver= new ChromeDriver();
		driver.get("http://www.google.co.in");
		/*Method 1
		TakesScreenshot screenShot=(TakesScreenshot) driver;
		File source=screenShot.getScreenshotAs(OutputType.FILE);
		File destination=new File("D://sample.png");
		FileHandler.copy(source,destination);*/
		
		//Method 2
		Robot robo= new Robot();
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect= new Rectangle(screenSize);
		BufferedImage source=robo.createScreenCapture(rect);
		File destination =new File("D://sample2.png");
		ImageIO.write(source, "png", destination);
		driver.close();
	}

	

}
