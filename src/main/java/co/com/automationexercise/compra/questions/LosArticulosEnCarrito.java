package co.com.automationexercise.compra.questions;

import co.com.automationexercise.compra.userinterfaces.CarritoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/**
 * Pregunta (Question) que verifica la cantidad de artículos en el carrito de compras.
 */
public class LosArticulosEnCarrito implements Question<Integer> {

    public static LosArticulosEnCarrito cantidad() {
        return new LosArticulosEnCarrito();
    }

    @Override
    public Integer answeredBy(Actor actor) {
        return CarritoPage.FILAS_PRODUCTOS.resolveAllFor(actor).size();
    }
}
