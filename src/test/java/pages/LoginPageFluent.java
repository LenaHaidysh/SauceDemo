package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageFluent extends BasePage {
    //вставляем локаторы,элементы, с которыми будем взаимодействовать'
    public static final By LOGIN_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.cssSelector("[value=LOGIN]");
    public static final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");


    public LoginPageFluent(WebDriver browser) {
        super(browser);
    }

    public LoginPageFluent open() {
        browser.get("https://www.saucedemo.com/");
        return this; //возвращает элемент этого же класса
    }

    public ProductsPage login(String userName, String password) {
        browser.findElement(LOGIN_INPUT).sendKeys(userName);
        browser.findElement(PASSWORD_INPUT).sendKeys(password);
        browser.findElement(LOGIN_BUTTON).click();
        return new ProductsPage(browser); //можно удалить инициализацию страницы из базы
    }

    public String getErrorMessage() {
        return browser.findElement(ERROR_MESSAGE).getText();
    }
}
