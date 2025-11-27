package proj.shopping.pages.components.system;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import proj.shopping.drivers.Driver;

public class CustomerInfo {
    private Driver driver;
    public CustomerInfo(Driver driver) {
        this.driver = driver;
    }

    private final By genderMale = By.id("gender-male");
    private final By genderFemale = By.id("gender-female");
    private final By firstName = By.id("FirstName");
    private final By lastName = By.id("LastName");
    private final By email = By.id("Email");
    private final By registerButton = By.cssSelector("input[value='Save']");
    private final By existemail = By.className("validation-summary-errors");

    @Step("Fill Registration Form")
    public CustomerInfo fillform(String gender, String fname, String lname) {
        if (gender == null || gender.isBlank()) {
            return this;
        }
        if (gender.equalsIgnoreCase("male")) {
            driver.element().click(genderMale);
        } else if (gender.equalsIgnoreCase("female")) {
            driver.element().click(genderFemale);
        }
        driver.element().type(firstName, fname);
        driver.element().type(lastName, lname);
        return this;
    }
    @Step("Click on Save Button")
    public CustomerInfo clickonsavebutton() {
        driver.element().click(registerButton);
        return this;
    }
    @Step("Verify Exist email Error Message")
    public CustomerInfo verifyfirstnameerror(String expectedfirstnameerror) {
        String actualfirstnameerror = driver.element().getText(existemail);
        driver.hardAssert().Equals(actualfirstnameerror, expectedfirstnameerror, "First name error message does not match");
        return this;
    }
}

