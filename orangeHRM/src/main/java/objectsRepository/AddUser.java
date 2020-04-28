package objectsRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddUser {
	
	@FindBy(how =How.XPATH, using = "//*[@id=\"menu_pim_viewPimModule\"]/b")
	public static WebElement adminPaneL;
	
	@FindBy(how =How.NAME, using = "btnAdd")
	public static WebElement addUseR;
	
	@FindBy(id = "firstName")
	public static WebElement userNamE;
	
	@FindBy(id = "employeeId")
	public static WebElement employeeID;
	
	@FindBy(id = "photofile")
	public static WebElement uploadPhoto;
	
	@FindBy(id = "chkLogin")
	public static WebElement checckBox;
	
	@FindBy(id = "user_name")
	public static WebElement userName;
	
	@FindBy(id = "status")
	public static WebElement status;
	
	@FindBy(id = "user_password")
	public static WebElement password;
	
	@FindBy(id = "re_password")
	public static WebElement confirmPassword;
	
	@FindBy(id = "btnSave")
	public static WebElement saveBtn;
	
	
}
