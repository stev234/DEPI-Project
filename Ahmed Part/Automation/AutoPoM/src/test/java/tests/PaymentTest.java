package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PaymentPage;

public class PaymentTest extends BaseTest {

    @Test
    public void paymentTest() {
        driver.get("https://automationexercise.com/payment");

        PaymentPage pay = new PaymentPage(driver);
        pay.enterPaymentDetails("Ahmed Iraqi", "4242424242424242", "123", "12", "2026");
        pay.submitPayment();

        Assert.assertTrue(pay.orderSuccess());
    }
}
