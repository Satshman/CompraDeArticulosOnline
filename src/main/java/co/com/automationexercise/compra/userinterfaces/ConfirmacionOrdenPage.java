package co.com.automationexercise.compra.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Mapeo de elementos de la página final de confirmación de la orden (/payment_done/...).
 */
public final class ConfirmacionOrdenPage {

    private ConfirmacionOrdenPage() {}

    public static final Target LBL_ORDER_PLACED = Target.the("título de confirmación ORDER PLACED!")
            .located(By.xpath("//*[@data-qa='order-placed'] | //h2[contains(., 'ORDER PLACED!') or contains(., 'Order Placed!')]"));

    public static final Target LBL_SUCCESS_MESSAGE = Target.the("mensaje de éxito de orden confirmada")
            .located(By.xpath("//p[contains(text(), 'Congratulations! Your order has been confirmed!') or contains(text(), 'Your order has been placed successfully!')]"));

    public static final Target BTN_DOWNLOAD_INVOICE = Target.the("botón Download Invoice")
            .located(By.xpath("//a[contains(@href, '/download_invoice')]"));

    public static final Target BTN_CONTINUE = Target.the("botón Continue final")
            .located(By.cssSelector("a[data-qa='continue-button']"));
}
