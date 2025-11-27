package proj.shopping.tests.userinterface;

import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import proj.shopping.drivers.Driver;
import proj.shopping.pages.components.system.NavigationBar;
import proj.shopping.pages.components.system.ProductDetailsPage;
import proj.shopping.pages.components.system.ProductsPage;

@Epic("Automation Project")
@Feature("UI Books Tests")
@Story("Products Tests")
@Severity(SeverityLevel.CRITICAL)
@Owner("QA Team")
public class ProductsTests extends BaseTest {

    //Tests
    @Test
    @Description("Search for a book and verify its details")
    public void searchBookAndVerifyDetails(){


        new NavigationBar(driver)
                .clickonbooksbutton()
                .verifywelcometext()
                .navg
                .entersearchtext(testdata.getJsonData("searchedBook.searchedname"));
                new ProductsPage(driver)
                .verifyproductpriceandname(
                        testdata.getJsonData("searchedBook.searchedname"),
                        testdata.getJsonData("searchedBook.searchedprice"));
    }
    @Test
    @Description("Search for a book and verify its details from homepage and add it to cart")
    public void searchBookAndVerifyDetailsinhome(){


        new NavigationBar(driver)
                .entersearchtext(testdata.getJsonData("searchedBook2.searchedname"));
        new ProductsPage(driver)
                .verifyproductpriceandname(
                        testdata.getJsonData("searchedBook2.searchedname"),
                        testdata.getJsonData("searchedBook2.searchedprice"))
                .clickonaddtocartbutton(testdata.getJsonData("book1.name"))
                .verifyaddtocartmessage(testdata.getJsonData("cartaddedmessage"))
                .closeaddtocartmessage();
    }



    @Test
    @Description("Add a book to the cart and verify with adding filters")
    public void addBookToCartAndVerify(){
        new NavigationBar(driver)
                .clickonbooksbutton()
                .verifywelcometext()
                .clickonfilteroptions(testdata.getJsonData("filterOption.no3"))
                .clickonremovefilter()
                .clickonaddtocartbutton(testdata.getJsonData("book3.name"))
                .verifyaddtocartmessage(testdata.getJsonData("cartaddedmessage"))
                .closeaddtocartmessage();

    }

    @Test
    @Description("Navigate to second page of books using Next button and add book to cart")
    public void navigateToSecondPageUsingNextButtonAndVerify() {
        new NavigationBar(driver)
                .clickonbooksbutton()
                .verifywelcometext()
                .selectDisplayPerPage(testdata.getJsonData("pageno.no1"))
                .clickonnextbutton()
                .productspage
                .selectViewMode(testdata.getJsonData("view.no2"))
                .clickonaddtocartbutton(testdata.getJsonData("book5.name"))
                .verifyaddtocartmessage(testdata.getJsonData("cartaddedmessage"));




    }

    @Test
    @Description("Navigate to second page of books using Next button and then return back and add book to cart")
    public void navigateToSecondPageUsingNextButtonAndVerifyandreturnback() {
        new NavigationBar(driver)
                .clickonbooksbutton()
                .verifywelcometext()
                .selectDisplayPerPage(testdata.getJsonData("pageno.no1"))
                .clickonnextbutton()
                .clickonpageno()
                .clickonaddtocartbutton(testdata.getJsonData("book3.name"))
                .verifyaddtocartmessage(testdata.getJsonData("cartaddedmessage"));


    }

    @Test
    @Description("select a diferent sort by and then add book to cart")
    public void selectdiffsort() {
        new NavigationBar(driver)
                .clickonbooksbutton()
                .verifywelcometext()
                .selectSortBy(testdata.getJsonData("sort.no4"))
                .clickonaddtocartbutton(testdata.getJsonData("book5.name"))
                .verifyaddtocartmessage(testdata.getJsonData("cartaddedmessage"));
    }

