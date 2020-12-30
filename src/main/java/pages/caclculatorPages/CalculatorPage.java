package pages.caclculatorPages;

import interactions.Interactions;
import logging.Log;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

public class CalculatorPage extends Interactions {

    private By acceptBtn = By.cssSelector(".qc-cmp2-summary-buttons button:nth-of-type(3)");
    private By multiplicateButton = By.id("BtnMult");
    private By equalButton = By.id("BtnCalc");
    private By plusButton = By.id("BtnPlus");
    private By moduloButton = By.id("BtnDiv");
    private By resultInput = By.cssSelector(".inputs #input");
    private By cosButton = By.id("BtnCos");
    private By dotButton = By.id("BtnDot");
    private By closingBracketButton = By.id("BtnParanR");
    private By radianButton = By.cssSelector(".options label[title='Radian']");

    private By numberButton(int number) {
        return By.cssSelector("#btns #Btn" + number);
    }

    public void acceptPrivacy() {
        clickOnElement(acceptBtn);
    }


    public void enterNumber(Double number) {
        Log.TEST_MESSAGE_CHECK("Entering number: " + number);
        String stringOfNumber = String.valueOf(number);
        if (stringOfNumber.contains(".")) {
            for (int i = 0; i < stringOfNumber.length(); i++) {
                if (Character.isDigit(stringOfNumber.charAt(i))) {
                    int valueToEnter = Character.getNumericValue(stringOfNumber.charAt(i));
                    clickOnElement(numberButton(valueToEnter));
                } else {
                    clickOnElement(dotButton);
                }
            }
        }
    }


    public void clickOnMultiplicateButton() {
        Log.TEST_MESSAGE_CHECK("Click on multiplicate button");
        clickOnElement(multiplicateButton);
    }

    public void clickOnEqualButton() {
        Log.TEST_MESSAGE_CHECK("Click on equal button");
        clickOnElement(equalButton);
    }

    public void clickOnPlusButton() {
        Log.TEST_MESSAGE_CHECK("Click on plus button");
        clickOnElement(plusButton);
    }

    public void clickOnModuloButton() {
        Log.TEST_MESSAGE_CHECK("Click on modulo button");
        clickOnElement(moduloButton);
    }

    public void clickOnResultInput() {
        clickOnElement(resultInput);
    }

    public void verifyResult(int expectedResult) {
        Log.TEST_MESSAGE_CHECK("Checking if result is the same as expected: " + expectedResult);
        Assertions.assertThat(getElementText(resultInput)).isEqualTo(String.valueOf(expectedResult));
        Log.TEST_MESSAGE_SUCESS("Result is properly");
    }

    public void enterCosinusExpression(Double value) {
        Log.TEST_MESSAGE_CHECK("Enter cosinus expression for value: " + value);
        clickOnElement(cosButton);
        enterNumber(value);
        clickOnElement(closingBracketButton);
    }

    public void clickOnRadianButton() {
        Log.TEST_MESSAGE_CHECK("Click on Radian button");
        clickOnElement(radianButton);
    }
}