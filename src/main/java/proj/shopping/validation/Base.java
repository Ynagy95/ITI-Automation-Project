package proj.shopping.validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import proj.shopping.utils.Wait;
import proj.shopping.utils.actions.ElementActions;



public abstract class Base {


    protected ElementActions elementActions;
    protected final Wait wait;
    protected final WebDriver driver;
    private static SoftAssert softAssert = new SoftAssert();

    protected Base( WebDriver driver) {
        this.elementActions = new ElementActions(driver);
        this.driver = driver;
        this.wait = new Wait(driver);
    }

 protected abstract void asserttrue(boolean condition, String message);
    protected abstract void assertfalse(boolean condition, String message);
    protected abstract void assertEquals(String actual, String expected, String message);

    public void Equals(String actual, String expected, String message) {
        assertEquals(actual, expected, message);
    }
    public void assertpageurlsoft(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        softAssert.assertEquals(actualUrl, expectedUrl,
                "Page URL does not match. Expected: " + expectedUrl + ", but got: " + actualUrl);
    }

    public void iselementvisible(By locator) {
        boolean flag = wait.fluentWait().until(driver1 ->
        {
            try {
                driver1.findElement(locator).isDisplayed();
                return true;
            } catch (Exception e) {
                return false;
        }



});
    asserttrue(flag, "Element is not visible: " + locator);
        }

        //verify page url
        public void assertpageurl(String expectedUrl) {
            String actualUrl = driver.getCurrentUrl();
            assertEquals(actualUrl, expectedUrl, "Page URL does not match. Expected: " + expectedUrl + ", but got: " + actualUrl);
        }

        //verify page title
        public void assertpagetitle(String expectedTitle) {
            String actualTitle = driver.getTitle();
            assertEquals(actualTitle, expectedTitle, "Page title does not match. Expected: ");
}

}