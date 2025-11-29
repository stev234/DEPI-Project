package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.ProductsPage;

public class SearchProductSteps {

    ProductsPage productPage;

    @Given("I am on Products page")
    public void openProducts() {
        Hooks.home.openProducts();
        productPage = new ProductsPage(Hooks.driver);
    }

    @When("I search for {string}")
    public void search(String word) { productPage.search(word); }

    @Then("Products list should be displayed")
    public void verifyList() {
        Assert.assertTrue(productPage.productsVisible());
    }
}
