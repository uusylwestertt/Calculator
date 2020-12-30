package TestBuilders;


import pages.PagesFactory;
import testConfig.TestConfig;

public class TestBuilder extends TestConfig {


    PagesFactory page = new PagesFactory();

    protected void acceptPrivacy(){
        page.calculatorPage.acceptPrivacy();
    }

    protected void enterNumber(int number){
        page.calculatorPage.enterNumber(number);
    }

    protected void clickOnMultiplicateButton() {
        page.calculatorPage.clickOnMultiplicateButton();
    }
    protected void clickOnResultInput(){
        page.calculatorPage.clickOnResultInput();
    }

    protected void clickOnEqualButton() {
        page.calculatorPage.clickOnEqualButton();
    }

    protected void clickOnPlusButton() {
        page.calculatorPage.clickOnPlusButton();
    }

    protected void clickOnModuloButton() {
        page.calculatorPage.clickOnModuloButton();
    }

    protected void verifyResult(int expectedValue){
        page.calculatorPage.verifyResult(expectedValue);
    }

    protected void enterCosinusExpression(Double value){
        page.calculatorPage.enterCosinusExpression(value);
    }

    protected void clickOnRadaianButton(){
        page.calculatorPage.clickOnRadianButton();
    }

    protected void clickOnSqrtButton(){
        page.calculatorPage.clickOnSqrtButton();
    }

    protected void checkHistory(int number){
        page.calculatorPage.checkHistory(number);
    }
}
