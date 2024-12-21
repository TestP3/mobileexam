package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;



public class ProductScreen extends PageObject {

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Container for fragments\"]/android.view.ViewGroup")
    private WebElement productsContainer;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.ViewGroup")
    private WebElement productDetailContainer;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"Tap to add product to cart\"]")
    private WebElement addToCartButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Decrease item quantity\"]")
    private WebElement decreaseQuantityButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Decrease item quantity\"]")
    private WebElement increaseQuantityButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Displays number of items in your cart\"]")
    private WebElement cartIcon;

    public boolean validateProductsDisplayed() {
        return element(productsContainer).isDisplayed();
    }

    public void selectProduct(String productName) {
        withTimeoutOf(15, TimeUnit.SECONDS).waitFor(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format("//android.widget.ImageView[@content-desc=\"%s\"]", productName))));
        $(By.xpath(String.format("//android.widget.ImageView[@content-desc=\"%s\"]", productName))).click();
    }

    public void setQuantity(int quantity) {
        if (quantity > 1) {
            for (int i = 1; i < quantity; i++) {
                withTimeoutOf(5, TimeUnit.SECONDS).waitFor(increaseQuantityButton).click();
            }
        }
    }

    public void addProductToCart(String productName, int quantity) {
        selectProduct(productName);
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(productDetailContainer);
        setQuantity(quantity);
        addToCart();
    }

    public void addToCart() {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(addToCartButton).click();
    }

    public void openCart() {
        withTimeoutOf(10, TimeUnit.SECONDS).waitFor(cartIcon).click();
    }

    public boolean isProductDetailDisplayed() {
        return withTimeoutOf(10, TimeUnit.SECONDS)
                .waitFor(productDetailContainer)
                .isDisplayed();
    }

    public String getCartBadgeCount() {
        return withTimeoutOf(5, TimeUnit.SECONDS)
                .waitFor(cartIcon)
                .getAttribute("content-desc");
    }
}