package proj.shopping.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.*;
import proj.shopping.utils.FileUtils;
import proj.shopping.drivers.WebDriverProvider;
import proj.shopping.media.ScreenRecordManager;
import proj.shopping.media.ScreenshotManager;
import proj.shopping.utils.datareader.PropertyReader;
import proj.shopping.utils.logs.LogsManager;
import proj.shopping.utils.report.AllureAttachmentManager;
import proj.shopping.utils.report.AllureConstants;
import proj.shopping.utils.report.AllureEnvironmentManager;
import proj.shopping.utils.report.AllureReportGenerator;
import proj.shopping.validation.Softassert;

import java.io.File;

public class TestNGListeners  implements ITestNGListener, ISuiteListener, IExecutionListener, IInvokedMethodListener, ITestListener {


    public void onStart(ISuite suite) {
        suite.getXmlSuite().setName("Shopping Application Test Suite");
    }

    public void onExecutionStart() {
        LogsManager.info("Test Execution started");


        cleanTestOutputDirectories();
        LogsManager.info("Directories cleaned");

        createTestOutputDirectories();
        LogsManager.info("Directories created");

        PropertyReader.loadProperties();
        LogsManager.info("Properties loaded");


        AllureEnvironmentManager.setEnvironmentVariables();
        LogsManager.info("Allure environment set");
    }

    public void onExecutionFinish() {
        AllureReportGenerator.generateReports(false);
        AllureReportGenerator.copyHistory();
        LogsManager.info("History copied");
        AllureReportGenerator.generateReports(true);
        String newFileName = AllureReportGenerator.renameReport();
        AllureReportGenerator.openReport(newFileName);
        LogsManager.info("Test Execution Finished");
    }
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            ScreenRecordManager.startRecording();
            LogsManager.info("Test Case " + testResult.getName() + " started");
        }
    }

    public void afterInvocation(IInvokedMethod method, ITestResult result) {
        WebDriver driver = null;
        if (method.isTestMethod()) {
            ScreenRecordManager.stopRecording(result.getName());
            Softassert.assertAll();
            if (result.getInstance() instanceof WebDriverProvider provider)
                driver = provider.getWebDriver();
            switch (result.getStatus()) {
                case ITestResult.FAILURE -> ScreenshotManager.takeFullPageScreenshot(driver, "failed-" + result.getName());

                case ITestResult.SUCCESS -> ScreenshotManager.takeFullPageScreenshot(driver, "passed-" + result.getName());

                case ITestResult.SKIP -> ScreenshotManager.takeFullPageScreenshot(driver, "skipped-" + result.getName());

            }
            AllureAttachmentManager.attachLogs();
            AllureAttachmentManager.attachRecords(result.getName());
        } else if (method.isConfigurationMethod()) {
            // For Configuration Methods: Log Only
            switch (result.getStatus()) {
                case ITestResult.FAILURE -> LogsManager.info("Configuration Method ", result.getName(), "failed");
                case ITestResult.SUCCESS -> LogsManager.info("Configuration Method ", result.getName(), "passed");
                case ITestResult.SKIP -> LogsManager.info("Configuration Method ", result.getName(), "skipped");
            }
        }
    }




    public void onTestSuccess(ITestResult result) {
        LogsManager.info("Test case", result.getName(), "passed");
    }

    public void onTestFailure(ITestResult result) {
        LogsManager.info("Test case", result.getName(), "failed");

    }
    public void onTestSkipped(ITestResult result) {
        LogsManager.info("Test case", result.getName(), "skipped");
    }

    public void onFinish(ISuite suite) {

    }




    private void cleanTestOutputDirectories() {

        FileUtils.cleanDirectory(AllureConstants.RESULTS_FOLDER.toFile());
        FileUtils.cleanDirectory(new File(String.valueOf(ScreenshotManager.SCREENSHOTS_PATH)));
        FileUtils.cleanDirectory(new File(String.valueOf(ScreenRecordManager.RECORDINGS_PATH)));
        FileUtils.cleanDirectory(new File(LogsManager.LOGS_PATH));
    }

    private void createTestOutputDirectories() {
        FileUtils.createDirectory(String.valueOf(ScreenshotManager.SCREENSHOTS_PATH));
        FileUtils.createDirectory(String.valueOf(ScreenRecordManager.RECORDINGS_PATH));
    }

}
