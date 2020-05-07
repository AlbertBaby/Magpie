package leave;



import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pom.LeavelistObject;

public class Leavelist {
	static Logger logger=Logger.getLogger(Leavelist.class);
	@Test
	public void leaveList(WebDriver driver){

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


		String from=properties.getProperty("From");
		String to=properties.getProperty("To");
		String Employeee=properties.getProperty("employee");
		PropertyConfigurator.configure("config.properties");
		PageFactory.initElements(driver,LeavelistObject.class);
        
		//Searching in leave list
		LeavelistObject.leave.click();
		LeavelistObject.fromdate.click();
		LeavelistObject.fromdate.clear();
		LeavelistObject.fromdate.sendKeys(from);
		LeavelistObject.todate.click();
		LeavelistObject.todate.clear();
		LeavelistObject.todate.sendKeys(to);
		LeavelistObject.Allcheck.click();
		LeavelistObject.empName.sendKeys(Employeee);
		Select subunit=new Select(LeavelistObject.Subunit);
		subunit.selectByVisibleText("All");
		LeavelistObject.pastemployees.click();
		LeavelistObject.Search.click();
		logger.info("Search completed");
		Robot r = null;
		try {
			r = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rectangle=new Rectangle(size);
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(LeavelistObject.btnSave)).click();
		BufferedImage source=r.createScreenCapture(rectangle);
		File destinationFile=new File("C:\\Users\\Balaji\\Desktop\\Vaish\\image1.png");
		try {
			ImageIO.write(source,"png",destinationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}




}


