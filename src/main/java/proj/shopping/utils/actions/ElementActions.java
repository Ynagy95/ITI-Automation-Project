package proj.shopping.utils.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import proj.shopping.utils.Wait;
import proj.shopping.utils.logs.LogsManager;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ElementActions {


    private final WebDriver driver;
    private Wait wait;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new Wait(driver);

    }

    public WebElement click(By locator) {
        return wait.fluentWait().until(driver -> {
            try {
                WebElement element = driver.findElement(locator);

                // Wait until the element is visible and clickable
                if (element.isDisplayed() && element.isEnabled()) {
                    new Actions(driver).scrollToElement(element).perform();
                    element.click();
                    LogsManager.info("Clicked on element: " + locator);
                    return element;
                }

                return null;
            } catch (Exception e) {
                return null;
            }
        });
    }
    public WebElement clear(By locator) {
        return wait.fluentWait().until(d -> {
            try {
                WebElement element = d.findElement(locator);
                new Actions(d).scrollToElement(element).perform();
                element.clear();
                LogsManager.info("Cleared text from element: " + locator);
                return element;
            } catch (Exception e) {
                LogsManager.error("Failed to clear element: " + locator + " - " + e.getMessage());
                return null;
            }
        });
    }
    public WebElement hover(By locator) {
        return wait.fluentWait().until(d -> {
            try {
                WebElement element = d.findElement(locator);
                new Actions(d).moveToElement(element).perform();
                LogsManager.info("Hovered over element: " + locator);
                return element; // ✅ Return the hovered element
            } catch (Exception e) {
                return null;
            }
        });
    }

    public void type(By locator, String text) {
        wait.fluentWait().until(d ->
                {
                    try {
                        WebElement element = d.findElement(locator);
                        new Actions(d).scrollToElement(element);
                        element.clear();
                        element.sendKeys(text);
                        LogsManager.info("Typed text '"+ text + "' into element: " + locator);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                }
        );
    }

    public String getText(By locator) {
        return wait.fluentWait().until(d -> {
                    try {
                        WebElement element = d.findElement(locator);
                        new Actions(d).scrollToElement(element);
                        String msg = element.getText();
                        LogsManager.info("Text retrieved from element " + locator + ": " + msg);
                        return !msg.isEmpty() ? msg : null;
                    } catch (Exception e) {
                        return null;
                    }
                }
        );
    }
    public String getAttribute(By locator) {
        return wait.fluentWait().until(d -> {
            try {
                WebElement element = d.findElement(locator);
                new Actions(d).scrollToElement(element).perform();
                String value = element.getAttribute("value");
                LogsManager.info("Attribute 'value' retrieved from element " + locator + ": " + value);
                return (value != null && !value.isEmpty()) ? value : null;
            } catch (Exception e) {
                LogsManager.error("Failed to retrieve attribute 'value' from element " + locator + ": " + e.getMessage());
                return null;
            }
        });
    }

    public List<String> getTexts(By locator) {
        // Wait until at least one element is visible
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(d -> {
                    List<WebElement> elements = d.findElements(locator);
                    return !elements.isEmpty() && elements.get(0).isDisplayed();
                });

        // Collect and normalize text (remove newlines, tabs, and multiple spaces)
        return driver.findElements(locator).stream()
                .map(WebElement::getText)
                .map(text -> text.replaceAll("\\s+", " ").trim()) // normalize internal spaces and line breaks
                .filter(text -> !text.isBlank())
                .collect(Collectors.toList());
    }



//verify file is downloaded in downloads
public void verifyInvoiceDownloaded() {
    File downloadDir = new File(System.getProperty("user.home") + "/Downloads");
    File[] files = downloadDir.listFiles((dir, name) ->
            name.toLowerCase().contains("order") && name.toLowerCase().endsWith(".pdf")
    );

    if (files == null || files.length == 0) {
        throw new AssertionError("No invoice PDF found in Downloads folder.");
    }

    LogsManager.info("Invoice PDF found: " + files[0].getName());
}



    public void selectfromdropdown(By locator, String visibletext) {
        wait.fluentWait().until(d ->
                {
                    try {
                        WebElement element = d.findElement(locator);
                        new Actions(d).scrollToElement(element);
                        Select select = new Select(element);
                        select.selectByVisibleText(visibletext);
                        LogsManager.info("Selected '" + visibletext + "' from dropdown: " + locator);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                }
               );
}
}