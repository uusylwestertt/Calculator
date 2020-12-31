package scnarios;

import TestBuilders.TestBuilder;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testConfig.TestListener;

@Listeners(TestListener.class)
public class CalculatorCases extends TestBuilder {

    @Epic("Calculator test")
    @Description("Calculate 35*999+(100/4)= and assert the correct result 34990.")

    @Test()
    public void homeTask1() {
        acceptPrivacy();
        enterNumber(35);
        clickOnMultiplicateButton();
        enterNumber(999);
        clickOnPlusButton();
        enterNumber(100);
        clickOnModuloButton();
        enterNumber(4);
        clickOnEqualButton();
        clickOnResultInput();
        verifyResult(34990);
    }

    @Epic("Calculator test1")
    @Description("Calculate cos(pi) with the rad radio button and assert the correct result -1.")
    @Test()
    public void homeTask2() {
        clickOnRadaianButton();
        enterCosinusExpression(Math.PI);
        clickOnEqualButton();
        verifyResult(-1);
    }

    @Epic("Calculator test1")
    @Description("Calculate sqrt(81) and assert assert the correct result 9.")
    @Test()
    public void homeTask3() {
        clickOnSqrtButton();
        enterNumber(81);
        clickOnEqualButton();
        verifyResult(9);
    }

    @Epic("Calculator test")
    @Description("Press history dropdown and assert that the list contains the 3 operations executed e.g. 35*999+(100/4)=, cos(pi),sqrt(81)")
    @Test()
    public void homeTask4() {
        checkHistory(3);
    }


}


