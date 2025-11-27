package proj.shopping.pages.components.system;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import proj.shopping.drivers.Driver;

public class Whishlist {
    private final Driver driver;


    public Whishlist(Driver driver) {
        this.driver = driver;


    }

    private final By welcome = By.tagName("h1");

    private By productTitle(String productTitle) {
        return By.xpath("//td//a[normalize-space(text())='" + productTitle + "']");
    }


    private By addtocartcheckbox(String productTitle) {
        return By.xpath("//td//a[normalize-space(text())='" + productTitle + "']"
                + "/ancestor::tr[contains(@class,'cart-item-row')]//input[@name='addtocart']");
    }
    private By removecheckbox(String productTitle) {
        return By.xpath("//td//a[normalize-space(text())='" + productTitle + "']"
                + "/ancestor::tr[contains(@class,'cart-item-row')]//input[@name='removefromcart']");
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
    @Step("Click on add to cart coupon ")
    public CartPage clickonaddtocart(String Name) {
        driver.element().click(cartbuttons(Name));
        return new CartPage(driver);
    }
    @Step("Click on add to cart coupon ")
    public EmailFriend clickonemailfriend(String Name) {
        driver.element().click(cartbuttons(Name));
        return new EmailFriend(driver);
    }
    @Step("Click on Update shopping cart ")
    public Whishlist clickonUpdatecart(String Name) {
        driver.element().click(cartbuttons(Name));
        return this;
    }

    @Step("click on edit ")
    public Whishlist clickonedit(String productTitle) {
        driver.element().click(productedit(productTitle));
        return this;
    }
    @Step("Click on checkbox ")
    public Whishlist clickonaddtocartcheckbox(String productTitle) {
        driver.element().click(addtocartcheckbox(productTitle));
        return this;
    }
    @Step("Click on checkbox ")
    public Whishlist clickonremovecheckbox(String productTitle) {
        driver.element().click(removecheckbox(productTitle));
        return this;
    }



    @Step("Get Welcome Text")
    public Whishlist verifywelcometext() {
        driver.hardAssert().iselementvisible(welcome);
        return this;
    }

    @Step("verify product qty and total")
    public Whishlist verifyproductpriceandnameqtytotal(String productTitle, String expectedPrice, String quantity, String total) {
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



}
