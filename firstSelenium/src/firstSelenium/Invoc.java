package firstSelenium;

import org.testng.annotations.Test;

public class Invoc {
	
	 @Test(invocationCount = 5) public void loopEx() {
	  System.out.println("Print me 5 times"); }
	 /*
	@Test (timeOut = 2000)
	public void method1() throws InterruptedException {
		Thread.sleep(2999);
		System.out.println("Check the code and run again");
		
	}
	
	@Test(dependsOnMethods = "method1",alwaysRun = true)
	public void method2() {
		
		System.out.println("Method 2 executed");
	}*/
}
