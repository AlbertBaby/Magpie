package firstSelenium;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Paramet {
	
	@Test
	@Parameters(value = "brand")
	public void selectCar(String brand) {
		System.out.println("The Car is "+brand);
		
	}

}
