package config.driverManager;

import logging.Log;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static common.Constatnt.TIMEOUT;

public class DriverManager {


    public static WebDriver driver;
    private static String projectPath = System.getProperty("user.dir");
    private static String chromeDriverLoc = projectPath + "/libs/chromedriver.exe";

    public static WebDriver createDriver() {
        if (driver == null) {
            Log.DEBUG_MESSAGE_CHECK("Starting driver");
            System.setProperty("webdriver.chrome.driver", chromeDriverLoc);
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        }
        return driver;
    }


    public static void quitDriver() {
        if (driver != null) {
            Log.DEBUG_MESSAGE_CHECK("Closing driver");
            driver.quit();
        }
    }

}
