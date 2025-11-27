package proj.shopping.media;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import proj.shopping.utils.logs.LogsManager;
import proj.shopping.utils.TimeStamp;
import proj.shopping.utils.report.AllureAttachmentManager;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenshotManager {

    // Base folder for screenshots
    public static final Path SCREENSHOTS_PATH = Paths.get(System.getProperty("user.dir"), "test-output", "screenshots");

    // Automatically create a timestamped folder for each run
    private static final String RUN_TIMESTAMP = TimeStamp.getTimestamp();
    private static final Path RUN_FOLDER = SCREENSHOTS_PATH.resolve(RUN_TIMESTAMP);

    static {
        try {
            Files.createDirectories(RUN_FOLDER);
        } catch (Exception e) {
            LogsManager.error("Failed to create screenshots folder: " + e.getMessage());
        }
    }

    // Take full-page screenshot
    public static void takeFullPageScreenshot(WebDriver driver, String screenshotName) {
        try {
            File screenshotSrc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            Path screenshotPath = RUN_FOLDER.resolve(screenshotName + "--" + TimeStamp.getSimpleTimestamp() + ".png");
            FileUtils.copyFile(screenshotSrc, screenshotPath.toFile());

            AllureAttachmentManager.attachScreenshot(screenshotName, screenshotPath.toString());
            LogsManager.info("✅ Screenshot saved at: " + screenshotPath);

        } catch (Exception e) {
            LogsManager.error("❌ Failed to capture full-page screenshot: " + e.getMessage());
        }
    }

    // Take element screenshot
    public static void takeElementScreenshot(WebDriver driver, By elementSelector) {
        try {
            String ariaName = driver.findElement(elementSelector).getAccessibleName();
            File screenshotSrc = driver.findElement(elementSelector).getScreenshotAs(OutputType.FILE);

            Path screenshotPath = RUN_FOLDER.resolve(ariaName + "--" + TimeStamp.getSimpleTimestamp() + ".png");
            FileUtils.copyFile(screenshotSrc, screenshotPath.toFile());

            AllureAttachmentManager.attachScreenshot(ariaName, screenshotPath.toString());
            LogsManager.info("✅ Element screenshot saved at: " + screenshotPath);

        } catch (Exception e) {
            LogsManager.error("❌ Failed to capture element screenshot: " + e.getMessage());
        }
    }
}
