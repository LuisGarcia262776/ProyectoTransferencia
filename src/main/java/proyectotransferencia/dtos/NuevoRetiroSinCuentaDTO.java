/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotransferencia.dtos;

import java.util.GregorianCalendar;
import proyectotransferencia.entidades.Operaciones;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class NuevoRetiroSinCuentaDTO {
    private Integer folio;
    private String contraseñaRetiro;
    private Float monto;
    private GregorianCalendar fechaHoraSolicitud;
    private GregorianCalendar fechaHoraCobro;
    private Operaciones idOperacion;

    public NuevoRetiroSinCuentaDTO() {
    }

    public NuevoRetiroSinCuentaDTO(Integer folio, String contraseñaRetiro, Float monto, GregorianCalendar fechaHoraSolicitud, GregorianCalendar fechaHoraCobro, Operaciones idOperacion) {
        this.folio = folio;
        this.contraseñaRetiro = contraseñaRetiro;
        this.monto = monto;
        this.fechaHoraSolicitud = fechaHoraSolicitud;
        this.fechaHoraCobro = fechaHoraCobro;
        this.idOperacion = idOperacion;
    }

    public Integer getFolio() {
        return folio;
    }

    public String getContraseñaRetiro() {
        return contraseñaRetiro;
    }

    public Float getMonto() {
        return monto;
    }

    public GregorianCalendar getFechaHoraSolicitud() {
        return fechaHoraSolicitud;
    }

    public GregorianCalendar getFechaHoraCobro() {
        return fechaHoraCobro;
    }

    public Operaciones getIdOperacion() {
        return idOperacion;
    }
    
    

}

    
