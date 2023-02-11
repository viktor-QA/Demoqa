import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDemoAlerts {
    @Test
    public void testAlert1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");


        driver.findElement(By.id("alertButton")).click();
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, "You clicked a button");
        driver.switchTo( ).alert( ).accept();

        driver.findElement(By.id("timerAlertButton")).click();
        Thread.sleep(6000);
        String timerAlertText = driver.switchTo().alert().getText();
        Assert.assertEquals(timerAlertText, "This alert appeared after 5 seconds");
        driver.switchTo( ).alert( ).accept();

        driver.findElement(By.id("confirmButton")).click();
        String confirmButtonText = driver.switchTo().alert().getText();
        Assert.assertEquals(confirmButtonText, "Do you confirm action?");
        driver.switchTo( ).alert( ).accept();

        driver.findElement(By.id("promtButton")).click();
        String promtButtonText = driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("Test");
        Assert.assertEquals(promtButtonText, "Please enter your name");
        driver.switchTo( ).alert( ).accept();
    }
}
