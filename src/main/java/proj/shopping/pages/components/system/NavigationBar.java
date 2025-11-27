package proj.shopping.pages.components.system;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import proj.shopping.drivers.Driver;
import proj.shopping.pages.components.loginorregister.LoginPage;
import proj.shopping.pages.components.loginorregister.SignUpPage;
import proj.shopping.utils.datareader.PropertyReader;
import proj.shopping.utils.logs.LogsManager;

public class NavigationBar {
    private final Driver driver;


    public NavigationBar(Driver driver) {
        this.driver = driver;


    }

    private final By home = By.cssSelector("img[alt=\"Tricentis Demo Web Shop\"]");
    private final By registerbutton = By.xpath("//a[text()='Register']");
    private final By loginbutton = By.xpath("//a[.='Log in']");
    private final By cart = By.cssSelector("li#topcartlink > a.ico-cart[href=\"/cart\"]");
    private final By firstWishlist = By.cssSelector("div.header-links a.ico-wishlist[href=\"/wishlist\"]");
    private final By books = By.cssSelector("ul.top-menu > li > a[href=\"/books\"]");
    private final By computers = By.cssSelector("ul.top-menu > li > a[href=\"/computers\"]");
    private final By electronics = By.cssSelector("ul.top-menu > li > a[href=\"/electronics\"]");
    private final By apparelshoes = By.cssSelector("ul.top-menu > li > a[href=\"/apparel-shoes\"]");
    private final By digitaldownloads = By.cssSelector("ul.top-menu > li > a[href=\"/digital-downloads\"]");
    private final By jewelry = By.cssSelector("ul.top-menu > li > a[href=\"/jewelry\"]");
    private final By giftcards = By.cssSelector("ul.top-menu > li > a[href=\"/gift-cards\"]");
    private final By customerlabel = By.xpath("(//a[@href='/customer/info'])[1]");
    private final By logoutbutton = By.xpath("//a[text()=\"Log out\"]");
    private final By welcome = By.className("topic-html-content-header");
    private final By Tricentis = By.cssSelector("a[href=\"/tricentis\"]");
    private final By newsletteremail = By.cssSelector("input#newsletter-email");
    private final By newsletterbutton = By.cssSelector("input#newsletter-subscribe-button");
    private final By verifynewslettermessage = By.id("newsletter-result-block");
    private final By searchbar = By.cssSelector("input#small-searchterms");
    private final By searchbutton = By.cssSelector("input[value=\"Search\"]");



    private By topMenu(String menuName) {
        return By.xpath("//ul[@class='top-menu']//a[normalize-space(text())='" + menuName + "']");
    }
    private By subMenu(String submenuName) {
        return By.xpath("//ul[@class='top-menu']//a[normalize-space(text())='" + submenuName + "']");
    }
    private By populartags(String name) {
        return By.xpath("//a[normalize-space(text())= '" + name + "']");
    }

    public NavigationBar hoverAndClick(String mainMenu, String Menusub) {
        driver.element().hover(topMenu(mainMenu));
        driver.element().click(subMenu(Menusub));
        return this;


    }




    @Step("Navigate to Home Page")
    public NavigationBar navigate(){

        driver.browser().navigateto(PropertyReader.getProperty("baseUrlWeb"));
        return this;

    }


    @Step ("click on Home Button")
    public NavigationBar clickonhomebutton(){

        driver.element().click(home);
        return this;
    }

    @Step ("click on Cart Button")
    public CartPage clickoncartbutton(){

        driver.element().click(cart);
        return new CartPage(driver);
    }

    @Step ("click on Register Button")
    public SignUpPage clickonregisterbutton(){

        driver.element().click(registerbutton);
        return new SignUpPage(driver);
    }
    @Step ("click on Login Button")
    public LoginPage clickonloginbutton(){

        driver.element().click(loginbutton);
        return new LoginPage(driver);
    }

    @Step ("click on Logout Button")
    public NavigationBar clickonlogoutbutton(){

        driver.element().click(logoutbutton);
        return this;
    }
    @Step ("click on popular tags")
    public NavigationBar clickonpopulartags(String name){
        driver.element().click(populartags(name));
        return this;
    }


    @Step ("click on Whishlist Button")
    public Whishlist clickonwhishlistbutton(){

        driver.element().click(firstWishlist);
        return new Whishlist(driver);
    }

    public CustomerInfo clickoncustomerbutton(){

        driver.element().click(customerlabel);
        return new CustomerInfo(driver);
    }
    @Step ("click on Books Button")
    public ProductsPage clickonbooksbutton() {
        driver.element().click(books);
        return new ProductsPage(driver);
    }
    @Step ("click on Computers Button")
    public ComElecFirstPage clickoncomputersbutton(){
        driver.element().click(computers);
        return new ComElecFirstPage(driver);
        }
    @Step ("click on ElectronicsButton")
    public ComElecFirstPage clickonelectronicsbutton(){
        driver.element().click(electronics);
        return new ComElecFirstPage (driver);
    }
    @Step ("click on Apparel & Shoes Button")
    public ProductsPage clickonapparelshoesbutton(){
        driver.element().click(apparelshoes);
        return new ProductsPage(driver);
    }
    @Step ("click on Digital Downloads Button")
    public ProductsPage clickondigitaldownloadsbutton(){
        driver.element().click(digitaldownloads);
        return new ProductsPage(driver);
    }
    @Step ("click on Jewelry Button")
    public ProductsPage clickonjewelrybutton(){
        driver.element().click(jewelry);
        return new ProductsPage(driver);
    }
    @Step ("click on Gift Cards Button")
    public ProductsPage clickongiftcardsbutton(){
        driver.element().click(giftcards);
        return new ProductsPage(driver);
    }

    @Step ("Enter Newsletter Email")
    public NavigationBar enternewsletteremail(String mail){
        driver.element().type(newsletteremail, mail);
        return this;
    }
    @Step ("click on Newsletter Button")
    public NavigationBar clickonnewsletterbutton(){
        driver.element().click(newsletterbutton);
        return this;
    }

    @Step("Enter Search Text")
    public NavigationBar entersearchtext(String searchtext){
        driver.element().type(searchbar, searchtext);
        driver.element().click(searchbutton);
        return this;
    }


    @Step ("verify Newsletter Result Block")
    public NavigationBar verifynewslettermessage() {
        driver.hardAssert().iselementvisible(verifynewslettermessage);
        return this;

    }

    //validations
    @Step ("verify Welcome Text")
    public NavigationBar verifywelcometext(){
        driver.hardAssert().iselementvisible(welcome);
        return this;
    }
    @Step("verify Customer Info Label")
    public NavigationBar verifycustomerlabel(String expectedname) {
        String actualname = driver.element().getText(customerlabel);
        LogsManager.info("verifying customer label: " + actualname);
        driver.hardAssert().Equals(actualname, expectedname, "Customer label does not match. Expected: " + expectedname + ", but got: " + actualname);
        return this;


    }






}
