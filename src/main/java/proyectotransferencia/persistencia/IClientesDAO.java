/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectotransferencia.persistencia;

import proyectotransferencia.dtos.NuevoClienteDTO;
import proyectotransferencia.entidades.Cliente;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public interface IClientesDAO {
    
    public abstract Cliente crearCleinte(NuevoClienteDTO nuevoClienteDTO)throws PersistenciaException;
    
}
