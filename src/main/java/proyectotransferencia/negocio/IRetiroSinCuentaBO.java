/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectotransferencia.negocio;

import java.util.GregorianCalendar;
import proyectotransferencia.dtos.NuevoRetiroSinCuentaDTO;
import proyectotransferencia.entidades.RetiroSinCuenta;
/**
 *
 * @author PC GAMER MASTER RACE
 */
public interface IRetiroSinCuentaBO {
    
    public abstract RetiroSinCuenta crearRetiroSinCuenta(NuevoRetiroSinCuentaDTO nuevoRetiroSinCuenta)throws NegocioException;
    
    public abstract RetiroSinCuenta obtenerReitroPorFolioYContraseña(Integer folio, String Contrasenia)throws NegocioException;
    
    public abstract RetiroSinCuenta actualizarFechaCobro(Integer folio, GregorianCalendar fechaCobro)throws NegocioException;
    
}
