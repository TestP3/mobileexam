package com.nttdata.steps;

import com.nttdata.screens.LoginScreen;
import com.nttdata.screens.ProductScreen;
import com.nttdata.screens.CartScreen;
import net.thucydides.core.annotations.Step;

public class CarritoSteps {

    private LoginScreen loginScreen;
    private ProductScreen productScreen;
    private CartScreen cartScreen;


    @Step("Iniciar sesión en la aplicación")
    public void login() {
        loginScreen.login(); // Ya no necesita parámetros porque los valores están en LoginScreen
    }
    @Step("Validar carga de productos")
    public void validateProductsLoaded() {
        productScreen.validateProductsDisplayed();
    }

    @Step("Agregar producto al carrito")
    public void addProductToCart(String productName, int quantity) {
        productScreen.addProductToCart(productName, quantity);
    }

    @Step("Validar carrito de compras")
    public boolean validateCart() {
        productScreen.openCart();
        return cartScreen.validateCartSummary();
    }

    @Step("Validar cantidad en carrito")
    public boolean validateCartQuantity(String expectedItems) {
        return cartScreen.validateCartStatus(expectedItems);
    }

    @Step("Obtener precio total del carrito")
    public String getCartTotal() {
        return cartScreen.getTotalPrice();
    }

    @Step("Obtener cantidad total de items")
    public String getTotalItems() {
        return cartScreen.getTotalItems();
    }
}