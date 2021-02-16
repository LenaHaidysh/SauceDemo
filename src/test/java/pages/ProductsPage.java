package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProductsPage extends BasePage {
    public static final String ADD_TO_CART = "//*[text()='%s']/ancestor::*[contains(@class,'inventory_item')]//button";
    public static final By PRODUCT_LABEL = By.cssSelector(".product_label");

    public ProductsPage(WebDriver browser) {
        super(browser);
    }

    @Override
    public BasePage open() {
        return null;
    }

    public ProductsPage buyProduct(String productName) {
        browser.findElement(By.xpath(String.format(ADD_TO_CART, productName))).click();
        return this;
    }

    public void isPageOpened1() {
        //boolean isOpened;  false по умолчанию /745
        try {
            browser.findElement(PRODUCT_LABEL);//Nosuchelementexception
        } catch (NoSuchElementException ex) {
            Assert.fail("Страница продуктов не была загружена");
        }
    }

    public void isPageOpened2() {
        try {
            wait.until((ExpectedConditions.visibilityOfElementLocated(PRODUCT_LABEL)));
        } catch (TimeoutException ex) {
            Assert.fail("Страница продуктов не была загружена");
        }

    }
}
