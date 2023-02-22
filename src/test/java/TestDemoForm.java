import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormPage;

public class TestDemoForm extends BaseTest {
    @Test
    public void testForm1() throws InterruptedException {
        FormPage formPage = openFormPage();

        formPage.typeText(By.id("firstName"), "test1");
        formPage.typeText(By.id("lastName"), "test2");
        formPage.typeText(By.id("userEmail"), "test1@test.com");
        formPage.click(By.xpath("//input[@id='gender-radio-1']/following-sibling::label"));
        formPage.typeText(By.id("userNumber"), "1234567890");
        formPage.click(By.id("dateOfBirthInput"));
        Select drpMonth = new Select(formPage.getElementBy(By.xpath("//div[@class='react-datepicker__month-dropdown-container react-datepicker__month-dropdown-container--select']/select")));
        Thread.sleep(1000);
        drpMonth.selectByValue("6");
        Thread.sleep(1000);
        Select drpYear = new Select(formPage.getElementBy(By.xpath("//div[@class='react-datepicker__year-dropdown-container react-datepicker__year-dropdown-container--select']/select")));
        Thread.sleep(1000);
        drpYear.selectByValue("1980");
        Thread.sleep(1000);
        formPage.click(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--011']"));
        Thread.sleep(1000);
        formPage.typeText(By.id("subjectsInput"), "m");
        Thread.sleep(1000);
        formPage.getElementBy(By.id("subjectsInput")).sendKeys(Keys.ARROW_DOWN);
        formPage.getElementBy(By.id("subjectsInput")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        formPage.click(By.xpath("//input[@value='3']/following-sibling::label"));
        Thread.sleep(1000);
        formPage.typeText(By.id("currentAddress"), "Test street");
        Thread.sleep(1000);

        WebElement e1 = formPage.getElementBy(By.xpath("//input[@id='react-select-3-input']"));
        e1.sendKeys("Uttar Pradesh");
        e1.sendKeys(Keys.ENTER);

        WebElement e2 = formPage.getElementBy(By.xpath("//input[@id='react-select-4-input']"));
        e2.sendKeys("Lucknow");
        e2.sendKeys(Keys.ENTER);

        formPage.getElementBy(By.xpath("//button[@id='submit']")).sendKeys(Keys.ENTER);

        String studentName = formPage.getText(By.xpath("//td[contains(text(),'Student Name')]/following-sibling::td"));
        Assert.assertEquals(studentName, "test1 test2");
        String studentEmail = formPage.getText(By.xpath("//td[contains(text(),'Student Email')]/following-sibling::td"));
        Assert.assertEquals(studentEmail, "test1@test.com");
        String studentGender = formPage.getText(By.xpath("//td[contains(text(),'Gender')]/following-sibling::td"));
        Assert.assertEquals(studentGender, "Male");
        String studentMobile = formPage.getText(By.xpath("//td[contains(text(),'Mobile')]/following-sibling::td"));
        Assert.assertEquals(studentMobile, "1234567890");
        String studentDate = formPage.getText(By.xpath("//td[contains(text(),'Date of Birth')]/following-sibling::td"));
        Assert.assertEquals(studentDate, "11 July,1980");
        String studentSubjects = formPage.getText(By.xpath("//td[contains(text(),'Subjects')]/following-sibling::td"));
        Assert.assertEquals(studentSubjects, "Chemistry");
        String studentHobbies = formPage.getText(By.xpath("//td[contains(text(),'Hobbies')]/following-sibling::td"));
        Assert.assertEquals(studentHobbies, "Music");
        String studentAddress = formPage.getText(By.xpath("//td[contains(text(),'Address')]/following-sibling::td"));
        Assert.assertEquals(studentAddress, "Test street");
        String studentState = formPage.getText(By.xpath("//td[contains(text(),'State and City')]/following-sibling::td"));
        Assert.assertEquals(studentState, "Uttar Pradesh Lucknow");


    }
}
