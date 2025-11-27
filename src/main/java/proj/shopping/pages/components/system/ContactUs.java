package proj.shopping.pages.components.system;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import proj.shopping.drivers.Driver;

public class ContactUs {
    private Driver driver;



    public ContactUs(Driver driver) {
        this.driver = driver;
    }
    private final By name = By.id("FullName");
    private final By email= By.className("Email");
    private final By message = By.id("Enquiry");
    private final By button = By.cssSelector("input[name=\"send-email\"]");
    private final By successmessage =By.cssSelector("div.result");


    @Step("Enter emails")
    public ContactUs Fillpage( String messagee) {

        driver.element().type(message,messagee);

        return this;
    }
    @Step("Click on send Button")
    public ContactUs clickonsubmit() {
        driver.element().click(button);
        return this;
    }
    @Step("verify message is displayed")
    public ContactUs messagedisplayed(String expectedtext){
        String actualtext=driver.element().getText(successmessage);
        driver.hardAssert().Equals(actualtext, expectedtext, "Error Text doesn't match");
        return this;


    }

}
