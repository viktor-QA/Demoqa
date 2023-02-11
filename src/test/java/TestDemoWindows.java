import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Set;


public class TestDemoWindows {
    @Test
    public void testWindows1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");

        String originalWindow = driver.getWindowHandle();
        driver.findElement(By.id("tabButton")).click();

        //Loop through until we find a new window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        String pageText = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(pageText, "This is a sample page");
        //Close the tab or window
        driver.close();
        //Switch back to the old tab or window
        driver.switchTo().window(originalWindow);

        driver.findElement(By.id("windowButton")).click();
        //Loop through until we find a new window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        String windowText = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
        Assert.assertEquals(windowText, "This is a sample page");
        driver.close();
        //Switch back to the old tab or window
        driver.switchTo().window(originalWindow);

        driver.findElement(By.id("messageWindowButton")).click();

        Set<String> s1 = driver.getWindowHandles();
        System.out.println("Child window handle is" + s1);
        Iterator<String> i1 = s1.iterator();
        System.out.println("Child window handle is" + i1);

        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!originalWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                String messageWindowText = driver.findElement(By.xpath("//body")).getText();
                System.out.println(messageWindowText);
                Assert.assertEquals(messageWindowText, "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.");
                driver.close();

            }
        }




    }
}
