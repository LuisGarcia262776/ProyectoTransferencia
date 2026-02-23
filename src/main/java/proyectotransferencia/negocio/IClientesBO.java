package proyectotransferencia.negocio;

import java.util.List;
import proyectotransferencia.dtos.NuevoClienteDTO;
import proyectotransferencia.entidades.Cliente;
import proyectotransferencia.persistencia.PersistenciaException;

/**
 * Interfaz que define las operaciones de negocio relacionadas con la gestión de clientes.
 * Contiene métodos para crear clientes, obtener la lista de clientes y manejar la autenticación.
 * 
 * Implementaciones de esta interfaz deben encargarse de validar los datos antes de llamar
 * a la capa de persistencia y de lanzar {@link NegocioException} en caso de errores de negocio.
 * 
 * @author PC
 */
public interface IClientesBO {
    
    /**
     * Crea un nuevo cliente en el sistema.
     * 
     * @param nuevoCliente DTO con los datos del cliente a crear.
     * @return El cliente creado con su ID asignado.
     * @throws NegocioException si ocurre un error de validación o de persistencia.
     */
    public abstract Cliente crearCliente(NuevoClienteDTO nuevoCliente) throws NegocioException;
    
    /**
     * Obtiene todos los clientes registrados en el sistema.
     * 
     * @return Lista de clientes.
     * @throws NegocioException si ocurre un error al consultar la base de datos.
     */
    List<Cliente> obtenerClientes() throws NegocioException;
    
    /**
     * Permite iniciar sesión de un cliente mediante su ID y contraseña.
     * 
     * @param idCliente ID del cliente que intenta iniciar sesión.
     * @param contrasenia Contraseña del cliente.
     * @return El cliente autenticado.
     * @throws NegocioException si el ID o la contraseña son incorrectos o si ocurre un error de persistencia.
     */
    public Cliente iniciarSesion(Integer idCliente, String contrasenia)throws NegocioException;
    
}