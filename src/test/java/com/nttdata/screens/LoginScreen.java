package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import net.thucydides.core.annotations.Step;

public class LoginScreen extends BaseScreen {
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/nameET\"]")
    private WebElement usernameInput;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.saucelabs.mydemoapp.android:id/passwordET\"]")
    private WebElement passwordInput;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Tap to login with given credentials\"]")
    private WebElement loginButton;

    @Step("Login en la aplicación")
    public void login() {
        escribirTexto(usernameInput, "bob@example.com");
        escribirTexto(passwordInput, "10203040");
        clickearElemento(loginButton);
    }

    public boolean isLoginPageDisplayed() {
        return elementoEsVisible(usernameInput);
    }
}