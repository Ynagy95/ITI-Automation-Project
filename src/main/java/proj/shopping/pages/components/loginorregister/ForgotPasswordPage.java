package proj.shopping.pages.components.loginorregister;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import proj.shopping.drivers.Driver;
import proj.shopping.utils.datareader.PropertyReader;

public class ForgotPasswordPage {
    private Driver driver;
    private final String pageUrl = PropertyReader.getProperty("baseUrlWeb") + "/passwordrecovery";
    public ForgotPasswordPage(Driver driver) {
        this.driver = driver;
    }

    private final By welcome = By.tagName("h1");
    private final By email = By.id("Email");
    private final By recoverbutton = By.cssSelector("input[value=\"Recover\"]");
    private final By enteremailerror = By.xpath("//*[text()=\"Enter your email\"]");
    private final By entervalidemailerror = By.xpath("//*[text()=\"Wrong email\"]");
    private final By emailfound = By.xpath("//*[normalize-space(text())=\"Email with instructions has been sent to you.\"]");
    private final By emailnotfounderror = By.xpath("//*[normalize-space(text())=\"Email not found.\"]");


    @Step("Get Password recovery Result Text")
    public ForgotPasswordPage verifywelcometext(){
        driver.softAssert().iselementvisible(welcome);
        driver.softAssert().assertpageurlsoft(pageUrl);
        driver.softAssert().assertAll();
        return this;
    }
    @Step("Enter Email")
    public ForgotPasswordPage enteremail(String mail) {
        driver.element().type(email, mail);
        return this;
    }

    @Step("click on Recover Button")
    public ForgotPasswordPage clickonrecoverbutton(){
        driver.element().click(recoverbutton);
        return this;
    }
    @Step("Email Found message is displayed")
    public ForgotPasswordPage verifyemailfound(String expectedmessage){
        String actualmessage = driver.element().getText(emailfound);
        driver.hardAssert().Equals(actualmessage, expectedmessage, "Email found message is not as expected");
        return this;

    }
    @Step("Email NotFound message is displayed")
    public ForgotPasswordPage verifyemailnotfound(String expectedmessage){
        String actualmessage = driver.element().getText(emailnotfounderror);
        driver.hardAssert().Equals(actualmessage, expectedmessage, "Email nofound message is not as expected");
        return this;

    }
    @Step("Email notvalid message is displayed")
    public ForgotPasswordPage verifyemailnotvalid(String expectedmessage){
        String actualmessage = driver.element().getText(entervalidemailerror);
        driver.hardAssert().Equals(actualmessage, expectedmessage, "invalidEmail message is not as expected");
        return this;

    }
    @Step("Email empty message is displayed")
    public ForgotPasswordPage verifyemailnotempty(String expectedmessage){
        String actualmessage = driver.element().getText(enteremailerror);
        driver.hardAssert().Equals(actualmessage, expectedmessage, "not Empty Email message is not as expected");
        return this;

    }








}
