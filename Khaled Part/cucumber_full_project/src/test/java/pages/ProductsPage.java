package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    WebDriver driver;

    By searchInput = By.id("search_product");
    By searchBtn = By.id("submit_search");

    public ProductsPage(WebDriver driver) { this.driver = driver; }

    public void search(String word) {
        driver.findElement(searchInput).sendKeys(word);
        driver.findElement(searchBtn).click();
    }

    public boolean productsVisible() {
        return driver.findElements(By.cssSelector(".productinfo")).size() > 0;
    }
}
