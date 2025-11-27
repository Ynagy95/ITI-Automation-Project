package proj.shopping.pages.components.system;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import proj.shopping.drivers.Driver;

public class EmailFriend {
    private Driver driver;
    public NavigationBar navg ;
    public ProductsPage productspage;
    public EmailFriend(Driver driver) {
        this.driver = driver;
        this.navg = new NavigationBar(driver);
        this.productspage = new ProductsPage(driver);
    }

    private final By welcome = By.tagName("h1");
    private final By friendemail = By.id("FriendEmail");
    private final By youremail= By.className("your-email");
    private final By messagee = By.id("PersonalMessage");
    private final By button = By.cssSelector("input[value=\"Send email\"]");
    private final By friendemailerror = By.xpath("//span[text()=\"Enter friend's email\"]");
    private final By youremailerror= By.xpath("//span[text()=\"Enter your email\"]");
    private final By wrongemail = By.xpath("//span[text()=\"Wrong email\"]");
    private final By notlogedinerror= By.xpath("//li[text()=\"Only registered customers can use email a friend feature\"]");
    private final By loggedinsuccessmessage =By.cssSelector("div.result");


    @Step("Get Welcome Text")
    public EmailFriend verifywelcometext(){
        driver.hardAssert().iselementvisible(welcome);
        return this;

    }
    @Step("Enter emails")
    public EmailFriend Fillpage(String mail,String email2, String message) {
        driver.element().type(friendemail, mail);
        driver.element().type(youremail,email2);
        driver.element().type(messagee,message);

        return this;
    }
    @Step("Enter emails")
    public EmailFriend Fillpage2(String mail, String message) {
        driver.element().type(friendemail, mail);
        driver.element().type(messagee,message);

        return this;
    }


    @Step("Click on send Button")
    public EmailFriend clickonsendemail() {
        driver.element().click(button);
        return this;
    }

    @Step("verify friend email error")
    public EmailFriend verifyfriendemailerrortext(String expectedtext){
        String actualtext=driver.element().getText(friendemailerror);
        driver.hardAssert().Equals(actualtext, expectedtext, "Error Text doesn't match");
        return this;


    }
    @Step("verify your email error")
    public EmailFriend verifyyouremailerrortext(String expectedtext){
        String actualtext=driver.element().getText(youremailerror);
        driver.hardAssert().Equals(actualtext, expectedtext, "Error Text doesn't match");
        return this;


    }
    @Step("verify your email is not in wrong format")
    public EmailFriend verifyyouremailnotwrongformaterrortext(String expectedtext){
        String actualtext=driver.element().getText(wrongemail);
        driver.hardAssert().Equals(actualtext, expectedtext, "Error Text doesn't match");
        return this;


    }
    @Step("verify message is displayed")
    public EmailFriend messagedisplayed(String expectedtext){
        String actualtext=driver.element().getText(notlogedinerror);
        driver.hardAssert().Equals(actualtext, expectedtext, "Error Text doesn't match");
        return this;


    }
    @Step("verify message is displayed")
    public EmailFriend messagedisplayed2(String expectedtext){
        String actualtext=driver.element().getText(loggedinsuccessmessage);
        driver.hardAssert().Equals(actualtext, expectedtext, "Error Text doesn't match");
        return this;


    }






}
