package proyectotransferencia.entidades;

/**
 * Representa una transferencia bancaria realizada desde una cuenta.
 * <p>
 * Contiene información del monto transferido, el concepto de la transferencia
 * y la operación asociada a esta transferencia.
 * </p>
 * 
 * @author PC GAMER MASTER RACE
 */
public class Transferencia{
    /**
     * Monto de dinero transferido.
     */
    private Float monto;

    /**
     * Concepto o descripción de la transferencia.
     */
    private String concepto;

    /**
     * Operación asociada a esta transferencia.
     */
    private Operaciones operacion;

    /**
     * Constructor por defecto.
     */
    public Transferencia() {
    }

    /**
     * Constructor que inicializa todos los atributos de la transferencia.
     * 
     * @param monto Monto de la transferencia.
     * @param concepto Concepto de la transferencia.
     * @param operacion Operación asociada a la transferencia.
     */
    public Transferencia(Float monto, String concepto, Operaciones operacion) {
        this.monto = monto;
        this.concepto = concepto;
        this.operacion = operacion;
    }

    /**
     * Obtiene el monto de la transferencia.
     * 
     * @return Monto transferido.
     */
    public Float getMonto() {
        return monto;
    }

    /**
     * Establece el monto de la transferencia.
     * 
     * @param monto Monto a asignar.
     */
    public void setMonto(Float monto) {
        this.monto = monto;
    }

    /**
     * Obtiene el concepto de la transferencia.
     * 
     * @return Concepto de la transferencia.
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * Establece el concepto de la transferencia.
     * 
     * @param concepto Concepto a asignar.
     */
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    /**
     * Obtiene la operación asociada a la transferencia.
     * 
     * @return Operación asociada.
     */
    public Operaciones getOperacion() {
        return operacion;
    }

    /**
     * Establece la operación asociada a la transferencia.
     * 
     * @param operacion Operación a asignar.
     */
    public void setOperacion(Operaciones operacion) {
        this.operacion = operacion;
    }
}