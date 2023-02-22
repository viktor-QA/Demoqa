import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;

public class TestDemoAlerts extends BaseTest {
    @Test
    public void testAlert1() {

        AlertsPage alertsPage = openAlertsPage();

        alertsPage.click(By.id("alertButton"));
        Assert.assertEquals(alertsPage.getAlertText(), "You clicked a button");
        alertsPage.acceptAlert();

        alertsPage.click(By.id("timerAlertButton"));
        alertsPage.waitSeconds(5);
        Assert.assertEquals(alertsPage.getAlertText(), "This alert appeared after 5 seconds");
        alertsPage.acceptAlert();

        alertsPage.click(By.id("confirmButton"));
        Assert.assertEquals(alertsPage.getAlertText(), "Do you confirm action?");
        alertsPage.acceptAlert();

        alertsPage.click(By.id("promtButton"));
        alertsPage.sendAlertText("Test");
        Assert.assertEquals(alertsPage.getAlertText(), "Please enter your name");
        alertsPage.acceptAlert();
    }
}