    @Test
    @Description("select a diferent view and sort by and then add book to cart")
    public void selectdiffview() {
        new NavigationBar(driver)
                .clickonbooksbutton()
                .verifywelcometext()
                .selectViewMode(testdata.getJsonData("view.no2"))
                .selectSortBy(testdata.getJsonData("sort.no2"))
                .clickonaddtocartbutton(testdata.getJsonData("book3.name"))
                .verifyaddtocartmessage(testdata.getJsonData("cartaddedmessage"));
    }

    @Test
    @Description("click on book name and add it to cart")
    public void clickonbookname(){
        new NavigationBar(driver)
                .clickonbooksbutton()
                .verifywelcometext()
                .clickonproducttitle(testdata.getJsonData("book1.name"))
                .verifywelcometext()
                .clickonaddtocartbutton(testdata.getJsonData("book1.name"))
                .verifyaddtocartmessage(testdata.getJsonData("cartaddedmessage"))
                .closemessage();





    }
    @Test
    @Description("click on book name and add it to cart with a related product")
    public void addtocartanotherrelatedbook(){
        new NavigationBar(driver)
                .clickonbooksbutton()
                .verifywelcometext()
                .clickonproducttitle(testdata.getJsonData("book3.name"))
                .verifywelcometext()
                .clickonaddtocartbutton(testdata.getJsonData("book3.name"))
                .verifyaddtocartmessage(testdata.getJsonData("cartaddedmessage"))
                .closemessage()
                .clickonaddtocartbutton2(testdata.getJsonData("book5.name"))
                .verifyaddtocartmessage(testdata.getJsonData("cartaddedmessage"))
                .closemessage();

    }
    @Test
    @Description("add book to wishlist")
    public void addtowishlist(){
        new NavigationBar(driver)
                .clickonbooksbutton()
                .verifywelcometext()
                .clickonproducttitle(testdata.getJsonData("book4.name"))
                .verifywelcometext()
                .clickwishlist()
                .verifyaddtowishlistmessage(testdata.getJsonData("wishlistmessage"))
                .closemessage()
                .clickwishlist()
                .verifywishlistmessageerror(testdata.getJsonData("wishlistmessageerror"));

    }
    @Test
    @Description("click book reviews")
    public void clickreviewforthebook(){
        new NavigationBar(driver)
                .clickonbooksbutton()
                .verifywelcometext()
                .clickonproductimage(testdata.getJsonData("book6.name"))
                .verifywelcometext()
                .clickonproductReviewLink(testdata.getJsonData("review.no1"));

    }
    @Test
    @Description("click  nice button")
    public void clicknice(){
        new NavigationBar(driver)
                .clickonbooksbutton()
                .verifywelcometext()
                .clickonproductimage(testdata.getJsonData("book1.name"))
                .verifywelcometext()
                .clicksuggestionword(testdata.getJsonData("wordsuggestion.no3"));

    }

    @Test
    @Description("click  compare button")
    public void clickcompare(){
        new NavigationBar(driver)
                .clickonbooksbutton()
                .verifywelcometext()
                .clickonproductimage(testdata.getJsonData("book3.name"))
                .verifywelcometext()
                .clickcomparelist();

    }

