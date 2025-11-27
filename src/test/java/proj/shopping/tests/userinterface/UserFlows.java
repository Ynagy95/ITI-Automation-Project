package proj.shopping.tests.userinterface;

import proj.shopping.drivers.Driver;
import proj.shopping.pages.components.system.CartPage;
import proj.shopping.pages.components.system.NavigationBar;
import proj.shopping.pages.components.loginorregister.SignUpPage;
import proj.shopping.utils.datareader.JsonReader;

public class UserFlows {
    private Driver driver;
    private JsonReader testdata;

    public UserFlows(Driver driver, JsonReader testdata) {
        this.driver = driver;
        this.testdata = testdata;
    }

    public void validregister(){

        new SignUpPage(driver)
                .navigate()
                .verifyregisterpage()
                .fillregistrationform(
                        testdata.getJsonData("genderMale"),
                        testdata.getJsonData("firstName"),
                        testdata.getJsonData("lastName"),
                        testdata.getJsonData("newemail2"),
                        testdata.getJsonData("password"),
                        testdata.getJsonData("confirmPassword"))
                .clickonregisterbutton()
                .verifywelcometext()
                .clickoncontinuebutton()
                .verifywelcometext();

    }
    public void validregister2(){

        new SignUpPage(driver)
                .navigate()
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
                .clickoncontinuebutton2();

    }
    public void selectfromapparel(){
        new NavigationBar(driver)
                .clickonapparelshoesbutton()
                .clickonproducttitle(testdata.getJsonData("apparel2.name"))
                .verifywelcometext()
                .verifyproductpriceandname(
                        testdata.getJsonData("apparel2.name"),
                        testdata.getJsonData("apparel2.price"))
                .selectsize(testdata.getJsonData("dropdown.size2greenSneaker"),
                        testdata.getJsonData("size.no10"))
                .clickonshoescolor(testdata.getJsonData("shoesColor.no3"))
                .clickonaddtocartbutton(testdata.getJsonData("apparel2.name"))
                .verifyaddtocartmessage(testdata.getJsonData("cartaddedmessage"))
                .closemessage();
        new NavigationBar(driver).clickoncartbutton();

    }
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
}
