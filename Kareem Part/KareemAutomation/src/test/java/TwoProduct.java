import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TwoProduct{

    public static void main(String[] args) throws InterruptedException {

        // -----------------------------------------
        // 1. OPEN BROWSER
        // -----------------------------------------
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Go to website
        driver.get("https://automationexercise.com/");
        Thread.sleep(2000);

        // -----------------------------------------
        // 2. SIGN UP
        // -----------------------------------------
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        Thread.sleep(1500);

        // enter sign up name & email
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("MahmoudTestUser");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("mahmoudtestuser123@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        Thread.sleep(2000);

        // fill required fields
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

        // continue button
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        Thread.sleep(2000);

        // Close ads popup issue fix
        try { driver.navigate().refresh(); } catch (Exception e) {}
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
        // 6. CLOSE BROWSER
        // -----------------------------------------
        driver.quit();
    }
}