    @Test
    @Description("click email friend button")
    public void clickemailfriend(){
        new NavigationBar(driver)
                .clickonbooksbutton()
                .verifywelcometext()
                .clickonproductimage(testdata.getJsonData("book3.name"))
                .verifywelcometext()
                .verifyproductpriceandname(
                        testdata.getJsonData("book3.name"),
                        testdata.getJsonData("book3.price"))
                .clickemailfriend()
                .verifywelcometext()
                .Fillpage(testdata.getJsonData("friendemail"),
                        testdata.getJsonData("youremail"),
                        testdata.getJsonData("message"))
                .clickonsendemail()
                .messagedisplayed(testdata.getJsonData("errormessage"));


    }
    @Test
    @Description("click email friend button")
    public void clickemailfriendwithemptyfields(){
        new NavigationBar(driver)
                .clickonbooksbutton()
                .verifywelcometext()
                .clickonproductimage(testdata.getJsonData("book3.name"))
                .verifywelcometext()
                .verifyproductpriceandname(
                        testdata.getJsonData("book3.name"),
                        testdata.getJsonData("book3.price"))
                .clickemailfriend()
                .verifywelcometext()
                .Fillpage(testdata.getJsonData(""),
                        testdata.getJsonData(""),
                        testdata.getJsonData(""))
                .clickonsendemail()
                .verifyfriendemailerrortext(testdata.getJsonData("yourfrienderror"))
                .verifyyouremailerrortext(testdata.getJsonData("youremailerror"))
                .Fillpage(testdata.getJsonData("friendwrongemail"),
                        testdata.getJsonData("yourwrongemail"),
                        testdata.getJsonData(""))
                .clickonsendemail()
                .verifyyouremailnotwrongformaterrortext(testdata.getJsonData("wrongemailmessage"))
                .Fillpage(testdata.getJsonData("friendemail"),
                        testdata.getJsonData("youremail"),
                        testdata.getJsonData("message"))
                .clickonsendemail()
                .messagedisplayed(testdata.getJsonData("errormessage"));




    }
    @Test
    @Description("click add review")
    public void clickaddreview(){
        new NavigationBar(driver)
                .clickonbooksbutton()
                .verifywelcometext()
                .clickonproductimage(testdata.getJsonData("book3.name"))
                .verifywelcometext()
                .verifyproductpriceandname(
                        testdata.getJsonData("book3.name"),
                        testdata.getJsonData("book3.price"))
                .clickaddreview()
                .verifywelcometext()
                .clickonratingOption(testdata.getJsonData("rating.no1"))
                .clickonsubmitbutton()
                .errormessage1displayed(testdata.getJsonData("Reviewtitleerror"))
                .errormessage2displayed(testdata.getJsonData("Reviewtexterror"))
                .messagedisplayed(testdata.getJsonData("reviewerrormessage"));



    }

