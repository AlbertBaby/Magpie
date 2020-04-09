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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ManageOrange {

	public static void mainMethod() throws AWTException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe" );
		WebDriver driver= new ChromeDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		WebElement username=driver.findElement(By.id("txtUsername"));
		username.sendKeys("Admin");
		
		WebElement password=driver.findElement(By.id("txtPassword"));
		password.sendKeys("admin123");

		WebElement logIn=driver.findElement(By.id("btnLogin"));
		logIn.click();
		
		driver.findElement(By.xpath("//*[@id=\"dashboard-quick-launch-panel-menu_holder\"]/table/tbody/tr/td[2]/div/a/img")).click();;
		
		WebElement startDate=driver.findElement(By.id("calFromDate"));
		startDate.clear();
		startDate.sendKeys("2008-03-06"+Keys.ENTER);
		
		WebElement endDate=driver.findElement(By.id("calToDate"));
		endDate.clear();
		endDate.sendKeys("2021-12-31"+Keys.ENTER);
		
		WebElement checkBox=driver.findElement(By.id("leaveList_chkSearchFilter_checkboxgroup_allcheck"));
		//Actions action = new Actions(driver);
		checkBox.click();
		
		driver.findElement(By.id("btnSearch")).click();
		
		
		  WebElement dropDwn=driver.findElement(By.id("select_leave_action_4")); Select
		  select = new Select(dropDwn); select.selectByIndex(1);
		  
		  driver.findElement(By.name("btnSave")).click();
		 
		
		Robot robo= new Robot();
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect= new Rectangle(screenSize);
		BufferedImage source=robo.createScreenCapture(rect);
		File destination =new File("D://Temp//sample2.png");
		ImageIO.write(source, "png", destination);
		
		Thread.sleep(3000);
		driver.quit();
		
		
	}
	
	

}
