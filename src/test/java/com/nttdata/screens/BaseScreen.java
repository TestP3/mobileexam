package com.nttdata.screens;

import com.nttdata.utils.WebDriverFactory;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BaseScreen extends PageObject {
    protected AndroidDriver driver;
    public BaseScreen() {
        this.driver = WebDriverFactory.getDriver();
    }
    public void esperarElemento(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickearElemento(WebElement element) {
        esperarElemento(element);
        element.click();
    }

    public void escribirTexto(WebElement element, String texto) {
        esperarElemento(element);
        element.sendKeys(texto);
    }

    public boolean elementoEsVisible(WebElement element) {
        try {
            esperarElemento(element);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}