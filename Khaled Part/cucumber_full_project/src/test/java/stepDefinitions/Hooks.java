package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

public class Hooks {

    public static WebDriver driver;
    public static HomePage home;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
        home = new HomePage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
