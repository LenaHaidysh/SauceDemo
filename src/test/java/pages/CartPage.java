package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CartPage extends BasePage {

    public static final String PRODUCT_DETAILS = "//*[text()='%s']";
    public static final By REMOVE_BUTTON = By.className("cart_button");
    public static final By CHECKOUT_BUTTON = By.cssSelector(".checkout_button");
    public static final By CART_HEADER = By.cssSelector(".subheader");


    public CartPage(WebDriver browser) {
        super(browser);
    }

    public void openCart() {
        browser.get("https://www.saucedemo.com/cart.html");
    }

    public void seeProductDetails(String productNameInCart) {
        browser.findElement(By.xpath(String.format(PRODUCT_DETAILS, productNameInCart))).click();
    }

    public void removeFromCart() {
        browser.findElement(REMOVE_BUTTON).click();
    }

    public void gotoCheckout() {
        browser.findElement(CHECKOUT_BUTTON).click();
    }

    public void isPageOpened3() {
        try {
            wait.until((ExpectedConditions.visibilityOfElementLocated(CART_HEADER)));
        } catch (TimeoutException ex) {
            Assert.fail("Страница с корзиной не была загружена");
        }
    }
}
