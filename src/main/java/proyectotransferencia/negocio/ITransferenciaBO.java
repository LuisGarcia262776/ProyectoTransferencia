package proyectotransferencia.negocio;

import proyectotransferencia.dtos.NuevaTransferenciaDTO;
import proyectotransferencia.entidades.Transferencia;

/**
 * Interfaz que define las operaciones de negocio relacionadas con las transferencias
 * entre cuentas.
 * 
 * Las implementaciones deben validar los datos de negocio y lanzar
 * {@link NegocioException} en caso de errores o datos inválidos.
 */
public interface ITransferenciaBO {

    /**
     * Crea una nueva transferencia basada en los datos proporcionados.
     * 
     * @param nuevaTransferencia DTO con los datos necesarios para crear la transferencia.
     * @return La transferencia creada con toda la información registrada.
     * @throws NegocioException si los datos son inválidos o ocurre un error de persistencia.
     */
    public abstract Transferencia crearTransferencia(NuevaTransferenciaDTO nuevaTransferencia) throws NegocioException;

}