package org.calc.StepDefinitions;

import org.calc.Hooks;
import org.calc.Page.P02_CalculatorPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

public class D02_Calculator {

    P02_CalculatorPage calculatorPage = new P02_CalculatorPage();

    public void clickButton(WebElement button) {
        button.click();
    }

    public void clickClear() {
        clickButton(calculatorPage.clearButton);
    }

    public void clickBack() {
        clickButton(calculatorPage.backButton);
    }

    public void clickEqual() {
        clickButton(calculatorPage.equalButton);
    }

    public void clickHistory() {
        clickButton(calculatorPage.historyButton);
    }

    public String getFrameTitleText(){
        return calculatorPage.frameTitle.getText();
    }

    public String getResultText() {
        return calculatorPage.result.getText();
    }

    private void inputDigits(String digits) {
        for (char digit : digits.toCharArray()) {
            Hooks.getRootDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(30));
            switch (digit) {
                case '0':
                    clickButton(calculatorPage.noZeroButton);
                    break;
                case '1':
                    clickButton(calculatorPage.noOneButton);
                    break;
                case '2':
                    clickButton(calculatorPage.noTwoButton);
                    break;
                case '3':
                    clickButton(calculatorPage.noThreeButton);
                    break;
                case '4':
                    clickButton(calculatorPage.noFourButton);
                    break;
                case '5':
                    clickButton(calculatorPage.noFiveButton);
                    break;
                case '6':
                    clickButton(calculatorPage.noSixButton);
                    break;
                case '7':
                    clickButton(calculatorPage.noSevenButton);
                    break;
                case '8':
                    clickButton(calculatorPage.noEightButton);
                    break;
                case '9':
                    clickButton(calculatorPage.noNineButton);
                    break;
                default:
                    System.out.println("Invalid digit: " + digit);
            }
        }
    }

    // Method to perform addition with an array of numbers
    public void performAddition(String[] numbers) {
        if (numbers.length == 0) return;

        inputDigits(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            clickButton(calculatorPage.plusButton);
            inputDigits(numbers[i]); // Input the next number
        }
        clickEqual();
    }

    // Method to perform multiplication with an array of numbers
    public void performMultiplication(String[] numbers) {
        if (numbers.length == 0) return;

        inputDigits(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            clickButton(calculatorPage.multiplyButton);
            inputDigits(numbers[i]); // Input the next number
        }
        clickEqual();
    }

    public static String sumArray(String[] stringArray) {
        int sum = 0;

        for (String str : stringArray) {
            try {
                // Convert string to int and add to sum
                sum += Integer.parseInt(str);
            } catch (NumberFormatException e) {
                // Handle the case where the string cannot be converted to an integer
                System.out.println("Invalid number: " + str);
            }
        }

        return String.valueOf(sum);
    }

    public static String mulArray(String[] stringArray) {
        int product = 1; // Initialize product to 1 for multiplication

        for (String str : stringArray) {
            try {
                // Convert string to int and multiply with product
                product *= Integer.parseInt(str);
            } catch (NumberFormatException e) {
                // Handle the case where the string cannot be converted to an integer
                System.out.println("Invalid number: " + str);
            }
        }

        return String.valueOf(product);
    }
}
