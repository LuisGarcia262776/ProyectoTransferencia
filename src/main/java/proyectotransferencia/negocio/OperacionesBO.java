/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotransferencia.negocio;

import java.util.GregorianCalendar;
import java.util.List;
import proyectotransferencia.dtos.NuevaOperacionDTO;
import proyectotransferencia.entidades.Cuenta;
import proyectotransferencia.entidades.Operaciones;
import proyectotransferencia.persistencia.IOperacionesDAO;
import proyectotransferencia.persistencia.PersistenciaException;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class OperacionesBO implements IOperacionesBO {
     private final IOperacionesDAO operacionesDAO;

    public OperacionesBO(IOperacionesDAO operacionesDAO) {
        this.operacionesDAO = operacionesDAO;
    }
    
    @Override
    public Operaciones crearOperacion(NuevaOperacionDTO nuevaOperacion) throws NegocioException {
        if(nuevaOperacion == null){
            throw new NegocioException("Los Datos de la Operacion no Pueden ser Nulos", null);
        }

        if(nuevaOperacion.getFechaHora() == null){
            throw new NegocioException("La Fecha y Hora no Pueden ser Nulas", null);
        }

        GregorianCalendar ahora = new GregorianCalendar();
        if(nuevaOperacion.getFechaHora().after(ahora)){
            throw new NegocioException("La Fecha no Puede Ser Futura", null);
        }

        if(nuevaOperacion.getTipoOperacion() == null || nuevaOperacion.getTipoOperacion().isEmpty()){
            throw new NegocioException("El Tipo de Operacion no Puede Estar Vacio", null);
        }

        if(!nuevaOperacion.getTipoOperacion().equalsIgnoreCase("RETIROSINTARJETA") && !nuevaOperacion.getTipoOperacion().equalsIgnoreCase("TRANSFERENCIA")){
            throw new NegocioException("Tipo de Operacion Invalido", null);
        }

        if(nuevaOperacion.getIdCuenta() == null){
            throw new NegocioException("Debe Proporcionar Una Cuenta Valida", null);
        }
        
       try{
            Operaciones operacion = this.operacionesDAO.crearOperacion(nuevaOperacion);
            return operacion;
        }catch(PersistenciaException ex){
            throw new NegocioException("Error al Crear La Operacion", ex);
        } 
    }


 
    
}
