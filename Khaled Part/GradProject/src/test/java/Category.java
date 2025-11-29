package tests;

import baseTests.baseTests;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Category extends baseTests {

    @Test
    public void selectThirdSubCategory() throws InterruptedException {
        // -----------------------------------------
        // 1. LOGIN
        // -----------------------------------------
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//input[@data-qa='login-email']"))
                .sendKeys("mahmoudtestuser123@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']"))
                .sendKeys("123456");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        Thread.sleep(2000);

        // -----------------------------------------
        // 2. EXPAND WOMEN CATEGORY AND SELECT 3RD SUB-CATEGORY
        // -----------------------------------------
        driver.findElement(By.xpath("//*[@id='accordian']/div[1]/div[1]/h4/a/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='Women']/div/ul/li[3]/a")).click();
        Thread.sleep(2000);

        System.out.println(">>> Third sub-category under Women selected successfully.");
    }
}
