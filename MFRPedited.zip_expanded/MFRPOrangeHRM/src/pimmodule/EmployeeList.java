package pimmodule;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import baseDriverClass.BaseWebDriver;
import pom.EmpListObject;

public class EmployeeList extends BaseWebDriver {
	static Logger logger=Logger.getLogger(EmployeeList.class);
	@Test
	public void empList() {
		//Adding and Searching Employee
		
		String frstName=properties.getProperty("fname");
		String scndName=properties.getProperty("sname");
		String UserName=properties.getProperty("uname");
		String Psswrd=properties.getProperty("pwrd");
		String cnfmpsswrd=properties.getProperty("conpwrd");
		String id=properties.getProperty("idno");
		PropertyConfigurator.configure("config.properties");
		EmpListObject.pimbutton.click();
		EmpListObject.Emplist.click();

		EmpListObject.btnAdd.click();
		EmpListObject.firstname.sendKeys(frstName);
		EmpListObject.lastname.sendKeys(scndName);
		Actions mouseAction1= new Actions(driver);
		mouseAction1.moveToElement(EmpListObject.choosefile).click(EmpListObject.choosefile).build().perform();

		String file=("C:\\Users\\DE admin\\eclipse-workspace\\MFRPOrangeHRM\\image1.png");
		StringSelection string= new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(string, null);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		EmpListObject.checkLogin.click();
		EmpListObject.Username.sendKeys(UserName);
		EmpListObject.Password.sendKeys(Psswrd);
		EmpListObject.cnfmPassword.sendKeys(cnfmpsswrd);
		Select Status=new Select(EmpListObject.status);
		Status.selectByVisibleText("Enabled");
		EmpListObject.Savee.click();
		EmpListObject.Emplist.click();
		EmpListObject.empName.sendKeys(Keys.CLEAR+"Linda Anderson"+Keys.ENTER);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EmpListObject.empsearchid.sendKeys(id);
		EmpListObject.empstatus.click();
		EmpListObject.currentemp.click();
		EmpListObject.supervisorname.sendKeys(Keys.CLEAR+"John Smith"+Keys.ENTER);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Select sel=new Select(EmpListObject.empjobtitle);
		sel.selectByValue("3");
		Select sel1=new Select(EmpListObject.sub_unit);
		sel1.selectByValue("5");
		EmpListObject.search.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EmpListObject.reset.click();
	}
}
