
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Cart {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {

            driver.manage().window().maximize();
            driver.get("https://automationexercise.com/");

            // ============ SIGN UP PROCESS ============

            WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[4]/a")));
            loginLink.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id='form']/div/div/div[3]/div/form/input[2]")));

            // Name + Email
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

            driver.findElement(By.id("newsletter")).click();
            driver.findElement(By.id("optin")).click();

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

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createAccountBtn);
            createAccountBtn.click();

            wait.until(ExpectedConditions.titleContains("Account Created"));
            System.out.println("Account created successfully → " + email);


            // ============ ADD TWO PRODUCTS TO CART ============

            driver.get("https://automationexercise.com/");

            // First Product
            WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[3]/div/div[1]/div[1]/a")));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstProduct);
            firstProduct.click();

            // Continue Shopping or Add more
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id='cartModal']/div/div/div[2]/p[2]/a/u"))).click();


            // Second Product (same xpath, you provided same one twice)
            WebElement secondProduct = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[3]/div/div[1]/div[1]/a")));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", secondProduct);
            secondProduct.click();

            // Go to cart
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id='cartModal']/div/div/div[2]/p[2]/a/u"))).click();

            // Cart page
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[@id='product-2']/td[6]/a")));

            System.out.println("Products added to cart successfully!");

            // ============ PAYMENT PART WILL GO HERE ============

        } catch (Exception e) {
            System.err.println("Test failed: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
