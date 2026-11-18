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
 * Tarea de negocio para iniciar sesión con credenciales existentes.
 */
public class IniciarSesion implements Task {

    private final String email;
    private final String password;

    public IniciarSesion(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static IniciarSesion conCredenciales(String email, String password) {
        return Tasks.instrumented(IniciarSesion.class, email, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.BTN_SIGNUP_LOGIN),
                EsperarElemento.seaVisible(LoginPage.TXT_LOGIN_EMAIL),
                Delay.forSocialization(),
                Enter.theValue(email).into(LoginPage.TXT_LOGIN_EMAIL),
                Enter.theValue(password).into(LoginPage.TXT_LOGIN_PASSWORD),
                Delay.forSocialization(),
                Click.on(LoginPage.BTN_LOGIN),
                Delay.forSocialization()
        );
    }
}
