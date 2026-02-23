package proyectotransferencia.entidades;

import java.util.GregorianCalendar;

/**
 * Representa una cuenta bancaria asociada a un cliente.
 * <p>
 * Contiene información sobre el identificador de la cuenta, número de cuenta,
 * fecha de apertura, saldo actual, estado de la cuenta y el cliente propietario.
 * </p>
 * 
 * @author PC GAMER MASTER RACE
 */
public class Cuenta {
    /**
     * Identificador único de la cuenta.
     */
    private Integer IdCuenta;

    /**
     * Número de la cuenta bancaria.
     */
    private String NumeroCuenta;

    /**
     * Fecha de apertura de la cuenta.
     */
    private GregorianCalendar fechaApertura;

    /**
     * Saldo actual de la cuenta.
     */
    private Double saldo;

    /**
     * Estado de la cuenta (por ejemplo, "ACTIVA" o "INACTIVA").
     */
    private String estado;

    /**
     * Cliente propietario de la cuenta.
     */
    private Cliente cliente;

    /**
     * Constructor por defecto.
     */
    public Cuenta() {
    }

    /**
     * Constructor que inicializa todos los atributos de la cuenta.
     * 
     * @param IdCuenta Identificador único de la cuenta.
     * @param NumeroCuenta Número de la cuenta bancaria.
     * @param fechaApertura Fecha de apertura de la cuenta.
     * @param saldo Saldo inicial de la cuenta.
     * @param estado Estado de la cuenta ("ACTIVA" o "INACTIVA").
     * @param cliente Cliente propietario de la cuenta.
     */
    public Cuenta(Integer IdCuenta, String NumeroCuenta, GregorianCalendar fechaApertura, Double saldo, String estado, Cliente cliente) {
        this.IdCuenta = IdCuenta;
        this.NumeroCuenta = NumeroCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.estado = estado;
        this.cliente = cliente;
    }

    /**
     * Obtiene el identificador de la cuenta.
     * 
     * @return Identificador de la cuenta.
     */
    public Integer getIdCuenta() {
        return IdCuenta;
    }

    /**
     * Establece el identificador de la cuenta.
     * 
     * @param IdCuenta Identificador a asignar.
     */
    public void setIdCuenta(Integer IdCuenta) {
        this.IdCuenta = IdCuenta;
    }

    /**
     * Obtiene el número de la cuenta.
     * 
     * @return Número de la cuenta bancaria.
     */
    public String getNumeroCuenta() {
        return NumeroCuenta;
    }

    /**
     * Establece el número de la cuenta.
     * 
     * @param NumeroCuenta Número de cuenta a asignar.
     */
    public void setNumeroCuenta(String NumeroCuenta) {
        this.NumeroCuenta = NumeroCuenta;
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
     * Establece la fecha de apertura de la cuenta.
     * 
     * @param fechaApertura Fecha a asignar.
     */
    public void setFechaApertura(GregorianCalendar fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    /**
     * Obtiene el saldo actual de la cuenta.
     * 
     * @return Saldo de la cuenta.
     */
    public Double getSaldo() {
        return saldo;
    }

    /**
     * Establece el saldo de la cuenta.
     * 
     * @param saldo Saldo a asignar.
     */
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    /**
     * Obtiene el estado de la cuenta.
     * 
     * @return Estado de la cuenta ("ACTIVA" o "INACTIVA").
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la cuenta.
     * 
     * @param estado Estado a asignar.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el cliente propietario de la cuenta.
     * 
     * @return Cliente asociado a la cuenta.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente propietario de la cuenta.
     * 
     * @param cliente Cliente a asignar.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}