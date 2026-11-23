package co.com.automationexercise.compra.stepdefinitions;

import co.com.automationexercise.compra.interactions.JavaScriptClick;
import co.com.automationexercise.compra.models.TarjetaCredito;
import co.com.automationexercise.compra.models.Usuario;
import co.com.automationexercise.compra.questions.ElMensajeDeErrorRegistro;
import co.com.automationexercise.compra.questions.LaConfirmacionDeLaOrden;
import co.com.automationexercise.compra.tasks.*;
import co.com.automationexercise.compra.userinterfaces.HomePage;
import co.com.automationexercise.compra.utils.Constantes;
import co.com.automationexercise.compra.utils.DataGenerator;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.CoreMatchers;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

/**
 * Step Definitions para la especificación BDD en lenguaje Gherkin.
 * Conecta las sentencias de negocio con las Tasks y Questions de Screenplay.
 */
public class CompraArticulosStepDefinitions {

    private Usuario usuarioActual;
    private TarjetaCredito tarjetaActual;
    private String emailDuplicado;

    @Before
    public void configurarEscenario() {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled(Constantes.ACTOR_DEFAULT);
    }

    @After
    public void finalizarEscenario() {
        OnStage.drawTheCurtain();
    }

    @Dado("que el comprador abre la página web de Automation Exercise")
    public void queElCompradorAbreLaPaginaWebDeAutomationExercise() {
        theActorInTheSpotlight().wasAbleTo(
                AbrirNavegador.enAutomationExercise()
        );
    }

    @Cuando("el comprador completa el registro con datos válidos de usuario y dirección")
    public void elCompradorCompletaElRegistroConDatosValidosDeUsuarioYDireccion() {
        usuarioActual = DataGenerator.generarUsuarioValido();
        theActorInTheSpotlight().attemptsTo(
                RegistrarNuevoUsuario.conDatos(usuarioActual)
        );
    }

    @Cuando("selecciona un producto del catálogo y lo añade al carrito de compras")
    public void seleccionaUnProductoDelCatalogoYLoAnadeAlCarritoDeCompras() {
        theActorInTheSpotlight().attemptsTo(
                AgregarProductoAlCarrito.enElCatalogo()
        );
    }

    @Cuando("agrega múltiples productos al carrito de compras")
    public void agregaMultiplesProductosAlCarritoDeCompras() {
        theActorInTheSpotlight().attemptsTo(
                AgregarMultiplesProductos.alCarrito()
        );
    }

    @Cuando("procede al checkout completando el pago con tarjeta de crédito")
    public void procedeAlCheckoutCompletandoElPagoConTarjetaDeCredito() {
        tarjetaActual = DataGenerator.generarTarjetaCreditoValida();
        theActorInTheSpotlight().attemptsTo(
                ProcederAlCheckout.estandar(),
                RealizarPago.conTarjeta(tarjetaActual)
        );
    }

    @Entonces("debería observar la orden de compra confirmada con el mensaje {string}")
    public void deberiaObservarLaOrdenDeCompraConfirmadaConElMensaje(String mensajeEsperado) {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        LaConfirmacionDeLaOrden.textoVisible(),
                        CoreMatchers.containsString(mensajeEsperado)
                )
        );
    }

    @Dado("que existe un usuario previamente registrado en la plataforma")
    public void queExisteUnUsuarioPreviamenteRegistradoEnLaPlataforma() {
        Usuario usuarioExistente = DataGenerator.generarUsuarioValido();
        emailDuplicado = usuarioExistente.getEmail();
        theActorInTheSpotlight().attemptsTo(
                RegistrarNuevoUsuario.conDatos(usuarioExistente),
                JavaScriptClick.on(HomePage.BTN_LOGOUT)
        );
    }

    @Cuando("el comprador intenta registrarse nuevamente con el mismo correo electrónico")
    public void elCompradorIntentaRegistrarseNuevamenteConElMismoCorreoElectronico() {
        theActorInTheSpotlight().attemptsTo(
                IntentarRegistroConEmailExistente.conCredenciales("Usuario Duplicado", emailDuplicado)
        );
    }

    @Entonces("debería visualizar el mensaje de advertencia {string}")
    public void deberiaVisualizarElMensajeDeAdvertencia(String mensajeEsperado) {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        ElMensajeDeErrorRegistro.visible(),
                        CoreMatchers.containsString(mensajeEsperado)
                )
        );
    }
}
