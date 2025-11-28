package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Delete {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            driver.manage().window().maximize();
            driver.get("https://automationexercise.com/");

            // Click Signup / Login
            WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")));
            loginLink.click();

            // ========== STEP 1: Name & Email Only ==========
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id='form']/div/div/div[3]/div/form/input[2]")));

            // Fill Name & Email
            driver.findElement(By.xpath("//*[@id='form']/div/div/div[3]/div/form/input[2]"))
                    .sendKeys("Mahmoud");

            String email = "mahmoud.elzayat+" + System.currentTimeMillis() + "@gmail.com";
            driver.findElement(By.xpath("//*[@id='form']/div/div/div[3]/div/form/input[3]"))
                    .sendKeys(email);

            // Click Signup
            driver.findElement(By.xpath("//*[@id='form']/div/div/div[3]/div/form/button")).click();

            // ========== STEP 2: Account & Address Info ==========
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1")));
            driver.findElement(By.id("id_gender1")).click();

            driver.findElement(By.id("password")).sendKeys("mah00612345");

            new Select(driver.findElement(By.id("days"))).selectByValue("15");
            new Select(driver.findElement(By.id("months"))).selectByVisibleText("August");
            new Select(driver.findElement(By.id("years"))).selectByValue("1995");

            WebElement newsletter = driver.findElement(By.id("newsletter"));
            if (!newsletter.isSelected()) newsletter.click();

            WebElement optin = driver.findElement(By.id("optin"));
            if (!optin.isSelected()) optin.click();

            driver.findElement(By.id("first_name")).sendKeys("Mahmoud");
            driver.findElement(By.id("last_name")).sendKeys("Elzayat");
            driver.findElement(By.id("company")).sendKeys("Zewail City");
            driver.findElement(By.id("address1")).sendKeys("123 Tech Lane");

            new Select(driver.findElement(By.id("country"))).selectByVisibleText("India");

            driver.findElement(By.id("state")).sendKeys("Maharashtra");
            driver.findElement(By.id("city")).sendKeys("Mumbai");
            driver.findElement(By.id("zipcode")).sendKeys("400001");
            driver.findElement(By.id("mobile_number")).sendKeys("+919876543210");

            // Scroll to and click Create Account
            WebElement createAccountBtn = driver.findElement(By.cssSelector("button[data-qa='create-account']"));
            ((org.openqa.selenium.JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView({block: 'center'});", createAccountBtn);
            createAccountBtn.click();

            // Verify account created
            wait.until(ExpectedConditions.titleContains("Account Created"));
            System.out.println("Account created successfully for: " + email);

            // ======== CLICK CONTINUE BUTTON (IMPORTANT) ========
            WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("a[data-qa='continue-button']")));
            continueBtn.click();

            // Sometimes the site shows an ad → force refresh
            try { driver.navigate().refresh(); } catch (Exception ignored) {}

            // ========== DELETE ACCOUNT ==========
            WebElement deleteAccountLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")));
            deleteAccountLink.click();

            // Confirm deletion
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[text()='Account Deleted!']")));

            System.out.println("Account deleted successfully!");

        } catch (Exception e) {
            System.err.println("Test failed: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
