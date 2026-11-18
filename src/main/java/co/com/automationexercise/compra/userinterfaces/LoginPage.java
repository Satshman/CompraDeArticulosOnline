package co.com.automationexercise.compra.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Mapeo de elementos de la página de Login y formulario de nuevo registro.
 */
public final class LoginPage {

    private LoginPage() {}

    // Formulario de Signup (Nuevo Registro)
    public static final Target TXT_SIGNUP_NAME = Target.the("campo nombre para registro")
            .located(By.cssSelector("input[data-qa='signup-name']"));

    public static final Target TXT_SIGNUP_EMAIL = Target.the("campo email para registro")
            .located(By.cssSelector("input[data-qa='signup-email']"));

    public static final Target BTN_SIGNUP = Target.the("botón Signup")
            .located(By.cssSelector("button[data-qa='signup-button']"));

    // Formulario de Login (Iniciar Sesión)
    public static final Target TXT_LOGIN_EMAIL = Target.the("campo email de login")
            .located(By.cssSelector("input[data-qa='login-email']"));

    public static final Target TXT_LOGIN_PASSWORD = Target.the("campo contraseña de login")
            .located(By.cssSelector("input[data-qa='login-password']"));

    public static final Target BTN_LOGIN = Target.the("botón Login")
            .located(By.cssSelector("button[data-qa='login-button']"));

    // Mensajes de error
    public static final Target LBL_ERROR_EMAIL_EXISTENTE = Target.the("mensaje de error correo existente")
            .located(By.xpath("//form[@action='/signup']//p[contains(text(), 'Email Address already exist!')]"));

    public static final Target LBL_ERROR_LOGIN = Target.the("mensaje de error credenciales inválidas")
            .located(By.xpath("//form[@action='/login']//p[contains(text(), 'incorrect')]"));
}
