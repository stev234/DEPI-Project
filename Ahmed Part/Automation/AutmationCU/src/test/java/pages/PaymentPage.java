package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PaymentPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By cardName = By.name("name_on_card");
    private By cardNumber = By.name("card_number");
    private By cvc = By.name("cvc");
    private By month = By.name("expiry_month");
    private By year = By.name("expiry_year");
    private By payButton = By.id("submit");
    private By success = By.xpath("//*[contains(text(),'Your order has been placed') or contains(text(),'Payment success')]"); 

    public void openPage() {
        driver.get("https://automationexercise.com/checkout");
    }

    public void enterPaymentDetails(String name, String number, String cvcCode, String expMonth, String expYear) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cardName)).sendKeys(name);
        driver.findElement(cardNumber).sendKeys(number);
        driver.findElement(cvc).sendKeys(cvcCode);
        driver.findElement(month).sendKeys(expMonth);
        driver.findElement(year).sendKeys(expYear);
    }

    public void submitPayment() {
        driver.findElement(payButton).click();
    }

    public boolean validateSuccess() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(success));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
