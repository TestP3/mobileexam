package com.nttdata.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;

public class WebDriverManager {
    private static AppiumDriver driver;

    public static AppiumDriver getDriver() {
        if (driver == null) {
            try {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("deviceName", "emulator-5554");
                capabilities.setCapability("automationName", "UiAutomator2");
                capabilities.setCapability("app", System.getProperty("user.dir") + "/src/test/resources/app/mda-2.0.2-23.apk");

                driver = new AppiumDriver(new URL("http://127.0.0.1:4723"), capabilities);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driver;
    }
}