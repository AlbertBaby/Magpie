package pimmodule;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import baseDriverClass.BaseWebDriver;
import pom.PIMConfig;

public class Configuration extends BaseWebDriver{
	static Logger logger = Logger.getLogger(Configuration.class);
	@Test
	public  void configMod() {
		//Searching employee details and add if we want

		String Field_Custom_Name=properties.getProperty("Field_Name");
		String Custom_Custom_Name=properties.getProperty("Custom_Name");
		String Report_Custom_Name=properties.getProperty("Report_Name");
		String Reg_Custom_Name=properties.getProperty("Reg_Name");
		String Request_Custom_Name=properties.getProperty("Request_Name");


		PropertyConfigurator.configure("log4j.properties");
		PageFactory.initElements(driver,PIMConfig.class);

		PIMConfig.pimbutton.click();
		PIMConfig.configuration.click();
		PIMConfig.optfield.click();
		PIMConfig.Edit.click();
		PIMConfig.depfield.click();
		PIMConfig.ssnbtn.click();
		PIMConfig.savebutton.click();
		logger.info("Successfully Edited");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PIMConfig.configuration.click();
		PIMConfig.customfield.click();

		PIMConfig.fieldname.sendKeys(Field_Custom_Name);
		Select select=new Select(PIMConfig.screen);
		select.selectByVisibleText("Qualifications");
		Select select1=new Select(PIMConfig.fieldtype);
		select1.selectByValue("0");
		PIMConfig.savebtn1.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PIMConfig.addBtn.click();
		PIMConfig.fieldname.sendKeys(Custom_Custom_Name);
		Select sele=new Select(PIMConfig.screen);
		sele.selectByVisibleText("Memberships");
		Select sele1=new Select(PIMConfig.fieldtype);
		sele1.selectByValue("1");
		PIMConfig.selopt.sendKeys("sel,opt"+Keys.ENTER);
		PIMConfig.btnSave.click();
		PIMConfig.allcheck.click();
		PIMConfig.buttonRemove.click();
		PIMConfig.btncancel.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PIMConfig.configuration.click();
		PIMConfig.dataimport.click();
		PIMConfig.download.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions mouseAct= new Actions(driver);
		mouseAct.moveToElement(PIMConfig.choose).click(PIMConfig.choose).build().perform();

		String file=("C:\\Users\\DE admin\\eclipse-workspace\\MFRPOrangeHRM\\OrangeHRMAddUserData.xlsx");
		StringSelection string= new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(string, null);
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		PIMConfig.upload.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PIMConfig.configuration.click();
		PIMConfig.reportmeth.click();
		PIMConfig.addbtn1.click();
		PIMConfig.reportmethname.sendKeys(Report_Custom_Name);
		PIMConfig.saveebtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PIMConfig.configuration.click();
		PIMConfig.termination.click();
		PIMConfig.adddbtn.click();
		PIMConfig.term_reason.sendKeys(Reg_Custom_Name);
		PIMConfig.termsave.click();
		PIMConfig.term_reason.sendKeys(Request_Custom_Name);
		PIMConfig.cancel.click();
	}


}


