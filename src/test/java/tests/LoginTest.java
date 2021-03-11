package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

//скриншот если упал
//связка с test case management system

public class LoginTest extends BaseTest {

    @Test(enabled = false)
    public void emptyUserName() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        String error = loginPage.getErrorMessage();
        assertEquals(error, "Epic sadface: Username is required", "неправильное сообщение об ошибке");
    }

    @DataProvider(name = "input for login")
    public Object[][] inputForLogin() {
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"}, // количество параметров любое
        };
    }

    @Test(dataProvider = "input for login") // связали с датапровайдером
    public void login(String user, String pass, String errorMessage) { // связали с переменными
        loginPage.open();
        loginPage.login(user, pass);
        String error = loginPage.getErrorMessage();
        assertEquals(error, errorMessage, "неправильное сообщение об ошибке");
    }

    //@Test(dataProvider = "input for login")
    //public void login(double number, String expectedString) { // тесту написать метод, который будет давать ему данные
    //    System.out.println(number + " " + expectedString);
    //}
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