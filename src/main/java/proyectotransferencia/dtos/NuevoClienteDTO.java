package proyectotransferencia.dtos;

import java.util.GregorianCalendar;

/**
 * Data Transfer Object (DTO) que representa los datos de un nuevo cliente.
 * <p>
 * Contiene información necesaria para crear un cliente,
 * incluyendo nombre, apellidos, domicilio, contraseña y fechas.
 * </p>
 * 
 * @author PC GAMER MASTER RACE
 */
public class NuevoClienteDTO {
    /**
     * Nombre del cliente.
     */
    private String nombre;

    /**
     * Apellido paterno del cliente.
     */
    private String apellidoPaterno;

    /**
     * Apellido materno del cliente.
     */
    private String apellidoMaterno;

    /**
     * Domicilio del cliente.
     */
    private String domicilio;

    /**
     * Contraseña para la cuenta del cliente.
     */
    private String contrasenia;

    /**
     * Fecha de nacimiento del cliente.
     */
    private GregorianCalendar fechaNacimiento;      

    /**
     * Fecha de registro del cliente en el sistema.
     */
    private GregorianCalendar fechaRegistro;        

    /**
     * Constructor por defecto.
     */
    public NuevoClienteDTO() {
    }

    /**
     * Constructor que inicializa todos los atributos del cliente.
     * 
     * @param nombre Nombre del cliente.
     * @param apellidoPaterno Apellido paterno del cliente.
     * @param apellidoMaterno Apellido materno del cliente.
     * @param domicilio Domicilio del cliente.
     * @param contrasenia Contraseña del cliente.
     * @param fechaNacimiento Fecha de nacimiento del cliente.
     * @param fechaRegistro Fecha de registro del cliente en el sistema.
     */
    public NuevoClienteDTO(String nombre, String apellidoPaterno, String apellidoMaterno, String domicilio, String contrasenia, GregorianCalendar fechaNacimiento, GregorianCalendar fechaRegistro) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasenia = contrasenia;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Obtiene el nombre del cliente.
     * 
     * @return Nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el apellido paterno del cliente.
     * 
     * @return Apellido paterno.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del cliente.
     * 
     * @return Apellido materno.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Obtiene el domicilio del cliente.
     * 
     * @return Domicilio del cliente.
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * Obtiene la fecha de nacimiento del cliente.
     * 
     * @return Fecha de nacimiento.
     */
    public GregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Obtiene la contraseña del cliente.
     * 
     * @return Contraseña.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Obtiene la fecha de registro del cliente en el sistema.
     * 
     * @return Fecha de registro.
     */
    public GregorianCalendar getFechaRegistro() {
        return fechaRegistro;
    }
}