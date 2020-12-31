package testConfig;

import config.driverManager.DriverManager;
import config.enums.BrowserTypes;
import logging.Log;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.caclculatorPages.CalculatorPage;

import static config.driverManager.DriverManager.properties;
import static config.driverManager.DriverManager.webDriver;


public class TestConfig {


    @BeforeSuite
    public void startBeforeSuite() {
        setupDriver();
        openUrl("http://web2.0calc.com/");
    }

    @BeforeMethod
    public void beforeMethod() {
        new CalculatorPage().clickOnClearButton();
    }


    @AfterMethod
    public void afterMethod() {
        webDriver.navigate().refresh();
    }

    @AfterTest
    public void thearDown() {
        DriverManager.quitDriver();
    }

    private void openUrl(String url) {
        Log.TEST_MESSAGE_CHECK("Opening url: " + url);
        webDriver.get(url);
    }

    private void setupDriver() {
        if (properties.getBrowserName().equals(BrowserTypes.CHROME)) {
            DriverManager.createDriver(BrowserTypes.CHROME);
        } else {
            DriverManager.createDriver(BrowserTypes.FIREFOX);
        }
    }
}
