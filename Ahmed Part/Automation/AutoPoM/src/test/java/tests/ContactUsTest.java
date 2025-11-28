package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.NavigationPage;

public class ContactUsTest extends BaseTest {

    @Test
    public void contactUsTest() {
        driver.get("https://automationexercise.com/");
        NavigationPage nav = new NavigationPage(driver);
        nav.goToContactUs();

        ContactUsPage contact = new ContactUsPage(driver);

        contact.fillForm("Ahmed", "ahmed@test.com", "Test Subject", "This is a test message.");
        contact.uploadFile("C:\\temp\\test.txt");
        contact.submit();

        Assert.assertTrue(contact.successMessageDisplayed());
    }
}
