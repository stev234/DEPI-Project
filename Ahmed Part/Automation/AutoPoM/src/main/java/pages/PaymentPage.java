package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {
    private WebDriver driver;

    private By nameOnCard = By.name("name_on_card");
    private By cardNumber = By.name("card_number");
    private By cvc = By.name("cvc");
    private By expiryMonth = By.name("expiry_month");
    private By expiryYear = By.name("expiry_year");
    private By payBtn = By.id("submit");
    private By successMsg = By.xpath("//p[contains(text(),'Your order has been placed successfully!')]");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterPaymentDetails(String name, String card, String cv, String month, String year) {
        driver.findElement(nameOnCard).sendKeys(name);
        driver.findElement(cardNumber).sendKeys(card);
        driver.findElement(cvc).sendKeys(cv);
        driver.findElement(expiryMonth).sendKeys(month);
        driver.findElement(expiryYear).sendKeys(year);
    }

    public void submitPayment() {
        driver.findElement(payBtn).click();
    }

    public boolean orderSuccess() {
        return driver.findElement(successMsg).isDisplayed();
    }
}
