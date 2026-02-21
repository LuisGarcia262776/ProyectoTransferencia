/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotransferencia.negocio;

import java.util.List;
import proyectotransferencia.dtos.NuevoClienteDTO;
import proyectotransferencia.entidades.Cliente;
import proyectotransferencia.persistencia.PersistenciaException;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public interface IClientesBO {
    
    public abstract Cliente crearCliente(NuevoClienteDTO nuevoCliente) throws NegocioException;
    
    List<Cliente> obtenerClientes() throws NegocioException;
    
    public Cliente iniciarSesion(Integer idCliente, String contrasenia)throws NegocioException;
    
}
