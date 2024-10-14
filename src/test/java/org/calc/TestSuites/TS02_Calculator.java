package org.calc.TestSuites;

import org.calc.Hooks;
import org.calc.StepDefinitions.D02_Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Time;
import java.time.Duration;

public class TS02_Calculator {
    D02_Calculator calculator = new D02_Calculator();
    TS01_Login ts01Login = new TS01_Login();

    @BeforeTest
    public void login() {
        ts01Login.tc07LoginWithValidCredentials();
    }

    @Test(testName = "TC01_AddTwoSingleDigits")
    public void tc01AddTwoSingleDigits() {
        String[] numbers = {"5", "7"};
        calculator.performAddition(numbers);
        Assert.assertEquals(calculator.getResultText(), D02_Calculator.sumArray(numbers));
    }

    @Test(testName = "TC02_AddTwoMultiDigits")
    public void tc02AddTwoMultiDigits() {
        String[] numbers = {"45", "27"};
        calculator.performAddition(numbers);
        Assert.assertEquals(calculator.getResultText(), D02_Calculator.sumArray(numbers));
    }

    @Test(testName = "TC03_MultiplyTwoSingleDigits")
    public void tc03MultiplyTwoSingleDigits() {
        String[] numbers = {"5", "7"};
        calculator.performMultiplication(numbers);
        Assert.assertEquals(calculator.getResultText(), D02_Calculator.mulArray(numbers));
    }

    @Test(testName = "TC04_MultiplyTwoMultiDigits")
    public void tc04MultiplyTwoMultiDigits() {
        String[] numbers = {"45", "27"};
        calculator.performMultiplication(numbers);
        Assert.assertEquals(calculator.getResultText(), D02_Calculator.mulArray(numbers));
    }

    @Test(testName = "TC05_ClearFunctionAfterAdd")
    public void tc05ClearFunctionAfterAdd() {
        calculator.performAddition(new String[]{"52", "17"});
        calculator.clickClear();
    }

    @Test(testName = "TC06_ClearFunctionAfterMultiply")
    public void tc06ClearFunctionAfterMultiply() {
        calculator.performMultiplication(new String[]{"23", "18"});
        calculator.clickClear();
    }

    @Test(testName = "TC09_DisplayResultAfterHistory")
    public void tc09DisplayResultAfterHistory() {
        String[] numbers = {"23", "18"};
        String sumResult = D02_Calculator.sumArray(numbers);
        calculator.performAddition(numbers);

        // Assert the multiplication result
        Assert.assertEquals(calculator.getResultText(), sumResult);

        // Click on history and back
        calculator.clickHistory();
        calculator.clickBack();
        Assert.assertEquals(calculator.getResultText(), sumResult);
    }

    @Test(testName = "TC10_CheckEqualButton")
    public void tc10CheckEqualButton() {
        String[] numbers = {"23", "18"};
        calculator.performAddition(numbers);

        // Perform the equal button clicks
        calculator.clickEqual();
        calculator.clickEqual();
        Hooks.getRootDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        calculator.clickEqual();

        // Assert the multiplication result
        Assert.assertEquals(calculator.getResultText(), D02_Calculator.sumArray(numbers));
    }

    @Test(testName = "TC11_CheckMultiAdd")
    public void tc11CheckMultiAdd() {
        String[] numbers = {"23", "18", "21", "04"};
        calculator.performAddition(numbers);

        // Perform the equal button clicks
        calculator.clickEqual();

        // Assert the multiplication result
        Assert.assertEquals(calculator.getResultText(), D02_Calculator.sumArray(numbers));
    }
}
