package proj.shopping.tests.userinterface;

import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import proj.shopping.drivers.Driver;
import proj.shopping.pages.components.system.CartPage;
import proj.shopping.pages.components.system.NavigationBar;

@Epic("Automation Project")
@Feature("UI Cart Tests")
@Story("Cart Tests")
@Severity(SeverityLevel.CRITICAL)
@Owner("QA Team")
public class CartTests extends BaseTest {


    @Test
    @Description("go to cart page")
    public void addingtocart(){
        new UserFlows(driver, testdata).selectfromapparel();
        new CartPage(driver)
                .verifywelcometext()
                .verifyproductpriceandnameqtytotal(testdata.getJsonData("apparel2.name"),
                        testdata.getJsonData("apparel2.price"),
                        testdata.getJsonData("apparel2.quantity"),
                        testdata.getJsonData("apparel2.total"))
                .clickoncontinueshopping(testdata.getJsonData("cartbuttons.no2"))
                .clickonaddtocartbutton(testdata.getJsonData("apparel3.name"))
                .verifyaddtocartmessage(testdata.getJsonData("cartaddedmessage"))
                .clickonshoppingcart()
                .verifyproductpriceandnameqtytotal(testdata.getJsonData("apparel3.name"),
                        testdata.getJsonData("apparel3.price"),
                        testdata.getJsonData("apparel3.quantity"),
                        testdata.getJsonData("apparel3.total")
                )
                .clickonproductcheckbox(testdata.getJsonData("apparel3.name"))
                .clickonUpdatecart(testdata.getJsonData("cartbuttons.no1"))
                .typeDiscountCode(testdata.getJsonData("cartinputfields.no1"),
                        testdata.getJsonData("textdata.no1"))
                .clickoncopoun(testdata.getJsonData("cartbuttons.no3"))
                .typegiftcard(testdata.getJsonData("cartinputfields.no2"),
                        testdata.getJsonData("textdata.no2"))
                .clickonaddgift(testdata.getJsonData("cartbuttons.no5"))
                .typepostalcode(testdata.getJsonData("cartinputfields.no3"),
                        testdata.getJsonData("textdata.no3"))
                .selectcountry(testdata.getJsonData("SelectCountry.country63"))
                .clickonshipping(testdata.getJsonData("cartbuttons.no4"))
                .clickoncheckoutbutton();
        new CartPage(driver)
                .clickonclosebutton()
                .clickonread();
        driver.browser().closewindow();
        new CartPage(driver)
                .clickoncheckbox()
                .clickoncheckoutbutton();

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
