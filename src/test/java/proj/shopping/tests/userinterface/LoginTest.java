package proj.shopping.tests.userinterface;

import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import proj.shopping.drivers.Driver;
import proj.shopping.pages.components.loginorregister.LoginPage;
import proj.shopping.pages.components.system.NavigationBar;

@Epic("Automation Project")
@Feature("UI Login Tests")
@Story("Login Tests")
@Severity(SeverityLevel.CRITICAL)
@Owner("QA Team")
public class LoginTest extends BaseTest {




    @Test
    @Description("Test to verify valid login functionality")
    public void validlogin(){

        new LoginPage(driver)
                .navigate()
                .verifywelcometext()
                .Fillloginpage(
                        testdata.getJsonData("loginemail"),
                        testdata.getJsonData("loginpassword"),
                        true)
                .clickonloginbutton()
                .navg
                .verifywelcometext();



    }
    @Test
    @Description("Test to verify invalid login functionality")
    public void invalidlogin(){

        new LoginPage(driver)
                .navigate()
                .verifywelcometext()
                .Fillloginpage(
                        testdata.getJsonData("logininvalidemail"),
                        testdata.getJsonData("loginpassword"),
                        false)
                .clickonloginbutton()
                .verifywelcometext()
                .verifyinvalidemailerrortext(testdata.getJsonData("loginwrongemailerror"));

    }
    @Test
    @Description("Test to verify login functionality with no credentials")
    public void nocustomercredentialslogin(){

        new LoginPage(driver)
                .navigate()
                .verifywelcometext()
                .Fillloginpage(
                        testdata.getJsonData(""),
                        testdata.getJsonData(""),
                        false)
                .clickonloginbutton()
                .verifywelcometext()
                .verifynotfoundcusterrortext(testdata.getJsonData("loginnotfoundcustomererror"));

    }
    @Test
    @Description("Test to verify login functionality with no password")
    public void notcompletecustomerloginnopass(){

        new LoginPage(driver)
                .navigate()
                .verifywelcometext()
                .Fillloginpage(
                        testdata.getJsonData("loginwrongemail"),
                        testdata.getJsonData(""),
                        false)
                .clickonloginbutton()
                .verifywelcometext()
                .verifynotfoundcusterrortext(testdata.getJsonData("loginnotfoundcustomererror"));

    }
    @Test
    @Description("Test to verify login functionality with not found customer")
    public void notfoundcustomerlogin(){

        new LoginPage(driver)
                .navigate()
                .verifywelcometext()
                .Fillloginpage(
                        testdata.getJsonData("loginwrongemail"),
                        testdata.getJsonData("loginpassword"),
                        false)
                .clickonloginbutton()
                .verifywelcometext()
                .verifynotfoundcusterrortext(testdata.getJsonData("loginnotfoundcustomererror"));

    }
    @Test
    @Description("Test to verify login functionality with no email")
    public void notcompletecustomerloginnoemail(){

        new LoginPage(driver)
                .navigate()
                .verifywelcometext()
                .Fillloginpage(
                        testdata.getJsonData(""),
                        testdata.getJsonData("loginpassword"),
                        false)
                .clickonloginbutton()
                .verifywelcometext()
                .verifynotfoundcusterrortext(testdata.getJsonData("loginnotfoundcustomererror"));

    }

    @Test
    @Description("Test to verify login functionality with invalid password")
    public void invalidcredentialslogin(){

        new LoginPage(driver)
                .navigate()
                .verifywelcometext()
                .Fillloginpage(
                        testdata.getJsonData("loginemail"),
                        testdata.getJsonData("logininvalidpassword"),
                        false)
                .clickonloginbutton()
                .verifywelcometext()
                .verifyloginerrortext(testdata.getJsonData("logininvalidcredentialserror"));

    }
    @Test
    @Description("Test to verify login functionality with empty password")
    public void invalidcredentialsloginemptypass(){

        new LoginPage(driver)
                .navigate()
                .verifywelcometext()
                .Fillloginpage(
                        testdata.getJsonData("loginemail"),
                        testdata.getJsonData(""),
                        false)
                .clickonloginbutton()
                .verifywelcometext()
                .verifyloginerrortext(testdata.getJsonData("logininvalidcredentialserror"));

    }

    @Test
    @Description("Test to verify register button functionality from login page")
    public void clickregisterbutton(){

        new LoginPage(driver)
                .navigate()
                .verifywelcometext()
                .clickonregisterbutton()
                .verifyregisterpage();
        new UserFlows(driver, testdata).validregister();
    }

    @Test
    @Description("Test to verify forgot password functionality with valid email")
    public void clickonforgotpasswordwithvalidemail(){

        new NavigationBar(driver)
                .clickonloginbutton()
                .verifywelcometext()
                .clickonforgotpasswordlink()
                .verifywelcometext()
                .enteremail(testdata.getJsonData("loginemail"))
                .clickonrecoverbutton()
                .verifyemailfound(testdata.getJsonData("loginrecoveremailvalid"));

    }
    @Test
    @Description("Test to verify forgot password functionality with invalid email")
    public void clickonforgotpasswordwithnotfoundvalidemail(){

        new NavigationBar(driver)
                .clickonloginbutton()
                .verifywelcometext()
                .clickonforgotpasswordlink()
                .verifywelcometext()
                .enteremail(testdata.getJsonData("loginwrongemail"))
                .clickonrecoverbutton()
                .verifyemailnotfound(testdata.getJsonData("loginrecoveremailinvalid"));

    }
    @Test
    @Description("Test to verify forgot password functionality with no email")
    public void clickonforgotpasswordwithnoemail(){

        new NavigationBar(driver)
                .clickonloginbutton()
                .verifywelcometext()
                .clickonforgotpasswordlink()
                .verifywelcometext()
                .enteremail(testdata.getJsonData(""))
                .clickonrecoverbutton()
                .verifyemailnotempty(testdata.getJsonData("loginnoemailerror"));

    }
    @Test
    @Description("Test to verify forgot password functionality with wrong email format")
    public void clickonforgotpasswordwithwrongemailformat(){

        new NavigationBar(driver)
                .clickonloginbutton()
                .verifywelcometext()
                .clickonforgotpasswordlink()
                .verifywelcometext()
                .enteremail(testdata.getJsonData("logininvalidemail"))
                .clickonrecoverbutton()
                .verifyemailnotvalid(testdata.getJsonData("loginwrongemailformaterror"));

    }












    @BeforeMethod
    public void setup(){
        driver = new Driver();
        new NavigationBar(driver).navigate();

    }

    @AfterMethod
    public void teardown(){
        driver.quitDriver();
    }
}
