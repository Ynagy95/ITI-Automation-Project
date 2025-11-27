package proj.shopping.drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import proj.shopping.utils.datareader.PropertyReader;
import proj.shopping.utils.logs.LogsManager;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class Chrome extends AbstractDriverFactory {

    private ChromeOptions getoptions() {
        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false); // disable password manager
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("profile.default_content_setting_values.popups", 0);
        prefs.put("safebrowsing.enabled", false);
        prefs.put("safebrowsing.disable_download_protection", true);
        prefs.put("profile.default_content_setting_values.automatic_downloads", 1);
        prefs.put("profile.default_content_setting_values.geolocation", 2);
        prefs.put("profile.default_content_setting_values.media_stream", 2);
        prefs.put("profile.password_leak_detection_enabled", false);
        prefs.put("profile.data_reduction_enabled", false);
        prefs.put("profile.autofill_credit_card_enabled", false);
        prefs.put("profile.autofill_address_enabled", false);

        // 💡 Add these to fully disable Chrome’s “Save Address?” popup
        prefs.put("autofill.profile_enabled", false);
        prefs.put("autofill.address_enabled", false);
        prefs.put("autofill.credit_card_enabled", false);
        prefs.put("autofill.server_address", false);
        prefs.put("autofill.enable_profile_suggestions", false);

        options.setExperimentalOption("prefs", prefs);

        // Disable banners and popups
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-features=AutofillServerCommunication,AutofillAddressSavePrompt,PasswordLeakDetection,SafeBrowsingEnhancedProtection");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        // normal or headless mode
        if (PropertyReader.getProperty("executionType").equalsIgnoreCase("LocalHeadless")
                || PropertyReader.getProperty("executionType").equalsIgnoreCase("Remote")) {
            options.addArguments("--headless=new");
        }

        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return options;
    }

    @Override
    public WebDriver startDriver() {
        if (PropertyReader.getProperty("executionType").equalsIgnoreCase("Local")
                || PropertyReader.getProperty("executionType").equalsIgnoreCase("LocalHeadless")) {

            return new ChromeDriver(getoptions());

        } else if (PropertyReader.getProperty("executionType").equalsIgnoreCase("Remote")) {
            try {
                return new RemoteWebDriver(
                        new URI("http://" + PropertyReader.getProperty("remoteHost") + ":" +
                                PropertyReader.getProperty("remotePort") + "/wd/hub").toURL(),
                        getoptions()
                );
            } catch (Exception e) {
                LogsManager.error("Error initializing remote WebDriver: " + e.getMessage());
                throw new RuntimeException("Error initializing remote WebDriver", e);
            }
        } else {
            LogsManager.error("Invalid execution type: " + PropertyReader.getProperty("executionType"));
            throw new IllegalArgumentException("Invalid execution type: " + PropertyReader.getProperty("executionType"));
        }
    }
}
