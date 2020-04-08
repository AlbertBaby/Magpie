package firstSelenium;

import org.testng.annotations.Test;

public class PhoneGroup {
	
	@Test(groups = "Apple")
	public void appleIphone11() throws InterruptedException{
		System.out.println("Phone is Iphone11");
		Thread.sleep(2000);
	}
	@Test(groups = "Apple")
	public void appleIphoneXR() throws InterruptedException {
		System.out.println("Phone is IphoneXR");
		Thread.sleep(3000);
	}
	@Test(groups = "Vivo")
	public void vivoF1() throws InterruptedException {
		System.out.println("Phone is VivoF1");
		Thread.sleep(2000);
	}
	@Test(groups = "Vivo")
	public void vivoE3() {
		System.out.println("Phone is VivoE3");
	}
	@Test(groups = "Nokia")
	public void nokia6(){
		System.out.println("Phone is Nokia6");
	}
	@Test(groups = "Nokia")
	public void nokia8() {
		System.out.println("Phone is Nokia8");
	}
	@Test(groups = "Oppo")
	public void oppoC3() {
		System.out.println("Phone is OPPOC3");
	}
	@Test(groups = "Oppo")
	public void oppoM() {
		System.out.println("Phone is OPPOM");
	}
}
