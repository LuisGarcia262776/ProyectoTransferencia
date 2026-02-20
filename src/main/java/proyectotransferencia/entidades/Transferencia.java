/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotransferencia.entidades;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class Transferencia{
    private Float monto;
    private String concepto;
    private Operaciones operacion;

    public Transferencia() {
    }

    public Transferencia(Float monto, String concepto, Operaciones operacion) {
        this.monto = monto;
        this.concepto = concepto;
        this.operacion = operacion;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Operaciones getOperacion() {
        return operacion;
    }

    public void setOperacion(Operaciones operacion) {
        this.operacion = operacion;
    }

    
    
    
    
}
