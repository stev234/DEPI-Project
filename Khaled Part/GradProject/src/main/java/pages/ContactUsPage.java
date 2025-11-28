package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class ContactUsPage {
    WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By nameBox = By.name("name");
    private By emailBox = By.name("email");
    private By subjectBox = By.name("subject");
    private By messageBox = By.name("message");
    private By submitBtn = By.name("submit");
    private By successMessage = By.xpath("//div[@class='status alert alert-success']");
    private By homeButton = By.xpath("//i[@class='fa fa-angle-double-left']");
    private By feedBackLink = By.linkText("feedback@automationexercise.com");

    //Actions
    public void enterName(String name){
        driver.findElement(nameBox).sendKeys(name);
    }
    public void enterEmail(String email) {
        driver.findElement(emailBox).sendKeys(email);
    }
    public void enterSubject (String subject) {
        driver.findElement(subjectBox).sendKeys(subject);
    }
    public void enterMessage (String msg) {
        driver.findElement(messageBox).sendKeys(msg);
    }
    public void clickOnSubmitButton (){
        driver.findElement(submitBtn).click();
    }
    public void acceptAllert(){
        driver.switchTo().alert().accept();
    }
    public void dismissAllert(){
        driver.switchTo().alert().dismiss();
    }
    public void clickOnFeedBack(){ driver.findElement(feedBackLink).click(); }
    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
    public void clickOnHomeButton() {
        driver.findElement(homeButton).click();
    }

}
