package co.com.automationexercise.compra.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Mapeo de elementos de la página de pago (/payment).
 */
public final class PagoPage {

    private PagoPage() {}

    public static final Target TXT_NAME_ON_CARD = Target.the("campo nombre del titular de la tarjeta")
            .located(By.name("name_on_card"));

    public static final Target TXT_CARD_NUMBER = Target.the("campo número de la tarjeta de crédito")
            .located(By.name("card_number"));

    public static final Target TXT_CVC = Target.the("campo código de seguridad CVC")
            .located(By.name("cvc"));

    public static final Target TXT_EXPIRY_MONTH = Target.the("campo mes de expiración")
            .located(By.name("expiry_month"));

    public static final Target TXT_EXPIRY_YEAR = Target.the("campo año de expiración")
            .located(By.name("expiry_year"));

    public static final Target BTN_PAY_AND_CONFIRM = Target.the("botón Pay and Confirm Order")
            .located(By.id("submit"));
}
