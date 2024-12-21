package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

public class CartScreen extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Displays number of items in your cart\"]")
    private WebElement cartIcon;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id=\"com.saucelabs.mydemoapp.android:id/bottomLL\"]")
    private WebElement cartSummaryContainer;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/totalPrice\"]")
    private WebElement totalPrice;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/totalItems\"]")
    private WebElement totalItems;

    public boolean validateCartSummary() {
        return element(cartSummaryContainer).isDisplayed();
    }

    public boolean validateCartStatus(String expectedItems) {
        return element(cartIcon).getText().equals(expectedItems);
    }

    public String getTotalPrice() {
        return element(totalPrice).getText();
    }

    public String getTotalItems() {
        return element(totalItems).getText();
    }
}