package pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddEmployee1 {
	
	@FindBy(how =How.XPATH, using = "//*[@id=\"menu_admin_viewAdminModule\"]/b")
	public static WebElement adminPanel;
	
	@FindBy(how =How.NAME, using = "btnAdd")
	public static WebElement addEmployee;
	
	@FindBy(id = "systemUser_userType")
	public static WebElement userRole;
	
	@FindBy(id = "systemUser_employeeName_empName")
	public static WebElement employeeName;
	
	@FindBy(id = "systemUser_userName")
	public static WebElement userName;
	
	@FindBy(id = "systemUser_status")
	public static WebElement status;
	
	@FindBy(id = "systemUser_password")
	public static WebElement password;
	
	@FindBy(id = "systemUser_confirmPassword")
	public static WebElement confirmPassword;
	
	@FindBy(id = "btnSave")
	public static WebElement saveBtn;
	
	
	
}
