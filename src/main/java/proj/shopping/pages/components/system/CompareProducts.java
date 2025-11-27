package proj.shopping.pages.components.system;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import proj.shopping.drivers.Driver;

public class CompareProducts {
    private Driver driver;
    public CompareProducts(Driver driver) {
        this.driver = driver;
    }
    private final By textverify = By.tagName("h1");

    private By productTitle(String productTitle) {
        return By.xpath("//td/a[normalize-space(text())= '" + productTitle + "']");
    }
    private By removebutton(String productTitle) {
            return By.xpath("//tr[@class='overview']/td[   position() = count(//tr[@class='product-name']/td[a[normalize-space()='"+productTitle+"']]/preceding-sibling::*) + 1 ]//input[@value='Remove']");
    }


    @Step("Click on productTitle Button")
    public ProductDetailsPage clickonproductTitle(String productTitle) {
        driver.element().click(productTitle(productTitle));
        return new ProductDetailsPage(driver);
    }
    @Step("Click on remove button Button")
    public CompareProducts clickonremovebutton(String productTitle) {
        driver.element().click(removebutton(productTitle));
        return this;
    }

    @Step("Get Welcome Text")
    public CompareProducts verifywelcometext() {
        driver.hardAssert().iselementvisible(textverify);
        return this;
    }
}
