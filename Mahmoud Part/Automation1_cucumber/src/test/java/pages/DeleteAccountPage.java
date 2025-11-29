package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import utils.DriverFactory;

import java.time.Duration;

public class DeleteAccountPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public DeleteAccountPage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private void safeClick(By by) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(by)).click();
        } catch (Exception e) {
            WebElement el = driver.findElement(by);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
        }
    }

    public void deleteAccount() {
        safeClick(By.cssSelector("a[href='/delete_account']"));
    }

    public boolean isAccountDeleted() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//b[normalize-space()='Account Deleted!']")
            ));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
