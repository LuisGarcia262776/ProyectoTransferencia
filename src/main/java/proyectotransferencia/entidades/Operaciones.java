package proyectotransferencia.entidades;

import java.util.GregorianCalendar;

/**
 * Representa una operación financiera realizada en una cuenta bancaria.
 * <p>
 * Cada operación tiene un identificador único, fecha y hora de realización,
 * tipo de operación (por ejemplo, retiro o transferencia) y la cuenta asociada.
 * </p>
 * 
 * @author PC GAMER MASTER RACE
 */
public class Operaciones {
    /**
     * Identificador único de la operación.
     */
    private Integer idOperacion;

    /**
     * Fecha y hora en que se realizó la operación.
     */
    private GregorianCalendar fechaHora;

    /**
     * Tipo de operación (por ejemplo, "RETIROSINTARJETA" o "TRANSFERENCIA").
     */
    private String tipoOperacion;

    /**
     * Cuenta asociada a la operación.
     */
    private Cuenta cuenta;

    /**
     * Constructor por defecto.
     */
    public Operaciones() {
    }

    /**
     * Constructor que inicializa todos los atributos de la operación.
     * 
     * @param idOperacion Identificador único de la operación.
     * @param fechaHora Fecha y hora de la operación.
     * @param tipoOperacion Tipo de operación.
     * @param cuenta Cuenta asociada a la operación.
     */
    public Operaciones(Integer idOperacion, GregorianCalendar fechaHora, String tipoOperacion, Cuenta cuenta) {
        this.idOperacion = idOperacion;
        this.fechaHora = fechaHora;
        this.tipoOperacion = tipoOperacion;
        this.cuenta = cuenta;
    }

    /**
     * Obtiene el identificador de la operación.
     * 
     * @return Identificador de la operación.
     */
    public Integer getIdOperacion() {
        return idOperacion;
    }

    /**
     * Establece el identificador de la operación.
     * 
     * @param idOperacion Identificador a asignar.
     */
    public void setIdOperacion(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }

    /**
     * Obtiene la fecha y hora de la operación.
     * 
     * @return Fecha y hora de la operación.
     */
    public GregorianCalendar getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora de la operación.
     * 
     * @param fechaHora Fecha y hora a asignar.
     */
    public void setFechaHora(GregorianCalendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene el tipo de operación.
     * 
     * @return Tipo de operación.
     */
    public String getTipoOperacion() {
        return tipoOperacion;
    }

    /**
     * Establece el tipo de operación.
     * 
     * @param tipoOperacion Tipo de operación a asignar.
     */
    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    /**
     * Obtiene la cuenta asociada a la operación.
     * 
     * @return Cuenta asociada.
     */
    public Cuenta getCuenta() {
        return cuenta;
    }

    /**
     * Establece la cuenta asociada a la operación.
     * 
     * @param cuenta Cuenta a asignar.
     */
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}