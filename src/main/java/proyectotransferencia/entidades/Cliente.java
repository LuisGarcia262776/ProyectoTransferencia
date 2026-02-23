package proyectotransferencia.entidades;

import java.util.GregorianCalendar;

/**
 * Representa un cliente del sistema bancario.
 * <p>
 * Contiene información personal y de registro del cliente, incluyendo
 * nombre, apellidos, domicilio, contraseña, fecha de nacimiento y fecha de registro.
 * </p>
 * 
 * @author PC GAMER MASTER RACE
 */
public class Cliente {
    /**
     * Identificador único del cliente.
     */
    private Integer idCliente; 

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
     * Contraseña de acceso del cliente.
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
    public Cliente() {
    }

    /**
     * Constructor que inicializa todos los atributos del cliente.
     * 
     * @param idCliente Identificador único del cliente.
     * @param nombre Nombre del cliente.
     * @param apellidoPaterno Apellido paterno del cliente.
     * @param apellidoMaterno Apellido materno del cliente.
     * @param domicilio Domicilio del cliente.
     * @param contrasenia Contraseña de acceso del cliente.
     * @param fechaNacimiento Fecha de nacimiento del cliente.
     * @param fechaRegistro Fecha de registro en el sistema.
     */
    public Cliente(Integer idCliente, String nombre, String apellidoPaterno, String apellidoMaterno, String domicilio, String contrasenia, GregorianCalendar fechaNacimiento, GregorianCalendar fechaRegistro) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.contrasenia = contrasenia;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Obtiene el identificador del cliente.
     * 
     * @return ID del cliente.
     */
    public Integer getIdCliente() {
        return idCliente;
    }

    /**
     * Establece el identificador del cliente.
     * 
     * @param idCliente ID a asignar.
     */
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
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
     * Establece el nombre del cliente.
     * 
     * @param nombre Nombre a asignar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     * Establece el apellido paterno del cliente.
     * 
     * @param apellidoPaterno Apellido paterno a asignar.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
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
     * Establece el apellido materno del cliente.
     * 
     * @param apellidoMaterno Apellido materno a asignar.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
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
     * Establece el domicilio del cliente.
     * 
     * @param domicilio Domicilio a asignar.
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
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
     * Establece la fecha de nacimiento del cliente.
     * 
     * @param fechaNacimiento Fecha de nacimiento a asignar.
     */
    public void setFechaNacimiento(GregorianCalendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene la contraseña del cliente.
     * 
     * @return Contraseña del cliente.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contraseña del cliente.
     * 
     * @param contrasenia Contraseña a asignar.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene la fecha de registro del cliente en el sistema.
     * 
     * @return Fecha de registro.
     */
    public GregorianCalendar getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Establece la fecha de registro del cliente en el sistema.
     * 
     * @param fechaRegistro Fecha a asignar.
     */
    public void setFechaRegistro(GregorianCalendar fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}