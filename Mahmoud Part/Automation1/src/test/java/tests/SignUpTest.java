package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    @Test
    public void signUpTest() {

        // Click Signup / Login
        WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")));
        loginLink.click();

        // STEP 1
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='form']/div/div/div[3]/div/form/input[2]")));

        driver.findElement(By.xpath("//*[@id='form']/div/div/div[3]/div/form/input[2]"))
                .sendKeys("Mahmoud");

        String email = "mahmoud.elzayat+" + System.currentTimeMillis() + "@gmail.com";
        driver.findElement(By.xpath("//*[@id='form']/div/div/div[3]/div/form/input[3]"))
                .sendKeys(email);

        driver.findElement(By.xpath("//*[@id='form']/div/div/div[3]/div/form/button")).click();

        // STEP 2
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

        WebElement createAccountBtn = driver.findElement(By.cssSelector("button[data-qa='create-account']"));
        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", createAccountBtn);
        createAccountBtn.click();

        wait.until(ExpectedConditions.titleContains("Account Created"));
        System.out.println("Account created successfully for: " + email);
    }
}
