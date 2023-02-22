import org.openqa.selenium.WebDriver;
import pages.*;

public class BaseTest {
    protected WebDriver webDriver;

    {
        webDriver = initDriver();
    }

    public WebDriver initDriver() {
        if (webDriver == null) {
            return Driver.CHROME.create();
        } else {
            return webDriver;
        }

    }

    public FormPage openFormPage() {
        FormPage formPage = new FormPage(webDriver);
        return formPage.openPage();
    }

    public SliderPage openSliderPage() {
        SliderPage sliderPage = new SliderPage(webDriver);
        return sliderPage.openPage();
    }

    public AlertsPage openAlertsPage() {
        AlertsPage alertsPage = new AlertsPage(webDriver);
        return alertsPage.openPage();
    }

    public FramesPage openFramesPage() {
        FramesPage framesPage = new FramesPage(webDriver);
        return framesPage.openPage();
    }

    public WindowsPage openWindowsPage() {
        WindowsPage windowsPage = new WindowsPage(webDriver);
        return windowsPage.openPage();
    }
}
