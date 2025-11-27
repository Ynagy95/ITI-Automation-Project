package proj.shopping.tests.userinterface;

import io.qameta.allure.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import proj.shopping.drivers.Driver;
import proj.shopping.pages.components.system.CartPage;
import proj.shopping.pages.components.system.Checkout;
import proj.shopping.pages.components.system.NavigationBar;
import proj.shopping.pages.components.system.OrderInformation;

@Epic("Automation Project")
@Feature("UI End to End Tests")
@Story("checkout Tests")
@Severity(SeverityLevel.CRITICAL)
@Owner("QA Team")
public class CheckoutTests extends BaseTest {

    @Test
    @Description("go to cart page")
    public void addtocart(){
        new UserFlows(driver, testdata).selectfromapparel();
        new CartPage(driver)
                .verifywelcometext()
                .verifyproductpriceandnameqtytotal(testdata.getJsonData("apparel2.name"),
                        testdata.getJsonData("apparel2.price"),
                        testdata.getJsonData("apparel2.quantity"),
                        testdata.getJsonData("apparel2.total"))
                .clickonedit(testdata.getJsonData("apparel2.name"))
                .clickonshoescolor(testdata.getJsonData("shoesColor.no2"))
                .clickonaddtocartbutton(testdata.getJsonData("apparel2.name"))
                .closemessage();
        new NavigationBar(driver).clickoncartbutton()
                .verifyproductsizeandcolor(testdata.getJsonData("apparel2.name"),
                        testdata.getJsonData("sizeColor"))
                .typepostalcode(testdata.getJsonData("cartinputfields.no3"),
                        testdata.getJsonData("textdata.no3"))
                .selectcountry(testdata.getJsonData("SelectCountry.country63"))
                .clickonshipping(testdata.getJsonData("cartbuttons.no4"))
                .clickonread();
        driver.browser().closewindow();
        new CartPage(driver)
                .clickoncheckbox()
                .clickoncheckoutbutton();

    }
    @Test(dependsOnMethods = "addtocart")
    @Description("checkout process")
   public void checkoutprocess(){
        new Checkout(driver)
                .verifywelcometext()
                .clickonguestcheckoutbutton()
                .verifywelcometext()
                .clickoncontinuebutton()
                .verifyInvalidCredentialsErrorforBillingaddress(testdata.getJsonData("BillingAddressErrorMessages"))
                .fillbillingaddressform(testdata.getJsonData("Billingaddress1.no1"),
                        (testdata.getJsonData("Billingaddress2.BillingNewAddress_FirstName"))
                        ,(testdata.getJsonData("Billingaddress1.no2")),
                        (testdata.getJsonData("Billingaddress2.BillingNewAddress_LastName")),
                        (testdata.getJsonData("Billingaddress1.no3")),
                        (testdata.getJsonData("Billingaddress2.BillingNewAddress_Email")),
                        (testdata.getJsonData("Billingaddress1.no4")),
                        (testdata.getJsonData("Billingaddress2.BillingNewAddress_Company")),
                        (testdata.getJsonData("countrystate.no1")),
                        (testdata.getJsonData("SelectCountry.country63")),
                        (testdata.getJsonData("countrystate.no2")),
                        (testdata.getJsonData("State")),
                        (testdata.getJsonData("Billingaddress1.no5")),
                        (testdata.getJsonData("Billingaddress2.BillingNewAddress_City"))
                        ,(testdata.getJsonData("Billingaddress1.no6")),
                        (testdata.getJsonData("Billingaddress2.BillingNewAddress_Address1")),
                        (testdata.getJsonData("Billingaddress1.no7")),
                        (testdata.getJsonData("Billingaddress2.BillingNewAddress_Address2")),
                        (testdata.getJsonData("Billingaddress1.no8")),
                        (testdata.getJsonData("Billingaddress2.BillingNewAddress_ZipPostalCode")),
                        (testdata.getJsonData("Billingaddress1.no9")),
                        (testdata.getJsonData("Billingaddress2.BillingNewAddress_PhoneNumber")),
                        (testdata.getJsonData("Billingaddress1.no10")),
                        (testdata.getJsonData("Billingaddress2.BillingNewAddress_FaxNumber")))
                 .clickoncontinuebutton()
                .selectnewshippingaddress(testdata.getJsonData("billingaddress"))
                .fillbillingaddressform(testdata.getJsonData("shippingaddress1.no1"),
                        (testdata.getJsonData("shippingaddress2.BillingNewAddress_FirstName"))
                        ,(testdata.getJsonData("shippingaddress1.no2")),
                        (testdata.getJsonData("shippingaddress2.BillingNewAddress_LastName")),
                        (testdata.getJsonData("shippingaddress1.no3")),
                        (testdata.getJsonData("shippingaddress2.BillingNewAddress_Email")),
                        (testdata.getJsonData("shippingaddress1.no4")),
                        (testdata.getJsonData("shippingaddress2.BillingNewAddress_Company")),
                        (testdata.getJsonData("countrystate.no3")),
                        (testdata.getJsonData("SelectCountry.country63")),
                        (testdata.getJsonData("countrystate.no4")),
                        (testdata.getJsonData("State")),
                        (testdata.getJsonData("shippingaddress1.no5")),
                        (testdata.getJsonData("shippingaddress2.BillingNewAddress_City"))
                        ,(testdata.getJsonData("shippingaddress1.no6")),
                        (testdata.getJsonData("shippingaddress2.BillingNewAddress_Address1")),
                        (testdata.getJsonData("shippingaddress1.no7")),
                        (testdata.getJsonData("shippingaddress2.BillingNewAddress_Address2")),
                        (testdata.getJsonData("shippingaddress1.no8")),
                        (testdata.getJsonData("shippingaddress2.BillingNewAddress_ZipPostalCode")),
                        (testdata.getJsonData("shippingaddress1.no9")),
                        (testdata.getJsonData("shippingaddress2.BillingNewAddress_PhoneNumber")),
                        (testdata.getJsonData("shippingaddress1.no10")),
                        (testdata.getJsonData("shippingaddress2.BillingNewAddress_FaxNumber")))
                .clickoncontinuebutton2()
                .clickonShippingorpaymentmethod(testdata.getJsonData("Shippingmethod.no2"))
                .clickoncontinuebutton3()
                .clickonShippingorpaymentmethod(testdata.getJsonData("Paymentmethod.no1"))
                .clickoncontinuebutton4()
                .verifypaymentinformation(testdata.getJsonData("confirmation.no1"))
                .clickonbackbutton()
                .clickonShippingorpaymentmethod(testdata.getJsonData("Paymentmethod.no3"))
                .clickoncontinuebutton4()
                .fillbillingpaymentform(testdata.getJsonData("creditcard.no1"),
                        (testdata.getJsonData("Cardholder.name")),
                        (testdata.getJsonData("Cardholderinfo.wrongname")),
                        (testdata.getJsonData("Cardholder.cardnumber")),
                        (testdata.getJsonData("Cardholderinfo.wrongcardnumber")),
                        (testdata.getJsonData("ExpireMonthOptions.no6")),
                        (testdata.getJsonData("ExpireYearOptions.no3")),
                        (testdata.getJsonData("Cardholder.cardcode")),
                        (testdata.getJsonData("Cardholderinfo.wrongcardcode")))
                .clickoncontinuebutton5()
                .verifyInvalidCredentialsErrorpaymentmethod(testdata.getJsonData("creditcardErrorMessages"))
                .fillbillingpaymentform(testdata.getJsonData("creditcard.no1"),
                        (testdata.getJsonData("Cardholder.name")),
                        (testdata.getJsonData("Cardholderinfo.name")),
                        (testdata.getJsonData("Cardholder.cardnumber")),
                        (testdata.getJsonData("Cardholderinfo.cardnumber")),
                        (testdata.getJsonData("ExpireMonthOptions.no6")),
                        (testdata.getJsonData("ExpireYearOptions.no3")),
                        (testdata.getJsonData("Cardholder.cardcode")),
                        (testdata.getJsonData("Cardholderinfo.cardcode")))
                .clickoncontinuebutton5()
                .verifyconfirmorderdetails(testdata.getJsonData("BillingAddressVerify"))
                .clickonconfirmbutton()
                .verifywelcometext2()
                .clickonorderdetails()
                .verifywelcometext()
                .clickonpdfinvoicebutton();
        driver.element().verifyInvoiceDownloaded();

    }
    @Test(dependsOnMethods = {"checkoutprocess", "addtocart"})
    @Description("re order same product")
    public void reorder(){
        new OrderInformation(driver)
                .clickonreorderbutton()
                .verifywelcometext()
                .verifyproductpriceandnameqtytotal(testdata.getJsonData("apparel2.name"),
                        testdata.getJsonData("apparel2.price"),
                        testdata.getJsonData("apparel2.quantity"),
                        testdata.getJsonData("apparel2.total"))
                .changequantity(testdata.getJsonData("apparel2.name"),
                        testdata.getJsonData("quantity.no1"))
                .clickonUpdatecart(testdata.getJsonData("cartbuttons.no1"))
                .verifyproductpriceandnameqtytotal(testdata.getJsonData("apparel2.name"),
                        testdata.getJsonData("apparel2.price"),
                        testdata.getJsonData("apparel2.newquantity"),
                        testdata.getJsonData("apparel2.newtotal"))
                .clickonread();
        driver.browser().closewindow();
        new CartPage(driver)
                .clickoncheckbox()
                .clickoncheckoutbutton();
        new Checkout(driver)
                .verifywelcometext()
                .clickonguestcheckoutbutton()
                .verifywelcometext()
                .clickoncontinuebutton()
                .selectinstorepickup()
                .clickoncontinuebutton2()
                .clickonShippingorpaymentmethod(testdata.getJsonData("Paymentmethod.no2"))
                .clickoncontinuebutton4()
                .verifypaymentinformation(testdata.getJsonData("confirmation.no2"))
                .clickoncontinuebutton5()
                .verifyconfirmorderdetails(testdata.getJsonData("BillingAddressVerify2"))
                .clickonconfirmbutton()
                .verifywelcometext2()
                .clickonorderdetails()
                .verifywelcometext()
                .clickonpdfinvoicebutton();
        driver.element().verifyInvoiceDownloaded();

    }






    @BeforeClass
    public void setup(){
        driver = new Driver();
        new NavigationBar(driver).navigate();

    }

    @AfterClass
    public void teardown(){
        driver.quitDriver();
    }

}
