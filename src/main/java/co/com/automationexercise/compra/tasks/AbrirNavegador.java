package co.com.automationexercise.compra.tasks;

import co.com.automationexercise.compra.interactions.Delay;
import co.com.automationexercise.compra.interactions.EsperarElemento;
import co.com.automationexercise.compra.interactions.JavaScriptClick;
import co.com.automationexercise.compra.userinterfaces.HomePage;
import co.com.automationexercise.compra.utils.Constantes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

/**
 * Tarea para abrir la aplicación web en la página de inicio.
 * Incluye tolerancia para la verificación inicial de red / Cloudflare
 * y reseteo de sesión para garantizar el principio F.I.R.S.T (Independent).
 */
public class AbrirNavegador implements Task {

    public static AbrirNavegador enAutomationExercise() {
        return Tasks.instrumented(AbrirNavegador.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(Constantes.URL_AUTOMATION_EXERCISE),
                Delay.ofSeconds(6)
        );

        if (HomePage.BTN_LOGOUT.resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    JavaScriptClick.on(HomePage.BTN_LOGOUT),
                    Delay.forSocialization()
            );
        }

        actor.attemptsTo(
                EsperarElemento.seaVisible(HomePage.BTN_SIGNUP_LOGIN, 20),
                Delay.forSocialization()
        );
    }
}
