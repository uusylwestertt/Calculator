package common.browserActions;

import logging.Log;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static common.Constatnt.TIMEOUT;
import static config.driverManager.DriverManager.webDriver;

public class BrowserActions {


    public void refreshPage() {
        webDriver.navigate().refresh();
        checkIsPageFullyLoaded();
    }

    public void checkIsPageFullyLoaded(){
        while (!isPageLoadeded()){
            Log.DEBUG_MESSAGE_CHECK("Page loading waiting..");
        }
    }

    private boolean isPageLoadeded() {
        return new WebDriverWait(webDriver, Duration.ofSeconds(TIMEOUT)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
}
