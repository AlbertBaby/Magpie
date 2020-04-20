package leafGround;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableTesting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = null;
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		driver= new ChromeDriver();

		driver.get("http://www.leafground.com/pages/table.html");  
		
		List<WebElement> col=driver.findElements(By.tagName("th"));
		int countCol =col.size();
		System.out.println("Number of columns:"+countCol);
		
		List<WebElement> row=driver.findElements(By.tagName("tr"));
		int countRow =row.size();
		System.out.println("Number of rows: "+countRow);
		
		WebElement progress=driver.findElement(By.xpath("//*[@id=\"table_id\"]/tbody/tr[3]/td[2]"));
		String getProgress=progress.getText();
		System.out.println("Progress= "+getProgress);
		
		List<WebElement> getLow=driver.findElements(By.xpath("//td[2]"));
		
		//driver.findElement(By.xpath("//*[@id=\"table_id\"]/tbody/tr[5]/td[3]/input")).click();
		
		List<Integer> ListofProgress =new ArrayList<Integer>();

		for (WebElement singlevalue : getLow) {
		String newValue=singlevalue.getText().replace("%","");
		ListofProgress.add(Integer.parseInt(newValue));
		}

		System.out.println(ListofProgress);
		int minimumValue= Collections.min(ListofProgress);
		String finalValue=Integer.toString(minimumValue)+"%";

		String finalXpath="//td[normalize-space()="+"\""+ finalValue +"\""+"]"+"//following::td[1]/input";

		WebElement checkBox=driver.findElement(By.xpath(finalXpath));

		checkBox.click();
		
		
	}

}
