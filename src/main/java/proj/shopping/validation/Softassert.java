package proj.shopping.validation;

import proj.shopping.utils.logs.LogsManager;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class Softassert extends Base {
    private static SoftAssert softAssert = new SoftAssert();
    private static boolean used = false; // Flag to track usage

    public Softassert(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void asserttrue(boolean condition, String message) {
        used = true;
        softAssert.assertTrue(condition, message);
    }

    @Override
    protected void assertfalse(boolean condition, String message) {
        used = true;
        softAssert.assertFalse(condition, message);
    }

    @Override
    protected void assertEquals(String actual, String expected, String message) {
        used = true;
        softAssert.assertEquals(actual, expected, message);
    }


    public static void assertAll() {
        if (!used) return; // If no assertions were made, do nothing
        try {
            softAssert.assertAll();
        } catch (AssertionError e) {
            LogsManager.error("Assertion failed:", e.getMessage());
            throw e;
        } finally {
            softAssert = new SoftAssert(); // Reset the soft assert instance
        }
    }

}
