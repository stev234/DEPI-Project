import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Category {

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
        // 3. EXPAND WOMEN CATEGORY AND SELECT 3RD SUB-CATEGORY
        // -----------------------------------------
        // Click plus button to expand Women
        driver.findElement(By.xpath("//*[@id='accordian']/div[1]/div[1]/h4/a/span")).click();
        Thread.sleep(1000);

        // Select 3rd sub-category under Women
        driver.findElement(By.xpath("//*[@id='Women']/div/ul/li[3]/a")).click();
        Thread.sleep(2000);

        // -----------------------------------------
        // 4. CLOSE BROWSER
        // -----------------------------------------
        driver.quit();
    }
}
