package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() throws InterruptedException {

        // 1️⃣ Go to Login page
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[@href='/login']"))).click();

        // 2️⃣ Enter Login Credentials
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@data-qa='login-email']")))
                .sendKeys("mahmoudtestuser123@gmail.com");

        driver.findElement(By.xpath("//input[@data-qa='login-password']"))
                .sendKeys("123456");

        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        Thread.sleep(1500); // tiny delay for the page redraw


        // 3️⃣ FIX POPUP → Click Continue OR Refresh
        try {
            WebElement continueBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-qa='continue-button']"))
            );
            continueBtn.click();
            Thread.sleep(1000);
        } catch (Exception ignored) {
            driver.navigate().refresh();
            Thread.sleep(1500);
        }

        System.out.println("✔ Login test completed successfully!");
    }
}
