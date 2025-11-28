package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class NavigationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public NavigationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By products = By.xpath("//a[contains(@href,'/products')]");
    private By cart = By.xpath("//a[contains(@href,'/view_cart')]");
    private By login = By.xpath("//a[contains(@href,'/login')]");
    private By contactUs = By.xpath("//a[contains(@href,'/contact_us')]");
    private By home = By.xpath("//a[@href='/' or contains(text(),'Home')]");

    public void goToProducts() {
        wait.until(ExpectedConditions.elementToBeClickable(products)).click();
    }

    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cart)).click();
    }

    public void goToLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(login)).click();
    }

    public void goToContactUs() {
        wait.until(ExpectedConditions.elementToBeClickable(contactUs)).click();
    }

    public void goHome() {
        wait.until(ExpectedConditions.elementToBeClickable(home)).click();
    }
}
