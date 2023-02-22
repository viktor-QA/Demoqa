import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WindowsPage;

import java.util.Iterator;
import java.util.Set;

public class TestDemoWindows extends BaseTest {
    @Test
    public void testWindows1() {
        WindowsPage windowsPage = openWindowsPage();

        String originalWindow = windowsPage.getWindowHandle();
        windowsPage.click(By.id("tabButton"));

        //Loop through until we find a new window handle
        for (String windowHandle : windowsPage.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                windowsPage.getWindow(windowHandle);
                break;
            }
        }
        Assert.assertEquals(windowsPage.getText(By.xpath("//h1")), "This is a sample page");
        windowsPage.driverClose();
        windowsPage.getWindow(originalWindow);

        windowsPage.click(By.id("windowButton"));
        for (String windowHandle : windowsPage.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                windowsPage.getWindow(windowHandle);
                break;
            }
        }
        Assert.assertEquals(windowsPage.getText(By.xpath("//h1[@id='sampleHeading']")), "This is a sample page");
        windowsPage.driverClose();
        windowsPage.getWindow(originalWindow);

        windowsPage.click(By.id("messageWindowButton"));

        Set<String> s1 = windowsPage.getWindowHandles();
        System.out.println("Child window handle is" + s1);
        Iterator<String> i1 = s1.iterator();
        System.out.println("Child window handle is" + i1);

        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            if (!originalWindow.equalsIgnoreCase(ChildWindow)) {
                windowsPage.getWindow(ChildWindow);
                String messageWindowText = windowsPage.getText(By.xpath("//body"));
                System.out.println(messageWindowText);
                Assert.assertEquals(messageWindowText, "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.");
            }

        }


    }
}
