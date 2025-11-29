package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.ContactUsPage;

public class ContactUsSteps {

    ContactUsPage contact;

    @Given("I open Contact Us page")
    public void openContactUs() {
        contact = Hooks.home.clickOnContactUS();
    }

    @When("I enter name {string}")
    public void enterName(String name) { contact.enterName(name); }

    @When("I enter email {string}")
    public void enterEmail(String email) { contact.enterEmail(email); }

    @When("I enter message {string}")
    public void enterMessage(String msg) { contact.enterMessage(msg); }

    @When("I submit the form")
    public void submitForm() { contact.submit(); }

    @Then("I should see a success message")
    public void verifyMessage() {
        Assert.assertTrue(contact.successMessageDisplayed());
    }
}
