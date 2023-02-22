package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Page {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public Page(WebDriver webDriver) {
        driver = webDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void navigateUrl(String url) {
        driver.get(url);

    }

    public WebElement getElementBy(By by) {
        return driver.findElement(by);
    }


    public void typeText(By by, String text) {
        getElementBy(by).sendKeys(text);
    }

    public String getText(By by) {
        return getElementBy(by).getText();
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void sendAlertText(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public void findFrame(WebElement text) {
        driver.switchTo().frame(text);
    }

    public void defaultFrame() {
        driver.switchTo().defaultContent();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public WebDriver getWindow(String text) {
        return driver.switchTo().window(text);
    }

    public void driverClose() {
        driver.close();
    }

    public void click(By by) {
        WebElement webElement = getElementBy(by);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public boolean webElementIsVisible(By by) {
        return getElementBy(by).isDisplayed();
    }


    protected void waitElementToBeClickable(String xpath) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    protected void waitElementToBeVisible(String xpath) {
        wait.until(ExpectedConditions.visibilityOf(getElementBy(By.xpath(xpath))));
    }


    protected void submit(By by) {
        WebElement webElement = getElementBy(by);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.submit();
    }

    public List<WebElement> getElementsBy(By by) {
        return driver.findElements(by);
    }

    public void waitSeconds(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void quiteAndCloseDriver() {
        driver.quit();
    }

    public void clearAndType(By by, String inputText) {
        WebElement webElement = getElementBy(by);
        webElement.clear();
        webElement.sendKeys(inputText);

    }

    public void clearFieldNonJS(By by) {
        getElementBy(by).sendKeys(Keys.CONTROL + "A" + Keys.DELETE);
    }

}
