/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectotransferencia.persistencia;

import java.util.List;
import proyectotransferencia.dtos.NuevaCuentaDTO;
import proyectotransferencia.entidades.Cuenta;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public interface ICuentaDAO {
    
    public abstract Cuenta crearCuenta(NuevaCuentaDTO nuevaCuenta)throws PersistenciaException;
    
    public abstract List<Cuenta> obtenerCuenta() throws PersistenciaException;
    
    public abstract Cuenta obtenerCuentaNumero(String numeroCuenta) throws PersistenciaException;
    
    
}
