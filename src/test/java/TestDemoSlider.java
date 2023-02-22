import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SliderPage;

public class TestDemoSlider extends BaseTest {
    @Test
    public void testSlider1() {
        SliderPage sliderPage = openSliderPage();

        WebElement slider = sliderPage.getElementBy(By.xpath("//input[@type='range']"));
        slider.sendKeys(Keys.ARROW_RIGHT);
        slider.sendKeys(Keys.ARROW_RIGHT);
        slider.sendKeys(Keys.ARROW_RIGHT);
        String sliderValue = sliderPage.getElementBy(By.id("sliderValue")).getAttribute("value");
        Assert.assertEquals(sliderValue, "28");
        System.out.println(sliderValue);

    }
}
