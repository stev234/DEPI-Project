package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import utils.DriverFactory;

import java.time.Duration;
import java.util.UUID;

public class SignUpPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public SignUpPage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private void safeClick(By by) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by)).click();
        } catch (Exception e) {
            WebElement el = driver.findElement(by);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
        }
    }

    // ================================
    // START PAGE
    // ================================
    public void openHomePage() {
        driver.get("https://automationexercise.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("img[alt*='automation']")
        ));
    }

    public void clickSignupLogin() {
        safeClick(By.cssSelector("a[href='/login']"));
    }

    public String enterNameAndEmail(String name, String emailTemplate) {
        String email = emailTemplate.contains("{rand}")
                ? emailTemplate.replace("{rand}", UUID.randomUUID().toString().substring(0, 6))
                : emailTemplate;

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[data-qa='signup-name']")
        )).sendKeys(name);

        driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys(email);

        safeClick(By.cssSelector("button[data-qa='signup-button']"));

        return email;
    }

    // ================================
    // FILL ACCOUNT FORM (Step 2)
    // ================================
    public void fillAccountInformation() {
        // Gender
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1"))).click();

        // Password
        driver.findElement(By.id("password")).sendKeys("mah00612345");

        // Date of Birth
        new Select(driver.findElement(By.id("days"))).selectByValue("15");
        new Select(driver.findElement(By.id("months"))).selectByVisibleText("August");
        new Select(driver.findElement(By.id("years"))).selectByValue("1995");

        // Newsletter
        WebElement newsletter = driver.findElement(By.id("newsletter"));
        if (!newsletter.isSelected()) newsletter.click();

        // Offers
        WebElement optin = driver.findElement(By.id("optin"));
        if (!optin.isSelected()) optin.click();

        // Address
        driver.findElement(By.id("first_name")).sendKeys("Mahmoud");
        driver.findElement(By.id("last_name")).sendKeys("Elzayat");
        driver.findElement(By.id("company")).sendKeys("Zewail City");
        driver.findElement(By.id("address1")).sendKeys("123 Tech Lane");

        new Select(driver.findElement(By.id("country"))).selectByVisibleText("India");

        driver.findElement(By.id("state")).sendKeys("Maharashtra");
        driver.findElement(By.id("city")).sendKeys("Mumbai");
        driver.findElement(By.id("zipcode")).sendKeys("400001");
        driver.findElement(By.id("mobile_number")).sendKeys("+919876543210");

        // Create account
        WebElement createBtn = driver.findElement(By.cssSelector("button[data-qa='create-account']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createBtn);
        createBtn.click();
    }

    // ================================
    // VALIDATION & RESULTS
    // ================================
    public boolean isAccountCreated() {
        try {
            wait.until(ExpectedConditions.titleContains("Account Created"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isEmailExistsMessageShown() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(),'Email Address already exist')]")
            )).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean hasValidationErrors() {
        try {
            WebElement pw = driver.findElement(By.id("password"));
            return !pw.getAttribute("validationMessage").isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    // ================================
    // DELETE ACCOUNT
    // ================================
    public void deleteAccount() {
        safeClick(By.cssSelector("a[href='/delete_account']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[text()='Account Deleted!']")
        ));
    }
}
