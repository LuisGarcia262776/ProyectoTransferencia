/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectotransferencia.persistencia;

import java.util.List;
import proyectotransferencia.dtos.NuevoClienteDTO;
import proyectotransferencia.entidades.Cliente;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad Cliente.
 * Aquí se declaran los métodos CRUD y de autenticación que deben implementar las clases DAO.
 * Implementa la separación de responsabilidades para la persistencia de clientes.
 * 
 * @author PC GAMER MASTER RACE
 */
public interface IClientesDAO {
    
    /**
     * Registra un nuevo cliente en la base de datos.
     * @param nuevoCliente DTO que contiene los datos del cliente a crear
     * @return Objeto Cliente con los datos guardados, incluyendo el ID generado
     * @throws PersistenciaException si ocurre algún error de acceso a datos
     */
    public abstract Cliente crearCliente(NuevoClienteDTO nuevoCliente) throws PersistenciaException;
    
    /**
     * Obtiene todos los clientes registrados en la base de datos.
     * @return Lista de objetos Cliente
     * @throws PersistenciaException si ocurre un error al consultar la base de datos
     */
    public abstract List<Cliente> obtenerClientes() throws PersistenciaException;
    
    /**
     * Permite iniciar sesión validando el ID y la contraseña del cliente.
     * @param idCliente ID del cliente
     * @param contrasenia Contraseña asociada al cliente
     * @return Objeto Cliente si los datos son correctos, null si no coincide
     * @throws PersistenciaException si ocurre un error durante la consulta
     */
    public Cliente iniciarSesion(Integer idCliente, String contrasenia) throws PersistenciaException;
    
}