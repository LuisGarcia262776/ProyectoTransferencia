/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotransferencia.dtos;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class NuevaTransferenciaDTO {
    private Float monto;
    private String concepto;
    private Integer idOperacion;

    public NuevaTransferenciaDTO() {
    }

    public NuevaTransferenciaDTO(Float monto, String concepto, Integer idOperacion) {
        this.monto = monto;
        this.concepto = concepto;
        this.idOperacion = idOperacion;
    }

    public Float getMonto() {
        return monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public Integer getIdOperacion() {
        return idOperacion;
    }
    

    
    
    
    
}
