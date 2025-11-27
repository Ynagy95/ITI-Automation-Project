package proj.shopping.pages.components.loginorregister;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import proj.shopping.drivers.Driver;
import proj.shopping.pages.components.system.CartPage;
import proj.shopping.pages.components.system.NavigationBar;

public class Registerresult {
    private Driver driver;
    public Registerresult(Driver driver) {
        this.driver = driver;

    }

    private final By result = By.cssSelector("div.result");
    private final By continuebutton = By.cssSelector("input.button-1.register-continue-button[type=\"button\"]");



    @Step("Get Registration Result Text")
    public Registerresult verifywelcometext(){
        driver.hardAssert().iselementvisible(result);
        return this;
    }

    @Step("click on Continue Button")
    public NavigationBar clickoncontinuebutton(){

        driver.element().click(continuebutton);
        return new NavigationBar(driver);
    }

    @Step("click on Continue Button")
    public CartPage clickoncontinuebutton2(){

        driver.element().click(continuebutton);
        return new CartPage(driver);
    }



}
