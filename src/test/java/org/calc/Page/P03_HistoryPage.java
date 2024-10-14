package org.calc.Page;

import org.calc.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P03_HistoryPage {

    @FindBy(xpath = "//android.widget.TextView[contains(@resource-id, \"eq\")]")
    public List<WebElement> historyList;

    @FindBy(xpath = "//android.widget.TextView[@text=\"History\"]")
    public WebElement bannerTitle;

    @FindBy(xpath = "//android.widget.CheckBox[contains(@resource-id, 'checkBox')]")
    public List<WebElement> checkBoxList;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"delete\"]")
    public WebElement deleteButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    public WebElement backButton;

    public P03_HistoryPage(){
        PageFactory.initElements(Hooks.getRootDriver(), this);
    }
}
