package co.com.automationexercise.compra.questions;

import co.com.automationexercise.compra.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/**
 * Pregunta (Question) que verifica el mensaje de error cuando se intenta registrar un correo ya existente.
 */
public class ElMensajeDeErrorRegistro implements Question<String> {

    public static ElMensajeDeErrorRegistro visible() {
        return new ElMensajeDeErrorRegistro();
    }

    @Override
    public String answeredBy(Actor actor) {
        return LoginPage.LBL_ERROR_EMAIL_EXISTENTE.resolveFor(actor).getText().trim();
    }
}
