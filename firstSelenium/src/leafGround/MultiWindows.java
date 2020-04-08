package leafGround;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiWindows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe" );
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://www.leafground.com/pages/Window.html");
		String mainWindow=driver.getWindowHandle();
		WebElement windowButton1 =driver.findElement(By.id("home"));
		windowButton1.click();
		
		WebElement windowButton2=driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[2]/div/div/button"));
		windowButton2.click();
		
		int nosOfWindows=driver.getWindowHandles().size();
		System.out.println("Number of opened windows: "+nosOfWindows+" Windows");
		
		WebElement windowButton3=driver.findElement(By.id("color"));
		windowButton3.click();
		
		Set<String> windows=driver.getWindowHandles();
		for (String string : windows) {
			if(!string.equals(mainWindow)) {
				driver.switchTo().window(string);
				driver.close();
			}
			
		}
		driver.switchTo().window(mainWindow);
		WebElement windowbutton4=driver.findElement(By.xpath("//*[@id=\"color\"]"));
		windowbutton4.click();
		Thread.sleep(5000);
		
		nosOfWindows=driver.getWindowHandles().size();
		System.out.println("Number of opened windows after 5 Sec: "+nosOfWindows+" Windows");
		
		Thread.sleep(2000);
		driver.quit();
		
		

	}

}
