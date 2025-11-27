package proj.shopping.pages.components.system;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import proj.shopping.drivers.Driver;

public class ProductsPage {
    private Driver driver;
    public NavigationBar navg ;



    public ProductsPage(Driver driver) {
        this.driver = driver;
        this.navg = new NavigationBar(driver);
    }

    //locators
    private final By view = By.id("products-viewmode");
    private final By sortby = By.id("products-orderby");
    private final By displayperpage = By.id("products-pagesize");
    private final By welcometext = By.cssSelector("div.page-title h1");
    private final By pageno = By.xpath( "//div[@class='pager']//a[text()='2']");
    private final By nextbutton = By.xpath("//a[text()=\"Next\"]");
    private final By addtocartmessage = By.xpath("//p[contains(text(),'The product has been added to your')] | //p//a[text()='shopping cart']");
    private final By close = By.cssSelector("span.close");
    private final By removefilter = By.xpath("//a[normalize-space(text())=\"Remove Filter\"]");
    private final By shoppingcart = By.cssSelector("p.content >a[href=\"/cart\"]");




    //dynamic locator
    private By productTitle(String productTitle) {
        return By.xpath("//h2[@class='product-title']/a[text()='" + productTitle + "']");
    }
    private By productprice(String productTitle) {
        return By.xpath("//h2[@class='product-title']/a[text()='" + productTitle + "']/ancestor::div[contains(@class,'item-box')]//div[@class='prices']/span[@class=\"price actual-price\"]");
    }
    private By addtocartbutton(String productTitle) {
        return By.xpath("//h2[@class='product-title']/a[text()='" + productTitle + "']/ancestor::div[contains(@class,'item-box')]//input[@value='Add to cart']");
    }
    private By productImage(String productTitle) {
        return By.xpath("//img[@alt='Picture of " + productTitle + "']");
    }
    private By priceFilter(String filterText) {
        return By.xpath("//div[@class='product-filters-wrapper']//a[contains(normalize-space(.), '" + filterText + "')]");
    }



    //actions

    @Step("Click on Page Number")
    public ProductsPage2 clickonpageno() {
        driver.element().click(pageno);
        return new ProductsPage2(driver);
    }
    @Step("Click on Next Button")
    public ProductsPage2 clickonnextbutton() {
        driver.element().click(nextbutton);
        return new ProductsPage2(driver);
    }
    @Step("Click on filter options")
    public ProductsPage clickonfilteroptions(String filterText) {
        driver.element().click(priceFilter(filterText));
        return this;

    }
    @Step("Click on remove filter")
    public ProductsPage clickonremovefilter() {
        driver.element().click(removefilter);
        return  this;
    }
    @Step("Click on shoppingcart")
    public CartPage clickonshoppingcart() {
        driver.element().click(shoppingcart);
        return new CartPage(driver);
    }

    @Step("Click on Add to Cart Button")
    public ProductsPage clickonaddtocartbutton(String productTitle) {
        driver.element().click(addtocartbutton(productTitle));
        return this;
    }
    @Step("click on product Image")
    public ProductDetailsPage clickonproductimage(String productTitle) {
        driver.element().click(productImage(productTitle));
        return new ProductDetailsPage(driver);
    }
    @Step("click on product Title")
    public ProductDetailsPage clickonproducttitle(String productTitle) {
        driver.element().click(productTitle(productTitle));
        return new ProductDetailsPage(driver);
    }
@Step("close add to cart message")
    public ProductsPage closeaddtocartmessage() {
        driver.element().click(close);
        return this;
    }


    @Step("select View Mode")
    public ProductsPage selectViewMode(String mode) {
        driver.element().selectfromdropdown(view, mode);
        return this;
    }
    @Step("select Sort By Criteria")
    public ProductsPage selectSortBy(String criteria) {
        driver.element().selectfromdropdown(sortby, criteria);
        return this;
    }
    @Step("select Display Per Page Number")
    public ProductsPage selectDisplayPerPage(String number) {
        driver.element().selectfromdropdown(displayperpage, number);
        return this;
    }

    //verifications
    @Step("Get Welcome Text")
    public ProductsPage verifywelcometext() {
        driver.hardAssert().iselementvisible(welcometext);
        return this;
    }
    @Step("Get add to cart message")
    public ProductsPage verifyaddtocartmessage(String expectedmessage) {
        String actualmessage = driver.element().getText(addtocartmessage);
        driver.hardAssert().Equals(actualmessage, expectedmessage, "Add to cart message is not as expected");
        return this;
    }

    @Step("verify product price and name")
    public ProductsPage verifyproductpriceandname(String productTitle, String price) {
        String actualname = driver.element().getText(productTitle(productTitle));
        String actualprice = driver.element().getText(productprice(productTitle));
        driver.softAssert().Equals(actualname, productTitle, "Product name is not as expected");
        driver.softAssert().Equals(actualprice, price, "Product price is not as expected");
        driver.softAssert().assertAll();

        return this;
    }







}
