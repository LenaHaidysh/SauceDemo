package tests;

import io.qameta.allure.Attachment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
    @Attachment(value = "screenshot", type = "image/png")
    public void checkoutWithValidData() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Backpack");
        cartPage.openCart();
        cartPage.gotoCheckout();
        checkoutPage.checkout("Lena", "Haidysh", "123");
        WebElement CheckoutOverview = browser.findElement(By.cssSelector(".subheader"));
        String actualResult = CheckoutOverview.getText();
        assertEquals(actualResult, "Checkout: Overview", "Не переходит к подтверждению заказа");
    }

    @Test
    public void checkoutWithEmptyFields() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Backpack");
        cartPage.openCart();
        cartPage.gotoCheckout();
        checkoutPage.checkout("", "", "");
        String error = checkoutPage.getErrorMessage2();
        assertEquals(error, "Error: First Name is required", "неправильное сообщение об ошибке");
    }
}
