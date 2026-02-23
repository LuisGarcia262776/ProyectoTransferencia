/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectotransferencia.persistencia;

import java.util.List;
import proyectotransferencia.dtos.NuevaOperacionDTO;
import proyectotransferencia.entidades.Operaciones;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad Operaciones.
 * Permite manejar el historial de operaciones y registrar nuevas transacciones en la base de datos.
 * Proporciona métodos para la persistencia desacoplada de operaciones de cuentas.
 * 
 * @author PC GAMER MASTER RACE
 */
public interface IOperacionesDAO {

    /**
     * Registra una nueva operación (por ejemplo, retiro, depósito o transferencia) en la base de datos.
     * @param nuevaOperacion DTO que contiene los datos de la operación a registrar
     * @return Objeto Operaciones con los datos guardados, incluyendo el ID generado
     * @throws PersistenciaException si ocurre un error al acceder a la base de datos
     */
    public abstract Operaciones crearOperacion(NuevaOperacionDTO nuevaOperacion) throws PersistenciaException;

    /**
     * Obtiene el historial de operaciones de un cliente específico.
     * @param idCliente ID del cliente del cual se desea obtener el historial
     * @return Lista de objetos Operaciones correspondientes a las transacciones del cliente
     * @throws PersistenciaException si ocurre un error al consultar la base de datos
     */
    public abstract List<Operaciones> obtenerHistorialPorCliente(Integer idCliente) throws PersistenciaException;
}