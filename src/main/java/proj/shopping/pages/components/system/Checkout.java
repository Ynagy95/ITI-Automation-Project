package proj.shopping.pages.components.system;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import proj.shopping.drivers.Driver;
import proj.shopping.pages.components.loginorregister.ForgotPasswordPage;
import proj.shopping.pages.components.loginorregister.SignUpPage;

public class Checkout {
    private Driver driver;
    public NavigationBar navg ;


    public Checkout(Driver driver) {
        this.driver = driver;
        this .navg = new NavigationBar(driver);
    }

    private final By welcome = By.xpath("//p/strong");
    private final By email = By.id("Email");
    private final By password = By.id("Password");
    private final By remembermecheckbox = By.id("RememberMe");
    private final By forgotpasswordlink = By.cssSelector("a[href=\"/passwordrecovery\"]");
    private final By loginbutton = By.cssSelector("input.button-1.login-button");
    private final By register = By.cssSelector("input[value=\"Register\"]");
    private final By guest = By.cssSelector("input[value=\"Checkout as Guest\"]");
    private final By invalidcredentials = By.xpath("//div[@class='validation-summary-errors'] | //div[@class='validation-summary-errors']//li");
    private final By notfoundcusterror =By.xpath("//div[@class='validation-summary-errors'] | //div[@class='validation-summary-errors']//li");
    private final By invalidemailerror = By.cssSelector("span[for=\"Email\"]");

    //actions


    @Step("Get Welcome Text")
    public Checkout verifywelcometext(){
        driver.hardAssert().iselementvisible(welcome);
        return this;

    }
    @Step("Click on Guest Checkout Button")
    public Checkout1 clickonguestcheckoutbutton() {
        driver.element().click(guest);
        return new Checkout1(driver) ;
    }
    @Step("Enter Login Page")
    public Checkout Fillloginpage(String mail,String pass, boolean rememberMe) {
        driver.element().type(email, mail);
        driver.element().type(password,pass);
        if (rememberMe) {
            driver.element().click(remembermecheckbox);
        }
        return this;
    }


    @Step("Click on Login Button")
    public CartPage clickonloginbutton() {
        driver.element().click(loginbutton);
        return new CartPage(driver);
    }
    @Step("Click on Forgot Password Link")
    public ForgotPasswordPage clickonforgotpasswordlink() {
        driver.element().click(forgotpasswordlink);
        return new ForgotPasswordPage(driver);
    }
    @Step("Click on  register button")
    public SignUpPage clickonregisterbutton() {
        driver.element().click(register);
        return new SignUpPage(driver);
    }

    @Step("Get Login Error Text")
    public Checkout verifyloginerrortext(String expectedtext){
        String actualtext=driver.element().getText(invalidcredentials);
        driver.hardAssert().Equals(actualtext, expectedtext, "Error Text doesn't match");
        return this;


    }
    @Step("Get Not Found Customer Error Text")
    public Checkout verifynotfoundcusterrortext(String expectedtext){
        String actualtext=driver.element().getText(notfoundcusterror);
        driver.hardAssert().Equals(actualtext, expectedtext, "Error Text doesn't match");
        return this;
    }
    @Step("Get Invalid Email Error Text")
    public Checkout verifyinvalidemailerrortext(String expectedtext){
        String actualtext=driver.element().getText(invalidemailerror);
        driver.hardAssert().Equals(actualtext, expectedtext, "Error Text doesn't match");
        return this;
    }

}
