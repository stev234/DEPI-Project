package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.SignUpPage;
import pages.SignUpFormPage;
import pages.ExistingEmailPage;
import pages.DeleteAccountPage;

public class SignUpSteps {

    SignUpPage startPage = new SignUpPage();
    SignUpFormPage formPage = new SignUpFormPage();
    ExistingEmailPage existingPage = new ExistingEmailPage();
    DeleteAccountPage deletePage = new DeleteAccountPage();

    private String generatedEmail;

    @Given("User is on the homepage")
    public void user_is_on_the_homepage() {
        startPage.openHomePage();
    }

    @When("User navigates to Signup/Login")
    public void user_navigates_to_signup_login() {
        startPage.clickSignupLogin();
    }

    @When("User enters name {string} and email {string}")
    public void user_enters_name_and_email(String name, String emailTemplate) {
        generatedEmail = startPage.enterNameAndEmail(name, emailTemplate);
    }

    @When("User fills all account information")
    public void user_fills_all_account_information() {
        formPage.fillFullForm();
    }

    @Then("Account should be created successfully")
    public void account_should_be_created_successfully() {
        Assert.assertTrue(formPage.isAccountCreated());
    }

    @Then("Signup should fail because email already exists")
    public void signup_should_fail_existing_email() {
        Assert.assertTrue(existingPage.isExistingEmailErrorShown());
    }

    @When("User submits incomplete account form")
    public void user_submits_incomplete_account_form() {
        formPage.submitIncompleteForm();
    }

    @Then("The site should show validation errors")
    public void the_site_should_show_validation_errors() {
        Assert.assertTrue(formPage.hasValidationError());
    }

    @Then("User deletes the account successfully")
    public void user_deletes_the_account_successfully() {
        deletePage.deleteAccount();
        Assert.assertTrue(deletePage.isAccountDeleted());
    }
}
