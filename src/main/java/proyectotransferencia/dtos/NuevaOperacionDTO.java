package proyectotransferencia.dtos;

import java.util.GregorianCalendar;
import proyectotransferencia.entidades.Cuenta;

/**
 * Data Transfer Object (DTO) que representa los datos necesarios para crear una operación.
 * <p>
 * Contiene información sobre la fecha y hora de la operación, el tipo de operación
 * y el identificador de la cuenta asociada.
 * </p>
 * 
 * Autor: PC GAMER MASTER RACE
 */
public class NuevaOperacionDTO {

    /**
     * Fecha y hora de la operación.
     */
    private GregorianCalendar fechaHora;

    /**
     * Tipo de operación. Puede ser, por ejemplo, "RETIROSINTARJETA" o "TRANSFERENCIA".
     */
    private String tipoOperacion;

    /**
     * Identificador de la cuenta asociada a la operación.
     */
    private Integer idCuenta;

    /**
     * Constructor por defecto.
     */
    public NuevaOperacionDTO() {
    }

    /**
     * Constructor que inicializa todos los atributos de la operación.
     * 
     * @param fechaHora Fecha y hora de la operación.
     * @param tipoOperacion Tipo de operación.
     * @param idCuenta Identificador de la cuenta asociada.
     */
    public NuevaOperacionDTO(GregorianCalendar fechaHora, String tipoOperacion, Integer idCuenta) {
        this.fechaHora = fechaHora;
        this.tipoOperacion = tipoOperacion;
        this.idCuenta = idCuenta;
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
     * Obtiene el tipo de operación.
     * 
     * @return Tipo de operación.
     */
    public String getTipoOperacion() {
        return tipoOperacion;
    }

    /**
     * Obtiene el identificador de la cuenta asociada a la operación.
     * 
     * @return Id de la cuenta.
     */
    public Integer getIdCuenta() {
        return idCuenta;
    }
}