    @Test
    @Description("Change product quantity and add to cart")
    public void changeproductquantity(){
        new NavigationBar(driver)
                .clickonbooksbutton()
                .verifywelcometext()
                .clickonproductimage(testdata.getJsonData("book1.name"))
                .verifywelcometext()
                .changequantity(testdata.getJsonData("quantitynumbers.no1"),
                       testdata.getJsonData("quantity.no1"))
                .clickonaddtocartbutton(testdata.getJsonData("book1.name"))
                .verifyaddtocartmessage(testdata.getJsonData("cartaddedmessage"))
                .closemessage();


    }
    @Test
    @Description("select a product from desktops")
    public void selectfromdesktops(){
        new NavigationBar(driver)
                .hoverAndClick(testdata.getJsonData("Hover1.topmenu"),
                        testdata.getJsonData("Hover1.submenu1"));
                new ProductsPage(driver)
                .verifywelcometext()
                .clickonaddtocartbutton(testdata.getJsonData("desktop1.name"));
                new ProductDetailsPage(driver)
                .clickonprocessorradio(testdata.getJsonData("processorradiobutton.no2"))
                .clickonramradio(testdata.getJsonData("Ramradiobutton.no3"))
                .clickonrhddradio(testdata.getJsonData("HDD.no2"))
                .clickonsoftware(testdata.getJsonData("Software.no4"))
                .clickonsoftware(testdata.getJsonData("Software.no5"))
                .clickonsoftware(testdata.getJsonData("Software.no6"))
                .changequantity(testdata.getJsonData("quantitynumbers.no2"),
                                testdata.getJsonData("quantity.no1"))
                .clickonaddtocartbutton(testdata.getJsonData("desktop1.name"))
                .verifyaddtocartmessage(testdata.getJsonData("cartaddedmessage"))
                .closemessage();



    }
    @Test
    @Description("select a product from desktops")
    public void selectfromdesktops2(){
        new NavigationBar(driver)
                .hoverAndClick(testdata.getJsonData("Hover1.topmenu"),
                        testdata.getJsonData("Hover1.submenu1"));
        new ProductsPage(driver)
                .verifywelcometext()
                .verifyproductpriceandname(
                        testdata.getJsonData("desktop2.name"),
                        testdata.getJsonData("desktop2.price"))
                .clickonproducttitle(testdata.getJsonData("desktop2.name"))
                .selectprocessordropdown(testdata.getJsonData("dropdown.processor"),
                        testdata.getJsonData("Processor.no1"))
                .selectramdropdown(testdata.getJsonData("dropdown.ram"),
                        testdata.getJsonData("RAM.no2"))
                .clickonrhddradio(testdata.getJsonData("HDD.no1"))
                .clickonosdradio(testdata.getJsonData("OS.no2"))
                .clickonsoftware(testdata.getJsonData("Software.no1"))
                .clickonsoftware(testdata.getJsonData("Software.no2"))
                .clickonaddtocartbutton(testdata.getJsonData("desktop2.name"))
                .verifyaddtocartmessage(testdata.getJsonData("cartaddedmessage"))
                .closemessage();



    }
    @Test
    @Description("select a product from notebooks")
    public void selectfromnotebooks(){
        new NavigationBar(driver)
                .clickoncomputersbutton()
                .clickonproducttitle(testdata.getJsonData("category2.name"))
                .verifywelcometext()
                .clickonfilteroptions(testdata.getJsonData("filterOption.no7"))
                .verifyproductpriceandname(
                        testdata.getJsonData("notebook.name"),
                        testdata.getJsonData("notebook.price"))
                .clickonaddtocartbutton(testdata.getJsonData("notebook.name"))
                .verifyaddtocartmessage(testdata.getJsonData("cartaddedmessage"))
                .closeaddtocartmessage();



    }
    @Test
    @Description("select a product from accessories")
    public void selectfromaccessories(){
        new NavigationBar(driver)
                .clickoncomputersbutton()
                .clickonproducttitle(testdata.getJsonData("category3.name"))
                .verifywelcometext()
                .clickonproducttitle(testdata.getJsonData("accessorie2.name"))
                .verifyproductpriceandname(
                        testdata.getJsonData("accessorie2.name"),
                        testdata.getJsonData("accessorie2.price"))
                .clickonaddtocartbutton(testdata.getJsonData("accessorie2.name"))
                .verifyaddtocartmessage(testdata.getJsonData("cartaddedmessage"))
                .closemessage()
                .clickonaddtocartbutton2(testdata.getJsonData("accessorie2.name"))
                .verifyaddtocartmessage(testdata.getJsonData("cartaddedmessage"))
                .closemessage();




    }
    @Test
    @Description("select a product from electronics")
    public void selectfromelectronics(){
        new NavigationBar(driver)
                .clickonelectronicsbutton()
                .clickonproducttitle(testdata.getJsonData("category4.name"))
                .verifywelcometext()
                .clickonproducttitle(testdata.getJsonData("Camera,photo3.name"))
                .verifyproductpriceandname3(
                        testdata.getJsonData("Camera,photo5.name"),
                        testdata.getJsonData("Camera,photo5.price"))
                .clickonaddtocartbutton3(testdata.getJsonData("Camera,photo5.name"))
                .verifyaddtocartmessage(testdata.getJsonData("cartaddedmessage"))
                .closemessage();

    }
    @Test
    @Description("select a product from cellphones")
    public void selectfrom(){
        new NavigationBar(driver)
                .hoverAndClick(testdata.getJsonData("Hover2.topmenu"),
                        testdata.getJsonData("Hover2.submenu2"));
        new ProductsPage(driver)
                .verifywelcometext()
                .clickonproducttitle(testdata.getJsonData("Cellphones3.name"))
                .verifyproductpriceandname(
                        testdata.getJsonData("Cellphones3.name"),
                        testdata.getJsonData("Cellphones3.price"))
                .clickoncoverimg(testdata.getJsonData("cover.no1"))
                .clickoncoverimg()
                .clickoncoverimg()
                .clickoncoverimg()
                .clickonnext()
                .clickonback()
                .closecover()
                .selectManufacturerdropdown(testdata.getJsonData("dropdown.Manufacturer"),
                        testdata.getJsonData("Manufacturer.no2"))
                .selectRAMdropdown(testdata.getJsonData("dropdown.Color"),
                        testdata.getJsonData("coverColor.no3"))
                .clickonaddtocartbutton(testdata.getJsonData("Cellphones3.name"))
                .verifyaddtocartmessage(testdata.getJsonData("cartaddedmessage"))
                .closemessage();

    }
    @Test
    @Description("select a product from apparel")
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

    }
    @Test
    @Description("select a product from digitaldownloads")
    public void selectfromdigitaldownloads(){
        new NavigationBar(driver)
                .clickondigitaldownloadsbutton()
                .clickonproducttitle(testdata.getJsonData("Digitaldownloads2.name"))
                .verifywelcometext()
                .verifyproductpriceandname(
                        testdata.getJsonData("Digitaldownloads2.name"),
                        testdata.getJsonData("Digitaldownloads2.price"))
                .clickDownloadsample()
                .clickonaddtocartbutton(testdata.getJsonData("Digitaldownloads2.name"))
                .verifyaddtocartmessage(testdata.getJsonData("cartaddedmessage"))
                .closemessage();

    }
    @Test
    @Description("select a product from Jewelry")
    public void selectfromJewelry(){
        new NavigationBar(driver)
                .clickonjewelrybutton()
                .clickonproducttitle(testdata.getJsonData("Jewelry1.name"))
                .verifywelcometext()
                .verifyproductpriceandname(
                        testdata.getJsonData("Jewelry1.name"),
                        testdata.getJsonData("Jewelry1.price"))
                .selectmaterial(testdata.getJsonData("dropdown.Jewelrymaterial"),
                testdata.getJsonData("Material.no2"))
                .typejewerylength(testdata.getJsonData("dropdown.Jewerlylength"),
                        testdata.getJsonData("jewerlylength"))
                .clickonPendant(testdata.getJsonData("Pendant.no2"))
                .clickonaddtocartbutton(testdata.getJsonData("Jewelry1.name"))
                .verifyaddtocartmessage(testdata.getJsonData("cartaddedmessage"))
                .closemessage();

    }
    @Test
    @Description("select a giftcard ")
    public void selectgiftcard(){
        new NavigationBar(driver)
                .clickongiftcardsbutton()
                .clickonproducttitle(testdata.getJsonData("GiftCards1.name"))
                .verifywelcometext()
                .verifyproductpriceandname(
                        testdata.getJsonData("GiftCards1.name"),
                        testdata.getJsonData("GiftCards1.price"))
                .clickonaddtocartbutton(testdata.getJsonData("GiftCards1.name"))
                .verifyaddtocartmessageerror(testdata.getJsonData("GiftCardinfo.errorMessages"))
                .closemessage()
                .typegiftcardinfo(testdata.getJsonData("GiftCard.no1"),
                        testdata.getJsonData("GiftCardinfo.RecipientsName"))
                .typegiftcardinfo(testdata.getJsonData("GiftCard.no2"),
                        testdata.getJsonData("GiftCardinfo.RecipientsEmail"))
                .typegiftcardinfo(testdata.getJsonData("GiftCard.no3"),
                        testdata.getJsonData("GiftCardinfo.YourName"))
                .typegiftcardinfo(testdata.getJsonData("GiftCard.no4"),
                        testdata.getJsonData("GiftCardinfo.Wrongemail"))
                .typegiftcardinfo(testdata.getJsonData("GiftCard.no5"),
                        testdata.getJsonData("GiftCardinfo.Message"))
                .clickonaddtocartbutton(testdata.getJsonData("GiftCards1.name"))
                .verifyaddtocartmessageerror( testdata.getJsonData("GiftCardinfo.wrongemailerror"))
                .closemessage()
                .typegiftcardinfo(testdata.getJsonData("GiftCard.no4"),
                        testdata.getJsonData("GiftCardinfo.YourEmail"))
                .clickonaddtocartbutton(testdata.getJsonData("GiftCards1.name"))
                .verifyaddtocartmessage(testdata.getJsonData("cartaddedmessage"))
                .closemessage();

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
