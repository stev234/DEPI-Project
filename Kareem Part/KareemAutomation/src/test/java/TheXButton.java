import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TheXButton {

    public static void main(String[] args) throws InterruptedException {

        // -----------------------------------------
        // 1. OPEN BROWSER
        // -----------------------------------------
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
        Thread.sleep(2000);

        // -----------------------------------------
        // 2. LOGIN
        // -----------------------------------------
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        Thread.sleep(1500);

        // Enter existing account credentials
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("mahmoudtestuser123@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        Thread.sleep(2000);

        // -----------------------------------------
        // 3. ADD PRODUCT 1: Blue Top
        // -----------------------------------------
        WebElement blueTop = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/a"));
        blueTop.click();
        Thread.sleep(1000);

        // click "Continue Shopping"
        driver.findElement(By.xpath("//*[@id='cartModal']/div/div/div[3]/button")).click();
        Thread.sleep(1500);

        // -----------------------------------------
        // 4. ADD PRODUCT 2: Men Tshirt
        // -----------------------------------------
        WebElement menTshirt = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]/a"));
        menTshirt.click();
        Thread.sleep(1000);

        // continue shopping again
        driver.findElement(By.xpath("//*[@id='cartModal']/div/div/div[3]/button")).click();
        Thread.sleep(1500);

        // -----------------------------------------
        // 5. VIEW CART
        // -----------------------------------------
        driver.findElement(By.xpath("//a[@href='/view_cart']")).click();
        Thread.sleep(2000);

        // -----------------------------------------
        // 6. REMOVE ONE ITEM (X BUTTON)
        // -----------------------------------------
        driver.findElement(By.xpath("//*[@id='product-2']/td[6]/a")).click();
        Thread.sleep(1500);

        // -----------------------------------------
        // 7. PROCEED TO CHECKOUT
        // -----------------------------------------
        driver.findElement(By.xpath("//*[@id='do_action']/div[1]/div/div/a")).click();
        Thread.sleep(2000);

        // -----------------------------------------
        // 8. CLOSE BROWSER
        // -----------------------------------------
        driver.quit();
    }
}
