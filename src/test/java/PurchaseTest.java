import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class PurchaseTest {

    @Test (enabled = false)
    public void userShouldBeAddToCart() {
        String productName = "Sauce Labs Bolt T-Shirt";
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("https://www.saucedemo.com/inventory.html");
        WebElement addProductToCart = browser.findElement(By.xpath("//*[text()='" + productName + "']/" +
                "ancestor::*[contains(@class,'inventory_item')]//button"));
        addProductToCart.click();
        WebElement cartIcon = browser.findElement(By.className("svg-inline--fa"));
        cartIcon.click();
        WebElement productPresent = browser.findElement(By.className("inventory_item_name"));
        //assertTrue(productPresent.isDisplayed(), "Добавленного продукта нет в корзине");
        String actualResult = productPresent.getText();
        assertEquals(actualResult, "" + productName + "", "Добавленного продукта нет в корзине");
        browser.quit();
    }
}