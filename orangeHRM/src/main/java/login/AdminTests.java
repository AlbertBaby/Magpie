package login;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import objectsRepository.AdminPageObjects;

public class AdminTests {

	public static XSSFRow row;
	public static String datas = null;

	@Test
	public void adminPage(WebDriver driver) throws IOException, InterruptedException {
		
		FileInputStream path = new FileInputStream("config.properties");
		Properties prop = new Properties();
		prop.load(path);

		String col = prop.getProperty("JobDetailsCol"),excelPath=prop.getProperty("ExcelPath");
		int colIndex=Integer.parseInt(col);
		
		PageFactory.initElements(driver, AdminPageObjects.class);
		AdminPageObjects.adminBtn.click();
		AdminPageObjects.nameBox.sendKeys("John Smith");
		AdminPageObjects.searchBtn.click();

		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.urlContains("viewSystemUsers"));

		AdminPageObjects.result.click();
		AdminPageObjects.edit.click();
		Select select =new Select(AdminPageObjects.userRole);
		select.selectByIndex(0);
		AdminPageObjects.cancelBtn.click();
		wait.until(ExpectedConditions.urlContains("viewSystemUsers"));
		AdminPageObjects.addUser.click();

		select.selectByVisibleText("Admin");
		
		File src= new File(excelPath);
		
		FileInputStream getBookPath=new FileInputStream(src);

		XSSFWorkbook excelBook= new XSSFWorkbook(getBookPath);

		XSSFSheet sheet1=excelBook.getSheetAt(0);
		Iterator<Row>  rowIterator = sheet1.iterator();

		String name=getExcelData(rowIterator,colIndex),uName=getExcelData(rowIterator, colIndex),
				status=getExcelData(rowIterator, colIndex),passWord=getExcelData(rowIterator, colIndex),
				confPass=getExcelData(rowIterator, colIndex);
		/*
		 * AdminTests forExcel=new AdminTests(); forExcel.setExcel(1);
		 */
		System.out.println(name+uName+status+passWord+confPass);
		
		AdminPageObjects.empName.sendKeys(name);
		AdminPageObjects.userName.sendKeys(uName);

		Select select1 =new Select(AdminPageObjects.userStatus);
		select1.selectByVisibleText(status);

		AdminPageObjects.userPass.sendKeys(passWord);
		AdminPageObjects.confirmPass.sendKeys(confPass);
		//Thread.sleep(5000);
		AdminPageObjects.cancelBtn.click();   //edit_AKA_save button
		excelBook.close();
	}
	
	/*
	 * public String name,uName,status,passWord,confPass; public XSSFWorkbook
	 * excelBook;
	 * 
	 * public void setExcel(int colInex) throws IOException { File src= new
	 * File("D:\\Temp\\MFRPAddUser.xlsx");
	 * 
	 * FileInputStream getBookPath=new FileInputStream(src);
	 * 
	 * excelBook= new XSSFWorkbook(getBookPath);
	 * 
	 * XSSFSheet sheet1=excelBook.getSheetAt(0); Iterator<Row> rowIterator =
	 * sheet1.iterator();
	 * 
	 * name =getExcelData(rowIterator,colInex);
	 * uName=getExcelData(rowIterator,colInex);
	 * status=getExcelData(rowIterator,colInex);
	 * passWord=getExcelData(rowIterator,colInex);
	 * confPass=getExcelData(rowIterator,colInex); excelBook.close();
	 * 
	 * }
	 */


	public String getExcelData(Iterator<Row> rowIterator,int colIndex) throws IOException {

		row = (XSSFRow) rowIterator.next();
		Cell cell = row.getCell(colIndex);
		datas=cell.getStringCellValue();
		return datas;
	}





}
