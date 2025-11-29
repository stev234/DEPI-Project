package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By contactUsBtn = By.xpath("//a[text()=' Contact us']");
    By productsBtn = By.xpath("//a[text()=' Products']");
    By womenCategory = By.xpath("//a[@href='#Women']");
    By womenTops = By.xpath("//a[text()='Tops ']");

    public HomePage(WebDriver driver) { this.driver = driver; }

    public pages.ContactUsPage clickOnContactUS() {
        driver.findElement(contactUsBtn).click();
        return new ContactUsPage(driver);
    }

    public void openProducts() { driver.findElement(productsBtn).click(); }

    public void openWomenCategory() { driver.findElement(womenCategory).click(); }

    public void clickWomenTops() { driver.findElement(womenTops).click(); }
}
