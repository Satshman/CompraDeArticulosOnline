package co.com.automationexercise.compra.utils;

/**
 * Constantes utilizadas a lo largo del framework de pruebas.
 */
public final class Constantes {

    private Constantes() {}

    public static final String URL_AUTOMATION_EXERCISE = "https://automationexercise.com";
    public static final String MENSAJE_ORDEN_CONFIRMADA = "ORDER PLACED!";
    public static final String MENSAJE_EXITO_ORDEN = "Congratulations! Your order has been confirmed!";
    public static final String MENSAJE_CUENTA_CREADA = "ACCOUNT CREATED!";
    public static final String MENSAJE_EMAIL_EXISTENTE = "Email Address already exist!";
    public static final String ACTOR_DEFAULT = "Comprador";

    // Constante para el tiempo de retraso entre interacciones (socialización)
    public static final int DELAY_POR_DEFECTO_MS = 1000;
}
