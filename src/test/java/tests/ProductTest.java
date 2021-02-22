package tests;

import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test (retryAnalyzer = Retry.class) //чтобы запустить несколько раз тест, если тест падает
    public void productSholdBeAvailable3() {
        loginPage
                .open()
                .login("standard_user", "secret_sauce")
                .buyProduct("Sauce Labs Backpack")
                .buyProduct("Sauce Labs Bike Light");

    }

    @Test
    public void productSholdBeAvailable() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Backpack");
        productsPage.buyProduct("Sauce Labs Bike Light");
    }

    @Test
    public void productSholdBeAvailable2() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Backpack");
        productsPage.buyProduct("Sauce Labs Bike Light");
    }
}
