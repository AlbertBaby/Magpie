package firstSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe" );
		WebDriver driver= new ChromeDriver();
		driver.get("http://www.google.co.in");
		WebElement search= driver.findElement(By.name("q"));
		
		search.sendKeys("Game of thrones");

		WebElement searchButton= driver.findElement(By.name("btnK"));
		searchButton.click();
	}

}
