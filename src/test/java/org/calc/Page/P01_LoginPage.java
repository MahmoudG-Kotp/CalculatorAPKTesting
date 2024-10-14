package org.calc.Page;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.calc.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P01_LoginPage {
    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"username\"]")
    public WebElement usernameField;

    @FindBy(xpath = "//android.widget.EditText[@resource-id=\"password\"]")
    public WebElement passwordField;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"login\"]")
    public WebElement loginButton;

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/message\"]")
    public WebElement alertMessage;

    @FindBy(xpath = "//android.widget.Button[@resource-id=\"android:id/button1\"]")
    public WebElement okButton;

    public P01_LoginPage() {
        PageFactory.initElements(Hooks.getRootDriver(), this);
    }

}
