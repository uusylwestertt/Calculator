package testConfig;

import common.browserActions.BrowserActions;
import config.driverManager.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import pages.caclculatorPages.CalculatorPage;

import static common.Constatnt.BASE_URL;


public class TestConfig {

    private DriverManager driverManager;

    @BeforeSuite
    public void startBeforeSuite() {
        driverManager = new DriverManager();
        driverManager.setupDriver();
        driverManager.openUrl(BASE_URL);
    }


    @AfterMethod
    public void afterMethod() {
        new CalculatorPage().clickOnClearButton();
        new BrowserActions().refreshPage();
    }

    @AfterTest
    public void thearDown() {
        driverManager.quitDriver();
    }


}
