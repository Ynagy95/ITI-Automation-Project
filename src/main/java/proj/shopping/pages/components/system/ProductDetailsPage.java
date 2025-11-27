package proj.shopping.pages.components.system;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import proj.shopping.drivers.Driver;

public class ProductDetailsPage {
    private Driver driver;
    public NavigationBar navg ;
    public ProductsPage productspage;
    public ProductDetailsPage(Driver driver) {
        this.driver = driver;
        this.navg = new NavigationBar(driver);
        this.productspage = new ProductsPage(driver);
    }


    private final By addreview = By.xpath("//a[text()=\"Add your review\"]");
    private final By emailfriend = By.cssSelector("input[value=\"Email a friend\"]");
    private final By comparelist = By.xpath("//input[@value=\"Add to compare list\"]");
    private final By wishlist = By.xpath("//input[@value=\"Add to wishlist\"]");
    private final By textverify = By.cssSelector("div.short-description");
    private final By addtocartmessage = By.xpath("//p[contains(text(),'The product has been added to your')] | //p//a[text()='shopping cart']");
    private final By addtowhishlistamessage = By.xpath("//p[contains(text(),'The product has been added to your')] | //p//a[text()='wishlist']");
    private final By addtowhishlisterrormessage = By.xpath("//p[contains(text(),'Your quantity exceeds stock on hand. The maximum quantity that can be added is 1.')] ");
    private final By close = By.cssSelector("span.close");
    private final By next = By.xpath("//button[@title=\"Next (Right arrow key)\"]");
    private final By back = By.xpath("//button[@title=\"Previous (Left arrow key)\"]");
    private final By coverimg = By.xpath("//img[@class=\"mfp-img\"]");
    private final By closecover = By.xpath("//button[@title=\"Close (Esc)\"]");
    private final By Downloadsample = By.xpath("//a[text()='Download sample']");
    private final By emptyfieldserror = By.cssSelector("#bar-notification p.content");
    private final By shoppingcart = By.cssSelector("p.content >a[href=\"/cart\"]");


//dynamic locators
private By productTitle(String productTitle) {
    return By.xpath("//h1[normalize-space(text())= '" + productTitle + "']");
}
    private By productprice(String productTitle) {
        return By.xpath("//h1[normalize-space(text())= '" + productTitle + "']/ancestor::div[contains(@class,'product-essential')]   //div[@class='product-price']//span[starts-with(@class, 'price-value')]");
    }
    private By addtocartbutton(String productTitle) {
        return By.xpath("//h1[normalize-space(text())= '" + productTitle + "']/ancestor::div[contains(@class,'product-essential')]   //div[@class='add-to-cart']//input[starts-with(@class, 'button-1 add-to-cart-button')]");
    }
    private By productReviewLink(String productId) {
        return By.xpath("//a[@href='/productreviews/" + productId + "']");
    }

    private By addtocartbutton2(String productTitle) {
        return By.xpath("//h2[@class='product-title']/a[text()='" + productTitle + "']/ancestor::div[contains(@class,'item-box')]//input[@value='Add to cart']");
    }
    private By addtocartbutton3(String productTitle) {
        return By.xpath("//div[normalize-space(text())= '" + productTitle + "']/ancestor::div[@class='product-variant-line']//input[@value='Add to cart']");
    }
    private By productprice3(String productTitle) {
        return By.xpath("//div[normalize-space(text())= '" + productTitle + "']/ancestor::div[@class='product-variant-line']//span[starts-with(@class, 'price-value')]");
    }
    private By productTitle3(String productTitle) {
        return By.xpath("//div[normalize-space(text())= '" + productTitle + "']");
    }
    private By dropdown(String id) {
        return By.id("product_attribute_" + id);
    }
    private By Pendant(String value) {
        return By.xpath("//label[normalize-space(text())= '" + value + "']");
    }

    private By HDD(String value) {
        return By.xpath("//label[text()='" + value + "']");
    }
    private By os(String value) {
        return By.xpath("//label[text()='" + value + "']");
    }
    private By software(String value) {
        return By.xpath("//label[text()='" + value + "']");
    }
    private By processorradio(String value) {
        return By.xpath("//label[text()='" + value + "']");
    }
    private By ramradio(String value) {
        return By.xpath("//label[text()='" + value + "']");
    }


