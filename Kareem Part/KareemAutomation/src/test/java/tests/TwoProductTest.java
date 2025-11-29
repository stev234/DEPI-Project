package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TwoProductTest extends BaseTest {

    @Test
    public void testTwoProducts() throws InterruptedException {

        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[@href='/login']")).click();
        Thread.sleep(1500);

        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("MahmoudTestUser");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("mahmoudtestuser1@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("password")).sendKeys("123456");

        driver.findElement(By.id("days")).sendKeys("10");
        driver.findElement(By.id("months")).sendKeys("May");
        driver.findElement(By.id("years")).sendKeys("2000");

        driver.findElement(By.id("first_name")).sendKeys("Mahmoud");
        driver.findElement(By.id("last_name")).sendKeys("Zayat");
        driver.findElement(By.id("address1")).sendKeys("Helwan");
        driver.findElement(By.id("state")).sendKeys("Cairo");
        driver.findElement(By.id("city")).sendKeys("Cairo");
        driver.findElement(By.id("zipcode")).sendKeys("12345");
        driver.findElement(By.id("mobile_number")).sendKeys("01000000000");

        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        Thread.sleep(2000);

        try { driver.navigate().refresh(); } catch (Exception ignored) {}
        Thread.sleep(2000);

        WebElement blueTop = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/a"));
        blueTop.click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id='cartModal']/div/div/div[3]/button")).click();
        Thread.sleep(1500);

        WebElement menTshirt = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]/a"));
        menTshirt.click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id='cartModal']/div/div/div[3]/button")).click();
        Thread.sleep(1500);

        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
        Thread.sleep(2000);

        System.out.println("Two products test completed!");
    }
}
