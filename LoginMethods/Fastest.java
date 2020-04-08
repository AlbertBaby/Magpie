package testCases;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Fastest {
	
	String [][] loginDatas;
	
	@DataProvider(name="loginCredentials")
	public String[][] loginDataProvider() throws BiffException, IOException {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		loginDatas=getExcelSheet();
		return loginDatas;
	}
	
	public String[][] getExcelSheet() throws BiffException, IOException {
		
		FileInputStream getBookPath=new FileInputStream("D:\\Temp\\OrangeTestData.xls");
		
		Workbook excelBook= Workbook.getWorkbook(getBookPath);
		
		Sheet setSheet=excelBook.getSheet(0);
		
		int rowsCount=setSheet.getRows();
		int colCount=setSheet.getColumns();
		String [][]testData=new String[rowsCount-1][colCount];
		
		for (int i = 1; i < rowsCount; i++) {
			for (int j = 0; j < colCount; j++) {
				testData[i-1][j]=setSheet.getCell(j, i).getContents();
				
			}
		}
		return testData;
	}
	
	public WebDriver driver;
	
	@BeforeSuite
	public void initialSetup() {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe" );
		driver= new ChromeDriver();
		
	}
	@BeforeMethod
	public void urlMeth() {
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test(dataProvider = "loginCredentials")
	public void test1(String getName, String getPass) throws InterruptedException {
		
		WebElement username=driver.findElement(By.id("txtUsername"));
		username.sendKeys(getName);
		
		WebElement password=driver.findElement(By.id("txtPassword"));
		password.sendKeys(getPass);
		
		WebElement logIn=driver.findElement(By.id("btnLogin"));
		logIn.click();
		
	}
	
	@AfterSuite
	public void finalSetup() {
		driver.quit();
	}

}
