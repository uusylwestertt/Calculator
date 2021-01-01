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
    private BrowserActions browserActions;

    @BeforeSuite
    public void startBeforeSuite() {
        driverManager = new DriverManager();
        browserActions = new BrowserActions();
        driverManager.setupDriver();
        driverManager.openUrl(BASE_URL);
        browserActions.checkIsPageFullyLoaded();
    }


    @AfterMethod
    public void afterMethod() {
        new CalculatorPage().clickOnClearButton();
       browserActions.refreshPage();
    }

    @AfterTest
    public void thearDown() {
        driverManager.quitDriver();
    }


}
