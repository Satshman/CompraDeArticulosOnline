package co.com.automationexercise.compra.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

/**
 * Mapeo de elementos del formulario detallado de registro de usuario (/signup).
 */
public final class RegistroPage {

    private RegistroPage() {}

    public static final Target RDO_GENERO_MR = Target.the("radio botón género Mr")
            .located(By.id("id_gender1"));

    public static final Target TXT_PASSWORD = Target.the("campo contraseña de registro")
            .located(By.id("password"));

    public static final Target SEL_DIA = Target.the("selector día de nacimiento")
            .located(By.id("days"));

    public static final Target SEL_MES = Target.the("selector mes de nacimiento")
            .located(By.id("months"));

    public static final Target SEL_ANIO = Target.the("selector año de nacimiento")
            .located(By.id("years"));

    public static final Target CHK_NEWSLETTER = Target.the("checkbox newsletter")
            .located(By.id("newsletter"));

    public static final Target CHK_OPTIN = Target.the("checkbox ofertas especiales")
            .located(By.id("optin"));

    // Información de dirección
    public static final Target TXT_FIRST_NAME = Target.the("campo primer nombre")
            .located(By.id("first_name"));

    public static final Target TXT_LAST_NAME = Target.the("campo apellido")
            .located(By.id("last_name"));

    public static final Target TXT_COMPANY = Target.the("campo compañía")
            .located(By.id("company"));

    public static final Target TXT_ADDRESS = Target.the("campo dirección")
            .located(By.id("address1"));

    public static final Target SEL_COUNTRY = Target.the("selector país")
            .located(By.id("country"));

    public static final Target TXT_STATE = Target.the("campo estado / departamento")
            .located(By.id("state"));

    public static final Target TXT_CITY = Target.the("campo ciudad")
            .located(By.id("city"));

    public static final Target TXT_ZIPCODE = Target.the("campo código postal")
            .located(By.id("zipcode"));

    public static final Target TXT_MOBILE_NUMBER = Target.the("campo número de celular")
            .located(By.id("mobile_number"));

    public static final Target BTN_CREATE_ACCOUNT = Target.the("botón Create Account")
            .located(By.cssSelector("button[data-qa='create-account']"));

    // Confirmación de cuenta creada
    public static final Target LBL_ACCOUNT_CREATED = Target.the("título de confirmación cuenta creada")
            .located(By.cssSelector("h2[data-qa='account-created']"));

    public static final Target BTN_CONTINUE = Target.the("botón Continue tras crear cuenta")
            .located(By.cssSelector("a[data-qa='continue-button']"));
}
