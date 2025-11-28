package baseTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.HomePage;

public class baseTests {
    public WebDriver driver;
    public HomePage homePage;

    @BeforeTest
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        goHome();
    }

    @BeforeMethod
    public void goHome () {
        driver.get("https://automationexercise.com/");
        homePage = new HomePage(driver);
    }
    @AfterClass
    public void quit(){
        driver.quit();
    }

}
