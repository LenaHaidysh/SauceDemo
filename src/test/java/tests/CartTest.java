package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    public void checkProductDetails() {

        loginPage.open();
        loginPage.login(System.getProperty("user", ""), "secret_sauce"); //вычитываем
        // из командной строки имя юзера
        productsPage.buyProduct("Sauce Labs Backpack");
        cartPage.openCart();
        cartPage.seeProductDetails("Sauce Labs Backpack");
        WebElement productNameDetails = browser.findElement(By.className("inventory_details_name"));
        String actualResult = productNameDetails.getText();
        assertEquals(actualResult, "Sauce Labs Backpack", "Невозможно просмотреть детальное описание товара");
    }

    @Test
    public void removeOneProductFromCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Backpack");
        cartPage.openCart();
        cartPage.isPageOpened3();
        cartPage.removeFromCart();
        int a = browser.findElements(By.className("removed_cart_item")).size();
        assertEquals(a, 1, "Добавленный товар не удален из корзины");
    }

    @Test
    public void goToCheckoutOneProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Backpack");
        cartPage.openCart();
        cartPage.gotoCheckout();
        checkoutPage.isPageOpened4();
        WebElement CheckoutInformation = browser.findElement(By.className("subheader"));
        String actualResult = CheckoutInformation.getText();
        assertEquals(actualResult, "Checkout: Your Information", "Невозможно перейти к чекауту");
    }

}
