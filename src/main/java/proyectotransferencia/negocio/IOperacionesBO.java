package proyectotransferencia.negocio;

import java.util.List;
import proyectotransferencia.dtos.NuevaOperacionDTO;
import proyectotransferencia.entidades.Cuenta;
import proyectotransferencia.entidades.Operaciones;

/**
 * Interfaz que define las operaciones de negocio relacionadas con las operaciones bancarias.
 * Permite registrar nuevas operaciones y consultar el historial de operaciones
 * del cliente actualmente en sesión.
 * 
 * Las implementaciones deben validar los datos antes de llamar a la capa de persistencia
 * y lanzar {@link NegocioException} en caso de errores de negocio.
 */
public interface IOperacionesBO {

    /**
     * Crea una nueva operación asociada a una cuenta.
     * 
     * @param nuevaOperacion DTO con los datos de la operación a crear.
     * @return La operación creada con su ID asignado.
     * @throws NegocioException si los datos son inválidos o ocurre un error en persistencia.
     */
    public abstract Operaciones crearOperacion(NuevaOperacionDTO nuevaOperacion) throws NegocioException;

    /**
     * Obtiene el historial de operaciones del cliente actualmente en sesión.
     * 
     * @return Lista de operaciones ordenadas por fecha.
     * @throws NegocioException si no hay sesión activa o ocurre un error de persistencia.
     */
    public abstract List<Operaciones> obtenerHistorialCliente() throws NegocioException;
}