package org.calc.StepDefinitions;

import org.calc.Page.P01_LoginPage;

public class D01_Login {
    P01_LoginPage loginPage = new P01_LoginPage();

    public void enterUsername(String username) {
        loginPage.usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        loginPage.passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginPage.loginButton.click();
    }

    public String getAlertMessage() {
        return loginPage.alertMessage.getText();
    }

    public void clickOK() {
        loginPage.okButton.click();
    }

    public void clearInputs(){
        loginPage.usernameField.clear();
        loginPage.passwordField.clear();
    }
}