package proj.shopping.pages.components.system;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import proj.shopping.drivers.Driver;
import proj.shopping.utils.logs.LogsManager;

public class Address {

    private Driver driver;



    public Address(Driver driver) {
        this.driver = driver;

    }

    private final By button = By.cssSelector("input[value='Add new']");
    private final By delete = By.cssSelector("input[value='Delete']");
    private final By edit = By.cssSelector("input[value='Edit']");
    private final By save = By.cssSelector("input[value='Save']");
    private final By errors = By.cssSelector("span.field-validation-error");
    private By countrystate(String id) {
        return By.id(id);

    }
    private By inputfields(String id) {
        return By.id(id);

    }
    @Step("Fill Address Form")
    public Address filladdressform(
            String id_fname, String fname,
            String id_lname, String lname,
            String id_email, String email,
            String id_company, String company,
            String id, String countryname,
            String id2, String stateName,
            String id_city, String city,
            String id_address1, String address1,
            String id_address2, String address2,
            String id_zipcode, String zipcode,
            String id_phoneNumber, String phoneNumber,
            String id_faxNumber, String faxNumber) {

        driver.element().type(inputfields(id_fname), fname);
        driver.element().type(inputfields(id_lname), lname);
        driver.element().type(inputfields(id_email), email);
        driver.element().type(inputfields(id_company), company);
        driver.element().selectfromdropdown(countrystate(id), countryname);
        driver.element().selectfromdropdown(countrystate(id2), stateName);
        driver.element().type(inputfields(id_city), city);
        driver.element().type(inputfields(id_address1), address1);
        driver.element().type(inputfields(id_address2), address2);
        driver.element().type(inputfields(id_zipcode), zipcode);
        driver.element().type(inputfields(id_phoneNumber), phoneNumber);
        driver.element().type(inputfields(id_faxNumber), faxNumber);

        return this;
    }
    @Step("click button")
    public Address clickonbutton(){
        driver.element().click(button);
        return this;
    }
    @Step("click button")
    public Address clickonbutton2(){
        driver.element().click(save);
        return this;
    }
    @Step("click delete button")
    public Address clickondeletebutton(){
        driver.element().click(delete);
        return this;
    }
    @Step("click edit button")
    public Address clickoneditbutton(){
        driver.element().click(edit);
        return this;
    }
    @Step("Verify Invalid Credentials Error Messages for address")
    public Address verifyInvalidCredentialsErrorforaddress(String expectedErrors) {
        String actualErrors = String.join(", ", driver.element().getTexts(errors));

        LogsManager.info("Actual Errors: " + actualErrors);
        LogsManager.info("Expected Errors: " + expectedErrors);

        driver.hardAssert().Equals(actualErrors, expectedErrors, "Invalid credentials error messages do not match expected results.");
        return this;
    }
}
