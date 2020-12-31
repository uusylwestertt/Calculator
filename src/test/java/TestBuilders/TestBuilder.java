package TestBuilders;


import io.qameta.allure.Step;
import pages.PagesFactory;
import testConfig.TestConfig;

public class TestBuilder extends TestConfig {


    PagesFactory page = new PagesFactory();

    @Step("Accept privacy")
    protected void acceptPrivacy() {
        page.calculatorPage.acceptPrivacy();
    }

    @Step("Enter number")
    protected void enterNumber(int number) {
        page.calculatorPage.enterNumber(number);
    }

    @Step("Click multiplicate button")
    protected void clickOnMultiplicateButton() {
        page.calculatorPage.clickOnMultiplicateButton();
    }

    @Step("Click result button")
    protected void clickOnResultInput() {
        page.calculatorPage.clickOnResultInput();
    }

    @Step("Clisk equal button")
    protected void clickOnEqualButton() {
        page.calculatorPage.clickOnEqualButton();
    }

    @Step("Click plus button")
    protected void clickOnPlusButton() {
        page.calculatorPage.clickOnPlusButton();
    }

    @Step("Click modulo button")
    protected void clickOnModuloButton() {
        page.calculatorPage.clickOnModuloButton();
    }

    @Step("Verify result")
    protected void verifyResult(int expectedValue) {
        page.calculatorPage.verifyResult(expectedValue);
    }

    @Step("Enter cosinus expression")
    protected void enterCosinusExpression(Double value) {
        page.calculatorPage.enterCosinusExpression(value);
    }

    @Step("Click radial radiobutton")
    protected void clickOnRadaianButton() {
        page.calculatorPage.clickOnRadianButton();
    }

    @Step("Click sqrt button")
    protected void clickOnSqrtButton() {
        page.calculatorPage.clickOnSqrtButton();
    }

    @Step("Check history")
    protected void checkHistory(int number) {
        page.calculatorPage.checkHistory(number);
    }
}
