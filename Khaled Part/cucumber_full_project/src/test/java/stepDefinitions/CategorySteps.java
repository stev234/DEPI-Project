package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import org.openqa.selenium.By;

public class CategorySteps {

    @When("I click Women category")
    public void womenClick() { Hooks.home.openWomenCategory(); }

    @When("I select Tops subcategory")
    public void topsClick() { Hooks.home.clickWomenTops(); }

    @Then("I should see category products displayed")
    public void verifyCategory() {
        Assert.assertTrue(Hooks.driver.findElements(By.cssSelector(".productinfo")).size() > 0);
    }
}
