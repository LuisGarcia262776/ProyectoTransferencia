package proyectotransferencia.negocio;

import java.util.GregorianCalendar;
import java.util.List;
import proyectotransferencia.dtos.NuevaOperacionDTO;
import proyectotransferencia.entidades.Cuenta;
import proyectotransferencia.entidades.Operaciones;
import proyectotransferencia.persistencia.IOperacionesDAO;
import proyectotransferencia.persistencia.PersistenciaException;
import proyectotransferencia.sesion.Sesion;

/**
 * Clase que implementa la lógica de negocio para operaciones bancarias.
 * 
 * Permite crear operaciones y consultar el historial de operaciones
 * de un cliente. Valida los datos de entrada y maneja las excepciones
 * de persistencia transformándolas en {@link NegocioException}.
 */
public class OperacionesBO implements IOperacionesBO {

    /**
     * DAO utilizado para realizar las operaciones en la base de datos.
     */
    private final IOperacionesDAO operacionesDAO;

    /**
     * Constructor que inicializa la clase con un DAO de operaciones.
     * 
     * @param operacionesDAO DAO para acceder a las operaciones persistidas.
     */
    public OperacionesBO(IOperacionesDAO operacionesDAO) {
        this.operacionesDAO = operacionesDAO;
    }

    /**
     * Crea una nueva operación bancaria.
     * 
     * Valida que la operación no sea nula, que tenga una fecha válida,
     * que el tipo de operación sea correcto y que la cuenta exista.
     * 
     * @param nuevaOperacion DTO con los datos necesarios para la operación.
     * @return La operación creada con toda la información registrada.
     * @throws NegocioException si los datos son inválidos o hay un error de persistencia.
     */
    @Override
    public Operaciones crearOperacion(NuevaOperacionDTO nuevaOperacion) throws NegocioException {
        if(nuevaOperacion == null){
            throw new NegocioException("Los Datos de la Operacion no Pueden ser Nulos", null);
        }

        if(nuevaOperacion.getFechaHora() == null){
            throw new NegocioException("La Fecha y Hora no Pueden ser Nulas", null);
        }

        GregorianCalendar ahora = new GregorianCalendar();
        if(nuevaOperacion.getFechaHora().after(ahora)){
            throw new NegocioException("La Fecha no Puede Ser Futura", null);
        }

        if(nuevaOperacion.getTipoOperacion() == null || nuevaOperacion.getTipoOperacion().isEmpty()){
            throw new NegocioException("El Tipo de Operacion no Puede Estar Vacio", null);
        }

        if(!nuevaOperacion.getTipoOperacion().equalsIgnoreCase("RETIROSINTARJETA") && !nuevaOperacion.getTipoOperacion().equalsIgnoreCase("TRANSFERENCIA")){
            throw new NegocioException("Tipo de Operacion Invalido", null);
        }

        if(nuevaOperacion.getIdCuenta() == null){
            throw new NegocioException("Debe Proporcionar Una Cuenta Valida", null);
        }
        
       try{
            Operaciones operacion = this.operacionesDAO.crearOperacion(nuevaOperacion);
            return operacion;
        }catch(PersistenciaException ex){
            throw new NegocioException("Error al Crear La Operacion", ex);
        } 
    }

    /**
     * Obtiene el historial de operaciones del cliente actualmente logueado.
     * 
     * @return Lista de operaciones realizadas por el cliente.
     * @throws NegocioException si no hay sesión activa o hay un error de persistencia.
     */
    @Override
    public List<Operaciones> obtenerHistorialCliente() throws NegocioException {
        Integer idCliente = Sesion.getIdCliente();

        if (idCliente == null) {
            throw new NegocioException("No hay una sesión activa para cargar el historial.", null);
        }

        try {
            return this.operacionesDAO.obtenerHistorialPorCliente(idCliente);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al obtener el historial de operaciones", ex);
        }
    }

}