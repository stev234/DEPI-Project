package tests;

import baseTests.baseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Search extends baseTests {

    @Test
    public void searchProduct() throws InterruptedException {
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
        // 2. NAVIGATE TO PRODUCTS PAGE
        // -----------------------------------------
        WebElement productsNav = driver.findElement(By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[2]/a"));
        productsNav.click();
        Thread.sleep(2000);

        // -----------------------------------------
        // 3. SEARCH PRODUCT
        // -----------------------------------------
        System.out.println(">>> Starting Product Search");
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='search_product']"));
        searchBox.clear();
        searchBox.sendKeys("Blue Top");
        driver.findElement(By.xpath("//*[@id='submit_search']")).click();
        Thread.sleep(2000);

        boolean resultsVisible = driver.findElement(By.xpath("//h2[contains(text(),'Searched Products')]")).isDisplayed();
        if (resultsVisible) {
            System.out.println(">>> Search Successful: Results displayed.");
        } else {
            System.out.println(">>> Search FAILED: No results found.");
        }
    }
}
