package pages;

import org.openqa.selenium.WebDriver;

public class FramesPage extends Page {
    public FramesPage(WebDriver driver) {
        super(driver);
    }
    public FramesPage openPage(){
        navigateUrl("https://demoqa.com/frames");
        return this;
    }
}
