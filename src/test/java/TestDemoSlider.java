import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDemoSlider {
    @Test
    public void testSlider1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/slider");
        driver.manage().window().maximize();
        Thread.sleep(1000);
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        slider.sendKeys(Keys.ARROW_RIGHT);
        slider.sendKeys(Keys.ARROW_RIGHT);
        slider.sendKeys(Keys.ARROW_RIGHT);
        String sliderValue = driver.findElement(By.id("sliderValue")).getAttribute("value");
        Assert.assertEquals(sliderValue, "28");
        System.out.println(sliderValue);

    }
}
