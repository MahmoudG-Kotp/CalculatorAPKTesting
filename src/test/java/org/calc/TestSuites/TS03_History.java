package org.calc.TestSuites;

import org.calc.Hooks;
import org.calc.StepDefinitions.D02_Calculator;
import org.calc.StepDefinitions.D03_History;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TS03_History {
    private final D03_History historyStepDef = new D03_History();
    private final D02_Calculator calculator = new D02_Calculator();
    private final TS01_Login ts01Login = new TS01_Login();

    @BeforeTest
    public void login() {
        ts01Login.tc07LoginWithValidCredentials();
    }

    @AfterMethod
    public void testInterval(){
        Hooks.getRootDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        historyStepDef.navigateBack();
    }

    @Test(testName = "TC01_HistoryButtonOpensHistory")
    public void tc01HistoryButtonOpensHistory() {
        calculator.performAddition(new String[]{"5", "3"}); // Perform a calculation
        calculator.clickHistory(); // Click the history button

        // Assert that the history page is displayed
        Assert.assertTrue(historyStepDef.isHistoryPageDisplayed(), "History page should be displayed after clicking the history button.");
    }

    @Test(testName = "TC02_DeleteCheckedCalculations")
    public void tc02DeleteCheckedCalculations() {
        calculator.performAddition(new String[]{"8", "2"});
        calculator.clickHistory();

        historyStepDef.selectAllHistoryItems();

        int initialCount = historyStepDef.getHistoryCount();
        System.out.println(initialCount);
        historyStepDef.deleteSelectedHistoryItems();

        Hooks.getRootDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Assert.assertTrue(historyStepDef.isHistoryEmpty(), "History should be empty after deleting selected items.");

        Assert.assertEquals(historyStepDef.getHistoryCount(), 0, "History count should be 0 after deletion.");
    }

    @Test(testName = "TC03_HistoryPageShowsCorrectCalculations")
    public void tc03HistoryPageShowsCorrectCalculations() {
        calculator.performAddition(new String[]{"4", "5"});
        calculator.clickHistory();

        String expectedCalculation = "4+5=9";
        boolean foundCalculation = false;

        for (WebElement historyItem : historyStepDef.getHistoryList()) {
            if (historyItem.getText().equals(expectedCalculation)) {
                foundCalculation = true; // The expected calculation was found in history
                break;
            }
        }

        Hooks.getRootDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Assert.assertTrue(foundCalculation, "Expected calculation should be present in history.");
    }

    @Test(testName = "TC04_EmptyHistoryAfterDelete")
    public void tc04EmptyHistoryAfterDelete() {
        calculator.performAddition(new String[]{"7", "3"});
        calculator.clickHistory();

        historyStepDef.selectAllHistoryItems();
        historyStepDef.deleteSelectedHistoryItems(); // Delete selected items

        // Assert that history is empty
        Assert.assertTrue(historyStepDef.isHistoryEmpty(), "History should be empty after all items are deleted.");
    }
}
