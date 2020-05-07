package admin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import pom.OrganizationObj;

public class Organization {
	static Logger logger=Logger.getLogger(Organization.class);
	
	@Test
	public void Organize(WebDriver driver) {
		
		//Loading  the properties file
				FileInputStream stream = null;
				try {
					stream = new FileInputStream("config.properties");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Properties properties=new Properties();
				try {
					properties.load(stream);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				String locationName=properties.getProperty("GiveName");
				String countryName=properties.getProperty("GiveCountry");
				String stateName=properties.getProperty("GiveState");
				String cityName=properties.getProperty("GiveCity");
				String locationAddress=properties.getProperty("GiveAddress");
				String locationPinCode=properties.getProperty("GivePinCode");
				String locationPhNo=properties.getProperty("GivePhoneNo");
				String locationsearch=properties.getProperty("Searchlocation");
				String searchCity=properties.getProperty("SearchCity");
				String searchCountry=properties.getProperty("SearchCountry");
				PropertyConfigurator.configure("config.properties");
		
		
		 PageFactory.initElements(driver,OrganizationObj.class);
		  //Adding Location in Organization part
		  OrganizationObj.organization.click();
		  OrganizationObj.location.click();
		  OrganizationObj.addbtn.click();
		  OrganizationObj.locname.sendKeys(locationName);
		  Select select=new Select(OrganizationObj.country);
		  select.selectByVisibleText(countryName);
		  OrganizationObj.state.sendKeys(stateName);	
		  OrganizationObj.city.sendKeys(cityName);
		  OrganizationObj.address.sendKeys(locationAddress+Keys.TAB);
		  OrganizationObj.zipcode.sendKeys(locationPinCode);
		  OrganizationObj.phone.sendKeys(locationPhNo);
		  OrganizationObj.Savebtn.click();
		  logger.info("Added new location successfully");
		  
		  //Searching from location list
		  OrganizationObj.Location_name.sendKeys(locationsearch);
		  OrganizationObj.Location_city.sendKeys(searchCity);
		  Select select1=new Select(OrganizationObj.loccountry);
		  select1.selectByVisibleText(searchCountry);
		  logger.info("Search location is successful");
		  OrganizationObj.Reset.click();
		  logger.info("Reset in loaction search is done ");
	}


}
