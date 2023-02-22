import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FramesPage;

public class TestDemoFrames extends BaseTest {
    @Test
    public void testFrame1() {
        FramesPage framesPage = openFramesPage();

        WebElement iframeElement1 = framesPage.getElementBy(By.id("frame1"));
        framesPage.findFrame(iframeElement1);
        Assert.assertEquals(framesPage.getElementBy(By.xpath("//body")).getText(), "This is a sample page");
        framesPage.defaultFrame();

        WebElement iframeElement2 = framesPage.getElementBy(By.id("frame2"));
        framesPage.findFrame(iframeElement2);
        Assert.assertEquals(framesPage.getElementBy(By.xpath("//h1[@id='sampleHeading']")).getText(), "This is a sample page");

    }
}
