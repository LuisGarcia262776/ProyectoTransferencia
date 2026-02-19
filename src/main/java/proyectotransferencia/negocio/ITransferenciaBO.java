/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectotransferencia.negocio;

import proyectotransferencia.dtos.NuevaTransferenciaDTO;
import proyectotransferencia.entidades.Transferencia;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public interface ITransferenciaBO {
    
    public abstract Transferencia crearTransferencia(NuevaTransferenciaDTO nuevaTransferenciaDTO) throws NegocioException;
    
}
