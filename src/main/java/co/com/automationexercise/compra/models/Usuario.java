package co.com.automationexercise.compra.models;

/**
 * Modelo que representa los datos de un usuario para el registro y autenticación.
 */
public class Usuario {

    private String nombre;
    private String email;
    private String password;
    private String diaNacimiento;
    private String mesNacimiento;
    private String anioNacimiento;
    private String nombrePila;
    private String apellido;
    private String compania;
    private String direccion;
    private String pais;
    private String estado;
    private String ciudad;
    private String codigoPostal;
    private String celular;

    public Usuario(String nombre, String email, String password, String diaNacimiento,
                   String mesNacimiento, String anioNacimiento, String nombrePila,
                   String apellido, String compania, String direccion, String pais,
                   String estado, String ciudad, String codigoPostal, String celular) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.diaNacimiento = diaNacimiento;
        this.mesNacimiento = mesNacimiento;
        this.anioNacimiento = anioNacimiento;
        this.nombrePila = nombrePila;
        this.apellido = apellido;
        this.compania = compania;
        this.direccion = direccion;
        this.pais = pais;
        this.estado = estado;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getDiaNacimiento() {
        return diaNacimiento;
    }

    public String getMesNacimiento() {
        return mesNacimiento;
    }

    public String getAnioNacimiento() {
        return anioNacimiento;
    }

    public String getNombrePila() {
        return nombrePila;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCompania() {
        return compania;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getPais() {
        return pais;
    }

    public String getEstado() {
        return estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public String getCelular() {
        return celular;
    }
}
