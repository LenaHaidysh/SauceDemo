package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver browser;
    LoginPageFluent loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @BeforeMethod
    public void setup() {
        //System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe"); не нужен так как есть генератор
        browser = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        browser.manage().window().maximize();//нужно в каждом проекте, на весь экран;
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage = new LoginPageFluent(browser);
        productsPage = new ProductsPage(browser);
        cartPage = new CartPage(browser);
        checkoutPage = new CheckoutPage(browser);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (browser != null) {
            browser.quit();
        }
    }
}
