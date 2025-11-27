package proj.shopping.utils.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import proj.shopping.utils.logs.LogsManager;

import java.util.Set;

public class BrowserActions {

    private final WebDriver driver;

    public BrowserActions(WebDriver driver) {
        this.driver = driver;
    }
    public void maximizewindow(){
        driver.manage().window().maximize();
    }

    public String getcurrenturl(){
       String url=driver.getCurrentUrl();
        LogsManager.info("Current url is: ",url);
        return url;
    }

    public void navigateto(String url){

        driver.get(url);
        LogsManager.info("Navigated to url: ",url);

    }

    public void refreshpage(){
        driver.navigate().refresh();
    }

    public void closewindow() {
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                driver.manage().window().maximize();
                LogsManager.info("Popup window opened — waiting 5 seconds before closing...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                driver.close(); // close the popup
                LogsManager.info("Popup window closed.");
            }
        }

        driver.switchTo().window(mainWindow); // return to main page
        LogsManager.info("Focus returned to main window.");
    }

    public void opennewwindow(){
        driver.switchTo().newWindow(WindowType.WINDOW);
    }
}
