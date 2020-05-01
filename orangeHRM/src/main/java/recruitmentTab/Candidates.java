package recruitmentTab;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
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

import objectsRepository.CandidatesObj;

public class Candidates {


	public static XSSFRow row;
	public static String datas = null;

	@Test
	public void employeeDetails(WebDriver driver) throws AWTException, IOException {
		

		FileInputStream path = new FileInputStream("config.properties");
		Properties prop = new Properties();
		prop.load(path);

		String col = prop.getProperty("CandidatesCol"),excelPath=prop.getProperty("ExcelPath")
				,resumePath=prop.getProperty("ResumePath");
		int colIndex=Integer.parseInt(col);

		PageFactory.initElements(driver, CandidatesObj.class);
		CandidatesObj.recruitmentbtn.click();

		CandidatesObj.addUseR.click();

		File src= new File(excelPath);
		FileInputStream getBookPath=new FileInputStream(src);

		XSSFWorkbook excelBook= new XSSFWorkbook(getBookPath);

		XSSFSheet sheet1=excelBook.getSheetAt(0);
		Iterator<Row>  rowIterator = sheet1.iterator();
		String username1=getExcelData(rowIterator,colIndex),username2=getExcelData(rowIterator,colIndex),
				username3=getExcelData(rowIterator,colIndex),emailID=getExcelData(rowIterator, colIndex),
				contactNO=getExcelData(rowIterator, colIndex),keyWord=getExcelData(rowIterator, colIndex),
				comments=getExcelData(rowIterator, colIndex);

		CandidatesObj.userNamE.sendKeys(username1+KeyEvent.VK_TAB+username2+KeyEvent.VK_TAB+username3);
		CandidatesObj.emailBox.sendKeys(emailID);
		CandidatesObj.contactNo.sendKeys(contactNO);

		Select select=new Select(CandidatesObj.setVacancy);
		select.selectByIndex(0);

		CandidatesObj.keyWords.sendKeys(keyWord);
		CandidatesObj.commentBox.sendKeys(comments);
		CandidatesObj.dateBox.clear();

		Actions act =new Actions(driver);
		act.click(CandidatesObj.addResume).build().perform();

		StringSelection stringSelection = new StringSelection(resumePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);

		robo.keyRelease(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);

		LocalDate pDate=java.time.LocalDate.now();
		String today=pDate.toString();
		CandidatesObj.dateBox.sendKeys(today);

		act.click(CandidatesObj.consentCheckBox).build().perform();
		excelBook.close();
	}

	public String getExcelData(Iterator<Row> rowIterator,int colIndex) throws IOException {

		row = (XSSFRow) rowIterator.next();
		Cell cell = row.getCell(colIndex);
		datas=cell.getStringCellValue();
		return datas;
	}

}
