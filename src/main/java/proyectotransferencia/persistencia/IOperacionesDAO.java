/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectotransferencia.persistencia;
import java.util.List;
import proyectotransferencia.dtos.NuevaOperacionDTO;
import proyectotransferencia.entidades.Operaciones;
/**
 *
 * @author PC GAMER MASTER RACE
 */
public interface IOperacionesDAO {
    public abstract Operaciones crearOperacion(NuevaOperacionDTO nuevaOperacion)throws PersistenciaException;
    
    public abstract List<Operaciones> obtenerHistorialPorCliente(Integer idCliente) throws PersistenciaException;
}
