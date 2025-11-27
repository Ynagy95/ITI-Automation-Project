package proj.shopping.pages.components.system;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import proj.shopping.drivers.Driver;

public class Footer {
    private final Driver driver;


    public Footer(Driver driver) {
        this.driver = driver;


    }
    private final By address = By.xpath("(//a[text()='Addresses'])[2]");
    private By words(String word){
        return By.xpath("//a[text()='"+ word +"']");
    }

    @Step("click on words")

    public Footer clickonwords(String text) {
        driver.element().click(words(text));
        return this;

    }
    @Step("click on Address")

    public Address clickonaddress() {
        driver.element().click(address);
        return new Address(driver);

    }


}
