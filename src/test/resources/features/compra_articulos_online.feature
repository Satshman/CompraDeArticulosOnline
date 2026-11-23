# language: es
@regresion @compra
Característica: Compra de articulos online en Automation Exercise
  Como un usuario de la plataforma de compras online Automation Exercise
  Quiero poder registrarme, seleccionar articulos y pagar con tarjeta de credito
  Para completar y confirmar satisfactoriamente la orden de compra

  Antecedentes:
    Dado que el comprador abre la pagina web de Automation Exercise

  @rutaFeliz @e2e
  Escenario: Registro exitoso de usuario, seleccion de producto y confirmacion de la orden de compra
    Cuando el comprador completa el registro con datos validos de usuario y direccion
    Y selecciona un producto del catalogo y lo agrega al carrito de compras
    Y procede al checkout completando el pago con tarjeta de credito
    Entonces deberia observar la orden de compra confirmada con el mensaje "ORDER PLACED!"

  @caminoAlterno
  Escenario: Compra de multiples productos en el carrito por un usuario autenticado
    Cuando el comprador completa el registro con datos validos de usuario y direccion
    Y agrega multiples productos al carrito de compras
    Y procede al checkout completando el pago con tarjeta de credito
    Entonces deberia observar la orden de compra confirmada con el mensaje "ORDER PLACED!"

  @caminoExcepcional @negativo
  Escenario: Intento de registro fallido con un correo electronico previamente utilizado
    Dado que existe un usuario previamente registrado en la plataforma
    Cuando el comprador intenta registrarse nuevamente con el mismo correo electronico
    Entonces deberia visualizar el mensaje de advertencia "Email Address already exist!"
