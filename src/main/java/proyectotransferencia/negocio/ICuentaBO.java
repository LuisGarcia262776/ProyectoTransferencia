/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectotransferencia.negocio;

import proyectotransferencia.dtos.NuevaCuentaDTO;
import proyectotransferencia.entidades.Cuenta;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public interface ICuentaBO {
    
    public abstract Cuenta crearCuenta(NuevaCuentaDTO nuevaCuenta)throws NegocioException;
    
}
