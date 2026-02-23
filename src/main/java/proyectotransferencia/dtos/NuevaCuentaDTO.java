package proyectotransferencia.dtos;

import java.util.GregorianCalendar;
import proyectotransferencia.entidades.Cliente;

/**
 * Data Transfer Object (DTO) que representa los datos necesarios para crear una cuenta.
 * <p>
 * Contiene información sobre el número de cuenta, fecha de apertura, saldo inicial,
 * estado de la cuenta y el identificador del cliente asociado.
 * </p>
 * 
 * Autor: PC GAMER MASTER RACE
 */
public class NuevaCuentaDTO {

    /**
     * Número de la cuenta.
     */
    private String numeroCuenta;

    /**
     * Fecha de apertura de la cuenta.
     */
    private GregorianCalendar fechaApertura;

    /**
     * Saldo inicial de la cuenta.
     */
    private Double saldo;

    /**
     * Estado de la cuenta, por ejemplo "ACTIVA" o "INACTIVA".
     */
    private String estado;

    /**
     * Identificador del cliente propietario de la cuenta.
     */
    private Integer idCliente;

    /**
     * Constructor por defecto.
     */
    public NuevaCuentaDTO() {
    }

    /**
     * Constructor que inicializa todos los atributos de la cuenta.
     * 
     * @param numeroCuenta Número de la cuenta.
     * @param fechaApertura Fecha de apertura de la cuenta.
     * @param saldo Saldo inicial de la cuenta.
     * @param estado Estado de la cuenta.
     * @param idCliente Id del cliente propietario.
     */
    public NuevaCuentaDTO(String numeroCuenta, GregorianCalendar fechaApertura, Double saldo, String estado, Integer idCliente) {
        this.numeroCuenta = numeroCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.estado = estado;
        this.idCliente = idCliente;
    }

    /**
     * Obtiene el número de la cuenta.
     * 
     * @return Número de cuenta.
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Obtiene la fecha de apertura de la cuenta.
     * 
     * @return Fecha de apertura.
     */
    public GregorianCalendar getFechaApertura() {
        return fechaApertura;
    }

    /**
     * Obtiene el saldo inicial de la cuenta.
     * 
     * @return Saldo de la cuenta.
     */
    public Double getSaldo() {
        return saldo;
    }

    /**
     * Obtiene el estado de la cuenta.
     * 
     * @return Estado de la cuenta.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Obtiene el identificador del cliente propietario de la cuenta.
     * 
     * @return Id del cliente.
     */
    public Integer getIdCliente() {
        return idCliente;
    }
}