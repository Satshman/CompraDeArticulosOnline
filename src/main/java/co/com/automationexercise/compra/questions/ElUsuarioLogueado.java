package co.com.automationexercise.compra.questions;

import co.com.automationexercise.compra.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/**
 * Pregunta (Question) que verifica que el usuario se encuentra autenticado en el sistema.
 */
public class ElUsuarioLogueado implements Question<String> {

    public static ElUsuarioLogueado nombreEnPantalla() {
        return new ElUsuarioLogueado();
    }

    @Override
    public String answeredBy(Actor actor) {
        return HomePage.LBL_LOGGED_USER.resolveFor(actor).getText().trim();
    }
}
