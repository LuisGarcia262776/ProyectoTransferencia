package proyectotransferencia.negocio;

import proyectotransferencia.dtos.NuevaTransferenciaDTO;
import proyectotransferencia.entidades.Transferencia;
import proyectotransferencia.persistencia.ITransferenciaDAO;
import proyectotransferencia.persistencia.PersistenciaException;

/**
 * Clase que implementa la lógica de negocio para las transferencias bancarias.
 * 
 * Se encarga de validar los datos de la transferencia antes de delegar la
 * operación al DAO correspondiente. Convierte excepciones de persistencia
 * en {@link NegocioException}.
 */
public class TransferenciaBO implements ITransferenciaBO {

    /**
     * DAO utilizado para interactuar con la base de datos de transferencias.
     */
    private final ITransferenciaDAO transferenciaDAO;

    /**
     * Constructor que inicializa la clase con un DAO de transferencias.
     * 
     * @param transferenciaDAO DAO para acceder a la persistencia de transferencias.
     */
    public TransferenciaBO(ITransferenciaDAO transferenciaDAO) {
        this.transferenciaDAO = transferenciaDAO;
    }

    /**
     * Crea una nueva transferencia bancaria.
     * 
     * Realiza validaciones sobre el monto, concepto y existencia del ID de operación.
     * 
     * @param nuevaTransferenciaDTO DTO con los datos necesarios para la transferencia.
     * @return La transferencia creada con la información registrada.
     * @throws NegocioException si los datos son inválidos o ocurre un error de persistencia.
     */
    @Override
    public Transferencia crearTransferencia(NuevaTransferenciaDTO nuevaTransferenciaDTO) throws NegocioException {

        if (nuevaTransferenciaDTO == null) {
            throw new NegocioException("La transferencia no puede ser nula", null);
        }

        if (nuevaTransferenciaDTO.getMonto() == null) {
            throw new NegocioException("El monto es obligatorio", null);
        }

        if (nuevaTransferenciaDTO.getMonto() <= 0) {
            throw new NegocioException("El monto debe ser mayor a 0", null);
        }

        if (nuevaTransferenciaDTO.getMonto() > 30000) {
            throw new NegocioException("El monto supera el límite de $30000", null);
        }

        if (nuevaTransferenciaDTO.getConcepto() == null || nuevaTransferenciaDTO.getConcepto().isEmpty()) {
            throw new NegocioException("El concepto es obligatorio", null);
        }
        
        if(nuevaTransferenciaDTO.getIdOperacion() == null){
            throw new NegocioException("El id de la Operacion no Puede ser Nulo", null);
        }

        try {
            return transferenciaDAO.crearTransferencia(nuevaTransferenciaDTO);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al realizar la transferencia", ex);
        }
    }
}