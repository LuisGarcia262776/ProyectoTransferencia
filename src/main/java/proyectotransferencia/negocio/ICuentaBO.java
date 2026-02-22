/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectotransferencia.negocio;

import java.util.List;
import proyectotransferencia.dtos.NuevaCuentaDTO;
import proyectotransferencia.entidades.Cuenta;
import proyectotransferencia.persistencia.PersistenciaException;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public interface ICuentaBO {

    public abstract Cuenta crearCuenta(NuevaCuentaDTO nuevaCuenta) throws NegocioException;

    public abstract List<Cuenta> obtenerCuenta() throws NegocioException;

    public abstract Cuenta obtenerCuentaNumero(String numeroCuenta) throws NegocioException;

    public abstract void retirar(Integer idCuenta, Float monto) throws NegocioException;

    public abstract void depositar(Integer idCuenta, Float monto) throws NegocioException;

    public List<Cuenta> obtenerCuentasDelCliente()
            throws NegocioException;

    public void cambiarEstadoCuenta(Integer idCuenta, String contrasenia)
            throws NegocioException;

}
