package proyectotransferencia.negocio;

import java.util.GregorianCalendar;
import java.util.logging.Logger;
import proyectotransferencia.dtos.NuevoRetiroSinCuentaDTO;
import proyectotransferencia.entidades.RetiroSinCuenta;
import proyectotransferencia.persistencia.IRetiroSinCuentaDAO;
import proyectotransferencia.persistencia.PersistenciaException;

/**
 * Clase que implementa la lógica de negocio para los retiros sin cuenta bancaria.
 * 
 * Permite crear retiros, consultar retiros por folio y contraseña, y actualizar
 * la fecha de cobro. Realiza validaciones de negocio sobre los datos recibidos
 * y convierte las excepciones de persistencia en {@link NegocioException}.
 */
public class RetiroSinCuentaBO implements IRetiroSinCuentaBO {

    /**
     * DAO utilizado para interactuar con la base de datos de retiros sin cuenta.
     */
    private final IRetiroSinCuentaDAO reitroSinCuentaDAO;

    /**
     * Constructor que inicializa la clase con un DAO de retiros sin cuenta.
     * 
     * @param reitroSinCuentaDAO DAO para acceder a la persistencia de retiros sin cuenta.
     */
    public RetiroSinCuentaBO(IRetiroSinCuentaDAO reitroSinCuentaDAO) {
        this.reitroSinCuentaDAO = reitroSinCuentaDAO;
    }

    /**
     * Crea un retiro sin cuenta.
     * 
     * Valida que los datos no sean nulos, que el monto esté dentro del rango permitido,
     * que la contraseña tenga 8 dígitos y que exista un ID de operación asociado.
     * 
     * @param nuevoRetiroSinCuenta DTO con los datos necesarios para el retiro.
     * @return El retiro creado con la información registrada.
     * @throws NegocioException si los datos son inválidos o ocurre un error de persistencia.
     */
    @Override
    public RetiroSinCuenta crearRetiroSinCuenta(NuevoRetiroSinCuentaDTO nuevoRetiroSinCuenta) throws NegocioException {
        if(nuevoRetiroSinCuenta == null){
            throw new NegocioException("Datos Invalidos", null);
        }

        if(nuevoRetiroSinCuenta.getMonto() == null){ 
            throw new NegocioException("El Monto no Puede ser Nulo", null);
        }

        if(nuevoRetiroSinCuenta.getMonto() <= 0){
            throw new NegocioException("El Monto Debe ser Mayor a 0", null);
        }

        if(nuevoRetiroSinCuenta.getMonto() > 31000){
            throw new NegocioException("El Monto Excede el Limite Permitido", null);
        }

        if(nuevoRetiroSinCuenta.getContraseñaRetiro() == null){
            throw new NegocioException("Contraseña Requerida", null);
        }

        if(nuevoRetiroSinCuenta.getContraseñaRetiro().isEmpty()){
            throw new NegocioException("Contraseña Requerida", null);
        }

        if(nuevoRetiroSinCuenta.getContraseñaRetiro().length() != 8){
            throw new NegocioException("La Contraseña debe Tener 8 Digitos", null);
        }

        if(nuevoRetiroSinCuenta.getIdOperacion()== null){
            throw new NegocioException("Debe Existir un IdOperacion",null);
        }

        if(nuevoRetiroSinCuenta.getFechaHoraSolicitud() == null){
            throw new NegocioException("Fecha de Solicitud Requerida", null);
        }

        try{
            RetiroSinCuenta retiroSinCuenta = this.reitroSinCuentaDAO.crearRetiroSinCuenta(nuevoRetiroSinCuenta);
            return retiroSinCuenta;
        }catch(PersistenciaException ex){
            throw new NegocioException("Error al crear retiro", ex);
        }
    }

    /**
     * Obtiene un retiro por folio y contraseña.
     * 
     * @param folio Folio del retiro.
     * @param Contrasenia Contraseña asociada al retiro.
     * @return El retiro encontrado o null si no existe.
     * @throws NegocioException si ocurre un error de persistencia.
     */
    @Override
    public RetiroSinCuenta obtenerReitroPorFolioYContraseña(Integer folio, String Contrasenia) throws NegocioException {
        try{
            RetiroSinCuenta retiroSinCuenta = reitroSinCuentaDAO.obtenerReitroPorFolioYContraseña(folio, Contrasenia);
            return retiroSinCuenta;
        }catch(PersistenciaException ex){
            throw new NegocioException("Error al buscar retiro", ex);
        }
    }

    /**
     * Actualiza la fecha de cobro de un retiro.
     * 
     * @param folio Folio del retiro a actualizar.
     * @param fechaCobro Fecha de cobro que se desea registrar.
     * @return El retiro con la fecha de cobro actualizada.
     * @throws NegocioException si ocurre un error de persistencia.
     */
    @Override
    public RetiroSinCuenta actualizarFechaCobro(Integer folio, GregorianCalendar fechaCobro) throws NegocioException {
        try{
           RetiroSinCuenta retiroSinCuenta =  reitroSinCuentaDAO.actualizarFechaCobro(folio, fechaCobro);
           return retiroSinCuenta;
        }catch(PersistenciaException ex){
            throw new NegocioException("Error al actualizar fecha cobro", ex);
        }
    }

}