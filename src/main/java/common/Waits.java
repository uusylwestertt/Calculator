package common;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static common.Constatnt.TIMEOUT;
import static config.driverManager.DriverManager.webDriver;


public class Waits {

    protected WebElement isElementPresent(By locator) {

        new WebDriverWait(webDriver, Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        new WebDriverWait(webDriver, Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.presenceOfElementLocated(locator));
        return new WebDriverWait(webDriver, Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement isElementPresent(WebElement element) {
        new WebDriverWait(webDriver, Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.visibilityOf(element));
        return new WebDriverWait(webDriver, Duration.ofSeconds(TIMEOUT)).until(ExpectedConditions.elementToBeClickable(element));

    }
}
