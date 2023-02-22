package pages;

import org.openqa.selenium.WebDriver;

public class WindowsPage extends Page {
    public WindowsPage(WebDriver driver) {
        super(driver);
    }
    public WindowsPage openPage(){
        navigateUrl("https://demoqa.com/browser-windows");
        return this;
    }
}
