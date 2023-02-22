package pages;

import org.openqa.selenium.WebDriver;

public class AlertsPage extends Page {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }
    public AlertsPage openPage(){
        navigateUrl("https://demoqa.com/alerts");
        return this;
    }
}
