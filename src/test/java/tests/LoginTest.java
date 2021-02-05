package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void emptyUserName() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        String error = loginPage.getErrorMessage();
        assertEquals(error, "Epic sadface: Username is required", "неправильное сообщение об ошибке");
    }
}

//By.xpath("//*[contains(text(),'text')]");
//By.xpath("//*[text()='Sauce Labs Onesie']"); - ищем любой тег,где есть текст. надо
//быть уверенным, что текст уникален
//By.xpath("//tag[contains(text(),'text')]");
//
////*[text()='Sauce Labs Onesie']/../../..//button - найдем кнопку возле конкретного товара, от текста поднимаеися до общего
//div class=inventory_item
//locator = String.format

////*[text()='Sauce Labs Onesie']/ancestor::div[@class='inventory_item']//button - ищем всех предков, содержащих текст
////*[text()='Sauce Labs Onesie']/ancestor::div[contains(@class='inventory_item')]//button