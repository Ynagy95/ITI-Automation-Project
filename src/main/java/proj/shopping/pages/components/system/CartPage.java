package proj.shopping.pages.components.system;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import proj.shopping.drivers.Driver;

public class CartPage {
    private Driver driver;
    public NavigationBar navg;

    public CartPage(Driver driver) {
        this.driver = driver;
        this.navg = new NavigationBar(driver);

    }

    private final By welcome = By.tagName("h1");
    private final By checkoutbutton = By.id("checkout");
    private final By state = By.id("StateProvinceId");
    private final By read = By.className("read");
    private final By country = By.id("CountryId");
    private final By checkboxagree = By.id("termsofservice");
    private final By close = By.cssSelector("button[title='close']");


    private By productTitle(String productTitle) {
        return By.xpath("//td//a[normalize-space(text())='" + productTitle + "']");
    }


    private By productcheckbox(String productTitle) {
        return By.xpath("//td//a[normalize-space(text())='" + productTitle + "']"
                + "/ancestor::tr[contains(@class,'cart-item-row')]//input[@type='checkbox']");
    }

    private By productsizecolor(String productTitle) {
        return By.xpath("//td//a[normalize-space(text())='" + productTitle + "']"
                + "/ancestor::tr[contains(@class,'cart-item-row')]//div[@class='attributes']");
    }


    private By productprice(String productTitle) {
        return By.xpath("//td//a[normalize-space(text())='" + productTitle + "']"
                + "/ancestor::tr[contains(@class,'cart-item-row')]//td[contains(@class,'unit-price')]");
    }


    private By productquantity(String productTitle) {
        return By.xpath("//td//a[normalize-space(text())='" + productTitle + "']"
                + "/ancestor::tr[contains(@class,'cart-item-row')]//input[contains(@class,'qty-input')]");
    }


    private By producttotal(String productTitle) {
        return By.xpath("//td//a[normalize-space(text())='" + productTitle + "']"
                + "/ancestor::tr[contains(@class,'cart-item-row')]//span[contains(@class,'product-subtotal')]");
    }


    private By productedit(String productTitle) {
        return By.xpath("//td//a[normalize-space(text())='" + productTitle + "']"
                + "/ancestor::tr[contains(@class,'cart-item-row')]//div[contains(@class,'edit-item')]//a[normalize-space()='Edit']");
    }

    private By cartbuttons(String Name) {
        return By.cssSelector("input[value= '" + Name + "']");
    }

    private By cartinputfields(String Name) {
        return By.cssSelector("input[name= '" + Name + "']");
    }

    @Step("Click on checkout button")
    public Checkout1 clickoncheckoutbutton() {
        driver.element().click(checkoutbutton);
        return new Checkout1(driver);
    }
    @Step("Click on close button")
    public CartPage clickonclosebutton() {
        driver.element().click(close);
        return this;
    }

    @Step("select Country")
    public CartPage selectcountry(String Name) {
        driver.element().selectfromdropdown(country, Name);
        return this;
    }

    @Step("select state")
    public CartPage selectstate(String Name) {
        driver.element().selectfromdropdown(state, Name);
        return this;
    }

    @Step("Click on read ")
    public CartPage clickonread() {
        driver.element().click(read);
        return this;
    }

    @Step("Click on checkbox agree ")
    public CartPage clickoncheckbox() {
        driver.element().click(checkboxagree);
        return this;
    }

    @Step("Click on checkbox ")
    public CartPage clickonproductcheckbox(String productTitle) {
        driver.element().click(productcheckbox(productTitle));
        return this;
    }

    @Step("Click on Update shopping cart ")
    public CartPage clickonUpdatecart(String Name) {
        driver.element().click(cartbuttons(Name));
        return this;
    }

    @Step("Click on continue shopping ")
    public ProductsPage clickoncontinueshopping(String Name) {
        driver.element().click(cartbuttons(Name));
        return new ProductsPage(driver);
    }

    @Step("Click on apply coupon ")
    public CartPage clickoncopoun(String Name) {
        driver.element().click(cartbuttons(Name));
        return this;
    }

    @Step("Click on add gift ")
    public CartPage clickonaddgift(String Name) {
        driver.element().click(cartbuttons(Name));
        return this;
    }

    @Step("Click on estimate shipping ")
    public CartPage clickonshipping(String Name) {
        driver.element().click(cartbuttons(Name));
        return this;
    }

    @Step("click on product Title")
    public ProductDetailsPage clickonproducttitle(String productTitle) {
        driver.element().click(productTitle(productTitle));
        return new ProductDetailsPage(driver);
    }

    @Step("click on edit ")
    public ProductDetailsPage clickonedit(String productTitle) {
        driver.element().click(productedit(productTitle));
        return new ProductDetailsPage(driver);
    }

    @Step("Type Discount Code")
    public CartPage typeDiscountCode(String id, String Name) {
        driver.element().type(cartinputfields(id), Name);
        return this;
    }

    @Step("Type Gift Cards")
    public CartPage typegiftcard(String id, String Name) {
        driver.element().type(cartinputfields(id), Name);
        return this;
    }

    @Step("Type postal code")
    public CartPage typepostalcode(String id, String Name) {
        driver.element().type(cartinputfields(id), Name);
        return this;
    }


    @Step("Get Welcome Text")
    public CartPage verifywelcometext() {
        driver.hardAssert().iselementvisible(welcome);
        return this;
    }

    @Step("change quantity")
    public CartPage changequantity(String productTitle, String no ) {

        driver.element().type(productquantity(productTitle),no);
        return this;
    }


    @Step("verify product qty and total")
    public CartPage verifyproductpriceandnameqtytotal(String productTitle, String expectedPrice, String quantity, String total) {
        String actualname = driver.element().getText(productTitle(productTitle));
        String actualprice = driver.element().getText(productprice(productTitle));
        String actualqty = driver.element().getAttribute(productquantity(productTitle));
        String actualtotal = driver.element().getText(producttotal(productTitle));
        driver.softAssert().Equals(actualname, productTitle, "Product name is not as expected");
        driver.softAssert().Equals(actualprice, expectedPrice, "Product price is not as expected");
        driver.softAssert().Equals(actualqty, quantity, "Product qty is not as expected");
        driver.softAssert().Equals(actualtotal, total, "Product total is not as expected");
        driver.softAssert().assertAll();

        return this;
    }

    @Step("verify product size and color")
    public CartPage verifyproductsizeandcolor(String productTitle, String expectedsizecolor) {
        String actualsizecolor = driver.element().getText(productsizecolor(productTitle));

        // Normalize format: replace newlines with comma + space
        actualsizecolor = actualsizecolor.replace("\n", ", ").trim();

        driver.hardAssert().Equals(actualsizecolor, expectedsizecolor,
                "Product size and color is not as expected");

        return this;
    }

}

