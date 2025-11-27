package proj.shopping.validation;

import junit.framework.Assert;
import org.openqa.selenium.WebDriver;

public class HardAssert extends Base {

    public HardAssert(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void asserttrue(boolean condition, String message) {
        Assert.assertTrue(message, condition);
    }

    @Override
    protected void assertfalse(boolean condition, String message) {
        Assert.assertFalse(message, condition);
    }

    @Override
    protected void assertEquals(String actual, String expected, String message) {
        Assert.assertEquals(message, expected, actual);
    }
}
