package common;


import org.openqa.selenium.By;

import static config.driverManager.DriverManager.driver;

public class BasePage extends Waits {


    protected boolean isPresentOnPage(By locator) {
        return getCountOfElements(locator) > 0;
    }

    private int getCountOfElements(By locator) {
        return driver.findElements(locator).size();
    }

}