    private By wordsuggestion(String value) {
        return By.xpath("//a[normalize-space(text())='" + value +"']");
    }
    private By cover(String value) {
        return By.xpath("//img[@src='https://demowebshop.tricentis.com/content/images/thumbs/" + value + "']");
    }


    private By quantity(String productId) {
        return By.id("addtocart_" + productId + "_EnteredQuantity");
    }
    private By Colorshoes(String value) {
        return By.xpath("//span[@title='" + value +"']");
    }

    private By giftcard(String id) {
        return By.id(id);
    }



    @Step("Click on Add to Cart Button")
    public ProductDetailsPage clickonaddtocartbutton(String productTitle) {
        driver.element().click(addtocartbutton(productTitle));
        return this;
    }
    @Step("Click on productReviewLink")
    public ProductDetailsPage clickonproductReviewLink(String productId) {
        driver.element().click(productReviewLink(productId));
        return this;
    }

    @Step("Click on Add to Cart Button")
    public ProductDetailsPage clickonaddtocartbutton2(String productTitle) {
        driver.element().click(addtocartbutton2(productTitle));
        return this;
    }

    @Step("Click on  cover images")
    public ProductDetailsPage clickoncoverimg(String value) {
        driver.element().click(cover(value));
        return this;
    }

    @Step("Click on Add to Cart Button")
    public ProductDetailsPage clickonaddtocartbutton3(String productTitle) {
        driver.element().click(addtocartbutton3(productTitle));
        return this;
    }
    @Step("close message")
    public ProductDetailsPage closemessage() {
        driver.element().click(close);
        return this;
    }
    @Step("click mobile cover")
    public ProductDetailsPage clickoncoverimg() {
        driver.element().click(coverimg);
        return this;
    }
    @Step("change mobile cover")
    public ProductDetailsPage clickonnext() {
        driver.element().click(next);
        return this;
    }
    @Step("change mobile cover")
    public ProductDetailsPage clickonback() {
        driver.element().click(back);
        return this;
    }

    @Step("close mobile cover")
    public ProductDetailsPage closecover() {
        driver.element().click(closecover);
        return this;
    }
    @Step("Click on suggestion word")
    public ProductDetailsPage clicksuggestionword(String suggestion) {
        driver.element().click(wordsuggestion(suggestion));
        return this;
    }

    @Step("Click emailfriend")
    public EmailFriend clickemailfriend() {
        driver.element().click(emailfriend);
        return new EmailFriend(driver);
    }
    @Step("Click comparelist")
    public CompareProducts clickcomparelist() {
        driver.element().click(comparelist);
        return new CompareProducts(driver);
    }
    @Step("Click wishlist")
    public ProductDetailsPage clickwishlist() {
        driver.element().click(wishlist);
        return this;
    }
    @Step("Click addreview ")
    public AddReview clickaddreview() {
        driver.element().click(addreview);
        return new AddReview(driver);
    }


    @Step("change quantity")
    public ProductDetailsPage changequantity(String productId, String no ) {

        driver.element().type(quantity(productId),no);
        return this;
    }
    @Step("Type tshirt text")
    public ProductDetailsPage typetshirt(String id,String Name) {
        driver.element().type(dropdown(id), Name);
        return this;
    }
    @Step("Type tshirt text")
    public ProductDetailsPage typejewerylength(String id,String Name) {
        driver.element().type(dropdown(id), Name);
        return this;
    }

