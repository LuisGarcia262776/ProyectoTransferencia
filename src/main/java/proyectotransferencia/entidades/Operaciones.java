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
public class Operaciones {
    private Integer idOperacion;
    private GregorianCalendar fechaHora;
    private String tipoOperacion;
    private Cuenta cuenta;

    public Operaciones() {
    }

    public Operaciones(Integer idOperacion, GregorianCalendar fechaHora, String tipoOperacion, Cuenta cuenta) {
        this.idOperacion = idOperacion;
        this.fechaHora = fechaHora;
        this.tipoOperacion = tipoOperacion;
        this.cuenta = cuenta;
    }

    public Integer getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }

    public GregorianCalendar getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(GregorianCalendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
    
    
}
