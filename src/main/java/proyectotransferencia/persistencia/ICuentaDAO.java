/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectotransferencia.persistencia;

import java.util.List;
import proyectotransferencia.dtos.NuevaCuentaDTO;
import proyectotransferencia.entidades.Cuenta;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad Cuenta.
 * Aquí se declaran los métodos CRUD y de transacciones que deben implementar las clases DAO.
 * Permite mantener la persistencia y manejo de cuentas de clientes de forma desacoplada.
 * 
 * @author PC GAMER MASTER RACE
 */
public interface ICuentaDAO {

    /**
     * Crea una nueva cuenta en la base de datos.
     * @param nuevaCuenta DTO con los datos de la cuenta a registrar
     * @return Objeto Cuenta con los datos guardados, incluyendo el ID generado
     * @throws PersistenciaException si ocurre un error de acceso a datos
     */
    public abstract Cuenta crearCuenta(NuevaCuentaDTO nuevaCuenta) throws PersistenciaException;

    /**
     * Obtiene todas las cuentas registradas en la base de datos.
     * @return Lista de objetos Cuenta
     * @throws PersistenciaException si ocurre un error al consultar la base de datos
     */
    public abstract List<Cuenta> obtenerCuenta() throws PersistenciaException;

    /**
     * Obtiene una cuenta por su número de cuenta.
     * @param numeroCuenta Número de la cuenta a buscar
     * @return Objeto Cuenta si se encuentra, null si no existe
     * @throws PersistenciaException si ocurre un error al consultar la base de datos
     */
    public abstract Cuenta obtenerCuentaNumero(String numeroCuenta) throws PersistenciaException;

    /**
     * Realiza un retiro de dinero en una cuenta específica.
     * @param idCuenta ID de la cuenta
     * @param monto Cantidad a retirar
     * @throws PersistenciaException si ocurre un error al actualizar la base de datos
     */
    public abstract void retirar(Integer idCuenta, Float monto) throws PersistenciaException;

    /**
     * Realiza un depósito de dinero en una cuenta específica.
     * @param idCuenta ID de la cuenta
     * @param monto Cantidad a depositar
     * @throws PersistenciaException si ocurre un error al actualizar la base de datos
     */
    public abstract void depositar(Integer idCuenta, Float monto) throws PersistenciaException;

    /**
     * Obtiene todas las cuentas asociadas a un cliente específico.
     * @param idCliente ID del cliente
     * @return Lista de cuentas pertenecientes al cliente
     * @throws PersistenciaException si ocurre un error al consultar la base de datos
     */
    public List<Cuenta> obtenerCuentasPorCliente(Integer idCliente) throws PersistenciaException;

    /**
     * Obtiene una cuenta específica por su ID.
     * @param idCuenta ID de la cuenta
     * @return Objeto Cuenta si se encuentra, null si no existe
     * @throws PersistenciaException si ocurre un error al consultar la base de datos
     */
    public Cuenta obtenerCuentaPorId(Integer idCuenta) throws PersistenciaException;

    /**
     * Actualiza el estado de una cuenta específica (por ejemplo, activa, bloqueada).
     * @param idCuenta ID de la cuenta
     * @param estado Nuevo estado a asignar
     * @throws PersistenciaException si ocurre un error al actualizar la base de datos
     */
    public void actualizarEstado(Integer idCuenta, String estado) throws PersistenciaException;

}