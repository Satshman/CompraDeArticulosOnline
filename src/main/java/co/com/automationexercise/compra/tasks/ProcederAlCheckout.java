package co.com.automationexercise.compra.tasks;

import co.com.automationexercise.compra.interactions.Delay;
import co.com.automationexercise.compra.interactions.EsperarElemento;
import co.com.automationexercise.compra.interactions.JavaScriptClick;
import co.com.automationexercise.compra.interactions.ScrollTo;
import co.com.automationexercise.compra.userinterfaces.CarritoPage;
import co.com.automationexercise.compra.userinterfaces.CheckoutPage;
import co.com.automationexercise.compra.userinterfaces.PagoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;

/**
 * Tarea de negocio para proceder desde el carrito al checkout,
 * verificar detalles de entrega y avanzar hacia la pasarela de pago.
 */
public class ProcederAlCheckout implements Task {

    private final String comentario;

    public ProcederAlCheckout(String comentario) {
        this.comentario = comentario;
    }

    public static ProcederAlCheckout conComentario(String comentario) {
        return Tasks.instrumented(ProcederAlCheckout.class, comentario);
    }

    public static ProcederAlCheckout estandar() {
        return Tasks.instrumented(ProcederAlCheckout.class, "Pedido realizado mediante prueba automatizada con Screenplay.");
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EsperarElemento.seaVisible(CarritoPage.BTN_PROCEED_TO_CHECKOUT, 20),
                JavaScriptClick.on(CarritoPage.BTN_PROCEED_TO_CHECKOUT),
                EsperarElemento.seaVisible(CheckoutPage.BTN_PLACE_ORDER, 20),
                Delay.forSocialization(),
                ScrollTo.element(CheckoutPage.TXT_COMENTARIOS),
                Enter.theValue(comentario).into(CheckoutPage.TXT_COMENTARIOS),
                Delay.forSocialization(),
                ScrollTo.element(CheckoutPage.BTN_PLACE_ORDER),
                JavaScriptClick.on(CheckoutPage.BTN_PLACE_ORDER),
                EsperarElemento.seaVisible(PagoPage.TXT_NAME_ON_CARD, 20),
                Delay.forSocialization()
        );
    }
}
