package testConfig;

import config.driverManager.DriverManager;
import logging.Log;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import pages.caclculatorPages.CalculatorPage;

import static config.driverManager.DriverManager.driver;


public class TestConfig {


    @BeforeMethod
    public void beforeTest() {
        DriverManager.createDriver();
        openUrl("http://web2.0calc.com/");
    }


    @AfterMethod
    public void afterTest() {
        driver.navigate().refresh();
    }

    @AfterTest
    public void thearDown(){
        DriverManager.quitDriver();
    }

    private void openUrl(String url) {
        Log.TEST_MESSAGE_CHECK("Opening url: " + url);
        driver.get(url);
    }
}
