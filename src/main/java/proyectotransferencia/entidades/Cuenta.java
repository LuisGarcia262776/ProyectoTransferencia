/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotransferencia.entidades;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class Cuenta {
    private Integer IdCuenta;
    private String NumeroCuenta;
    private GregorianCalendar fechaApertura;
    private Double saldo;
    private String estado;
    private Cliente cliente;

    public Cuenta() {
    }

    public Cuenta(Integer IdCuenta, String NumeroCuenta, GregorianCalendar fechaApertura, Double saldo, String estado, Cliente cliente) {
        this.IdCuenta = IdCuenta;
        this.NumeroCuenta = NumeroCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.estado = estado;
        this.cliente = cliente;
    }

    public Integer getIdCuenta() {
        return IdCuenta;
    }

    public void setIdCuenta(Integer IdCuenta) {
        this.IdCuenta = IdCuenta;
    }

    public String getNumeroCuenta() {
        return NumeroCuenta;
    }

    public void setNumeroCuenta(String NumeroCuenta) {
        this.NumeroCuenta = NumeroCuenta;
    }

    public GregorianCalendar getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(GregorianCalendar fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    

    
}
