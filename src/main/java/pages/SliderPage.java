package pages;

import org.openqa.selenium.WebDriver;

public class SliderPage extends Page {
    public SliderPage(WebDriver driver) {
        super(driver);
    }
    public SliderPage openPage(){
        navigateUrl("https://demoqa.com/slider");
        return this;
    }

}
