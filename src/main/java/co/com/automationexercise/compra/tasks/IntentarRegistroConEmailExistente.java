package co.com.automationexercise.compra.tasks;

import co.com.automationexercise.compra.interactions.Delay;
import co.com.automationexercise.compra.interactions.EsperarElemento;
import co.com.automationexercise.compra.userinterfaces.HomePage;
import co.com.automationexercise.compra.userinterfaces.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

/**
 * Tarea para probar el camino excepcional:
 * Intentar registrar un usuario con un correo electrónico previamente registrado en el sistema.
 */
public class IntentarRegistroConEmailExistente implements Task {

    private final String nombre;
    private final String email;

    public IntentarRegistroConEmailExistente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public static IntentarRegistroConEmailExistente conCredenciales(String nombre, String email) {
        return Tasks.instrumented(IntentarRegistroConEmailExistente.class, nombre, email);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (!LoginPage.TXT_SIGNUP_NAME.resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    Click.on(HomePage.BTN_SIGNUP_LOGIN),
                    EsperarElemento.seaVisible(LoginPage.TXT_SIGNUP_NAME, 10)
            );
        }
        actor.attemptsTo(
                Delay.forSocialization(),
                Enter.theValue(nombre).into(LoginPage.TXT_SIGNUP_NAME),
                Enter.theValue(email).into(LoginPage.TXT_SIGNUP_EMAIL),
                Delay.forSocialization(),
                Click.on(LoginPage.BTN_SIGNUP),
                Delay.forSocialization()
        );
    }
}
