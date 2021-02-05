package tests;

import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    @Test
    public void productSholdBeAvailable() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.buyProduct("Sauce Labs Backpack");
        productsPage.buyProduct("Sauce Labs Bike Light");
    }
}
