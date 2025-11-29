package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class MissingFieldsTest extends BaseTest {

    @Test
    public void missingFieldsTest() {

        WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[4]/a")));
        loginLink.click();

        WebElement signupButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='form']/div/div/div[3]/div/form/button")));

        signupButton.click();

        WebElement nameField = driver.findElement(By.xpath("//*[@id='form']/div/div/div[3]/div/form/input[2]"));
        System.out.println("Name field validation → " + nameField.getAttribute("validationMessage"));

        nameField.sendKeys("Mahmoud");
        signupButton.click();

        WebElement emailField = driver.findElement(By.xpath("//*[@id='form']/div/div/div[3]/div/form/input[3]"));
        System.out.println("Email validation → " + emailField.getAttribute("validationMessage"));
    }
}
