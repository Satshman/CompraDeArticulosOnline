package co.com.automationexercise.compra.tasks;

import co.com.automationexercise.compra.interactions.Delay;
import co.com.automationexercise.compra.interactions.EsperarElemento;
import co.com.automationexercise.compra.interactions.JavaScriptClick;
import co.com.automationexercise.compra.models.Usuario;
import co.com.automationexercise.compra.userinterfaces.HomePage;
import co.com.automationexercise.compra.userinterfaces.LoginPage;
import co.com.automationexercise.compra.userinterfaces.RegistroPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

/**
 * Tarea de negocio que encapsula el registro completo de un nuevo usuario en la plataforma.
 */
public class RegistrarNuevoUsuario implements Task {

    private final Usuario usuario;

    public RegistrarNuevoUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public static RegistrarNuevoUsuario conDatos(Usuario usuario) {
        return Tasks.instrumented(RegistrarNuevoUsuario.class, usuario);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // 1. Navegar al formulario de registro/login
                Click.on(HomePage.BTN_SIGNUP_LOGIN),
                EsperarElemento.seaVisible(LoginPage.TXT_SIGNUP_NAME),
                Delay.forSocialization(),

                // 2. Ingresar nombre y correo inicial
                Enter.theValue(usuario.getNombre()).into(LoginPage.TXT_SIGNUP_NAME),
                Enter.theValue(usuario.getEmail()).into(LoginPage.TXT_SIGNUP_EMAIL),
                Delay.forSocialization(),
                Click.on(LoginPage.BTN_SIGNUP),

                // 3. Completar formulario detallado de cuenta
                EsperarElemento.seaVisible(RegistroPage.RDO_GENERO_MR),
                Click.on(RegistroPage.RDO_GENERO_MR),
                Enter.theValue(usuario.getPassword()).into(RegistroPage.TXT_PASSWORD),
                SelectFromOptions.byValue(usuario.getDiaNacimiento()).from(RegistroPage.SEL_DIA),
                SelectFromOptions.byValue(usuario.getMesNacimiento()).from(RegistroPage.SEL_MES),
                SelectFromOptions.byValue(usuario.getAnioNacimiento()).from(RegistroPage.SEL_ANIO),
                JavaScriptClick.on(RegistroPage.CHK_NEWSLETTER),
                JavaScriptClick.on(RegistroPage.CHK_OPTIN),

                // 4. Completar información de dirección
                Enter.theValue(usuario.getNombrePila()).into(RegistroPage.TXT_FIRST_NAME),
                Enter.theValue(usuario.getApellido()).into(RegistroPage.TXT_LAST_NAME),
                Enter.theValue(usuario.getCompania()).into(RegistroPage.TXT_COMPANY),
                Enter.theValue(usuario.getDireccion()).into(RegistroPage.TXT_ADDRESS),
                SelectFromOptions.byVisibleText(usuario.getPais()).from(RegistroPage.SEL_COUNTRY),
                Enter.theValue(usuario.getEstado()).into(RegistroPage.TXT_STATE),
                Enter.theValue(usuario.getCiudad()).into(RegistroPage.TXT_CITY),
                Enter.theValue(usuario.getCodigoPostal()).into(RegistroPage.TXT_ZIPCODE),
                Enter.theValue(usuario.getCelular()).into(RegistroPage.TXT_MOBILE_NUMBER),
                Delay.forSocialization(),

                // 5. Crear cuenta y continuar
                JavaScriptClick.on(RegistroPage.BTN_CREATE_ACCOUNT),
                EsperarElemento.seaVisible(RegistroPage.LBL_ACCOUNT_CREATED),
                Delay.forSocialization(),
                JavaScriptClick.on(RegistroPage.BTN_CONTINUE),
                Delay.forSocialization()
        );
    }
}
