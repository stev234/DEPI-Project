package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPage {
    private WebDriver driver;

    private By home = By.xpath("//a[contains(text(),'Home')]");
    private By products = By.xpath("//a[contains(text(),'Products')]");
    private By cart = By.xpath("//a[contains(text(),'Cart')]");
    private By login = By.xpath("//a[contains(text(),'Signup / Login')]");
    private By contactUs = By.xpath("//a[contains(text(),'Contact')]");
    private By testCases = By.xpath("//a[contains(text(),'Test Cases')]");

    public NavigationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToHome() {
        driver.findElement(home).click();
    }

    public void goToProducts() {
        driver.findElement(products).click();
    }

    public void goToCart() {
        driver.findElement(cart).click();
    }

    public void goToLogin() {
        driver.findElement(login).click();
    }

    public void goToContactUs() {
        driver.findElement(contactUs).click();
    }

    public void goToTestCases() {
        driver.findElement(testCases).click();
    }
}
