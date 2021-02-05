package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    public static final String ADD_TO_CART = "//*[text()='%s']/ancestor::*[contains(@class,'inventory_item')]//button";

    public ProductsPage(WebDriver browser) {
        super(browser);
    }

    public void buyProduct(String productName) {
        browser.findElement(By.xpath(String.format(ADD_TO_CART, productName))).click();
    }
}
