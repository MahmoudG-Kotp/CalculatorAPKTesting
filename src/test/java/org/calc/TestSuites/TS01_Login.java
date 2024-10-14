package org.calc.TestSuites;

import org.calc.Hooks;
import org.calc.StepDefinitions.D01_Login;
import org.calc.StepDefinitions.D02_Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.NoSuchElementException;

public class TS01_Login {
    private final D01_Login loginStepDef = new D01_Login();
    private final static String VALID_USERNAME = "admin";
    private final static String VALID_PASSWORD = "1234";

    @Test(testName = "TC01_LoginWithEmptyPassword")
    public void tc01LoginWithEmptyPassword() {

        loginStepDef.enterUsername("testUsername");
        Hooks.getRootDriver().hideKeyboard();

        loginStepDef.enterPassword("");
        Hooks.getRootDriver().hideKeyboard();

        loginStepDef.clickLogin();

        Assert.assertEquals(loginStepDef.getAlertMessage(), "Login failed");

        loginStepDef.clickOK();

        loginStepDef.clearInputs();
    }

    @Test(testName = "TC02_LoginWithEmptyPassword")
    public void tc02LoginWithEmptyUsername() {

        loginStepDef.enterUsername("");
        Hooks.getRootDriver().hideKeyboard();

        loginStepDef.enterPassword("testPassword");
        Hooks.getRootDriver().hideKeyboard();

        loginStepDef.clickLogin();

        Assert.assertEquals(loginStepDef.getAlertMessage(), "Login failed");

        loginStepDef.clickOK();

        loginStepDef.clearInputs();
    }

    @Test(testName = "TC03_LoginWithEmptyCredentials")
    public void tc03LoginWithEmptyCredentials() {

        loginStepDef.enterUsername("");
        Hooks.getRootDriver().hideKeyboard();

        loginStepDef.enterPassword("");
        Hooks.getRootDriver().hideKeyboard();

        loginStepDef.clickLogin();

        Assert.assertEquals(loginStepDef.getAlertMessage(), "Login failed");

        loginStepDef.clickOK();
    }

    @Test(testName = "TC04_LoginWithWrongCredentials")
    public void tc04LoginWithWrongCredentials() {

        loginStepDef.enterUsername("wrongUsername");
        Hooks.getRootDriver().hideKeyboard();

        loginStepDef.enterPassword("wrongPassword");
        Hooks.getRootDriver().hideKeyboard();

        loginStepDef.clickLogin();

        Assert.assertEquals(loginStepDef.getAlertMessage(), "Login failed");

        loginStepDef.clickOK();

        loginStepDef.clearInputs();
    }

    @Test(testName = "TC05_LoginWithWrongPassword")
    public void tc05LoginWithWrongPassword() {

        loginStepDef.enterUsername(VALID_USERNAME);
        Hooks.getRootDriver().hideKeyboard();

        loginStepDef.enterPassword("wrongPassword");
        Hooks.getRootDriver().hideKeyboard();

        loginStepDef.clickLogin();

        Assert.assertEquals(loginStepDef.getAlertMessage(), "Login failed");

        loginStepDef.clickOK();

        loginStepDef.clearInputs();
    }

    @Test(testName = "TC06_LoginWithWrongUsername")
    public void tc06LoginWithWrongUsername() {

        loginStepDef.enterUsername("wrongUsername");
        Hooks.getRootDriver().hideKeyboard();

        loginStepDef.enterPassword(VALID_PASSWORD);
        Hooks.getRootDriver().hideKeyboard();

        loginStepDef.clickLogin();

        Assert.assertEquals(loginStepDef.getAlertMessage(), "Login failed");

        loginStepDef.clickOK();

        loginStepDef.clearInputs();
    }

    @Test(testName = "TC07_LoginWithValidCredentials")
    public void tc07LoginWithValidCredentials() {

        loginStepDef.enterUsername(VALID_USERNAME);
        Hooks.getRootDriver().hideKeyboard();

        loginStepDef.enterPassword(VALID_PASSWORD);
        Hooks.getRootDriver().hideKeyboard();

        loginStepDef.clickLogin();

        try {
            Assert.assertEquals(new D02_Calculator().getFrameTitleText(), "Calc");
        }catch (NoSuchElementException exception){
            Assert.fail("Login Failed!, Banner title not equal Calc");
        }
    }


}
