package proj.shopping.tests.userinterface;

import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import proj.shopping.pages.components.system.*;
import proj.shopping.drivers.Driver;

@Epic("Automation Project")
@Feature("UI End to End Tests")
@Story("checkout Tests")
@Severity(SeverityLevel.CRITICAL)
@Owner("QA Team")
public class LoggedinCheckoutTests extends BaseTest {


    @Test
    @Description("checkout as a registered customer")
    public void checkoutprocessregisteredcust() {
        new UserFlows(driver, testdata).addtocart();
        new Checkout(driver)
                .verifywelcometext()
                .clickonregisterbutton()
                .verifyregisterpage()
                .fillregistrationform(
                        testdata.getJsonData("genderMale"),
                        testdata.getJsonData("firstName"),
                        testdata.getJsonData("lastName"),
                        testdata.getJsonData("newemail3"),
                        testdata.getJsonData("password"),
                        testdata.getJsonData("confirmPassword"))
                .clickonregisterbutton()
                .verifywelcometext()
                .clickoncontinuebutton2()
                .clickoncheckbox()
                .clickoncheckoutbutton()
                .fillbillingaddressform2(
                        (testdata.getJsonData("Billingaddress1.no4")),
                        (testdata.getJsonData("billingaddress2forregister.BillingNewAddress_Company")),
                        (testdata.getJsonData("countrystate.no1")),
                        (testdata.getJsonData("SelectCountry.country63")),
                        (testdata.getJsonData("countrystate.no2")),
                        (testdata.getJsonData("State")),
                        (testdata.getJsonData("Billingaddress1.no5")),
                        (testdata.getJsonData("billingaddress2forregister.BillingNewAddress_City"))
                        , (testdata.getJsonData("Billingaddress1.no6")),
                        (testdata.getJsonData("billingaddress2forregister.BillingNewAddress_Address1")),
                        (testdata.getJsonData("Billingaddress1.no7")),
                        (testdata.getJsonData("billingaddress2forregister.BillingNewAddress_Address2")),
                        (testdata.getJsonData("Billingaddress1.no8")),
                        (testdata.getJsonData("billingaddress2forregister.BillingNewAddress_ZipPostalCode")),
                        (testdata.getJsonData("Billingaddress1.no9")),
                        (testdata.getJsonData("billingaddress2forregister.BillingNewAddress_PhoneNumber")),
                        (testdata.getJsonData("Billingaddress1.no10")),
                        (testdata.getJsonData("billingaddress2forregister.BillingNewAddress_FaxNumber")))
                .clickoncontinuebutton()
                .clickoncontinuebutton2()
                .clickonShippingorpaymentmethod(testdata.getJsonData("Shippingmethod.no2"))
                .clickoncontinuebutton3()
                .clickonShippingorpaymentmethod(testdata.getJsonData("Paymentmethod.no1"))
                .clickoncontinuebutton4()
                .verifypaymentinformation(testdata.getJsonData("confirmation.no1"))
                .clickoncontinuebutton5()
                .clickonconfirmbutton()
                .verifywelcometext2()
                .clickonorderdetails()
                .verifywelcometext()
                .clickonpdfinvoicebutton();
        driver.element().verifyInvoiceDownloaded();


    }
    @Test
    @Description("checkout as a logged in customer")
    public void checkoutprocesslogincst() {
        new UserFlows(driver, testdata).addtocart();
        new Checkout(driver)
                .verifywelcometext()
                .Fillloginpage(
                        testdata.getJsonData("loginemail"),
                        testdata.getJsonData("loginpassword"),
                        true)
                .clickonloginbutton()
                .verifywelcometext()
                .verifyproductpriceandnameqtytotal(testdata.getJsonData("apparel2.name"),
                        testdata.getJsonData("apparel2.price"),
                        testdata.getJsonData("apparel2.quantity"),
                        testdata.getJsonData("apparel2.total"))
                .clickoncheckbox()
                .clickoncheckoutbutton()
                .clickoncontinuebutton()
                .clickoncontinuebutton2()
                .clickonShippingorpaymentmethod(testdata.getJsonData("Shippingmethod.no3"))
                .clickoncontinuebutton3()
                .clickonShippingorpaymentmethod(testdata.getJsonData("Paymentmethod.no1"))
                .clickoncontinuebutton4()
                .verifypaymentinformation(testdata.getJsonData("confirmation.no1"))
                .clickoncontinuebutton5()
                .clickonconfirmbutton()
                .verifywelcometext2()
                .clickonorderdetails()
                .verifywelcometext()
                .clickonpdfinvoicebutton();
        driver.element().verifyInvoiceDownloaded();


    }
    @Test
    @Description("checkout as a logged in customer from the begging")
    public void checkoutprocesslogincst2() {
        new NavigationBar(driver)
                .clickonloginbutton()
                .verifywelcometext()
                .Fillloginpage(
                        testdata.getJsonData("loginemail"),
                        testdata.getJsonData("loginpassword"),
                        true)
                .clickonloginbutton()
                .foot
                .clickonwords(testdata.getJsonData("footer.no3"));
        new ProductsPage(driver)
                .clickonproducttitle(testdata.getJsonData("apparel11.name"))
                .verifywelcometext()
                .verifyproductpriceandname(
                        testdata.getJsonData("apparel11.name"),
                        testdata.getJsonData("apparel11.price"))
                .clickonaddtocartbutton(testdata.getJsonData("apparel11.name"))
                .verifyaddtocartmessage(testdata.getJsonData("cartaddedmessage"))
                .closemessage();
        new NavigationBar(driver).clickoncartbutton();
        new CartPage(driver)
                .verifywelcometext()
                .verifyproductpriceandnameqtytotal(testdata.getJsonData("apparel11.name"),
                        testdata.getJsonData("apparel11.price"),
                        testdata.getJsonData("apparel11.quantity"),
                        testdata.getJsonData("apparel11.total"))
                .typepostalcode(testdata.getJsonData("cartinputfields.no3"),
                        testdata.getJsonData("textdata.no3"))
                .selectcountry(testdata.getJsonData("SelectCountry.country63"))
                .clickonshipping(testdata.getJsonData("cartbuttons.no4"))
                .clickonread();
        driver.browser().closewindow();
        new CartPage(driver)
                .clickoncheckbox()
                .clickoncheckoutbutton()
                .clickoncontinuebutton()
                .selectinstorepickup()
                .clickoncontinuebutton2()
                .clickonShippingorpaymentmethod(testdata.getJsonData("Paymentmethod.no4"))
                .clickoncontinuebutton4()
                .clickoncontinuebutton5()
                .clickonconfirmbutton()
                .verifywelcometext2()
                .clickonorderdetails();
        new Footer(driver).clickonwords(testdata.getJsonData("footer.no1"));
        new ContactUs(driver)
                .Fillpage(testdata.getJsonData("contactus"))
                .clickonsubmit()
                .messagedisplayed(testdata.getJsonData("contactusmessage"));
        new Footer(driver).clickonwords(testdata.getJsonData("footer.no4"));
        new OrderInformation(driver)
                .clickonorders()
                .verifywelcometext()
                .clickonpdfinvoicebutton();
        driver.element().verifyInvoiceDownloaded();
        new NavigationBar(driver).clickonlogoutbutton();





    }
    @Test
    @Description("checkout as a logged in customer from the begging")
    public void checkoutprocessregister2() {
        new NavigationBar(driver)
                .clickonregisterbutton()
                .verifyregisterpage()
                .fillregistrationform(
                        testdata.getJsonData("genderMale"),
                        testdata.getJsonData("firstname2"),
                        testdata.getJsonData("lastname2"),
                        testdata.getJsonData("newemail4"),
                        testdata.getJsonData("password"),
                        testdata.getJsonData("confirmPassword"))
                .clickonregisterbutton()
                .verifywelcometext()
                .clickoncontinuebutton()
                .verifywelcometext()
                .clickoncustomerbutton()
                .fillform(testdata.getJsonData("genderMale"),
                        testdata.getJsonData("firstname3"),
                        testdata.getJsonData("lastname3"))
                .clickonsavebutton();
        new Footer(driver).clickonaddress()
                .clickonbutton()
                .clickonbutton2()
                .verifyInvalidCredentialsErrorforaddress(testdata.getJsonData("AddressErrorMessages"))
                .filladdressform(testdata.getJsonData("address1.no1"),
                        (testdata.getJsonData("address2.NewAddress_FirstName"))
                        ,(testdata.getJsonData("address1.no2")),
                        (testdata.getJsonData("address2.NewAddress_LastName")),
                        (testdata.getJsonData("address1.no3")),
                        (testdata.getJsonData("address2.NewAddress_Email")),
                        (testdata.getJsonData("address1.no4")),
                        (testdata.getJsonData("address2.NewAddress_Company")),
                        (testdata.getJsonData("countrystate.no5")),
                        (testdata.getJsonData("SelectCountry.country63")),
                        (testdata.getJsonData("countrystate.no6")),
                        (testdata.getJsonData("State")),
                        (testdata.getJsonData("address1.no5")),
                        (testdata.getJsonData("address2.NewAddress_City"))
                        ,(testdata.getJsonData("address1.no6")),
                        (testdata.getJsonData("address2.NewAddress_Address1")),
                        (testdata.getJsonData("address1.no7")),
                        (testdata.getJsonData("address2.NewAddress_Address2")),
                        (testdata.getJsonData("address1.no8")),
                        (testdata.getJsonData("address2.NewAddress_ZipPostalCode")),
                        (testdata.getJsonData("address1.no9")),
                        (testdata.getJsonData("address2.NewAddress_PhoneNumber")),
                        (testdata.getJsonData("address1.no10")),
                        (testdata.getJsonData("address2.NewAddress_FaxNumber")))
                .clickonbutton2();
        new NavigationBar(driver).clickonhomebutton();
        new ProductsPage(driver)
                .clickonproducttitle(testdata.getJsonData("GiftCards2.name"))
                .verifywelcometext()
                .verifyproductpriceandname(
                        testdata.getJsonData("GiftCards2.name"),
                        testdata.getJsonData("GiftCards2.price"))
                .typegiftcardinfo(testdata.getJsonData("GiftCard.no6"),
                        testdata.getJsonData("GiftCardinfo.RecipientsName"))
                .typegiftcardinfo(testdata.getJsonData("GiftCard.no7"),
                        testdata.getJsonData("GiftCardinfo.RecipientsEmail"))
                .typegiftcardinfo(testdata.getJsonData("GiftCard.no10"),
                        testdata.getJsonData("GiftCardinfo.Message"))
                .clickwishlist()
                .verifyaddtowishlistmessage(testdata.getJsonData("wishlistmessage"))
                .closemessage();
        new NavigationBar(driver).clickonwhishlistbutton()
                .verifywelcometext()
                .clickonemailfriend(testdata.getJsonData("cartbuttons.no8"))
                .verifywelcometext()
                .Fillpage2(testdata.getJsonData("friendemail"),
                        testdata.getJsonData("message"))
                .clickonsendemail()
                .messagedisplayed2(testdata.getJsonData("successmessage"));
        new NavigationBar(driver).clickonwhishlistbutton()
                .clickonaddtocartcheckbox(testdata.getJsonData("GiftCards2.name"))
                .clickonaddtocart( testdata.getJsonData("cartbuttons.no7"))
                .verifywelcometext()
                .verifyproductpriceandnameqtytotal(testdata.getJsonData("GiftCards2.name"),
                        testdata.getJsonData("GiftCards2.price"),
                        testdata.getJsonData("GiftCards2.quantity"),
                        testdata.getJsonData("GiftCards2.total"))
                .clickonread();
        driver.browser().closewindow();
        new CartPage(driver)
                .clickoncheckbox()
                .clickoncheckoutbutton()
                .clickoncontinuebutton()
                .clickonShippingorpaymentmethod(testdata.getJsonData("Paymentmethod.no1"))
                .clickoncontinuebutton4()
                .verifypaymentinformation(testdata.getJsonData("confirmation.no1"))
                .clickoncontinuebutton5()
                .clickonconfirmbutton()
                .verifywelcometext2()
                .clickonorderdetails()
                .verifywelcometext()
                .clickonpdfinvoicebutton();
        driver.element().verifyInvoiceDownloaded();

    }
    @Test
    @Description("add to compare products and add review")
    public void addtocompareproducts() {
        new NavigationBar(driver)
                .clickonloginbutton()
                .verifywelcometext()
                .Fillloginpage(
                        testdata.getJsonData("loginemail"),
                        testdata.getJsonData("loginpassword"),
                        true)
                .clickonloginbutton();
        new ProductsPage(driver)
                .clickonproducttitle(testdata.getJsonData("desktop1.name"))
                .verifywelcometext()
                .verifyproductpriceandname(
                        testdata.getJsonData("desktop1.name"),
                        testdata.getJsonData("desktop1.price"))
                .clickcomparelist();
        new NavigationBar(driver).entersearchtext(testdata.getJsonData("desktop6.name"));
        new ProductsPage(driver)
                .clickonproducttitle(testdata.getJsonData("desktop6.name"));
        new ProductDetailsPage(driver)
        .verifywelcometext()
                .verifyproductpriceandname(
                        testdata.getJsonData("desktop6.name"),
                        testdata.getJsonData("desktop6.price"))
                .clickcomparelist();
        new NavigationBar(driver).clickonhomebutton();
        new ProductsPage(driver)
                .clickonproducttitle(testdata.getJsonData("desktop3.name"))
                .verifywelcometext()
                .verifyproductpriceandname(
                        testdata.getJsonData("desktop3.name"),
                        testdata.getJsonData("desktop3.price"))
                .clickcomparelist()
                .clickonremovebutton(testdata.getJsonData("desktop1.name"))
                .clickonproductTitle(testdata.getJsonData("desktop3.name"))
                .clickaddreview()
                .verifywelcometext()
                .FillReviewtitle(testdata.getJsonData("Reviewtitle"))
                .FillReviewtext(testdata.getJsonData("Reviewtext"))
                .clickonratingOption(testdata.getJsonData("rating.no1"))
                .clickonsubmitbutton()
                .verifysucessmessage();
        new Footer(driver).clickonwords(testdata.getJsonData("footer.no5"))
                .clickonwords(testdata.getJsonData("footer.no6"));
        new NavigationBar(driver).clickonhomebutton()
                .enternewsletteremail( testdata.getJsonData("loginemail"))
                .clickonnewsletterbutton()
                .verifynewslettermessage()
                .clickonpopulartags(testdata.getJsonData("wordsuggestion.no4"));

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
