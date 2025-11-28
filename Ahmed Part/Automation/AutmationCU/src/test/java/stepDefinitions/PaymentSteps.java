package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import pages.PaymentPage;
import utils.DriverFactory;

public class PaymentSteps {

    WebDriver driver = DriverFactory.getDriver();
    PaymentPage paymentPage = new PaymentPage(driver);

    @Given("I open the payment page")
    public void openPaymentPage() {
        paymentPage.openPage();
    }

    @When("I enter valid payment details")
    public void enterPaymentData() {
        paymentPage.enterPaymentDetails("Ahmed Test", "4242424242424242", "123", "12", "2030");
    }

    @When("I submit the payment")
    public void submitPayment() {
        paymentPage.submitPayment();
    }

    @Then("the order should be placed successfully")
    public void checkOrder() {
        Assert.assertTrue(paymentPage.validateSuccess(), "Payment/order success was not confirmed");
    }
}
