package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.NavigationPage;

public class NavigationTest extends BaseTest {

    @Test
    public void navigationTest() {
        driver.get("https://automationexercise.com/");
        NavigationPage nav = new NavigationPage(driver);

        nav.goToProducts();
        nav.goToCart();
        nav.goToLogin();
        nav.goToTestCases();
        nav.goToContactUs();
        nav.goToHome();
    }
}
