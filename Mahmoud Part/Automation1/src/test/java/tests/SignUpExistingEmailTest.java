package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class SignUpExistingEmailTest extends BaseTest {

    @Test
    public void existingEmail() {

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"))).click();

        String existingEmail = "mahmoud.elzayat+1764331177031@gmail.com";

        driver.findElement(By.xpath("//*[@id='form']/div/div/div[3]/div/form/input[2]"))
                .sendKeys("Mahmoud");

        driver.findElement(By.xpath("//*[@id='form']/div/div/div[3]/div/form/input[3]"))
                .sendKeys(existingEmail);

        driver.findElement(By.xpath("//*[@id='form']/div/div/div[3]/div/form/button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'Email Address already exist')]")));

        System.out.println("✔ Existing email test passed");
    }
}
