/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotransferencia.persistencia;

import java.sql.SQLException;
import java.util.logging.Logger;
import proyectotransferencia.dtos.NuevoClienteDTO;
import proyectotransferencia.entidades.Cliente;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class ClientesDAO implements IClientesDAO{
    
    private static final Logger LOGGER = Logger.getLogger(ClientesDAO.class.getName());

    @Override
    public Cliente crearCleinte(NuevoClienteDTO nuevoClienteDTO) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
