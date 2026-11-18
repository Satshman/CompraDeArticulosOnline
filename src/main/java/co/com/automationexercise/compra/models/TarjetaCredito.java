package co.com.automationexercise.compra.models;

/**
 * Modelo que representa la información de pago con tarjeta de crédito.
 */
public class TarjetaCredito {

    private String nombreTitular;
    private String numeroTarjeta;
    private String cvc;
    private String mesExpiracion;
    private String anioExpiracion;

    public TarjetaCredito(String nombreTitular, String numeroTarjeta, String cvc,
                          String mesExpiracion, String anioExpiracion) {
        this.nombreTitular = nombreTitular;
        this.numeroTarjeta = numeroTarjeta;
        this.cvc = cvc;
        this.mesExpiracion = mesExpiracion;
        this.anioExpiracion = anioExpiracion;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public String getCvc() {
        return cvc;
    }

    public String getMesExpiracion() {
        return mesExpiracion;
    }

    public String getAnioExpiracion() {
        return anioExpiracion;
    }
}
