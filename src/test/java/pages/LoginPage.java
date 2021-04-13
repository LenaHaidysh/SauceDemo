package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    //вставляем локаторы,элементы, с которыми будем взаимодействовать'
    public static final By LOGIN_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.cssSelector("[value=Login]");
    public static final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");


    public LoginPage(WebDriver browser) {
        super(browser);
    }

    public LoginPage open() {
        browser.get("https://www.saucedemo.com/");
        return new LoginPage(browser);
    }

    public void login(String userName, String password) {
        browser.findElement(LOGIN_INPUT).sendKeys(userName);
        browser.findElement(PASSWORD_INPUT).sendKeys(password);
        browser.findElement(LOGIN_BUTTON).click();
    }

    public String getErrorMessage() {
        return browser.findElement(ERROR_MESSAGE).getText();
    }
}
