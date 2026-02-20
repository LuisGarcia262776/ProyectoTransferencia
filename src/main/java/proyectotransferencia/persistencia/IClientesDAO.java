/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectotransferencia.persistencia;

import java.util.List;
import proyectotransferencia.dtos.NuevoClienteDTO;
import proyectotransferencia.entidades.Cliente;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public interface IClientesDAO {
    
    public abstract Cliente crearCliente(NuevoClienteDTO nuevoCliente)throws PersistenciaException;
    
    public abstract List<Cliente> obtenerClientes() throws PersistenciaException;
    
    public abstract Cliente iniciarSesion(String numeroCuenta, String contrasenia) throws PersistenciaException;
    
    
    
}
