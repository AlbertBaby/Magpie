package unitTest;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class OrangeHRM {

	static ArrayList<String> usernameList=new ArrayList<String>();
	static ArrayList<String> passwordList= new ArrayList<String>();
	
	
	public void readExel() throws IOException {
		FileInputStream excelPath= new FileInputStream("D:\\Temp\\OrangeTestData.xlsx");
		Workbook workBook=new XSSFWorkbook(excelPath);
		Sheet setSheet= workBook.getSheetAt(0);

		Iterator<Row> rowIterator =setSheet.iterator();
		while (rowIterator.hasNext()) {
			Row rowValue= rowIterator.next();

			Iterator<Cell> colIterator=rowValue.iterator();
			int i=2;
			while (colIterator.hasNext()) {
			if (i%2==0) {
				usernameList.add(colIterator.next().getStringCellValue());
			}
			else {
				passwordList.add(colIterator.next().getStringCellValue());
			}
			i++;
		}
		}
	}
	ChromeDriver driver= new ChromeDriver();
	
	
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe" );
		WebDriver driver= new ChromeDriver();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
	}
	
	
	public void logIn(String getName,String getPass) {
		
		WebElement username=driver.findElement(By.id("txtUsername"));
		username.sendKeys(getName);

		WebElement password=driver.findElement(By.id("txtPassword"));
		password.sendKeys(getPass);

		WebElement logIn=driver.findElement(By.id("btnLogin"));
		logIn.click();
		
		
	}
	
	
	public void endScript() {
		driver.quit();
	}

	public void execute() {
		for (int i = 0; i < usernameList.size(); i++) {
			logIn(usernameList.get(i), passwordList.get(i));

		}
	}
	
	@BeforeSuite
	public void JustForTest() throws IOException {
		// TODO Auto-generated method stub
		OrangeHRM usingPoi=new OrangeHRM();
		usingPoi.readExel();
		System.out.println("Password List "+passwordList);
		System.out.println("Username List "+usernameList);
		usingPoi.execute();
	}
}
