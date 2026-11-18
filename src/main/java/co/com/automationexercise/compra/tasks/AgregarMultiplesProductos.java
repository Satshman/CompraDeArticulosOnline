package co.com.automationexercise.compra.tasks;

import co.com.automationexercise.compra.interactions.Delay;
import co.com.automationexercise.compra.interactions.EsperarElemento;
import co.com.automationexercise.compra.interactions.JavaScriptClick;
import co.com.automationexercise.compra.interactions.ScrollTo;
import co.com.automationexercise.compra.userinterfaces.CarritoPage;
import co.com.automationexercise.compra.userinterfaces.HomePage;
import co.com.automationexercise.compra.utils.Constantes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

/**
 * Tarea de negocio para agregar múltiples productos al carrito (Camino Alterno).
 */
public class AgregarMultiplesProductos implements Task {

    public static AgregarMultiplesProductos alCarrito() {
        return Tasks.instrumented(AgregarMultiplesProductos.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // 1. Agregar primer producto
                ScrollTo.element(HomePage.PRIMER_PRODUCTO_ADD),
                Delay.forSocialization(),
                JavaScriptClick.on(HomePage.PRIMER_PRODUCTO_ADD),
                Delay.ofMillis(1500),

                // 2. Agregar segundo producto
                ScrollTo.element(HomePage.SEGUNDO_PRODUCTO_ADD),
                Delay.forSocialization(),
                JavaScriptClick.on(HomePage.SEGUNDO_PRODUCTO_ADD),
                Delay.ofMillis(2000),

                // 3. Abrir la página del carrito directamente
                Open.url(Constantes.URL_AUTOMATION_EXERCISE + "/view_cart"),
                EsperarElemento.seaVisible(CarritoPage.BTN_PROCEED_TO_CHECKOUT, 15),
                Delay.forSocialization()
        );
    }
}
