package objectsRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JobTabObj {
	
	@FindBy(xpath = "//a[text()=\"Admin\"]")
	public static WebElement result;
	
	@FindBy(xpath = "//div[@id=\"wrapper\"]/div[2]/ul/li[1]/ul/li[2]")
	public static WebElement JobList;
	
	@FindBy(id = "menu_admin_viewJobTitleList")
	public static WebElement Jobtitle;
	
	@FindBy(id = "btnAdd" )
	public static WebElement Add;
	
	@FindBy(id = "btnCancel" )
	public static WebElement Save;
	
	@FindBy(xpath = "//input[@name=\"jobTitle[jobTitle]\"]")
	public static WebElement titleBox;
	
	@FindBy(id = "jobTitle_note")
	public static WebElement noteBox;
	
	@FindBy(id = "payGrade_name")
	public static WebElement namePayGrade;
	
	@FindBy(id = "jobTitle_jobDescription")
	public static WebElement descBox;
	
	@FindBy(xpath = "//input[@id=\"jobTitle_jobSpec\"]")
	public static WebElement uploadBtn;
	
	@FindBy(id = "menu_admin_viewPayGrades")
	public static WebElement payGrade;
	
}
