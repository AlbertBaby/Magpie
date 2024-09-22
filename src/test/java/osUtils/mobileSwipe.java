package osUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class mobileSwipe extends mobileUtils{

    private AppiumDriver appiumDriver;
    private Dimension screenSize;
    private TouchAction touchAction;
    private final int halfScreenWidth;
    private final int screenHeight;

    public mobileSwipe(AppiumDriver appiumDriver, TouchAction touchAction, int halfScreenWidth, long timeout) {
        super(appiumDriver, timeout); // call existing constructor
        this.appiumDriver = appiumDriver;
        this.touchAction = touchAction;
        this.wait = new WebDriverWait(appiumDriver, Duration.ofSeconds(timeout));
        this.screenSize = appiumDriver.manage().window().getSize();
        this.halfScreenWidth = screenSize.width / 2;;
        this.screenHeight = screenSize.height;
    }

    public void swipeUp() {
        swipe(halfScreenWidth,
                screenHeight * 8 / 10,
                halfScreenWidth,
                screenHeight / 10);
    }

    public void swipeDown() {
        int startY = screenSize.height / 10;
        int endY = screenSize.height * 8 / 10;
        swipe(halfScreenWidth, startY, halfScreenWidth, endY);
    }

    public void swipeLeft() {
        int startY = screenSize.height / 2;
        int startX = screenSize.width * 8 / 10;
        int endX = screenSize.width / 10;
        swipe(startX, startY, endX, startY);
    }

    public void swipeRight() {
        int startY = screenSize.height / 2;
        int startX = screenSize.width / 10;
        int endX = screenSize.width * 8 / 10;
        swipe(startX, startY, endX, startY);
    }

    public void scrollDownToElement(WebElement element) {
        int startX = screenSize.width / 2;
        int startY = screenSize.height / 10;
        int endY = screenSize.height * 8 / 10;
        swipe(startX, startY, startX, endY);

    }

    public void scrollToRightElement(WebElement element) {
        int startY = screenSize.height / 2;
        int startX = screenSize.width / 10;
        int endX = screenSize.width * 8 / 10;
        swipe(startX, startY, endX, startY);
    }

    // Helper method
    private void swipe(int startX, int startY, int endX, int endY) {
        touchAction.longPress(PointOption.point(startX, startY))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }
}
