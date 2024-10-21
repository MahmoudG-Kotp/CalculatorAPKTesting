package org.calc;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Hooks {
    private static boolean IS_HOOKS_SETUP = false;
    //This line declares an AndroidDriver object, which will be used to interact with the Android device.
    private static AndroidDriver rootDriver;

    public static AndroidDriver getRootDriver() {
        setupDriver();
        return rootDriver;
    }

    private static void setupDriver() {
        if (!IS_HOOKS_SETUP) {

            IS_HOOKS_SETUP = true;
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("appium:automationName", "UiAutomator2");
            capabilities.setCapability("appium:deviceName", "Medium Phone API 35");
            capabilities.setCapability("appium:app", "C:\\Users\\mahmo\\Desktop\\Assignments\\appium\\<Your APK>");
            //This line creates a new AndroidDriver instance, connecting to the Appium server on localhost (127.0.0.1)and port 4723, passing the previously configured options.
            try {
                rootDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            //Sets an implicit wait of 10 seconds.
            rootDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    public static void quit(){
        IS_HOOKS_SETUP = false;
        rootDriver.quit();
    }
}
