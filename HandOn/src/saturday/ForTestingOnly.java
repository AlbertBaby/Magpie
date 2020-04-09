package saturday;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;

public class ForTestingOnly {

	public static void main(String[] args) {
		System.setProperty("phantomjs.binary.path", "D:\\Temp\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
		WebDriver driver=new PhantomJSDriver();
		driver.get("https://mvnrepository.com/artifact/com.github.detro.ghostdriver/phantomjsdriver/1.1.0");
		System.out.println(driver.getTitle());

	}

}
