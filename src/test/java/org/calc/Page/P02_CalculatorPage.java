package org.calc.Page;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.calc.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P02_CalculatorPage {
    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"no. 0\"]")
    public WebElement noZeroButton;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"no. 1\"]")
    public WebElement noOneButton;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"no. 2\"]")
    public WebElement noTwoButton;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"no. 3\"]")
    public WebElement noThreeButton;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"no. 4\"]")
    public WebElement noFourButton;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"no. 5\"]")
    public WebElement noFiveButton;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"no. 6\"]")
    public WebElement noSixButton;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"no. 7\"]")
    public WebElement noSevenButton;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"no. 8\"]")
    public WebElement noEightButton;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"no. 9\"]")
    public WebElement noNineButton;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"plusButton\"]")
    public WebElement plusButton;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"timesButton\"]")
    public WebElement multiplyButton;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"clearButton\"]")
    public WebElement clearButton;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id=\"equalButton\"]")
    public WebElement equalButton;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"history\"]")
    public WebElement historyButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    public WebElement backButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"result\"]")
    public WebElement result;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Calc\"]")
    public WebElement frameTitle;

    public P02_CalculatorPage() {
        PageFactory.initElements(Hooks.getRootDriver(), this);
    }
}
