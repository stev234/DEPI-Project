package ContactUs;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import baseTests.baseTests;


public class ContactUs extends baseTests {

    ContactUsPage contactUsPage;

    @Test(priority = 1)
    public void sucessfulCase() throws InterruptedException {
        contactUsPage = homePage.clickOnContactUS();
        contactUsPage.enterName("Khaled");
        contactUsPage.enterEmail("khaled@123");
        contactUsPage.enterSubject("Please Help me");
        contactUsPage.enterMessage("I cannot find adidd t shirt");
        contactUsPage.clickOnSubmitButton();
        Thread.sleep(2000);
        contactUsPage.acceptAllert();

        Thread.sleep(2000);
        String successMsg = contactUsPage.getSuccessMessage();
        Assert.assertEquals(successMsg, "Success! Your details have been submitted successfully.");
        Thread.sleep(2000);
        contactUsPage.clickOnHomeButton();
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void submitFormWithoutEmailShowsError_attributeCheck() throws InterruptedException {

        contactUsPage = homePage.clickOnContactUS();
        contactUsPage.enterName("Khaled");
        contactUsPage.enterSubject("Please Help me");
        contactUsPage.enterMessage("I cannot find adidd t shirt");;
        contactUsPage.clickOnSubmitButton();

        boolean isRequired = driver.findElement(By.name("email")).getAttribute("required") != null;

        Assert.assertTrue(isRequired, "Email field is NOT required!");
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void feedBackNotWork() throws InterruptedException {

        contactUsPage = homePage.clickOnContactUS();;
        contactUsPage.clickOnFeedBack();
        System.out.println("Clicked on feedback Is Done!!");
    }
}