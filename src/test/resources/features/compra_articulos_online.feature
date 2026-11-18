# language: es
@regresion @compra
Característica: Compra de artículos online en Automation Exercise
  Como un usuario de la plataforma de compras online Automation Exercise
  Quiero poder registrarme, seleccionar artículos y pagar con tarjeta de crédito
  Para completar y confirmar satisfactoriamente la orden de compra

  Antecedentes:
    Dado que el comprador abre la página web de Automation Exercise

  @rutaFeliz @e2e
  Escenario: Registro exitoso de usuario, selección de producto y confirmación de la orden de compra
    Cuando el comprador completa el registro con datos válidos de usuario y dirección
    Y selecciona un producto del catálogo y lo añade al carrito de compras
    Y procede al checkout completando el pago con tarjeta de crédito
    Entonces debería observar la orden de compra confirmada con el mensaje "ORDER PLACED!"

  @caminoAlterno
  Escenario: Compra de múltiples productos en el carrito por un usuario autenticado
    Cuando el comprador completa el registro con datos válidos de usuario y dirección
    Y agrega múltiples productos al carrito de compras
    Y procede al checkout completando el pago con tarjeta de crédito
    Entonces debería observar la orden de compra confirmada con el mensaje "ORDER PLACED!"

  @caminoExcepcional @negativo
  Escenario: Intento de registro fallido con un correo electrónico previamente utilizado
    Dado que existe un usuario previamente registrado en la plataforma
    Cuando el comprador intenta registrarse nuevamente con el mismo correo electrónico
    Entonces debería visualizar el mensaje de advertencia "Email Address already exist!"
