package recruitmentTab;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import objectsRepository.VacancyObj;

public class Vacancies {
	
	public XSSFRow row;
	public String datas;
	
	@Test
	public void createVacancy(WebDriver driver) throws IOException {
		
		FileInputStream path = new FileInputStream("config.properties");
		Properties prop = new Properties();
		prop.load(path);

		String col = prop.getProperty("vacancyCol"),excelPath=prop.getProperty("ExcelPath");
		int colIndex=Integer.parseInt(col);
		
		PageFactory.initElements(driver, VacancyObj.class);
		
		VacancyObj.Vacancy.click();
		VacancyObj.AddBtn.click();
		
		File src= new File(excelPath);
		FileInputStream getBookPath=new FileInputStream(src);

		XSSFWorkbook excelBook= new XSSFWorkbook(getBookPath);

		XSSFSheet sheet1=excelBook.getSheetAt(0);
		Iterator<Row>  rowIterator = sheet1.iterator();
		String vacancyName=getExcelData(rowIterator,colIndex),hiringMGR=getExcelData(rowIterator,colIndex),
				NoOfPosition=getExcelData(rowIterator,colIndex),description=getExcelData(rowIterator, colIndex),
				JobTitle=getExcelData(rowIterator, colIndex);
		
		Select select=new Select(VacancyObj.JobTitle);
		select.selectByVisibleText(JobTitle);;
		
		VacancyObj.VacancyName.sendKeys(vacancyName);
		VacancyObj.HMgr.sendKeys(hiringMGR);
		VacancyObj.NOS.sendKeys(NoOfPosition);
		VacancyObj.Description.sendKeys(description);
		
		Actions act=new Actions(driver);
		act.click(VacancyObj.Active).build().perform();
		act.click(VacancyObj.publish).build().perform();
		
		VacancyObj.SaveBtn.click();
		excelBook.close();
		
	}
	
	public String getExcelData(Iterator<Row> rowIterator,int colIndex) throws IOException {

		row = (XSSFRow) rowIterator.next();
		Cell cell = row.getCell(colIndex);
		datas=cell.getStringCellValue();
		return datas;
	}
	

}
