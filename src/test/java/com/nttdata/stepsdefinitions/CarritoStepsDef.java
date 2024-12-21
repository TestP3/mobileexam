package com.nttdata.stepsdefinitions;

import com.nttdata.steps.CarritoSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class CarritoStepsDef {
    @Steps
    private CarritoSteps carritoSteps;

    @Given("estoy en la aplicación de SauceLabs")
    public void estoyEnLaAplicacionDeSauceLabs() {
        carritoSteps.login();
    }
    @When("inicio sesion en la aplicacion")
    public void inicioSesionEnLaAplicacion() {
        carritoSteps.login();
    }

    @When("valido que carguen correctamente los productos en la galeria")
    public void validoQueCaguenCorrectamenteLosProductos() {
        carritoSteps.validateProductsLoaded();
    }

    @When("agrego {int} del siguiente producto {string}")
    public void agregoProductoAlCarrito(int cantidad, String producto) {
        carritoSteps.addProductToCart(producto, cantidad);
    }

    @Then("valido el carrito de compra actualice correctamente")
    public void validoElCarritoDeCompra() {
        carritoSteps.validateCart();
    }
}
