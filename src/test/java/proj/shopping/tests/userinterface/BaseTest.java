package proj.shopping.tests.userinterface;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import proj.shopping.drivers.Driver;
import proj.shopping.drivers.WebDriverProvider;
import proj.shopping.utils.datareader.JsonReader;

public class BaseTest implements WebDriverProvider {

    protected JsonReader testdata;
     protected Driver driver;

    @BeforeClass
    public void beforeclass() {
        testdata = new JsonReader("register-data.json", "login-data.json", "products-data.json","home-data.json","cart-data.json","checkout-data.json");
    }





    @Override
    public WebDriver getWebDriver() {
        return driver.get();
    }
}
