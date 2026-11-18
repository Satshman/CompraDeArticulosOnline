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
 * Tarea de negocio para seleccionar un producto del catálogo y añadirlo al carrito de compras.
 */
public class AgregarProductoAlCarrito implements Task {

    public static AgregarProductoAlCarrito enElCatalogo() {
        return Tasks.instrumented(AgregarProductoAlCarrito.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ScrollTo.element(HomePage.PRIMER_PRODUCTO_ADD),
                Delay.forSocialization(),
                JavaScriptClick.on(HomePage.PRIMER_PRODUCTO_ADD),
                Delay.ofMillis(2000),
                Open.url(Constantes.URL_AUTOMATION_EXERCISE + "/view_cart"),
                EsperarElemento.seaVisible(CarritoPage.BTN_PROCEED_TO_CHECKOUT, 15),
                Delay.forSocialization()
        );
    }
}
