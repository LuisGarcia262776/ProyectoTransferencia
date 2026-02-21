/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotransferencia.entidades;

import java.util.GregorianCalendar;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class RetiroSinCuenta {
    private Integer folio;
    private String contraseñaRetiro;
    private Float monto;
    private GregorianCalendar fechaHoraSolicitud;
    private GregorianCalendar fechaHoraCobro;
    private Operaciones operacion;

    public RetiroSinCuenta() {
    }

    public RetiroSinCuenta(Integer folio, String contraseñaRetiro, Float monto, GregorianCalendar fechaHoraSolicitud, GregorianCalendar fechaHoraCobro, Operaciones operacion) {
        this.folio = folio;
        this.contraseñaRetiro = contraseñaRetiro;
        this.monto = monto;
        this.fechaHoraSolicitud = fechaHoraSolicitud;
        this.fechaHoraCobro = fechaHoraCobro;
        this.operacion = operacion;
    }

    public Integer getFolio() {
        return folio;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public String getContraseñaRetiro() {
        return contraseñaRetiro;
    }

    public void setContraseñaRetiro(String contraseñaRetiro) {
        this.contraseñaRetiro = contraseñaRetiro;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public GregorianCalendar getFechaHoraSolicitud() {
        return fechaHoraSolicitud;
    }

    public void setFechaHoraSolicitud(GregorianCalendar fechaHoraSolicitud) {
        this.fechaHoraSolicitud = fechaHoraSolicitud;
    }

    public GregorianCalendar getFechaHoraCobro() {
        return fechaHoraCobro;
    }

    public void setFechaHoraCobro(GregorianCalendar fechaHoraCobro) {
        this.fechaHoraCobro = fechaHoraCobro;
    }

    public Operaciones getOperacion() {
        return operacion;
    }

    public void setOperacion(Operaciones operacion) {
        this.operacion = operacion;
    }

    
    
}
