package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By contactUs = By.cssSelector("a[href='/contact_us']");

    //Actions
    public ContactUsPage clickOnContactUS () {
        driver.findElement(contactUs).click();
        return new ContactUsPage(driver);
    }

}
