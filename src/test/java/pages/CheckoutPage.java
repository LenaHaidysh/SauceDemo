package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    public static final By FIRST_NAME_INPUT = By.id("first-name");
    public static final By LAST_NAME_INPUT = By.id("last-name");
    public static final By ZIP_INPUT = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.cssSelector("[value=CONTINUE]");
    public static final By ERROR_MESSAGE2 = By.cssSelector("[data-test=error]");


    public CheckoutPage(WebDriver browser) {
        super(browser);
    }

    public void checkout(String firstName, String lastName, String zipCode) {
        browser.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        browser.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        browser.findElement(ZIP_INPUT).sendKeys(zipCode);
        browser.findElement(CONTINUE_BUTTON).click();
    }

    public String getErrorMessage2() {
        return browser.findElement(ERROR_MESSAGE2).getText();
    }


}
