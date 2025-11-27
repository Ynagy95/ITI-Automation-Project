package proj.shopping.tests.userinterface;

import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import proj.shopping.drivers.Driver;
import proj.shopping.pages.components.system.NavigationBar;
import proj.shopping.pages.components.loginorregister.SignUpPage;

@Epic("Automation Project")
@Feature("UI Register Tests")
@Story("Register Tests")
@Severity(SeverityLevel.CRITICAL)
@Owner("QA Team")
public class RegisterTest extends BaseTest {




    //Tests

    @Test
    @Description("Test to verify valid register functionality")
    public void validregister(){

        new SignUpPage(driver)
                .navigate()
                .verifyregisterpage()
                .fillregistrationform(
                        testdata.getJsonData("genderMale"),
                        testdata.getJsonData("firstName"),
                        testdata.getJsonData("lastName"),
                        testdata.getJsonData("newemail"),
                        testdata.getJsonData("password"),
                        testdata.getJsonData("confirmPassword"))
                .clickonregisterbutton()
                .verifywelcometext()
                .clickoncontinuebutton()
                .verifywelcometext();

      }

    @Test
    @Description("Test to verify invalid register functionality with empty firstname")
    public void invalidregisteremptyfirstname() {

        new SignUpPage(driver)
                .navigate()
                .verifyregisterpage()
                .fillregistrationform(
                        testdata.getJsonData("genderMale"),
                        testdata.getJsonData(""),
                        testdata.getJsonData("lastName"),
                        testdata.getJsonData("newemail"),
                        testdata.getJsonData("password"),
                        testdata.getJsonData("confirmPassword"))
                .clickonregisterbuttoninvalid()
                .verifyregisterpage()
                .verifyfirstnameerror(testdata.getJsonData("firstnameerror"));
    }
    @Test
    @Description("Test to verify invalid register functionality with empty lastname")
    public void invalidregisteremptylastname() {

        new SignUpPage(driver)
                .navigate()
                .verifyregisterpage()
                .fillregistrationform(
                        testdata.getJsonData("genderMale"),
                        testdata.getJsonData("firstName"),
                        testdata.getJsonData(""),
                        testdata.getJsonData("newemail"),
                        testdata.getJsonData("password"),
                        testdata.getJsonData("confirmPassword"))
                .clickonregisterbuttoninvalid()
                .verifyregisterpage()
                .verifylastnameerror(testdata.getJsonData("secondnameerror"));
    }
    @Test
    @Description("Test to verify invalid register functionality with empty email")
    public void invalidregisteremptyemail() {

        new SignUpPage(driver)
                .navigate()
                .verifyregisterpage()
                .fillregistrationform(
                        testdata.getJsonData("genderMale"),
                        testdata.getJsonData("firstName"),
                        testdata.getJsonData("lastName"),
                        testdata.getJsonData(""),
                        testdata.getJsonData("password"),
                        testdata.getJsonData("confirmPassword"))
                .clickonregisterbuttoninvalid()
                .verifyregisterpage()
                .verifyemailerror(testdata.getJsonData("emptyemailerror"));
    }

    @Test
    @Description("Test to verify invalid register functionality with wrong email")
    public void invalidregisterwrongemail() {

        new SignUpPage(driver)
                .navigate()
                .verifyregisterpage()
                .fillregistrationform(
                        testdata.getJsonData("genderMale"),
                        testdata.getJsonData("firstName"),
                        testdata.getJsonData("lastName"),
                        testdata.getJsonData("wrongemail"),
                        testdata.getJsonData("password"),
                        testdata.getJsonData("confirmPassword"))
                .clickonregisterbuttoninvalid()
                .verifyregisterpage()
                .verifywrongemailerror(testdata.getJsonData("wrongemailerror"));
    }
    @Test
    @Description("Test to verify invalid register functionality with existing email")
    public void invalidregisterexistemail() {

        new SignUpPage(driver)
                .navigate()
                .verifyregisterpage()
                .fillregistrationform(
                        testdata.getJsonData("genderMale"),
                        testdata.getJsonData("firstName"),
                        testdata.getJsonData("lastName"),
                        testdata.getJsonData("existemail"),
                        testdata.getJsonData("password"),
                        testdata.getJsonData("confirmPassword"))
                .clickonregisterbuttoninvalid()
                .verifyregisterpage()
                .verifyexistemailerror(testdata.getJsonData("existemailerror"));
    }

