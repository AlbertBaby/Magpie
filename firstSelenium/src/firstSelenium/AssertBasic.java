package firstSelenium;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertBasic {
	
	String value = "WFH";
	boolean state=true;

	@Test
	public void assertTest() {

		//Assert.assertEquals(value, "WfH");
		//Assert.assertFalse(state, "Not Same string");
		Assert.assertTrue(state, "String matches");
		
	}
}
