package testJUnit;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class NewAnnot {

		@BeforeClass
		public void classStarts() {
			System.out.println("1st Method (Before class)");
		}
		
		@Before
		public void testStarts() {
			System.out.println("2nd Method (Before method)");
		}
		
		@Test
		public void ready() {
			System.out.println(" 3rd Meethod or inside test method");
		}
		
		@After
		public void testEnd() {
			System.out.println("4th Method(After method)");
		}
		
		@AfterClass
		public void classEnd() {
			System.out.println("5st Method (After class)");
		}

		@Ignore
		public void ignoreMe() {
			System.out.println("Test Failed if you see me");
		}
		
		@Test(timeout = 500)
		public void timeOutTest() throws InterruptedException {
			Thread.sleep(550);
			System.out.println("Timeout Method. Test Failed if you see me");
		}
		
		@Test(expected = NoSuchElementException.class)
		public void expectTesing() throws InterruptedException  {
			Thread.sleep(550);
			System.out.println("Check for expected exception");
		}
	}


