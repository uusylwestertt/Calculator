package config.driverManager;

import config.enums.BrowserTypes;
import config.properties.GetProperties;
import logging.Log;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static common.Constatnt.TIMEOUT;

public class DriverManager {


    public static WebDriver webDriver;
    public static String projectPath = System.getProperty("user.dir");
    private static String chromeDriverLoc = projectPath + "/libs/chromedriver.exe";
    private static String firefoxDriverLoc = projectPath + "/libs/geckoDriver.exe";
    public static GetProperties properties = new GetProperties();

    public  WebDriver createDriver(BrowserTypes browser) {

        switch (browser) {
            case CHROME:
                createChrmeDriver();
                break;
            case FIREFOX:
                createFirefoxDriver();
                break;
            default:
                webDriver = null;
                Log.TEST_MESSAGE_FAIL("Not defined driver");
        }
        return webDriver;
    }


    private  void createChrmeDriver() {
        Log.DEBUG_MESSAGE_CHECK("Starting webDriver");
        System.setProperty("webdriver.chrome.driver", chromeDriverLoc);
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    private  void createFirefoxDriver() {
        Log.DEBUG_MESSAGE_CHECK("Starting webDriver");
        System.setProperty("webdriver.gecko.driver", firefoxDriverLoc);
        webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        new WebDriverWait(webDriver, Duration.ofSeconds(30)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }


    public  void quitDriver() {
        if (webDriver != null) {
            Log.DEBUG_MESSAGE_CHECK("Closing webDriver");
            webDriver.quit();
            webDriver = null;
        }
    }


    public void openUrl(String url) {
        Log.TEST_MESSAGE_CHECK("Opening url: " + url);
        webDriver.get(url);
    }

    public void setupDriver() {
        if (properties.getBrowserName().equals(BrowserTypes.CHROME.getName())) {
         createDriver(BrowserTypes.CHROME);
        } else {
          createDriver(BrowserTypes.FIREFOX);
        }
    }

}