    @Step("select ram")
    public ProductDetailsPage selectramdropdown(String id,String Name) {
        driver.element().selectfromdropdown(dropdown(id), Name);
        return this;
    }
    @Step("select Processor")
    public ProductDetailsPage selectprocessordropdown(String id,String Name) {
        driver.element().selectfromdropdown(dropdown(id), Name);
        return this;
    }
    @Step("select Manufacturer")
    public ProductDetailsPage selectManufacturerdropdown(String id,String Name) {
        driver.element().selectfromdropdown(dropdown(id) , Name);
        return this;
    }
    @Step("select Color")
    public ProductDetailsPage selectRAMdropdown(String id,String Name) {
        driver.element().selectfromdropdown(dropdown(id) , Name);
        return this;
    }
    @Step("Click on HDD")
    public ProductDetailsPage clickonrhddradio(String value) {
        driver.element().click(HDD(value));
        return this;
    }
    @Step("Click on OS")
    public ProductDetailsPage clickonosdradio(String value) {
        driver.element().click(os(value));
        return this;
    }
    @Step("Click on Software")
    public ProductDetailsPage clickonsoftware(String value) {
        driver.element().click(software(value));
        return this;
    }
    @Step("Click on processor radio button")
    public ProductDetailsPage clickonprocessorradio(String value) {
        driver.element().click(processorradio(value));
        return this;
    }
    @Step("Click on RAM radio button")
    public ProductDetailsPage clickonramradio(String value) {
        driver.element().click(ramradio(value));
        return this;
    }
    @Step("Click on shoes color")
    public ProductDetailsPage clickonshoescolor(String value) {
        driver.element().click(Colorshoes(value));
        return this;
    }
    @Step("select size")
    public ProductDetailsPage selectsize(String id,String Name) {
        driver.element().selectfromdropdown(dropdown(id) , Name);
        return this;
    }
    @Step("click Download sample")
    public ProductDetailsPage clickDownloadsample() {
        driver.element().click(Downloadsample);
        return this;
    }
    @Step("Click on Pendant")
    public ProductDetailsPage clickonPendant(String value) {
        driver.element().click(Pendant(value));
        return this;
    }
    @Step("select Material")
    public ProductDetailsPage selectmaterial(String id,String Name) {
        driver.element().selectfromdropdown(dropdown(id) , Name);
        return this;
    }
    @Step("Type Gift card info")
    public ProductDetailsPage typegiftcardinfo(String id,String Name) {
        driver.element().type(giftcard(id), Name);
        return this;
    }
    @Step("Click on shoppingcart")
    public CartPage clickonshoppingcart() {
        driver.element().click(shoppingcart);
        return new CartPage(driver);
    }






    //verifications
    @Step("Get Welcome Text")
    public ProductDetailsPage verifywelcometext() {
        driver.hardAssert().iselementvisible(textverify);
        return this;
    }
    @Step(" add to cart error message")
    public ProductDetailsPage verifyaddtocartmessageerror(String expectedmessage) {
    String actualErrors = String.join(", ", driver.element().getTexts(emptyfieldserror));
        driver.hardAssert().Equals(actualErrors, expectedmessage, "Add to cart message is not as expected");
        return this;
    }
    @Step("Get add to cart message")
    public ProductDetailsPage verifyaddtocartmessage(String expectedmessage) {
        String actualmessage = driver.element().getText(addtocartmessage);
        driver.hardAssert().Equals(actualmessage, expectedmessage, "Add to cart message is not as expected");
        return this;
    }
    @Step("Get add to cart message")
    public ProductDetailsPage verifywishlistmessageerror(String expectedmessage) {
        String actualmessage = driver.element().getText(addtowhishlisterrormessage);
        driver.hardAssert().Equals(actualmessage, expectedmessage, "Add to cart message is not as expected");
        return this;
    }


    @Step("Get add to wishlist message")
    public ProductDetailsPage verifyaddtowishlistmessage(String expectedmessage) {
        String actualmessage = driver.element().getText(addtowhishlistamessage);
        driver.hardAssert().Equals(actualmessage, expectedmessage, "Add to cart message is not as expected");
        return this;
    }

    @Step("verify product price and name")
    public ProductDetailsPage verifyproductpriceandname(String productTitle, String price) {
        String actualname = driver.element().getText(productTitle(productTitle));
        String actualprice = driver.element().getText(productprice(productTitle));
        driver.softAssert().Equals(actualname, productTitle, "Product name is not as expected");
        driver.softAssert().Equals(actualprice, price, "Product price is not as expected");
        driver.softAssert().assertAll();

        return this;
    }
    @Step("verify product price and name")
    public ProductDetailsPage verifyproductpriceandname3(String productTitle, String price) {
        String actualname = driver.element().getText(productTitle3(productTitle));
        String actualprice = driver.element().getText(productprice3(productTitle));
        driver.softAssert().Equals(actualname, productTitle, "Product name is not as expected");
        driver.softAssert().Equals(actualprice, price, "Product price is not as expected");
        driver.softAssert().assertAll();

        return this;
    }






}
