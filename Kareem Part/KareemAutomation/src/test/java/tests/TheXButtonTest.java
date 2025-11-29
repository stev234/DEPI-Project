package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class TheXButtonTest extends BaseTest {

    @Test
    public void testRemoveItem() throws InterruptedException {

        // 1. LOGIN
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        Thread.sleep(1500);

        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("mahmoudtestuser123@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        Thread.sleep(2000); // WAIT FOR POPUP


        // ⭐⭐⭐ IMPORTANT FIX ⭐⭐⭐
        //sometimes popup shows Continue button
        try {
            WebElement continueBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-qa='continue-button']"))
            );
            continueBtn.click();
            Thread.sleep(1000);
        } catch (Exception e) {
            // If continue button doesn’t exist → refresh (clears popup)
            driver.navigate().refresh();
            Thread.sleep(2000);
        }


        // 2. ADD BLUE TOP
        WebElement blueTop = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/a")));
        blueTop.click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id='cartModal']/div/div/div[3]/button")).click();
        Thread.sleep(1500);


        // 3. ADD MEN TSHIRT
        WebElement menTshirt = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]/a")));
        menTshirt.click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id='cartModal']/div/div/div[3]/button")).click();
        Thread.sleep(1500);


        // 4. VIEW CART
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
        Thread.sleep(2000);


        // 5. REMOVE ONE PRODUCT (X BUTTON)
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='product-2']/td[6]/a"))).click();

        Thread.sleep(1500);


        // 6. PROCEED TO CHECKOUT
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='do_action']/div[1]/div/div/a"))).click();

        Thread.sleep(2000);

        System.out.println("✔ X button test completed successfully!");
    }
}
