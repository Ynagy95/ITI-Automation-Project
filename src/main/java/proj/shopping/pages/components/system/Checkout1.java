package proj.shopping.pages.components.system;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import proj.shopping.drivers.Driver;
import proj.shopping.utils.logs.LogsManager;

public class Checkout1 {
    private Driver driver;
    public NavigationBar navg ;


    public Checkout1(Driver driver) {
        this.driver = driver;
        this .navg = new NavigationBar(driver);
    }
//locators
    private final By errors = By.cssSelector("span.field-validation-error");
    private final By confirm = By.cssSelector("input[value='Confirm']");
    private final By continuee = By.cssSelector("input[value='Continue']");
    private final By continuee2 = By.xpath("//div[@id='shipping-buttons-container']//input[@class='button-1 new-address-next-step-button' and @value='Continue']");
    private final By continuee3 = By.xpath("//div[@id='shipping-method-buttons-container']//input[@class='button-1 shipping-method-next-step-button' and @value='Continue']");
    private final By continuee4 = By.xpath("//div[@id='payment-method-buttons-container']//input[@class='button-1 payment-method-next-step-button' and @value='Continue']");
    private final By continuee5 = By.xpath("//div[@id='payment-info-buttons-container']//input[@class='button-1 payment-info-next-step-button' and @value='Continue']");
    private final By welcome = By.tagName("h1");
    private final By ExpireMonth = By.id("ExpireMonth");
    private final By ExpireYear = By.id("ExpireYear");
    private final By creditcard = By.id("CreditCardType");
    private final By billingaddress = By.id("billing-address-select");
    private final By ponumber = By.id("PurchaseOrderNumber");
    private final By back = By.xpath("(//a[text()=\"Back\"])[4]");
    private final By instore = By.id("PickUpInStore");
    private final By creditcarderrors = By.cssSelector("div.validation-summary-errors");
    private final By verifytext = By.className("title");
    private final By orderdetails = By.xpath("//a[text()='Click here for order details.']");
    private final By verifyconfirmorder = By.cssSelector("ul.billing-info");
    private final By newshippingaddress = By.id("shipping-address-select");



    private By inputfields(String id) {
        return By.id(id);

    }
    private By countrystate(String id) {
        return By.id(id);

    }


    private By h1(String text) {
        return By.xpath("//h2[normalize-space(text())='" + text + "']");
    }

    private By Shippingmethodpayment(String value) {
        return By.xpath("//label[text()='" + value + "']");
    }
    private By verifyPaymentinformation(String value) {
        return By.xpath("//p[contains(text(),'" + value + "')]");
    }


//actions
    @Step("Click on Continue Button")
    public Checkout1 clickoncontinuebutton() {
        driver.element().click(continuee);
        return this;

    }
    @Step("Click on Continue Button 2")
    public Checkout1 clickoncontinuebutton2() {
        driver.element().click(continuee2);
        return this;
    }
    @Step("Click on Continue Button 3")
    public Checkout1 clickoncontinuebutton3() {
        driver.element().click(continuee3);
        return this;
    }
    @Step("Click on Continue Button 4")
    public Checkout1 clickoncontinuebutton4() {
        driver.element().click(continuee4);
        return this;
    }
    @Step("Click on Continue Button 5")
    public Checkout1 clickoncontinuebutton5() {
        driver.element().click(continuee5);
        return this;
    }
    @Step("Click on confirm Button")
    public Checkout1 clickonconfirmbutton() {
        driver.element().click(confirm);
        return this;

    }
    @Step("select new shipping address")
    public Checkout1 selectnewshippingaddress(String Name) {
        driver.element().selectfromdropdown(newshippingaddress, Name);
        return this;
    }
    @Step("click on order details")
    public OrderInformation clickonorderdetails() {
        driver.element().click(orderdetails);
        return new OrderInformation(driver) ;
    }
    @Step("click on h1")
    public Checkout1 clickonh1(String text) {
        driver.element().click(h1(text));
        return this;

    }

