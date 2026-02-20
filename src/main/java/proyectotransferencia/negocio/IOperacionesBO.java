/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectotransferencia.negocio;

import proyectotransferencia.dtos.NuevaOperacionDTO;
import proyectotransferencia.entidades.Operaciones;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public interface IOperacionesBO {
    
    public abstract Operaciones crearOperacion(NuevaOperacionDTO nuevaOperacion)throws NegocioException;
    
}
