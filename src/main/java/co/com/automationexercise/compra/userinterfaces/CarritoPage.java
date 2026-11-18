package co.com.automationexercise.compra.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Mapeo de elementos de la página del carrito de compras (/view_cart).
 */
public final class CarritoPage {

    private CarritoPage() {}

    public static final Target TABLA_PRODUCTOS = Target.the("tabla de productos del carrito")
            .located(By.id("cart_info_table"));

    public static final Target FILAS_PRODUCTOS = Target.the("filas de artículos agregados al carrito")
            .located(By.cssSelector("#cart_info_table tbody tr"));

    public static final Target BTN_PROCEED_TO_CHECKOUT = Target.the("botón Proceed To Checkout")
            .located(By.xpath("//a[contains(@class, 'check_out') or contains(text(), 'Proceed To Checkout')]"));

    public static final Target MODAL_CHECKOUT_REGISTER_LOGIN = Target.the("botón Register / Login en modal de checkout")
            .located(By.xpath("//div[@id='checkoutModal']//u[contains(text(), 'Register / Login')]/.. | //div[@id='checkoutModal']//a[@href='/login']"));
}
