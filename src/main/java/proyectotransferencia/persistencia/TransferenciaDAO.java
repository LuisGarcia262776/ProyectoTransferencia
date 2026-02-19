/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotransferencia.persistencia;

import java.util.logging.Logger;
import proyectotransferencia.dtos.NuevaTransferenciaDTO;
import proyectotransferencia.entidades.Transferencia;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class TransferenciaDAO implements ITransferenciaDAO {
    private static final Logger LOGGER = Logger.getLogger(ClientesDAO.class.getName());

    @Override
    public Transferencia crearTransferencia(NuevaTransferenciaDTO nuevaTransferenciaDTO) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
