package proj.shopping.pages.components.system;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import proj.shopping.drivers.Driver;

public class AddReview {
    private Driver driver;
    public NavigationBar navg ;
    public ProductsPage productspage;
    public AddReview(Driver driver) {
        this.driver = driver;
        this.navg = new NavigationBar(driver);
        this.productspage = new ProductsPage(driver);
    }

    private final By Reviewtitle = By.id("AddProductReview_Title");
    private final By Reviewtext = By.id("AddProductReview_ReviewText");
    private final By verifyword = By.xpath("//strong[text()=\"Existing reviews\"]");
    private final By button = By.xpath("//input[@value=\"Submit review\"]");
    private final By errormessage = By.xpath("//li[text()=\"Only registered users can write reviews\"]");
    private final By Reviewtitleerror = By.xpath("//span[text()=\"Review title is required.\"]");
    private final By Reviewtexterror = By.xpath("//span[text()=\"Review text is required.\"]");
    private final By successmessage = By.cssSelector("div.result");


    private By ratingOption(String value) {
        return By.xpath("//input[@name='AddProductReview.Rating' and @value='" + value + "']");
    }

    @Step("Get Welcome Text")
    public AddReview verifywelcometext(){
        driver.hardAssert().iselementvisible(verifyword);
        return this;

    }
    @Step("Enter Reviewtitle")
    public AddReview FillReviewtext(String Reviewtext1) {
        driver.element().type(Reviewtext, Reviewtext1);

        return this;
    }
    @Step("Enter Reviewtitle")
    public AddReview FillReviewtitle(String Reviewtitle1) {
        driver.element().type(Reviewtitle, Reviewtitle1);

        return this;
    }
    @Step("Click on ratingOption")
    public AddReview clickonratingOption(String value) {
        driver.element().click(ratingOption(value));
        return this;
    }

    @Step("Click on send Button")
    public AddReview clickonsubmitbutton() {
        driver.element().click(button);
        return this;
    }
    @Step("Get sucess Text")
    public AddReview verifysucessmessage(){
        driver.hardAssert().iselementvisible(successmessage);
        return this;

    }

    @Step("verify message is displayed")
    public AddReview messagedisplayed(String expectedtext){
        String actualtext=driver.element().getText(errormessage);
        driver.hardAssert().Equals(actualtext, expectedtext, "Error Text doesn't match");
        return this;


    }
    @Step("verify error message is displayed")
    public AddReview errormessage1displayed(String expectedtext){
        String actualtext=driver.element().getText(Reviewtitleerror);
        driver.hardAssert().Equals(actualtext, expectedtext, "Error Text doesn't match");
        return this;


    }
    @Step("verify error message is displayed")
    public AddReview errormessage2displayed(String expectedtext){
        String actualtext=driver.element().getText(Reviewtexterror);
        driver.hardAssert().Equals(actualtext, expectedtext, "Error Text doesn't match");
        return this;


    }


}
