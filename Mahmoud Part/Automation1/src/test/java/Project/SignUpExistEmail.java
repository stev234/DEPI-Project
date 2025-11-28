package Project;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class SignUpExistEmail {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.manage().window().maximize();
            driver.get("https://automationexercise.com/");

            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"))).click();

            // 🔥 PASTE THE EMAIL FROM SIGNUP HERE
            String existingEmail = "mahmoud.elzayat+1764331177031@gmail.com";

            driver.findElement(By.xpath("//*[@id='form']/div/div/div[3]/div/form/input[2]"))
                    .sendKeys("Mahmoud");

            driver.findElement(By.xpath("//*[@id='form']/div/div/div[3]/div/form/input[3]"))
                    .sendKeys(existingEmail);

            driver.findElement(By.xpath("//*[@id='form']/div/div/div[3]/div/form/button")).click();

            // Verify the error message
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(),'Email Address already exist')]")));

            System.out.println("✔ Existing email error displayed successfully for: " + existingEmail);

        } catch (Exception e) {
            System.err.println("Test Failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
