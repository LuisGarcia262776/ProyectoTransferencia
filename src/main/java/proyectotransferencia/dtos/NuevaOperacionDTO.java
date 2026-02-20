/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotransferencia.dtos;

import java.util.Date;
import java.util.GregorianCalendar;
import proyectotransferencia.entidades.Cuenta;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class NuevaOperacionDTO {
    private GregorianCalendar fechaHora;
    private String tipoOperacion;
    private Integer idCuenta;

    public NuevaOperacionDTO() {
    }

    public NuevaOperacionDTO(GregorianCalendar fechaHora, String tipoOperacion, Integer idCuenta) {
        this.fechaHora = fechaHora;
        this.tipoOperacion = tipoOperacion;
        this.idCuenta = idCuenta;
    }

    public GregorianCalendar getFechaHora() {
        return fechaHora;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }
    
    
    
}