    @Step("select in store pickup")
    public Checkout1 selectinstorepickup() {
        driver.element().click(instore);
        return this;
    }
    @Step("click on back button")
    public Checkout1 clickonbackbutton() {
        driver.element().click(back);
        return this;
    }

    @Step("select differenr address")
    public Checkout1 selectdifferentaddress(String Name) {
        driver.element().selectfromdropdown(billingaddress, Name);
        return this;
    }
    @Step("Type PO Number info")
    public Checkout1 typepoinfo( String Name) {
        driver.element().type(ponumber, Name);
        return this;
    }
    @Step("Fill payment Address Form")
    public Checkout1 fillbillingpaymentform(
            String CC,
            String id_name, String name,
            String id_cardnumber, String cardnumber,
             String month,String year,
            String id_cardcode, String cardcode
        ) {


        driver.element().selectfromdropdown(creditcard ,CC);
        driver.element().type(inputfields(id_name), name);
        driver.element().type(inputfields(id_cardnumber), cardnumber);
        driver.element().selectfromdropdown(ExpireMonth ,month);
        driver.element().selectfromdropdown(ExpireYear ,year);
        driver.element().type(inputfields(id_cardcode), cardcode);


        return this;
    }
    @Step("Click on Shipping method")
    public Checkout1 clickonShippingorpaymentmethod(String value) {
        driver.element().click(Shippingmethodpayment(value));
        return this;
    }





    @Step("Fill Billing Address Form")
    public Checkout1 fillbillingaddressform(
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
    @Step("Fill Billing Address Form")
    public Checkout1 fillbillingaddressform2(

            String id_company, String company,
            String id, String countryname,
            String id2, String stateName,
            String id_city, String city,
            String id_address1, String address1,
            String id_address2, String address2,
            String id_zipcode, String zipcode,
            String id_phoneNumber, String phoneNumber,
            String id_faxNumber, String faxNumber) {


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


    @Step("Verify Welcome Text on Checkout Page")
    public Checkout1 verifywelcometext() {
        driver.hardAssert().iselementvisible(welcome);
        return this;
    }
    @Step("Verify Welcome Text on ")
    public Checkout1 verifywelcometext2() {
        driver.hardAssert().iselementvisible(verifytext);
        return this;
    }
    @Step("Verify Payment Information")
    public Checkout1 verifypaymentinformation(String expectedText) {
        String actualText = driver.element().getText(verifyPaymentinformation(expectedText));
        LogsManager.info("Actual Payment Information: " + actualText);
        LogsManager.info("Expected Payment Information: " + expectedText);
        driver.hardAssert().Equals(actualText, expectedText, "Payment information does not match expected value.");
        return this;
    }
    @Step("Verify Invalid Credentials Error Messages for Billing address")
    public Checkout1 verifyInvalidCredentialsErrorforBillingaddress(String expectedErrors) {
        String actualErrors = String.join(", ", driver.element().getTexts(errors));

        LogsManager.info("Actual Errors: " + actualErrors);
        LogsManager.info("Expected Errors: " + expectedErrors);

        driver.hardAssert().Equals(actualErrors, expectedErrors, "Invalid credentials error messages do not match expected results.");
        return this;
    }

    @Step("Verify Invalid Credentials Error Messages")
    public Checkout1 verifyInvalidCredentialsErrorpaymentmethod(String expectedErrors) {
        String actualErrors = String.join(", ", driver.element().getTexts(creditcarderrors));

        LogsManager.info("Actual Errors: " + actualErrors);
        LogsManager.info("Expected Errors: " + expectedErrors);

        driver.hardAssert().Equals(actualErrors, expectedErrors, "Invalid credentials error messages do not match expected results.");
        return this;
    }
@Step("Verify Confirm Order Details")
    public Checkout1 verifyconfirmorderdetails(String expectedText) {
    String actualErrors = String.join(", ", driver.element().getTexts(verifyconfirmorder));
        LogsManager.info("Actual Confirm Order Details: " + actualErrors);
        LogsManager.info("Expected Confirm Order Details: " + expectedText);
        driver.hardAssert().Equals(actualErrors, expectedText, "Confirm order details do not match expected value.");
        return this;
    }


}
