package pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddEmplyee {

	public static WebElement Admin(WebDriver driver) {

		return driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]/b"));
	}

	public static WebElement AddButton(WebDriver driver) {

		return driver.findElement(By.xpath("//*[@id=\"btnAdd\"]"));
	}

	public static WebElement userRole(WebDriver driver) {

		return driver.findElement(By.xpath("//*[@id=\"systemUser_userType\"]"));
	}


	public static WebElement EmployeeName(WebDriver driver) {

		return  driver.findElement(By.id("systemUser_employeeName_empName"));
	}
	
	public static WebElement UserName(WebDriver driver) {

		return driver.findElement(By.id("systemUser_userName"));
	}
	
	public static WebElement UserStatus(WebDriver driver) {

		return driver.findElement(By.id("systemUser_status"));
	}
	
	public static WebElement UserPassword(WebDriver driver) {

		return driver.findElement(By.id("systemUser_password"));
	}
	
	public static WebElement PasswordConfirm(WebDriver driver) {

		return driver.findElement(By.id("systemUser_confirmPassword"));
	}
	
	public static WebElement SaveButton(WebDriver driver) {

		return driver.findElement(By.id("btnSave"));
	}

}
