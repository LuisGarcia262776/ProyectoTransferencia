package proyectotransferencia.entidades;

import java.util.GregorianCalendar;

/**
 * Representa un retiro de dinero realizado sin una cuenta bancaria asociada.
 * <p>
 * Contiene información sobre el folio del retiro, contraseña de retiro, monto,
 * fecha y hora de solicitud, fecha y hora de cobro, y la operación asociada.
 * </p>
 * 
 * @author PC GAMER MASTER RACE
 */
public class RetiroSinCuenta {
    /**
     * Folio único que identifica el retiro.
     */
    private Integer folio;

    /**
     * Contraseña utilizada para autorizar el retiro.
     */
    private String contraseñaRetiro;

    /**
     * Monto de dinero a retirar.
     */
    private Float monto;

    /**
     * Fecha y hora en que se solicitó el retiro.
     */
    private GregorianCalendar fechaHoraSolicitud;

    /**
     * Fecha y hora en que se cobró el retiro. Puede ser null si aún no se ha cobrado.
     */
    private GregorianCalendar fechaHoraCobro;

    /**
     * Operación asociada al retiro.
     */
    private Operaciones operacion;

    /**
     * Constructor por defecto.
     */
    public RetiroSinCuenta() {
    }

    /**
     * Constructor que inicializa todos los atributos del retiro sin cuenta.
     * 
     * @param folio Folio del retiro.
     * @param contraseñaRetiro Contraseña de autorización del retiro.
     * @param monto Monto del retiro.
     * @param fechaHoraSolicitud Fecha y hora de la solicitud.
     * @param fechaHoraCobro Fecha y hora de cobro.
     * @param operacion Operación asociada al retiro.
     */
    public RetiroSinCuenta(Integer folio, String contraseñaRetiro, Float monto, GregorianCalendar fechaHoraSolicitud, GregorianCalendar fechaHoraCobro, Operaciones operacion) {
        this.folio = folio;
        this.contraseñaRetiro = contraseñaRetiro;
        this.monto = monto;
        this.fechaHoraSolicitud = fechaHoraSolicitud;
        this.fechaHoraCobro = fechaHoraCobro;
        this.operacion = operacion;
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
     * Establece el folio del retiro.
     * 
     * @param folio Folio a asignar.
     */
    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    /**
     * Obtiene la contraseña del retiro.
     * 
     * @return Contraseña del retiro.
     */
    public String getContraseñaRetiro() {
        return contraseñaRetiro;
    }

    /**
     * Establece la contraseña del retiro.
     * 
     * @param contraseñaRetiro Contraseña a asignar.
     */
    public void setContraseñaRetiro(String contraseñaRetiro) {
        this.contraseñaRetiro = contraseñaRetiro;
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
     * Establece el monto del retiro.
     * 
     * @param monto Monto a asignar.
     */
    public void setMonto(Float monto) {
        this.monto = monto;
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
     * Establece la fecha y hora de solicitud del retiro.
     * 
     * @param fechaHoraSolicitud Fecha y hora a asignar.
     */
    public void setFechaHoraSolicitud(GregorianCalendar fechaHoraSolicitud) {
        this.fechaHoraSolicitud = fechaHoraSolicitud;
    }

    /**
     * Obtiene la fecha y hora de cobro del retiro.
     * 
     * @return Fecha y hora de cobro.
     */
    public GregorianCalendar getFechaHoraCobro() {
        return fechaHoraCobro;
    }

    /**
     * Establece la fecha y hora de cobro del retiro.
     * 
     * @param fechaHoraCobro Fecha y hora a asignar.
     */
    public void setFechaHoraCobro(GregorianCalendar fechaHoraCobro) {
        this.fechaHoraCobro = fechaHoraCobro;
    }

    /**
     * Obtiene la operación asociada al retiro.
     * 
     * @return Operación asociada.
     */
    public Operaciones getOperacion() {
        return operacion;
    }

    /**
     * Establece la operación asociada al retiro.
     * 
     * @param operacion Operación a asignar.
     */
    public void setOperacion(Operaciones operacion) {
        this.operacion = operacion;
    }
}