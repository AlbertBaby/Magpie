package firstSelenium;

import org.openqa.selenium.By;

public class DynamicXpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		By.xpath("//*[@name=\"FORM_LOGINID\"]");//METH 1
		
		By.xpath("//input[@id=\"newPassword\"]");//meth 2
		
		By.xpath("//*[text()=\"Forgot Password?\"]");// meth 3
		
		By.xpath("//*[contains(text(),\"Register\")]"); //meth 4
		
		By.xpath("//*[@value=\"Login\"][@type=\"submit\"][@name=\"ABCustomLoginPortletFormSubmit\"]"); //meth 5
		
		By.xpath("//*[starts-with(text(),'Enable')]"); //meth 6

		By.xpath("//label[contains(@for,'key')]"); //meth 7
	}

}
