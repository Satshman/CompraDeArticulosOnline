package co.com.automationexercise.compra.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Mapeo de elementos de la página de Checkout (/checkout).
 */
public final class CheckoutPage {

    private CheckoutPage() {}

    public static final Target LBL_DIRECCION_ENTREGA = Target.the("sección dirección de entrega")
            .located(By.id("address_delivery"));

    public static final Target LBL_DIRECCION_FACTURACION = Target.the("sección dirección de facturación")
            .located(By.id("address_invoice"));

    public static final Target TXT_COMENTARIOS = Target.the("campo texto de comentarios del pedido")
            .located(By.name("message"));

    public static final Target BTN_PLACE_ORDER = Target.the("botón Place Order")
            .located(By.xpath("//a[contains(@href, '/payment')]"));
}
