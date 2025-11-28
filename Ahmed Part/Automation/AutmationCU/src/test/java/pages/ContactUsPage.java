package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ContactUsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By nameField = By.name("name");
    private By emailField = By.name("email");
    private By subjectField = By.name("subject");
    private By messageField = By.id("message");
    private By uploadField = By.name("upload_file");
    private By submitBtn = By.name("submit");
    private By successMsg = By.xpath("//*[contains(text(),'Success') or contains(text(),'successfully')]"); 

    public void openContactPage() {
        // Assume nav link is tapped via NavigationPage in steps, but keep fallback
        driver.get("https://automationexercise.com/contact_us");
    }

    public void fillForm(String name, String email, String subject, String message) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(subjectField).sendKeys(subject);
        driver.findElement(messageField).sendKeys(message);
    }

    public void uploadFile(String path) {
        driver.findElement(uploadField).sendKeys(path);
    }

    public void submitForm() {
        driver.findElement(submitBtn).click();
    }

    public boolean checkSuccessMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
