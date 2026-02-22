/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectotransferencia.persistencia;
import java.util.GregorianCalendar;
import proyectotransferencia.dtos.NuevoRetiroSinCuentaDTO;
import proyectotransferencia.entidades.RetiroSinCuenta;
import proyectotransferencia.persistencia.PersistenciaException;
/**
 *
 * @author PC GAMER MASTER RACE
 */
public interface IRetiroSinCuentaDAO{
    
    public abstract RetiroSinCuenta crearRetiroSinCuenta(NuevoRetiroSinCuentaDTO nuevoRetiroSinCuenta)throws PersistenciaException;
    
    public abstract RetiroSinCuenta obtenerReitroPorFolioYContraseña(Integer folio, String Contrasenia)throws PersistenciaException;
    
    public abstract RetiroSinCuenta actualizarFechaCobro(Integer folio, GregorianCalendar fechaCobro)throws PersistenciaException;

    }
    
