package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.NavigationPage;
import utils.DriverFactory;

public class NavigationSteps {

    WebDriver driver = DriverFactory.getDriver();
    NavigationPage navPage = new NavigationPage(driver);

    @Given("I open the website")
    public void openWebsite() {
        driver.get("https://automationexercise.com/");
    }

    @When("I navigate to Products page")
    public void goProducts() {
        navPage.goToProducts();
    }

    @When("I navigate to Cart page")
    public void goCart() {
        navPage.goToCart();
    }

    @When("I navigate to Login page")
    public void goLogin() {
        navPage.goToLogin();
    }

    @When("I navigate to Contact Us page")
    public void goContactUs() {
        navPage.goToContactUs();
    }

    @Then("I navigate back to Home page")
    public void goHome() {
        navPage.goHome();
    }
}
