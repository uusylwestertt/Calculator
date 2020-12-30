package common;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static config.driverManager.DriverManager.webDriver;

public class BasePage extends Waits {


    protected List<WebElement> listOfElements(By locator) {
        return webDriver.findElements(locator);
    }

}
