/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotransferencia.dtos;

import java.util.Date;
import java.util.GregorianCalendar;
import proyectotransferencia.entidades.Cliente;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class NuevaCuentaDTO {
    private String numeroCuenta;
    private GregorianCalendar fechaApertura;
    private Double saldo;
    private String estado;
    private Integer idCliente;

    public NuevaCuentaDTO() {
    }

    public NuevaCuentaDTO(String numeroCuenta, GregorianCalendar fechaApertura, Double saldo, String estado, Integer idCliente) {
        this.numeroCuenta = numeroCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.estado = estado;
        this.idCliente = idCliente;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public GregorianCalendar getFechaApertura() {
        return fechaApertura;
    }

    public Double getSaldo() {
        return saldo;
    }

    public String getEstado() {
        return estado;
    }

    public Integer getIdCliente() {
        return idCliente;
    }
    
    
    
}
