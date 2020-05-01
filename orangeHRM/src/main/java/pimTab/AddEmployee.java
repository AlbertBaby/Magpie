package pimTab;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import objectsRepository.AddUserObj;

public class AddEmployee {
	
	@Test
	public void employeeDetails(WebDriver driver) throws AWTException {
		
		PageFactory.initElements(driver, AddUserObj.class);
		
		AddUserObj.PIMbtn.click();
		AddUserObj.addUseR.click();
		AddUserObj.userNamE.sendKeys("Sagar"+Keys.TAB+"Alias"+Keys.TAB+"Jacky");
		AddUserObj.employeeID.clear();
		AddUserObj.employeeID.sendKeys("2211");
		
		Actions act=new Actions(driver);
		act.click(AddUserObj.uploadPhoto).build().perform();

		String path="D:\\Temp\\MyPhoto.png";
		StringSelection stringSelection = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		
		robo.keyRelease(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);

		act.click(AddUserObj.checckBox).build().perform();

		AddUserObj.userName.sendKeys("Franklin Rosevelt"); 
		String password="IamHannah123$$GGhh";
		AddUserObj.password.sendKeys(password);
		AddUserObj.confirmPassword.sendKeys(password);
		Select select1= new Select(AddUserObj.status);
		select1.selectByVisibleText("Enabled");
		AddUserObj.saveBtn.click();
		
	}

}
