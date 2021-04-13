package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPageFluent;
import pages.ProductsPage;

import java.util.concurrent.TimeUnit;


@Listeners(TestListener.class) //будет слушать все тесты

public class BaseTest {
    WebDriver browser;
    LoginPageFluent loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    //public String user; 7/48 2303
    //public String pass; 7/48 2303
    //user = System.getenv().getOrDefault("user", PropertyReader.getProperty("user"));//вычитывание из файла PropertyReader
    //user=System.getenv
    //Faker faker = new Faker();
    //String username = faker.name().lastName();

    @BeforeMethod
    public void setup(ITestContext context) { //itestresult был в скобках
        //System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe"); не нужен так как есть генератор
        browser = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        //if(System.getProperty("browser").equals("firefox")) {
        //    browser = new FirefoxDriver();
        //} else {
        //    browser = new ChromeDriver();
        // }
        browser.manage().window().maximize();//нужно в каждом проекте, на весь экран;
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        context.setAttribute("driver", browser);
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
