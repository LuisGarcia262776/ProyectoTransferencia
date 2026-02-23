/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectotransferencia.persistencia;

import java.util.GregorianCalendar;
import proyectotransferencia.dtos.NuevoRetiroSinCuentaDTO;
import proyectotransferencia.entidades.RetiroSinCuenta;
import proyectotransferencia.persistencia.PersistenciaException;

/**
 * Interfaz que define las operaciones de acceso a datos para retiros realizados sin cuenta bancaria.
 * Permite registrar, consultar y actualizar operaciones de este tipo de retiro en la base de datos.
 * Proporciona persistencia desacoplada para retiros sin cuenta.
 * 
 * @author PC GAMER MASTER RACE
 */
public interface IRetiroSinCuentaDAO {

    /**
     * Registra un nuevo retiro sin cuenta en la base de datos.
     * @param nuevoRetiroSinCuenta DTO que contiene los datos del retiro a registrar
     * @return Objeto RetiroSinCuenta con los datos guardados, incluyendo el folio generado
     * @throws PersistenciaException si ocurre un error al acceder a la base de datos
     */
    public abstract RetiroSinCuenta crearRetiroSinCuenta(NuevoRetiroSinCuentaDTO nuevoRetiroSinCuenta) throws PersistenciaException;
    
    /**
     * Obtiene un retiro sin cuenta específico mediante su folio y contraseña.
     * @param folio Folio del retiro
     * @param Contrasenia Contraseña asociada al retiro
     * @return Objeto RetiroSinCuenta si se encuentra, null si no existe
     * @throws PersistenciaException si ocurre un error al consultar la base de datos
     */
    public abstract RetiroSinCuenta obtenerReitroPorFolioYContraseña(Integer folio, String Contrasenia) throws PersistenciaException;
    
    /**
     * Actualiza la fecha de cobro de un retiro sin cuenta específico.
     * @param folio Folio del retiro a actualizar
     * @param fechaCobro Nueva fecha de cobro
     * @return Objeto RetiroSinCuenta actualizado con la nueva fecha
     * @throws PersistenciaException si ocurre un error al actualizar la base de datos
     */
    public abstract RetiroSinCuenta actualizarFechaCobro(Integer folio, GregorianCalendar fechaCobro) throws PersistenciaException;

}