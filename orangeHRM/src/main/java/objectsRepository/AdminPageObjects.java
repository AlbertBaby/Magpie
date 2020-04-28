package objectsRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPageObjects {
	
	@FindBy(xpath = "//*[text()=\"Admin\"]")
	public static WebElement adminBtn;
	
	@FindBy(xpath = "//input[@id=\"searchSystemUser_employeeName_empName\"]")
	public static WebElement nameBox;
	
	@FindBy(xpath = "//input[@id=\"searchBtn\"]")
	public static WebElement searchBtn;
	
	@FindBy(xpath = "//a[text()=\"Admin\"]")
	public static WebElement result;
	
	@FindBy(id = "btnSave" )
	public static WebElement edit;
	
	@FindBy(id = "systemUser_userType" )
	public static WebElement userRole;
	
	@FindBy(id = "btnAdd" )
	public static WebElement addUser;
	
	@FindBy(id = "systemUser_employeeName_empName" )
	public static WebElement empName;
	
	@FindBy(id = "systemUser_userName" )
	public static WebElement userName;
	
	@FindBy(id = "systemUser_status" )
	public static WebElement userStatus;
	
	@FindBy(id = "systemUser_password" )
	public static WebElement userPass;
	
	@FindBy(id = "systemUser_confirmPassword" )
	public static WebElement confirmPass;
	
	@FindBy(id ="btnCancel")
	public static WebElement cancelBtn;
	
	
	

}
