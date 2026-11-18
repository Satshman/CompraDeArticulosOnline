package co.com.automationexercise.compra.questions;

import co.com.automationexercise.compra.userinterfaces.ConfirmacionOrdenPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/**
 * Pregunta (Question) que verifica la confirmación exitosa de la orden de compra.
 */
public class LaConfirmacionDeLaOrden implements Question<String> {

    public static LaConfirmacionDeLaOrden textoVisible() {
        return new LaConfirmacionDeLaOrden();
    }

    @Override
    public String answeredBy(Actor actor) {
        if (ConfirmacionOrdenPage.LBL_ORDER_PLACED.resolveFor(actor).isVisible()) {
            return ConfirmacionOrdenPage.LBL_ORDER_PLACED.resolveFor(actor).getText().trim();
        }
        return ConfirmacionOrdenPage.LBL_SUCCESS_MESSAGE.resolveFor(actor).getText().trim();
    }
}
