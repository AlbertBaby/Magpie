package pageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageObjects {
	
	@FindBy(how =How.ID, using = "txtUsername")
	public static WebElement username;
	
	@FindBy(id = "txtPassword")
	public static WebElement password;
	
	@FindBy(id="btnLogin")
	public static WebElement loginBtn;

}