    @Test
    @Description("Test to verify invalid register functionality with empty password")
    public void invalidregisteremptypassword() {

        new SignUpPage(driver)
                .navigate()
                .verifyregisterpage()
                .fillregistrationform(
                        testdata.getJsonData("genderMale"),
                        testdata.getJsonData("firstName"),
                        testdata.getJsonData("lastName"),
                        testdata.getJsonData("newemail"),
                        testdata.getJsonData(""),
                        testdata.getJsonData("confirmPassword"))
                .clickonregisterbuttoninvalid()
                .verifyregisterpage()
                .verifypassworderror(testdata.getJsonData("passworderror"));
    }

    @Test
    @Description("Test to verify invalid register functionality with empty confirm password")
    public void invalidregisteremptyconfirmpassword() {

        new SignUpPage(driver)
                .navigate()
                .verifyregisterpage()
                .fillregistrationform(
                        testdata.getJsonData("genderMale"),
                        testdata.getJsonData("firstName"),
                        testdata.getJsonData("lastName"),
                        testdata.getJsonData("newemail"),
                        testdata.getJsonData("password"),
                        testdata.getJsonData(""))
                .clickonregisterbuttoninvalid()
                .verifyregisterpage()
                .verifyconfirmpassworderror(testdata.getJsonData("passwordconfirmerror"));
    }
    @Test
    @Description("Test to verify invalid register functionality with password less than 6 characters")
    public void invalidregisterpasswordlessthan6() {

        new SignUpPage(driver)
                .navigate()
                .verifyregisterpage()
                .fillregistrationform(
                        testdata.getJsonData("genderMale"),
                        testdata.getJsonData("firstName"),
                        testdata.getJsonData("lastName"),
                        testdata.getJsonData("newemail"),
                        testdata.getJsonData("passwordlessthan6digits"),
                        testdata.getJsonData("passwordlessthan6digits"))
                .clickonregisterbuttoninvalid()
                .verifyregisterpage()
                .verifypasswordlessthan6charerror(testdata.getJsonData("passwordlessthan6charerror"));
    }

    @Test
    @Description("Test to verify invalid register functionality with password and confirm password not matched")
    public void invalidregisterpasswordnotmatched() {

        new SignUpPage(driver)
                .navigate()
                .verifyregisterpage()
                .fillregistrationform(
                        testdata.getJsonData("genderMale"),
                        testdata.getJsonData("firstName"),
                        testdata.getJsonData("lastName"),
                        testdata.getJsonData("newemail"),
                        testdata.getJsonData("password"),
                        testdata.getJsonData("notsamepassword"))
                .clickonregisterbuttoninvalid()
                .verifyregisterpage()
                .verifypasswordnotmatcherror(testdata.getJsonData("passwordnotmatcherror"));
    }

    @Test
    @Description("Test to verify invalid register functionality with confirm password and password not matched")
    public void invalidregisterpasswordnotmatched2() {

        new SignUpPage(driver)
                .navigate()
                .verifyregisterpage()
                .fillregistrationform(
                        testdata.getJsonData("genderMale"),
                        testdata.getJsonData("firstName"),
                        testdata.getJsonData("lastName"),
                        testdata.getJsonData("newemail"),
                        testdata.getJsonData("notsamepassword"),
                        testdata.getJsonData("password"))
                .clickonregisterbuttoninvalid()
                .verifyregisterpage()
                .verifypasswordnotmatcherror(testdata.getJsonData("passwordnotmatcherror"));
    }
    @Test
    @Description("Test to verify invalid register functionality with all fields empty")
    public void verifyinvalidcredentialserrors() {

        new SignUpPage(driver)
                .navigate()
                .verifyregisterpage()
                .fillregistrationform(
                        testdata.getJsonData(""),
                        testdata.getJsonData(""),
                        testdata.getJsonData(""),
                        testdata.getJsonData(""),
                        testdata.getJsonData(""),
                        testdata.getJsonData(""))
                .clickonregisterbuttoninvalid()
                .verifyregisterpage()
                .verifyInvalidCredentialsError(testdata.getJsonData("requiredFields"));
    }











    //configurations
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
