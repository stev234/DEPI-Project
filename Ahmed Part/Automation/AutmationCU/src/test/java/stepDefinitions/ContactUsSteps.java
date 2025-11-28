package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import pages.ContactUsPage;
import utils.DriverFactory;

public class ContactUsSteps {

    WebDriver driver = DriverFactory.getDriver();
    ContactUsPage contactPage = new ContactUsPage(driver);

    @Given("I go to Contact Us page")
    public void goToContactPage() {
        contactPage.openContactPage();
    }

    @When("I fill the contact form with valid data")
    public void fillForm() {
        contactPage.fillForm("Ahmed", "test@test.com", "Subject", "Message from automated test");
    }

    @When("I upload a file")
    public void uploadFile() {
        // Update this path if you want to use a different local file
        contactPage.uploadFile(System.getProperty("user.home") + "/Desktop/test.png");
    }

    @When("I submit the contact form")
    public void submitForm() {
        contactPage.submitForm();
    }

    @Then("the success message should appear")
    public void verifySuccess() {
        Assert.assertTrue(contactPage.checkSuccessMessage(), "Success message was not displayed");
    }
}
