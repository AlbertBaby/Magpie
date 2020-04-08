package firstSelenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AnnoTaionS {
 
		@Test
	  public void Test1() {
			System.out.println("Test NO:1");
	  }
		
		@Test
		public void Test2() {
			System.out.println("Test NO:2");
		}
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("This is 'beforeMethod' Method");
	  }
	
	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("This is 'afterMethod' Method");
	  }
	
	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("This is 'beforeClass' Method");
	  }
	
	  @AfterClass
	  public void afterClass() {
		  System.out.println("This is 'afterClass' Method");
	  }
	
	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("This is 'beforeTest' Method");
	  }
	
	  @AfterTest
	  public void afterTest() {
		  System.out.println("This is 'afterTest' Method");
	  }
	
	  @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("This is 'beforeSuite' Method");
	  }
	
	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("This is 'afterSuite' Method");
	  }

}
