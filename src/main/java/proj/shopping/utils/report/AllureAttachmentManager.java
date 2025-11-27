package proj.shopping.utils.report;

import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import proj.shopping.media.ScreenRecordManager;
import proj.shopping.utils.logs.LogsManager;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import static proj.shopping.utils.datareader.PropertyReader.getProperty;

public class AllureAttachmentManager {

    public static void attachScreenshot(String name, String path) {
        try {
            Path screenshot = Path.of(path);
            if (Files.exists(screenshot)) {
                Allure.addAttachment(name, Files.newInputStream(screenshot));
                LogsManager.info("Attached screenshot: " + name);
            } else {
                LogsManager.error("Screenshot not found: " + path);
            }
        } catch (Exception e) {
            LogsManager.error("Error attaching screenshot", e.getMessage());
        }
    }

    public static void attachLogs() {
        try {
            LogManager.shutdown();
            File logFile = Path.of(LogsManager.LOGS_PATH, "logs.log").toFile();
            ((LoggerContext) LogManager.getContext(false)).reconfigure();

            if (logFile.exists()) {
                Allure.attachment("logs.log", Files.readString(logFile.toPath()));
                LogsManager.info("Attached logs successfully.");
            } else {
                LogsManager.warn("Log file not found: " + logFile.getAbsolutePath());
            }
        } catch (Exception e) {
            LogsManager.error("Error attaching logs", e.getMessage());
        }
    }

    public static void attachRecords(String testMethodName) {
        if (getProperty("recordTests").equalsIgnoreCase("true")) {
            try {
                File record = new File(ScreenRecordManager.RECORDINGS_PATH + testMethodName + ".mp4");
                if (record.exists() && record.isFile()) {
                    Allure.addAttachment(testMethodName, "video/mp4", Files.newInputStream(record.toPath()), ".mp4");
                    LogsManager.info("Attached recording: " + record.getName());
                } else {
                    LogsManager.warn("No video found for test: " + testMethodName);
                }
            } catch (Exception e) {
                LogsManager.error("Error attaching records", e.getMessage());
            }
        }
    }
}
