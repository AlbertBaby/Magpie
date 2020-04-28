package login;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import objectsRepository.JobTabObj;

public class TestOnJob {
	
	public static XSSFRow row;
	public static String datas = null;
	public Logger logger = Logger.getLogger(LoginAndImg.class);
	
	@Test
	public void jobTitles(WebDriver driver) throws IOException, AWTException, InterruptedException {
		FileInputStream path = new FileInputStream("config.properties");
		Properties prop = new Properties();
		prop.load(path);
		String col = prop.getProperty("JobDetailsCol"),excelPath=prop.getProperty("ExcelPath")
				,textPath=prop.getProperty("TextPath");
		int colIndex=Integer.parseInt(col);
		
		PageFactory.initElements(driver, JobTabObj.class);
		Actions act=new Actions(driver);
		act.moveToElement(JobTabObj.JobList).click().build().perform();
		
		JobTabObj.Jobtitle.click();
		JobTabObj.Add.click();
		File src= new File(excelPath);
		
		FileInputStream getBookPath=new FileInputStream(src);

		XSSFWorkbook excelBook= new XSSFWorkbook(getBookPath);

		XSSFSheet sheet1=excelBook.getSheetAt(0);
		Iterator<Row>  rowIterator = sheet1.iterator();
		String jobTitle=getExcelData(rowIterator,colIndex),jobDesc=getExcelData(rowIterator, colIndex),
				note=getExcelData(rowIterator, colIndex);
		JobTabObj.titleBox.sendKeys(jobTitle);
		JobTabObj.descBox.sendKeys(jobDesc);
		JobTabObj.noteBox.sendKeys(note);
		
		//System.out.println("1");
		//JobTabObj.uploadBtn.click();
		act.click(JobTabObj.uploadBtn).build().perform();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//Thread.sleep(5000);
		
		StringSelection stringSelection = new StringSelection(textPath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		
		robo.keyRelease(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		JobTabObj.Save.click();//Mapped to cancel button inorder to test
		
		String payName=getExcelData(rowIterator, colIndex);
		excelBook.close();
		
		act.moveToElement(JobTabObj.JobList).click().build().perform();
		JobTabObj.payGrade.click();
		JobTabObj.Add.click();
		JobTabObj.namePayGrade.sendKeys(payName);
		JobTabObj.Save.click();
	}
	
	public String getExcelData(Iterator<Row> rowIterator,int colIndex) throws IOException {

		row = (XSSFRow) rowIterator.next();
		Cell cell = row.getCell(colIndex);
		datas=cell.getStringCellValue();
		return datas;
	}

}
