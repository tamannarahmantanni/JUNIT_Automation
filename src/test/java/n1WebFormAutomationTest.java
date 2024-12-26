import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class n1WebFormAutomationTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    @Test
    public void testWebFormSubmission() throws InterruptedException {

        driver.get("https://www.digitalunite.com/practice-webform-learners");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");

        driver.findElement(By.id("edit-name")).sendKeys("Tamanna");

        driver.findElement(By.id("edit-number")).sendKeys("123456678901");

        driver.findElement(By.id("edit-email")).sendKeys("t@example.com");

        WebElement dateField = driver.findElement(By.id("edit-date"));
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        dateField.sendKeys(today);

        driver.findElement(By.id("edit-tell-us-a-bit-about-yourself-")).sendKeys("This is a test submission for automation.");

        WebElement fileInput = driver.findElement(By.id("edit-uploadocument-upload"));
        fileInput.sendKeys("C:/Users/Tamanna Rahman/subtitle.pdf");

        Thread.sleep(3000);

        WebElement ageCheckbox = driver.findElement(By.id("edit-age"));
        js.executeScript("arguments[0].scrollIntoView(true);", ageCheckbox);
        wait.until(ExpectedConditions.elementToBeClickable(ageCheckbox));

        WebElement overlay = driver.findElement(By.className("ot-sdk-container"));
        wait.until(ExpectedConditions.invisibilityOf(overlay));

        js.executeScript("arguments[0].click();", ageCheckbox);

        WebElement submitButton = driver.findElement(By.id("edit-submit"));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();


        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Thank you for your submission!')]")));

        assertEquals("Thank you for your submission!", successMessage.getText());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

