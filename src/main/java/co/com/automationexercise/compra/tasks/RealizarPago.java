package co.com.automationexercise.compra.tasks;

import co.com.automationexercise.compra.interactions.Delay;
import co.com.automationexercise.compra.interactions.EsperarElemento;
import co.com.automationexercise.compra.interactions.JavaScriptClick;
import co.com.automationexercise.compra.models.TarjetaCredito;
import co.com.automationexercise.compra.userinterfaces.ConfirmacionOrdenPage;
import co.com.automationexercise.compra.userinterfaces.PagoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;

/**
 * Tarea de negocio para ingresar los datos de la tarjeta de crédito
 * y confirmar el pago de la orden de compra.
 */
public class RealizarPago implements Task {

    private final TarjetaCredito tarjeta;

    public RealizarPago(TarjetaCredito tarjeta) {
        this.tarjeta = tarjeta;
    }

    public static RealizarPago conTarjeta(TarjetaCredito tarjeta) {
        return Tasks.instrumented(RealizarPago.class, tarjeta);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(tarjeta.getNombreTitular()).into(PagoPage.TXT_NAME_ON_CARD),
                Enter.theValue(tarjeta.getNumeroTarjeta()).into(PagoPage.TXT_CARD_NUMBER),
                Enter.theValue(tarjeta.getCvc()).into(PagoPage.TXT_CVC),
                Enter.theValue(tarjeta.getMesExpiracion()).into(PagoPage.TXT_EXPIRY_MONTH),
                Enter.theValue(tarjeta.getAnioExpiracion()).into(PagoPage.TXT_EXPIRY_YEAR),
                Delay.forSocialization(),
                JavaScriptClick.on(PagoPage.BTN_PAY_AND_CONFIRM),
                EsperarElemento.seaVisible(ConfirmacionOrdenPage.LBL_ORDER_PLACED, 15),
                Delay.forSocialization()
        );
    }
}
