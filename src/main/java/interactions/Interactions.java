package interactions;

import common.BasePage;
import logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Interactions extends BasePage {

    public void clickOnElement(By locator) {
        Log.DEBUG_MESSAGE_CHECK("Click on element: " + locator);
        isElementPresent(locator).click();
    }

    protected String getElementText(By locator) {
        Log.DEBUG_MESSAGE_CHECK("Getting text from element: " + locator);
        return isElementPresent(locator).getAttribute("value");
    }

    protected String getElementText(WebElement element) {
        Log.DEBUG_MESSAGE_CHECK("Getting text from webElement");
        return isWebElementPresent(element).getText();
    }

}
