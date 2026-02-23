package proyectotransferencia.dtos;

/**
 * Data Transfer Object (DTO) que representa los datos necesarios para crear una transferencia.
 * <p>
 * Contiene información sobre el monto, el concepto y el id de la operación asociada.
 * </p>
 * 
 * @author PC GAMER MASTER RACE
 */
public class NuevaTransferenciaDTO {

    /**
     * Monto de la transferencia.
     */
    private Float monto;

    /**
     * Concepto de la transferencia.
     */
    private String concepto;

    /**
     * Identificador de la operación asociada a la transferencia.
     */
    private Integer idOperacion;

    /**
     * Constructor por defecto.
     */
    public NuevaTransferenciaDTO() {
    }

    /**
     * Constructor que inicializa todos los atributos de la transferencia.
     * 
     * @param monto Monto de la transferencia.
     * @param concepto Concepto de la transferencia.
     * @param idOperacion Identificador de la operación asociada.
     */
    public NuevaTransferenciaDTO(Float monto, String concepto, Integer idOperacion) {
        this.monto = monto;
        this.concepto = concepto;
        this.idOperacion = idOperacion;
    }

    /**
     * Obtiene el monto de la transferencia.
     * 
     * @return Monto.
     */
    public Float getMonto() {
        return monto;
    }

    /**
     * Obtiene el concepto de la transferencia.
     * 
     * @return Concepto.
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * Obtiene el identificador de la operación asociada.
     * 
     * @return Id de la operación.
     */
    public Integer getIdOperacion() {
        return idOperacion;
    }
}