package Project;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpMissingFields {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.manage().window().maximize();
            driver.get("https://automationexercise.com/");

            // Click Signup/Login
            WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[4]/a")));
            loginLink.click();

            // ======== STEP 1: Try to submit empty fields ========
            WebElement signupButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id='form']/div/div/div[3]/div/form/button")));

            // Try clicking Signup with EMPTY fields
            signupButton.click();

            // ==== BROWSER VALIDATION CHECK ====
            WebElement nameField = driver.findElement(By.xpath("//*[@id='form']/div/div/div[3]/div/form/input[2]"));

            String validationMessage = nameField.getAttribute("validationMessage");

            if (!validationMessage.isEmpty()) {
                System.out.println("PASS: Browser prevented submission due to missing Name → " + validationMessage);
            } else {
                System.out.println("FAIL: Signup submitted even with missing Name!");
            }

            // ======== STEP 1: Missing Email Test ========
            nameField.sendKeys("Mahmoud");
            signupButton.click();

            WebElement emailField = driver.findElement(By.xpath("//*[@id='form']/div/div/div[3]/div/form/input[3]"));

            String emailValidation = emailField.getAttribute("validationMessage");

            if (!emailValidation.isEmpty()) {
                System.out.println("PASS: Browser prevented submission due to missing Email → " + emailValidation);
            } else {
                System.out.println("FAIL: Signup submitted even with missing Email!");
            }

            // Now enter name + email → proceed to Step 2
            emailField.sendKeys("mah.test+" + System.currentTimeMillis() + "@gmail.com");
            signupButton.click();

            // ======== STEP 2: Missing Required Fields ========
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1")));

            WebElement createAccountBtn = driver.findElement(By.cssSelector("button[data-qa='create-account']"));

            // Try clicking Create Account without filling password/address
            createAccountBtn.click();

            // Check browser validation for password
            WebElement passwordField = driver.findElement(By.id("password"));
            String pwdMessage = passwordField.getAttribute("validationMessage");

            if (!pwdMessage.isEmpty()) {
                System.out.println("PASS: Missing Password correctly stopped form → " + pwdMessage);
            } else {
                System.out.println("FAIL: Form accepted missing password!");
            }

            // Fill password correctly then remove required address field
            passwordField.sendKeys("123456");

            WebElement firstName = driver.findElement(By.id("first_name"));
            firstName.clear(); // Make field empty

            createAccountBtn.click();

            String addressValidation = firstName.getAttribute("validationMessage");

            if (!addressValidation.isEmpty()) {
                System.out.println("PASS: Missing First Name correctly prevented submission → " + addressValidation);
            } else {
                System.out.println("FAIL: Form accepted missing first name!");
            }

        } catch (Exception e) {
            System.err.println("Test failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
