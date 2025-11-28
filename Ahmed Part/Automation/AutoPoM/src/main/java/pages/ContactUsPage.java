package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {
    private WebDriver driver;

    private By name = By.name("name");
    private By email = By.name("email");
    private By subject = By.name("subject");
    private By message = By.id("message");
    private By uploadFile = By.name("upload_file");
    private By submitBtn = By.name("submit");
    private By successMsg = By.xpath("//div[contains(text(),'Success! Your details have been submitted successfully.')]");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillForm(String n, String e, String s, String m) {
        driver.findElement(name).sendKeys(n);
        driver.findElement(email).sendKeys(e);
        driver.findElement(subject).sendKeys(s);
        driver.findElement(message).sendKeys(m);
    }

    public void uploadFile(String path) {
        driver.findElement(uploadFile).sendKeys(path);
    }

    public void submit() {
        driver.findElement(submitBtn).click();
    }

    public boolean successMessageDisplayed() {
        return driver.findElement(successMsg).isDisplayed();
    }
}
