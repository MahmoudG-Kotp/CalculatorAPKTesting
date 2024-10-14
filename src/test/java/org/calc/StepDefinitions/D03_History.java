package org.calc.StepDefinitions;

import org.calc.Hooks;
import org.calc.Page.P03_HistoryPage;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class D03_History {
    P03_HistoryPage historyPage = new P03_HistoryPage();

    public boolean isHistoryPageDisplayed() {
        return historyPage.bannerTitle.isDisplayed();
    }

    public void selectAllHistoryItems() {
        for (WebElement checkBox : historyPage.checkBoxList) {
            Hooks.getRootDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(200));
            if (!checkBox.isSelected()) {
                checkBox.click(); // Click to select
            }
        }
    }

    public void deleteSelectedHistoryItems() {
        if (historyPage.deleteButton.isDisplayed()) {
            historyPage.deleteButton.click(); // Click the delete button
        }
    }

    public List<WebElement> getHistoryList() {
        return historyPage.historyList;
    }

    public int getHistoryCount() {
        return historyPage.historyList.size();
    }

    public boolean isHistoryEmpty() {
        return getHistoryCount() == 0;
    }

    public void navigateBack() {
        historyPage.backButton.click();
    }
}
