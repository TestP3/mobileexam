package com.nttdata.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;
import net.thucydides.core.webdriver.DriverSource;

import java.net.URL;

public class AppiumConfig implements DriverSource {

    @Override
    public WebDriver newDriver() {
        try {
            UiAutomator2Options options = new UiAutomator2Options()
                    .setDeviceName("emulator-5554")
                    .setAutomationName("UiAutomator2")
                    .setApp(System.getProperty("user.dir") + "/src/test/resources/app/mda-2.0.2-23.apk")
                    .setAppPackage("com.saucelabs.mydemoapp")
                    .setAppActivity("com.saucelabs.mydemoapp.android.view.activities.MainActivity");

            return new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo inicializar AndroidDriver", e);
        }
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}