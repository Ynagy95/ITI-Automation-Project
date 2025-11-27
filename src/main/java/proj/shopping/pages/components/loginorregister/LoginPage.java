package proj.shopping.pages.components.loginorregister;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import proj.shopping.drivers.Driver;
import proj.shopping.pages.components.system.Footer;
import proj.shopping.pages.components.system.NavigationBar;
import proj.shopping.utils.datareader.PropertyReader;

public class LoginPage {

    private Driver driver;
    public NavigationBar navg ;
    public Footer foot;
    private final String pageUrl = PropertyReader.getProperty("baseUrlWeb") + "/login";

    public LoginPage(Driver driver) {
        this.driver = driver;
        this .navg = new NavigationBar(driver);
        this .foot = new Footer(driver);
    }

    private final By welcome = By.tagName("h1");
    private final By email = By.id("Email");
    private final By password = By.id("Password");
    private final By remembermecheckbox = By.id("RememberMe");
    private final By forgotpasswordlink = By.cssSelector("a[href=\"/passwordrecovery\"]");
    private final By loginbutton = By.cssSelector("input.button-1.login-button");
    private final By register = By.cssSelector("input[value=\"Register\"]");
    private final By invalidcredentials = By.xpath("//div[@class='validation-summary-errors'] | //div[@class='validation-summary-errors']//li");
    private final By notfoundcusterror =By.xpath("//div[@class='validation-summary-errors'] | //div[@class='validation-summary-errors']//li");
    private final By invalidemailerror = By.cssSelector("span[for=\"Email\"]");

    //actions

    @Step("Navigate to this Page")
    public LoginPage navigate(){
        driver.browser().navigateto(pageUrl);
        return this;
    }
    @Step("Get Welcome Text")
    public LoginPage verifywelcometext(){
        driver.softAssert().iselementvisible(welcome);
        driver.softAssert().assertpageurlsoft(pageUrl);
        driver.softAssert().assertAll();
        return this;

    }
    @Step("Enter Login Page")
    public LoginPage Fillloginpage(String mail,String pass, boolean rememberMe) {
        driver.element().type(email, mail);
        driver.element().type(password,pass);
        if (rememberMe) {
            driver.element().click(remembermecheckbox);
        }
        return this;
    }


    @Step("Click on Login Button")
    public LoginPage clickonloginbutton() {
        driver.element().click(loginbutton);
        return this;
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
    public LoginPage verifyloginerrortext(String expectedtext){
        String actualtext=driver.element().getText(invalidcredentials);
        driver.hardAssert().Equals(actualtext, expectedtext, "Error Text doesn't match");
        return this;


    }
    @Step("Get Not Found Customer Error Text")
    public LoginPage verifynotfoundcusterrortext(String expectedtext){
        String actualtext=driver.element().getText(notfoundcusterror);
        driver.hardAssert().Equals(actualtext, expectedtext, "Error Text doesn't match");
        return this;
    }
    @Step("Get Invalid Email Error Text")
    public LoginPage verifyinvalidemailerrortext(String expectedtext){
        String actualtext=driver.element().getText(invalidemailerror);
        driver.hardAssert().Equals(actualtext, expectedtext, "Error Text doesn't match");
        return this;
    }







}
