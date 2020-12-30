package common;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static common.Constatnt.TIMEOUT;
import static config.driverManager.DriverManager.driver;


public class Waits {

    protected WebElement isElementPresent(By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.elementToBeClickable(locator));
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected WebElement isElementPresent(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.elementToBeClickable(element));
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.elementToBeClickable(element));

    }
}
