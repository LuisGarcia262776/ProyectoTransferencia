/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotransferencia.negocio;

import proyectotransferencia.dtos.NuevaTransferenciaDTO;
import proyectotransferencia.entidades.Transferencia;


/**
 *
 * @author PC GAMER MASTER RACE
 */
public class TransferenciaBO implements ITransferenciaBO {
    private final ITransferenciaBO transferenciaBO;

    public TransferenciaBO(ITransferenciaBO transferenciaBO) {
        this.transferenciaBO = transferenciaBO;
    }

    @Override
    public Transferencia crearTransferencia(NuevaTransferenciaDTO nuevaTransferenciaDTO) throws NegocioException {
        if(nuevaTransferenciaDTO.getMonto() == null){
            throw new NegocioException("El Monto Es Obligatorio", null);
        }
        
        if(nuevaTransferenciaDTO.getMonto() <=0){
            throw new NegocioException("El Monto debe ser Mayor a 0", null);
        }
        
        if(nuevaTransferenciaDTO.getMonto()>30000){
            throw new NegocioException("El Monto Supera El Limite de $30000", null);
        }
        
        if(nuevaTransferenciaDTO.getConcepto() == null){
            throw new NegocioException("El Concepto Es Obligatorio", null);
        }
        
        if(nuevaTransferenciaDTO.getConcepto().isEmpty()){
            throw new NegocioException("El Concepto No Puede Estar Vacio", null);
        }
        
        Transferencia transferencia = this.transferenciaBO.crearTransferencia(nuevaTransferenciaDTO);
        return transferencia;
    }
    
}
