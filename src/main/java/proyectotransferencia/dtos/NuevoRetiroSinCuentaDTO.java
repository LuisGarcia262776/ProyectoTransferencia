package proyectotransferencia.dtos;

import java.util.GregorianCalendar;
import proyectotransferencia.entidades.Operaciones;

/**
 * Data Transfer Object (DTO) que representa un retiro sin cuenta.
 * <p>
 * Contiene información necesaria para crear un retiro sin cuenta,
 * incluyendo folio, contraseña de retiro, monto, fechas y operación asociada.
 * </p>
 * 
 * @author PC GAMER MASTER RACE
 */
public class NuevoRetiroSinCuentaDTO {
    /**
     * Folio único del retiro.
     */
    private Integer folio;

    /**
     * Contraseña requerida para realizar el retiro.
     */
    private String contraseñaRetiro;

    /**
     * Monto a retirar.
     */
    private Float monto;

    /**
     * Fecha y hora en que se solicitó el retiro.
     */
    private GregorianCalendar fechaHoraSolicitud;

    /**
     * Fecha y hora en que se realizó el cobro del retiro.
     */
    private GregorianCalendar fechaHoraCobro;

    /**
     * Operación asociada al retiro.
     */
    private Operaciones idOperacion;

    /**
     * Constructor por defecto.
     */
    public NuevoRetiroSinCuentaDTO() {
    }

    /**
     * Constructor que inicializa todos los atributos del retiro.
     * 
     * @param folio Folio del retiro.
     * @param contraseñaRetiro Contraseña del retiro.
     * @param monto Monto a retirar.
     * @param fechaHoraSolicitud Fecha y hora de solicitud del retiro.
     * @param fechaHoraCobro Fecha y hora del cobro del retiro.
     * @param idOperacion Operación asociada al retiro.
     */
    public NuevoRetiroSinCuentaDTO(Integer folio, String contraseñaRetiro, Float monto, GregorianCalendar fechaHoraSolicitud, GregorianCalendar fechaHoraCobro, Operaciones idOperacion) {
        this.folio = folio;
        this.contraseñaRetiro = contraseñaRetiro;
        this.monto = monto;
        this.fechaHoraSolicitud = fechaHoraSolicitud;
        this.fechaHoraCobro = fechaHoraCobro;
        this.idOperacion = idOperacion;
    }

    /**
     * Obtiene el folio del retiro.
     * 
     * @return Folio del retiro.
     */
    public Integer getFolio() {
        return folio;
    }

    /**
     * Obtiene la contraseña de retiro.
     * 
     * @return Contraseña de retiro.
     */
    public String getContraseñaRetiro() {
        return contraseñaRetiro;
    }

    /**
     * Obtiene el monto del retiro.
     * 
     * @return Monto del retiro.
     */
    public Float getMonto() {
        return monto;
    }

    /**
     * Obtiene la fecha y hora de solicitud del retiro.
     * 
     * @return Fecha y hora de solicitud.
     */
    public GregorianCalendar getFechaHoraSolicitud() {
        return fechaHoraSolicitud;
    }

    /**
     * Obtiene la fecha y hora en que se realizó el cobro.
     * 
     * @return Fecha y hora del cobro.
     */
    public GregorianCalendar getFechaHoraCobro() {
        return fechaHoraCobro;
    }

    /**
     * Obtiene la operación asociada al retiro.
     * 
     * @return Operación asociada.
     */
    public Operaciones getIdOperacion() {
        return idOperacion;
    }
}