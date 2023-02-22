package pages;

import org.openqa.selenium.WebDriver;

public class FormPage extends Page {

    public FormPage(WebDriver driver) {
        super(driver);
    }
    public FormPage openPage(){
        navigateUrl("https://demoqa.com/automation-practice-form");
        return this;
    }
}
