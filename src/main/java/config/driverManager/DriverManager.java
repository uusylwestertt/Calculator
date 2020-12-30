package config.driverManager;

import logging.Log;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static common.Constatnt.TIMEOUT;

public class DriverManager {


    public static WebDriver webDriver;
    public static String projectPath = System.getProperty("user.dir");
    private static String chromeDriverLoc = projectPath + "/libs/chromedriver.exe";

    public static WebDriver createDriver() {
        if (webDriver == null) {
            Log.DEBUG_MESSAGE_CHECK("Starting webDriver");
            System.setProperty("webdriver.chrome.driver", chromeDriverLoc);
            webDriver = new ChromeDriver();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
            new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(
                    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        }
        return webDriver;
    }


    public static void quitDriver() {
        if (webDriver != null) {
            Log.DEBUG_MESSAGE_CHECK("Closing webDriver");
            webDriver.quit();
            webDriver = null;
        }
    }

}
