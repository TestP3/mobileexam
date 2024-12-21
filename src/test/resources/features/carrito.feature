Feature: Validar funcionalidad del carrito de compras

  @test
  Scenario Outline: Agregar productos al carrito de compras
    Given estoy en la aplicación de SauceLabs
    When inicio sesion en la aplicacion
    And valido que carguen correctamente los productos en la galeria
    And agrego <UNIDADES> del siguiente producto "<PRODUCTO>"
    Then valido el carrito de compra actualice correctamente

    Examples:
      | PRODUCTO                 | UNIDADES |
      | Sauce Labs Backpack     | 1        |
#      | Sauce Labs Bolt T-Shirt | 1        |
#      | Sauce Labs Bike Li1ght   | 2        |