/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotransferencia.persistencia;

import proyectotransferencia.dtos.NuevaTransferenciaDTO;
import proyectotransferencia.entidades.Transferencia;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public interface ITransferenciaDAO {
    
    public abstract Transferencia crearTransferencia(NuevaTransferenciaDTO nuevaTransferenciaDTO)throws PersistenciaException;
    
}
