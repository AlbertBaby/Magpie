package leafGround;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Download {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe" );
		WebDriver driver= new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/download.html");
		WebElement getExcel=driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div[3]/div[2]/a[1]"));
		getExcel.click();
		
		Thread.sleep(1000);
		
		File checkExcel=new File("D:\\CNC\\Make_for_19\\testleaf.xlsx");
		boolean findexcel=checkExcel.exists();
		if (findexcel==true){
			System.out.println("File has been successfully downloaded");
		}
		
		WebElement getPDF=driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div/div[3]/div[2]/a[2]"));
		getPDF.click();
		
		Thread.sleep(2000);
		File pdfLocation=new File("D:\\CNC\\Make_for_19\\testleaf.pdf");
		boolean findPDF=pdfLocation.exists();
		if (findPDF==true){
			System.out.println("PDF has been successfully downloaded");
		}
		/*
		 * Actions action =new Actions(driver);
		 * action.contextClick().sendKeys("save",Keys.ENTER);
		 */
		//sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN, Keys.ENTER, Keys.ENTER);
		
		
		
		/*
		 * Robot robo=new Robot(); robo.keyPress(KeyEvent.VK_CONTROL);
		 * robo.keyPress(KeyEvent.VK_S); robo.keyRelease(KeyEvent.VK_CONTROL);
		 * robo.keyRelease(KeyEvent.VK_S); robo.keyPress(KeyEvent.VK_ENTER);
		 * robo.keyRelease(KeyEvent.VK_ENTER);
		 */
		/*
		 * 
		 * Thread.sleep(2000);
		 * 
		 * File checkPDF=new File("D:\\CNC\\Make_for_19\\testleaf.pdf"); boolean
		 * findPDF=checkPDF.exists(); if (findPDF==true){
		 * System.out.println("PDF has been successfully downloaded"); }
		 */
		
		
	}

}
