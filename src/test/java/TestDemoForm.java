import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDemoForm {
    @Test
    public void testForm1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
        driver.findElement(By.id("firstName")).sendKeys("test1");
        driver.findElement(By.id("lastName")).sendKeys("test2");
        driver.findElement(By.id("userEmail")).sendKeys("test1@test.com");
        driver.findElement(By.xpath("//input[@id='gender-radio-1']/following-sibling::label")).click();
        driver.findElement(By.id("userNumber")).sendKeys("1234567890");
        driver.findElement(By.id("dateOfBirthInput")).click();
        Select drpMonth = new Select(driver.findElement(By.xpath("//div[@class='react-datepicker__month-dropdown-container react-datepicker__month-dropdown-container--select']/select")));
        Thread.sleep(1000);
        drpMonth.selectByValue("6");
        Thread.sleep(1000);
        Select drpYear = new Select(driver.findElement(By.xpath("//div[@class='react-datepicker__year-dropdown-container react-datepicker__year-dropdown-container--select']/select")));
        Thread.sleep(1000);
        drpYear.selectByValue("1980");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--011']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("subjectsInput")).sendKeys("m");
        Thread.sleep(1000);
        driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value='3']/following-sibling::label")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("currentAddress")).sendKeys("Test street");
        Thread.sleep(1000);

        WebElement e1 = driver.findElement(By.xpath("//input[@id='react-select-3-input']"));
        e1.sendKeys("Uttar Pradesh");
        e1.sendKeys(Keys.ENTER);

        WebElement e2 = driver.findElement(By.xpath("//input[@id='react-select-4-input']"));
        e2.sendKeys("Lucknow");
        e2.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//button[@id='submit']")).sendKeys(Keys.ENTER);

        String studentName = driver.findElement(By.xpath("//td[contains(text(),'Student Name')]/following-sibling::td")).getText();
        Assert.assertEquals(studentName,"test1 test2");
        String studentEmail = driver.findElement(By.xpath("//td[contains(text(),'Student Email')]/following-sibling::td")).getText();
        Assert.assertEquals(studentEmail,"test1@test.com");
        String studentGender = driver.findElement(By.xpath("//td[contains(text(),'Gender')]/following-sibling::td")).getText();
        Assert.assertEquals(studentGender,"Male");
        String studentMobile = driver.findElement(By.xpath("//td[contains(text(),'Mobile')]/following-sibling::td")).getText();
        Assert.assertEquals(studentMobile,"1234567890");
        String studentDate = driver.findElement(By.xpath("//td[contains(text(),'Date of Birth')]/following-sibling::td")).getText();
        Assert.assertEquals(studentDate,"11 July,1980");
        String studentSubjects = driver.findElement(By.xpath("//td[contains(text(),'Subjects')]/following-sibling::td")).getText();
        Assert.assertEquals(studentSubjects,"Chemistry");
        String studentHobbies = driver.findElement(By.xpath("//td[contains(text(),'Hobbies')]/following-sibling::td")).getText();
        Assert.assertEquals(studentHobbies,"Music");
        String studentAddress = driver.findElement(By.xpath("//td[contains(text(),'Address')]/following-sibling::td")).getText();
        Assert.assertEquals(studentAddress,"Test street");
        String studentState = driver.findElement(By.xpath("//td[contains(text(),'State and City')]/following-sibling::td")).getText();
        Assert.assertEquals(studentState,"Uttar Pradesh Lucknow");


    }
}
