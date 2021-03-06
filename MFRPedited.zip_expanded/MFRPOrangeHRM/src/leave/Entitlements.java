package leave;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import baseDriverClass.BaseWebDriver;
import pom.EntitlementLeaveObj;

public class Entitlements extends BaseWebDriver{
	
	static Logger logger=Logger.getLogger(Entitlements.class);
	@Test
	public void entIcon() {

		
		PageFactory.initElements(driver, EntitlementLeaveObj.class);

		String Employe=properties.getProperty("employe");
		String Entitlement=properties.getProperty("Entitlement");

		EntitlementLeaveObj.Leave.click();

		Actions hover2=new Actions(driver);
		hover2.moveToElement(EntitlementLeaveObj.Entitlement).build().perform();
		EntitlementLeaveObj.AddEntitlement.click();

		EntitlementLeaveObj.cancel.click();

		EntitlementLeaveObj.Leave.click();

		Actions hover=new Actions(driver);
		hover.moveToElement(EntitlementLeaveObj.Entitlement).build().perform();
		EntitlementLeaveObj.AddEntitlement.click();

		WebDriverWait wait = new WebDriverWait(driver,70);
		wait.until(ExpectedConditions.visibilityOf( EntitlementLeaveObj.Employee));

		EntitlementLeaveObj.Employee.sendKeys(Employe);
		wait.until(ExpectedConditions.elementToBeClickable( EntitlementLeaveObj.Employee));
		EntitlementLeaveObj.Employee.sendKeys(Keys.ENTER );

		Select select=new Select(EntitlementLeaveObj.LeaveType);
		select.selectByValue("1");

		Select select1=new Select(EntitlementLeaveObj.Period);
		select1.selectByValue("2020-01-01$$2020-12-31");


		EntitlementLeaveObj.Entitle.sendKeys(Entitlement);


		EntitlementLeaveObj.SAve.click();
		EntitlementLeaveObj.Add.click();

		wait.until(ExpectedConditions.elementToBeClickable( EntitlementLeaveObj.checkbox));

		EntitlementLeaveObj.checkbox.click();

		Select location=new Select(EntitlementLeaveObj.Location);
		location.selectByValue("1");

		Select subunit=new Select(EntitlementLeaveObj.SubUnit);
		subunit.selectByValue("0");

		Select type=new Select(EntitlementLeaveObj.Leavetype);
		type.selectByValue("2");


		Select select2=new Select(EntitlementLeaveObj.Period);
		select2.selectByValue("2020-01-01$$2020-12-31");


		EntitlementLeaveObj.SAve.click();
		EntitlementLeaveObj.Confirm.click();


		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);


		Actions hover3=new Actions(driver);
		hover3.moveToElement(EntitlementLeaveObj.Entitlement).build().perform();

		EntitlementLeaveObj.EmployeEntitlement.click();
		EntitlementLeaveObj.Employee.sendKeys(Employe+Keys.ENTER);
		EntitlementLeaveObj.Search.click();
		EntitlementLeaveObj.Check.click();
		EntitlementLeaveObj.delete.click();
		EntitlementLeaveObj.OK.click();


	}

}