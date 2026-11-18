package co.com.automationexercise.compra.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Mapeo de elementos de la página de inicio (Home) y barra de navegación.
 */
public final class HomePage {

    private HomePage() {}

    public static final Target BTN_SIGNUP_LOGIN = Target.the("botón Signup / Login")
            .located(By.xpath("//a[contains(@href, '/login')]"));

    public static final Target BTN_CART = Target.the("botón Cart")
            .located(By.xpath("//a[contains(@href, '/view_cart')]"));

    public static final Target BTN_PRODUCTS = Target.the("botón Products")
            .located(By.xpath("//a[contains(@href, '/products')]"));

    public static final Target LBL_LOGGED_USER = Target.the("etiqueta de usuario autenticado")
            .located(By.xpath("//a[contains(., 'Logged in as')]"));

    public static final Target BTN_LOGOUT = Target.the("botón Logout")
            .located(By.xpath("//a[contains(@href, '/logout')]"));

    public static final Target BTN_DELETE_ACCOUNT = Target.the("botón Delete Account")
            .located(By.xpath("//a[contains(@href, '/delete_account')]"));

    public static final Target PRIMER_PRODUCTO_ADD = Target.the("primer botón Add to cart")
            .located(By.xpath("(//a[contains(@class, 'add-to-cart')])[1]"));

    public static final Target SEGUNDO_PRODUCTO_ADD = Target.the("segundo botón Add to cart")
            .located(By.xpath("(//div[@class='productinfo text-center']//a[contains(@class, 'add-to-cart')])[2]"));

    public static final Target MODAL_VIEW_CART = Target.the("enlace View Cart del modal")
            .located(By.xpath("//div[@id='cartModal']//u[contains(text(), 'View Cart')]/.. | //div[@id='cartModal']//a[@href='/view_cart']"));

    public static final Target MODAL_CONTINUE_SHOPPING = Target.the("botón Continue Shopping del modal")
            .located(By.xpath("//div[@id='cartModal']//button[contains(@class, 'close-modal')]"));
}
