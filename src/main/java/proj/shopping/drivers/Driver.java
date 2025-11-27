package proj.shopping.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;
import proj.shopping.utils.actions.BrowserActions;
import proj.shopping.utils.actions.ElementActions;
import proj.shopping.utils.datareader.PropertyReader;
import proj.shopping.utils.logs.LogsManager;
import proj.shopping.validation.HardAssert;
import proj.shopping.validation.Softassert;

public class Driver {

    private final String browser = PropertyReader.getProperty("browserType");
    private ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public Driver() {
        BrowserType browserType = BrowserType.valueOf(browser.toUpperCase());
        LogsManager.info("Starting driver for browser: " + browserType);

        AbstractDriverFactory abstractDriverFactory = browserType.getDriverFactory();
        WebDriver driver = ThreadGuard.protect(abstractDriverFactory.startDriver());

        driverThreadLocal.set(driver);
    }

    public HardAssert hardAssert() {
        return new HardAssert(get());
    }

    public Softassert softAssert() {
        return new Softassert(get());
    }
    public ElementActions element() {
        return new ElementActions(get());
    }

    public BrowserActions browser() {
        return new BrowserActions(get());
    }


    public WebDriver get() {
        return driverThreadLocal.get();
    }

    public void quitDriver() {
        driverThreadLocal.get().quit();
    }
}
