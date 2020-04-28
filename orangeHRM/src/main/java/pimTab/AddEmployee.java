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

import objectsRepository.AddUser;

public class AddEmployee {
	
	@Test
	public void employeeDetails(WebDriver driver) throws AWTException {
		
		PageFactory.initElements(driver, AddUser.class);
		AddUser.addUseR.click();
		AddUser.userNamE.sendKeys("Sagar"+Keys.TAB+"Alias"+Keys.TAB+"Jacky");
		AddUser.employeeID.clear();
		AddUser.employeeID.sendKeys("2211");
		
		Actions act=new Actions(driver);
		act.click(AddUser.uploadPhoto).build().perform();

		String path="D:\\Temp\\MyPhoto.png";
		StringSelection stringSelection = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_V);
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);

		
		act.click(AddUser.checckBox).build().perform();

		AddUser.userName.sendKeys("Franklin Rosevelt"); 
		String password="IamHannah123$$GGhh";
		AddUser.password.sendKeys(password);
		AddUser.confirmPassword.sendKeys(password);
		Select select1= new Select(AddUser.status);
		select1.selectByVisibleText("Enabled");
		AddUser.saveBtn.click();
		
	}

}
