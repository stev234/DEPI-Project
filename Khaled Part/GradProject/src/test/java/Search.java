import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search {

    public static void main(String[] args) throws InterruptedException {

        // -----------------------------
        // 1. OPEN BROWSER
        // -----------------------------
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
        Thread.sleep(2000);

        // -----------------------------
        // 2. LOGIN
        // -----------------------------
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        Thread.sleep(1500);

        // Enter login credentials (replace with your existing account)
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("mahmoudtestuser123@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("123456");

        // Click login button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        Thread.sleep(2000);

        // -----------------------------
        // 3. NAVIGATE TO PRODUCTS PAGE
        // -----------------------------
        WebElement productsNav = driver.findElement(By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[2]/a"));
        productsNav.click();
        Thread.sleep(2000);

        // -----------------------------
        // 4. SEARCH PRODUCT
        // -----------------------------
        System.out.println(">>> Starting Product Search");

        // Type product to search
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='search_product']"));
        searchBox.clear();
        searchBox.sendKeys("Blue Top");

        // Click search button
        driver.findElement(By.xpath("//*[@id='submit_search']")).click();
        Thread.sleep(2000);

        // Verify results visible
        boolean resultsVisible = driver.findElement(By.xpath("//h2[contains(text(),'Searched Products')]")).isDisplayed();

        if (resultsVisible) {
            System.out.println(">>> Search Successful: Results displayed.");
        } else {
            System.out.println(">>> Search FAILED: No results found.");
        }

        // -----------------------------
        // 5. CLOSE BROWSER
        // -----------------------------
        driver.quit();
    }
}
