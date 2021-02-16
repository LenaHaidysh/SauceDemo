package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

    public abstract class BasePage {
    WebDriver browser;
    WebDriverWait wait;

    public BasePage(WebDriver browser) {
        this.browser = browser;
        wait = new WebDriverWait(browser, 10);
    }

    public abstract BasePage open(); //может открыть любой из классов наследников
}
