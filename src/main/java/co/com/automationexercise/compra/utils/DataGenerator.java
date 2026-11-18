package co.com.automationexercise.compra.utils;

import co.com.automationexercise.compra.models.TarjetaCredito;
import co.com.automationexercise.compra.models.Usuario;

import java.util.UUID;

/**
 * Utilidad para la generación dinámica de datos de prueba.
 * Garantiza el principio F.I.R.S.T (Independent y Repeatable),
 * evitando pruebas frágiles por colisiones de datos preexistentes.
 */
public final class DataGenerator {

    private DataGenerator() {}

    /**
     * Genera una instancia de Usuario con información única y válida.
     */
    public static Usuario generarUsuarioValido() {
        long timestamp = System.currentTimeMillis();
        String uuidPart = UUID.randomUUID().toString().substring(0, 5);

        String nombre = "Tester" + uuidPart;
        String email = "auto_" + timestamp + "_" + uuidPart + "@mailinator.com";
        String password = "Password" + uuidPart + "123!";

        return new Usuario(
                nombre,
                email,
                password,
                "15",
                "5",
                "1995",
                "Juan",
                "Perez",
                "Calidad Soft S.A.S",
                "Calle 100 # 15-20",
                "United States",
                "Florida",
                "Miami",
                "33101",
                "+13055551234"
        );
    }

    /**
     * Genera una tarjeta de crédito válida para pruebas de checkout.
     */
    public static TarjetaCredito generarTarjetaCreditoValida() {
        return new TarjetaCredito(
                "Juan Perez",
                "4000123456789010",
                "311",
                "12",
                "2028"
        );
    }

    /**
     * Retorna un correo existente / constante para la prueba de camino de excepción.
     */
    public static String obtenerEmailExistente() {
        return "usuario_existente_fijo@automationtest.com";
    }
}
