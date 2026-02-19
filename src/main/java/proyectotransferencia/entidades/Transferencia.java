/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotransferencia.entidades;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class Transferencia extends Operaciones {
    private Float monto;
    private String concepto;

    public Transferencia() {
    }

    public Transferencia(Float monto, String concepto) {
        this.monto = monto;
        this.concepto = concepto;
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
    
    
    
}
