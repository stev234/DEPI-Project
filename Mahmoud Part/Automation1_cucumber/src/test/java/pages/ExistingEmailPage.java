package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import utils.DriverFactory;

import java.time.Duration;

public class ExistingEmailPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ExistingEmailPage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public boolean isExistingEmailErrorShown() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(),'Email Address already exist')]")
            ));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
