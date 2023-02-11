import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDemoFrames {
    @Test
    public void testFrame1() {
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/frames");
        driver.manage().window().maximize();

        WebElement iframeElement1 = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(iframeElement1);
        String f1 = driver.findElement(By.xpath("//body")).getText();
        Assert.assertEquals(f1, "This is a sample page");
        System.out.println(f1);

        driver.switchTo().defaultContent();

        WebElement iframeElement2 = driver.findElement(By.id("frame2"));
        driver.switchTo().frame(iframeElement2);
        String f2 = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
        Assert.assertEquals(f2, "This is a sample page");
        System.out.println(f2);

    }
}
