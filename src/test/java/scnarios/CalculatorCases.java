package scnarios;

import TestBuilders.TestBuilder;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testConfig.TestListener;

@Listeners(TestListener.class)
public class CalculatorCases extends TestBuilder {


    @Test
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

    @Test
    public void homeTask2(){
        clickOnRadaianButton();
        enterCosinusExpression(Math.PI);
        clickOnEqualButton();
        verifyResult(-1);
    }

    @Test
    public void homeTask3(){
        clickOnSqrtButton();
        enterNumber(81);
        clickOnEqualButton();
        verifyResult(9);
    }

    @Test
    public void homeTask4(){
        checkHistory(3);
    }


}


