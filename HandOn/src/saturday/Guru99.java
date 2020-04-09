package saturday;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
//import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Guru99 {

	WebDriver driver;
	/**
	 * @param args
	 * @throws AWTException 
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	@BeforeSuite
	public void setbrowser() {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe" );
		 driver= new ChromeDriver();
		 driver.get("http://demo.guru99.com/");
			driver.manage().window().maximize();
	}
	@Test
	public void guruTest() throws AWTException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul/li[9]/a")).click();
		
		WebElement setDropdown=driver.findElement(By.name("quantity"));
		Select select=new Select(setDropdown);
		select.selectByVisibleText("7");
		
		WebElement buyButton=driver.findElement(By.xpath("//*[@id=\"three\"]/div/form/div/div[8]/ul/li/input"));
		buyButton.click();
		
		WebElement cardNumber=driver.findElement(By.id("card_nmuber"));
		cardNumber.sendKeys("1234567887654321");
		
		WebElement expMonth=driver.findElement(By.id("month"));
		Select select1=new Select(expMonth);
		select1.selectByIndex(7);
		
		WebElement expYear=driver.findElement(By.id("year"));
		Select select2=new Select(expYear);
		select2.selectByVisibleText("2022");
		
		WebElement cvvCode=driver.findElement(By.id("cvv_code"));
		cvvCode.sendKeys("711");
		
		WebElement subMit=driver.findElement(By.xpath("//*[@id=\"three\"]/div/form/div[2]/div/ul/li/input"));
		subMit.click();
		
		Robot robo=new Robot();
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle size=new Rectangle(screenSize);
		BufferedImage imgCaptured=robo.createScreenCapture(size);
		File destination= new File("D:\\Temp\\captured.png");
		ImageIO.write(imgCaptured, "png", destination);
		
		WebElement getHome= driver.findElement(By.partialLinkText("HOME"));
		getHome.click();
		
	}
	@AfterSuite
	public void closeWindow() {
		driver.quit();
	}

}
