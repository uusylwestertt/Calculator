package common.browserActions;

import static config.driverManager.DriverManager.webDriver;

public class BrowserActions {


    public void refreshPage(){
        webDriver.navigate().refresh();
    }
}
