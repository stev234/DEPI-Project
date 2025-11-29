package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class BrandTest extends BaseTest {

    @Test
    public void testClickBrand() throws InterruptedException {

        // Scroll to brand section (Optional but safer)
        Thread.sleep(1500);
        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("window.scrollBy(0, 600)");

        // Click the 3rd brand in the list — EXACT XPath you gave
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("/html/body/section[2]/div/div/div[1]/div/div[3]/div/ul/li[3]/a")
        )).click();

        Thread.sleep(1500);

        // Verify brand products page loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(),'Brand')]")
        ));

        System.out.println("✔ Brand test completed successfully!");
    }
}
