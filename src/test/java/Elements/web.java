package Elements;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class web {

    @FindBy(xpath = "")
    public static WebElement searchButton;
    
    @FindBy(name = "id_login")
    public static WebElement loginButton;

    @FindBy(name = "btnK")
    public WebElement getSearchButton;

    @FindBy(id = "APjFqb")
    public WebElement searchInputField;

}
