import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class LoginTest {

    @Test (enabled = false)
    public void userShouldBeLoginByValidData() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();//нужно в каждом проекте, на весь экран;
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("https://www.saucedemo.com/");
        WebElement loginField = browser.findElement(By.id("user-name"));
        WebElement passwordField = browser.findElement(By.id("password"));
        loginField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        WebElement loginButton = browser.findElement(By.cssSelector("[value=LOGIN]"));
        loginButton.click();
        WebElement productsPresent = browser.findElement(By.className("product_label"));
        //assertTrue(productsPresent.isDisplayed(),"Списка продуктов нет на странице, логин прошел неуспешно");
        String actualResult = productsPresent.getText();
        assertEquals(actualResult, "Products", "Списка продуктов нет на странице, логин прошел неуспешно");
        browser.quit();
    }
}