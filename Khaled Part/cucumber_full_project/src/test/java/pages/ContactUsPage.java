package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {
    WebDriver driver;

    By name = By.name("name");
    By email = By.name("email");
    By message = By.id("message");
    By submit = By.name("submit");
    By successMsg = By.cssSelector(".status");

    public ContactUsPage(WebDriver driver) { this.driver = driver; }

    public void enterName(String n) { driver.findElement(name).sendKeys(n); }

    public void enterEmail(String e) { driver.findElement(email).sendKeys(e); }

    public void enterMessage(String m) { driver.findElement(message).sendKeys(m); }

    public void submit() { driver.findElement(submit).click(); }

    public boolean successMessageDisplayed() {
        return driver.findElement(successMsg).isDisplayed();
    }
}
