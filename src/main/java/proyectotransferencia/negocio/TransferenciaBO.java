/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotransferencia.negocio;

import proyectotransferencia.dtos.NuevaTransferenciaDTO;
import proyectotransferencia.entidades.Transferencia;
import proyectotransferencia.persistencia.ITransferenciaDAO;
import proyectotransferencia.persistencia.PersistenciaException;


/**
 *
 * @author PC GAMER MASTER RACE
 */
public class TransferenciaBO implements ITransferenciaBO {

    private final ITransferenciaDAO transferenciaDAO;

    public TransferenciaBO(ITransferenciaDAO transferenciaDAO) {
        this.transferenciaDAO = transferenciaDAO;
    }

    @Override
    public Transferencia crearTransferencia(NuevaTransferenciaDTO nuevaTransferenciaDTO) throws NegocioException {

        if (nuevaTransferenciaDTO == null) {
            throw new NegocioException("La transferencia no puede ser nula", null);
        }

        if (nuevaTransferenciaDTO.getMonto() == null) {
            throw new NegocioException("El monto es obligatorio", null);
        }

        if (nuevaTransferenciaDTO.getMonto() <= 0) {
            throw new NegocioException("El monto debe ser mayor a 0", null);
        }

        if (nuevaTransferenciaDTO.getMonto() > 30000) {
            throw new NegocioException("El monto supera el límite de $30000", null);
        }

        if (nuevaTransferenciaDTO.getConcepto() == null || nuevaTransferenciaDTO.getConcepto().isEmpty()) {
            throw new NegocioException("El concepto es obligatorio", null);
        }
        
        if(nuevaTransferenciaDTO.getIdOperacion() == null){
            throw new NegocioException("El id de la Operacion no Puede ser Nulo", null);
        }

        try {
            return transferenciaDAO.crearTransferencia(nuevaTransferenciaDTO);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al realizar la transferencia", ex);
        }
    }
}