package osUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import java.time.Duration;
import java.util.List;

public class webUtil {

    Logger logger = Logger.getLogger(webUtil.class);
    protected WebDriver driver;
    protected Wait wait;
    protected int timeout =10;


    webUtil(WebDriver driver, long timeout) {
        this.driver = driver;
        this.wait =  new WebDriverWait(driver, Duration.ofSeconds(this.timeout));
    }

    public final void click(WebElement element){
       /* click on webelement without wait time*/
            element.click();
            logger.debug("clicked on the element:" + element.getText());

    }

    public final void click(By locator){
        /* click on locator without wait time*/
        final WebElement element= findElement(locator);
        click(element);
        logger.debug("clicked on the element: "+locator.toString());

    }

    public final void click(String xpath) {
        /* click on xpath without wait time*/
        try {
            final WebElement element = findElement(By.xpath(xpath));
            click(element);
            logger.debug("clicked on the element: " + xpath.toString());
        } catch (Exception exception) {
            logger.error(exception.getMessage());

        }
    }

    public final void waitUntilClick(ExpectedCondition<WebElement> expectedConditions, WebElement element) {
        try {
            wait.until(expectedConditions);
            click(element);
            logger.debug("clicked on the element: "+ element.toString());
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
    }

    // Send keys
    public final void sendKeys(WebElement textBox, String text) {
        wait.until(ExpectedConditions.visibilityOf(textBox));
        textBox.sendKeys(text);
        logger.info("Characters entered into the textbox");
    }

    public final void sendKeys(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        sendKeys(findElement(locator), text);
    }

    // Get text
    public final String getElementText(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        final String elementText = element.getText();
        logger.debug("Text from the element: "+elementText);
        return elementText;
    }

    public final String getElementText(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return getElementText(driver.findElement(locator));
    }

    // Wait methods
    public final void waitForElement(ExpectedCondition<WebElement> expectedCondition) {
        wait.until(expectedCondition);
    }

    public final void waitForLocator(ExpectedCondition<By> expectedCondition){
        wait.until(expectedCondition);
    }

    // JavaScript Executor
    public void executeJavaScript(String script) {
        ((JavascriptExecutor) driver).executeScript(script);
    }

    // Find elements
    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    // Check exists
    public boolean isElementPresent(By locator) {
        return findElements(locator).size() > 0;
    }
}
