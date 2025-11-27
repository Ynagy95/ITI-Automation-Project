package proj.shopping.pages.components.loginorregister;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import proj.shopping.drivers.Driver;
import proj.shopping.utils.datareader.PropertyReader;
import proj.shopping.utils.logs.LogsManager;

public class SignUpPage {
    private Driver driver;
    private final String pageUrl = PropertyReader.getProperty("baseUrlWeb") + "/register";

    public SignUpPage(Driver driver) {
        this.driver = driver;
    }


    private final By genderMale = By.id("gender-male");
    private final By genderFemale = By.id("gender-female");
    private final By firstName = By.id("FirstName");
    private final By lastName = By.id("LastName");
    private final By email = By.id("Email");
    private final By password = By.id("Password");
    private final By confirmPassword = By.id("ConfirmPassword");
    private final By registerButton = By.id("register-button");
    private final By registerword = By.xpath("//*[text()='Your Personal Details']");
    private final By firstnameerror = By.cssSelector("span[for=\"FirstName\"]");
    private final By lastnameerror = By.cssSelector("span[for=\"LastName\"]");
    private final By emailerror = By.xpath("//*[text()=\"Email is required.\"]");
    private final By passworderror = By.cssSelector("span.field-validation-error");
    private final By confirmpassworderror = By.xpath("//*[text()=\"Password is required.\"]");
    private final By wrongemailerror = By.xpath("//*[text()=\"Wrong email\"]");
    private final By existemailerror = By.xpath("//*[text()=\"The specified email already exists\"]");
    private final By passwordlessthan6charerror = By.xpath("//*[text()=\"The password should have at least 6 characters.\"]");
    private final By passwordnotmatcherror = By.xpath("//*[text()=\"The password and confirmation password do not match.\"]");
    private final By validationMessages = By.cssSelector("span.field-validation-error");



    //actions

    @Step("Navigate to this Page")
    public SignUpPage navigate(){

        driver.browser().navigateto(pageUrl);
        return this;

    }
    @Step("Fill Registration Form")
    public SignUpPage fillregistrationform(String gender, String fname, String lname, String mail, String pass, String confirmpass) {
        if (gender == null || gender.isBlank()) {
            return this;
        }
        if (gender.equalsIgnoreCase("male")) {
            driver.element().click(genderMale);
        } else if (gender.equalsIgnoreCase("female")) {
            driver.element().click(genderFemale);
        }
        driver.element().type(firstName, fname);
        driver.element().type(lastName, lname);
        driver.element().type(email, mail);
        driver.element().type(password, pass);
        driver.element().type(confirmPassword, confirmpass);
        return this;
    }



    @Step("Click on Register Button")
    public Registerresult clickonregisterbutton() {
        driver.element().click(registerButton);
        return new Registerresult(driver);
    }
    @Step("Click on Register Button")
    public SignUpPage clickonregisterbuttoninvalid() {
        driver.element().click(registerButton);
        return this;
    }



    //validations
    @Step("Verify Register Page")
    public SignUpPage verifyregisterpage() {
        driver.softAssert().iselementvisible(registerword);
        driver.softAssert().assertpageurlsoft(pageUrl);
        driver.softAssert().assertAll();

        return this;
    }
    @Step("Verify First Name Error Message")
    public SignUpPage verifyfirstnameerror(String expectedfirstnameerror) {
        String actualfirstnameerror = driver.element().getText(firstnameerror);
        driver.hardAssert().Equals(actualfirstnameerror, expectedfirstnameerror, "First name error message does not match");
        return this;
    }
    @Step("Verify Last Name Error Message")
    public SignUpPage verifylastnameerror(String expectedlastnameerror) {
        String actuallastnameerror = driver.element().getText(lastnameerror);
        driver.hardAssert().Equals(actuallastnameerror, expectedlastnameerror, "Last name error message does not match");
        return this;
    }
    @Step("Verify Email Error Message")
    public SignUpPage verifyemailerror(String expectedemailerror) {
        String actualemailerror = driver.element().getText(emailerror);
        driver.hardAssert().Equals(actualemailerror, expectedemailerror, "Email error message does not match");
        return this;
    }
    @Step("Verify Wrong Email Error Message")
    public SignUpPage verifywrongemailerror(String expectedwrongemailerror) {
        String actualwrongemailerror = driver.element().getText(wrongemailerror);
        driver.hardAssert().Equals(actualwrongemailerror, expectedwrongemailerror, "Wrong email error message does not match");
        return this;
    }
    @Step("Verify Exist Email Error Message")
    public SignUpPage verifyexistemailerror(String expectedexistemailerror) {
        String actualexistemailerror = driver.element().getText(existemailerror);
        driver.hardAssert().Equals(actualexistemailerror, expectedexistemailerror, "Exist email error message does not match");
        return this;
    }
    @Step("Verify Password Error Message")
    public SignUpPage verifypassworderror(String expectedpassworderror) {
        String actualpassworderror = String.join(", ", driver.element().getTexts(validationMessages));
        driver.hardAssert().Equals(actualpassworderror, expectedpassworderror, "Password error message does not match");
        return this;
    }
    @Step("Verify Password Less Than 6 Characters Error Message")
    public SignUpPage verifypasswordlessthan6charerror(String expectedpasswordlessthan6charerror) {
        String actualpasswordlessthan6charerror = driver.element().getText(passwordlessthan6charerror);
        driver.hardAssert().Equals(actualpasswordlessthan6charerror, expectedpasswordlessthan6charerror, "Password less than 6 characters error message does not match");
        return this;
    }
    @Step("Verify Confirm Password Error Message")
    public SignUpPage verifyconfirmpassworderror(String expectedconfirmpassworderror) {
        String actualconfirmpassworderror = driver.element().getText(confirmpassworderror);
        driver.hardAssert().Equals(actualconfirmpassworderror, expectedconfirmpassworderror, "Confirm password error message does not match");
        return this;
    }
    @Step("Verify Password Not Match Error Message")
    public SignUpPage verifypasswordnotmatcherror(String expectedpasswordnotmatcherror) {
        String actualpasswordnotmatcherror = driver.element().getText(passwordnotmatcherror);
        driver.hardAssert().Equals(actualpasswordnotmatcherror, expectedpasswordnotmatcherror, "Password not match error message does not match");
        return this;
    }
    @Step("Verify Invalid Credentials Error Messages")
    public void verifyInvalidCredentialsError(String expectedErrors) {
        String actualErrors = String.join(", ", driver.element().getTexts(validationMessages));

        LogsManager.info("Actual Errors: " + actualErrors);
        LogsManager.info("Expected Errors: " + expectedErrors);

        driver.hardAssert().Equals(actualErrors, expectedErrors, "Invalid credentials error messages do not match expected results.");
    }




}
