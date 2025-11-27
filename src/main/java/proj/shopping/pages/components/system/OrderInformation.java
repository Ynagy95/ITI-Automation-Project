package proj.shopping.pages.components.system;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import proj.shopping.drivers.Driver;

public class OrderInformation {
    private Driver driver;



    public OrderInformation(Driver driver) {
        this.driver = driver;
    }

    //locators
    private final By welcome = By.tagName("h1");
   private final By pdfinvoice= By.cssSelector("a.button-2.pdf-order-button");
   private final By reorder = By.cssSelector("input.button-1.re-order-button");
    private final By detailsbutton = By.cssSelector("input[value='Details']");

    @Step("Verify Welcome Text on Checkout Page")
    public OrderInformation verifywelcometext() {
        driver.hardAssert().iselementvisible(welcome);
        return this;
    }
    @Step("Click on orders ")
    public OrderInformation clickonorders() {
        driver.element().click(detailsbutton);
        return this;
    }

    @Step("Click on PDF Invoice Button" )
    public OrderInformation clickonpdfinvoicebutton() {
        driver.element().click(pdfinvoice);
        return this;
    }

    @Step("Click on Reorder Button" )
    public CartPage clickonreorderbutton() {
        driver.element().click(reorder);
        return new CartPage(driver);
    }



}
