package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import utils.DriverFactory;

import java.time.Duration;

public class SignUpFormPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public SignUpFormPage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private void safeClick(By by) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by)).click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();", driver.findElement(by));
        }
    }

    public void fillFullForm() {
        safeClick(By.id("id_gender1"));
        driver.findElement(By.id("password")).sendKeys("P@ssw0rd");

        new Select(driver.findElement(By.id("days"))).selectByValue("15");
        new Select(driver.findElement(By.id("months"))).selectByVisibleText("August");
        new Select(driver.findElement(By.id("years"))).selectByValue("1995");

        driver.findElement(By.id("first_name")).sendKeys("Mahmoud");
        driver.findElement(By.id("last_name")).sendKeys("Automation");
        driver.findElement(By.id("company")).sendKeys("TestCo");
        driver.findElement(By.id("address1")).sendKeys("Street 1");
        driver.findElement(By.id("state")).sendKeys("Cairo");
        driver.findElement(By.id("city")).sendKeys("Cairo");
        driver.findElement(By.id("zipcode")).sendKeys("12345");
        driver.findElement(By.id("mobile_number")).sendKeys("01000000000");

        safeClick(By.cssSelector("button[data-qa='create-account']"));
    }

    public void submitIncompleteForm() {
        driver.findElement(By.id("password")).sendKeys("P@ssw0rd");
        driver.findElement(By.id("first_name")).clear(); // required → missing
        safeClick(By.cssSelector("button[data-qa='create-account']"));
    }

    public boolean isAccountCreated() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//b[normalize-space()='Account Created!']")
            ));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean hasValidationError() {
        try {
            return driver.findElement(By.id("first_name")).getAttribute("validationMessage").length() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
