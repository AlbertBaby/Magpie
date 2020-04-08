package leafGround;



import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe" );
		WebDriver driver= new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		WebElement box1= driver.findElement(By.id("dropdown1"));
		
		Select drop1=new Select(box1);
		drop1.selectByIndex(3);
		
		WebElement box2= driver.findElement(By.name("dropdown2"));
		Select drop2=new Select(box2);
		drop2.selectByVisibleText("Selenium");
		
		WebElement box3= driver.findElement(By.id("dropdown3"));
		Select drop3=new Select(box3);
		drop3.selectByValue("2");
		
		WebElement getCount=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/select"));
		Select drop4=new Select(getCount);
		List<WebElement> number =drop4.getOptions();
		int Size=number.size();
		System.out.println("Size of Dropdown is "+Size);
		
		
		WebElement box4=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[5]/select"));
		box4.sendKeys("Loadrunner");
		box4.click();
		
		WebElement box5=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[6]/select"));
		Select list1=new Select(box5);
		list1.selectByVisibleText("Appium");
		
		
		Thread.sleep(3000);
		//driver.close();
	}

}
