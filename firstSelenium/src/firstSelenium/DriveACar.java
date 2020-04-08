package firstSelenium;

import org.testng.annotations.Test;

public class DriveACar {
		@Test
	   public void start() {
	      System.out.println("in test case 1:start");
	   }

	   // test case 2
	   @Test(dependsOnMethods = "start")
	   public void gear1() throws InterruptedException {
	      System.out.println("in test case 2: 1st gear");
	      //Thread.sleep(5000);
	   }
	   
	   @Test(dependsOnMethods = "gear1", timeOut = 500)
	   public void gear3() throws InterruptedException {
	      
	     Thread.sleep(450);
	     System.out.println("in test case 3: 2nd gear");
	   }
}
