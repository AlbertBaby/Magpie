package osUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class mobileUtils extends webUtil{
    private AppiumDriver appiumDriver;

    public mobileUtils(AppiumDriver appiumDriver, long timeout) {
        super(appiumDriver, timeout); // call existing constructor
        this.appiumDriver = appiumDriver;
        this.wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(timeout));
    }

    // Appium specific methods

    public void tap(WebElement element) {
        final TouchAction touchAction = new TouchAction((PerformsTouchActions) appiumDriver);
//
    }

    public void tap(By locator) {
    tap(findElement(locator));
    }


    @Override
    public final WebElement findElement(By locator) {
        return appiumDriver.findElement(locator);
    }

    @Override
    public final List<WebElement> findElements(By locator) {
        return appiumDriver.findElements(locator);
    }

}
