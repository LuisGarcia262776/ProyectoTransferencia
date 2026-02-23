package proyectotransferencia.negocio;

import java.util.GregorianCalendar;
import java.util.List;
import proyectotransferencia.dtos.NuevaCuentaDTO;
import proyectotransferencia.entidades.Cuenta;
import proyectotransferencia.persistencia.ICuentaDAO;
import proyectotransferencia.persistencia.PersistenciaException;
import proyectotransferencia.sesion.Sesion;

/**
 * Clase de negocio que implementa la lógica para la gestión de cuentas bancarias.
 * Se encarga de validar los datos de la cuenta antes de enviarlos a la capa de persistencia,
 * realizar operaciones como retiro, depósito y activar/desactivar cuentas.
 * 
 * Implementa la interfaz {@link ICuentaBO}.
 * 
 * @author PC GAMER
 */
public class CuentaBO implements ICuentaBO {

    /** DAO de cuentas para interactuar con la base de datos */
    private final ICuentaDAO cuentaDAO;

    /**
     * Constructor de la clase.
     * @param cuentaDAO DAO de cuentas a utilizar.
     */
    public CuentaBO(ICuentaDAO cuentaDAO) {
        this.cuentaDAO = cuentaDAO;
    }

    /**
     * Crea una nueva cuenta bancaria después de validar los datos.
     * 
     * @param nuevaCuenta DTO con los datos de la nueva cuenta.
     * @return La cuenta creada con su ID asignado.
     * @throws NegocioException si hay errores de validación o de persistencia.
     */
    @Override
    public Cuenta crearCuenta(NuevaCuentaDTO nuevaCuenta) throws NegocioException {
        // Validaciones de campos obligatorios y restricciones
        if (nuevaCuenta == null) {
            throw new NegocioException("Los Datos de la Cuenta no Pueden ser Nulos", null);
        }

        if (nuevaCuenta.getNumeroCuenta() == null || nuevaCuenta.getNumeroCuenta().isEmpty()) {
            throw new NegocioException("El Numero de Cuenta No Puede ser Nulo o Vacio", null);
        }

        if (nuevaCuenta.getFechaApertura() == null) {
            throw new NegocioException("La Fecha de Registro No Puede ser Nula", null);
        }

        GregorianCalendar hoy = new GregorianCalendar();

        if (nuevaCuenta.getFechaApertura().after(hoy)) {
            throw new NegocioException("La Fecha No Puede Ser Futura", null);
        }

        if (nuevaCuenta.getSaldo() == null || nuevaCuenta.getSaldo() < 0) {
            throw new NegocioException("El Saldo No Puede Ser Nulo o Negativo", null);
        }

        if (nuevaCuenta.getEstado() == null ||
           (!nuevaCuenta.getEstado().equalsIgnoreCase("ACTIVA") &&
            !nuevaCuenta.getEstado().equalsIgnoreCase("INACTIVA"))) {
            throw new NegocioException("El Estado debe ser ACTIVA o INACTIVA", null);
        }

        if (nuevaCuenta.getIdCliente() == null) {
            throw new NegocioException("Debe Proporcionar Un Cliente Valido", null);
        }

        try {
            // Llamada al DAO para crear la cuenta
            return cuentaDAO.crearCuenta(nuevaCuenta);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al Crear La Cuenta", ex);
        }
    }

    /**
     * Obtiene todas las cuentas registradas en el sistema.
     * 
     * @return Lista de cuentas.
     * @throws NegocioException si ocurre un error al consultar la base de datos.
     */
    @Override
    public List<Cuenta> obtenerCuenta() throws NegocioException {
        try {
            return cuentaDAO.obtenerCuenta();
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se Pudieron Obtener Las Cuentas", ex);
        }
    }

    /**
     * Obtiene una cuenta por su número de cuenta.
     * 
     * @param numeroCuenta Número de cuenta a buscar.
     * @return La cuenta correspondiente.
     * @throws NegocioException si ocurre un error al consultar la base de datos.
     */
    @Override
    public Cuenta obtenerCuentaNumero(String numeroCuenta) throws NegocioException {
        try {
            return cuentaDAO.obtenerCuentaNumero(numeroCuenta);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se Pudo Obtener El Numero de Cuenta", ex);
        }
    }

    /**
     * Realiza un retiro de dinero de una cuenta específica.
     * 
     * @param idCuenta ID de la cuenta.
     * @param monto Monto a retirar.
     * @throws NegocioException si ocurre un error en la operación.
     */
    @Override
    public void retirar(Integer idCuenta, Float monto) throws NegocioException {
        try {
            cuentaDAO.retirar(idCuenta, monto);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al retirar dinero", ex);
        }
    }

    /**
     * Deposita dinero en una cuenta específica.
     * 
     * @param idCuenta ID de la cuenta.
     * @param monto Monto a depositar.
     * @throws NegocioException si ocurre un error en la operación.
     */
    @Override
    public void depositar(Integer idCuenta, Float monto) throws NegocioException {
        try {
            cuentaDAO.depositar(idCuenta, monto);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al depositar dinero", ex);
        }
    }

    /**
     * Obtiene todas las cuentas asociadas al cliente actualmente activo en sesión.
     * 
     * @return Lista de cuentas del cliente activo.
     * @throws NegocioException si no hay sesión activa o ocurre un error de persistencia.
     */
    @Override
    public List<Cuenta> obtenerCuentasDelCliente() throws NegocioException {
        if (Sesion.getClienteActivo() == null) {
            throw new NegocioException("No hay sesión activa", null);
        }

        try {
            return cuentaDAO.obtenerCuentasPorCliente(
                    Sesion.getIdCliente());
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudieron obtener las cuentas", ex);
        }
    }

    /**
     * Activa una cuenta específica después de validar la sesión y la contraseña.
     * 
     * @param idCuenta ID de la cuenta a activar.
     * @param contrasenia Contraseña del cliente activo.
     * @throws NegocioException si no hay sesión activa, la cuenta no existe,
     *         ya está activa o la contraseña es incorrecta.
     */
    @Override
    public void activarCuenta(Integer idCuenta, String contrasenia)
            throws NegocioException {

        if (Sesion.getClienteActivo() == null) {
            throw new NegocioException("No hay sesión activa", null);
        }

        try {
            Cuenta cuenta = cuentaDAO.obtenerCuentaPorId(idCuenta);

            if (cuenta == null) {
                throw new NegocioException("La cuenta no existe", null);
            }

            if (!cuenta.getCliente().getIdCliente().equals(Sesion.getIdCliente())) {
                throw new NegocioException("La cuenta no pertenece al cliente", null);
            }

            if (cuenta.getEstado().equalsIgnoreCase("ACTIVA")) {
                throw new NegocioException("La cuenta ya está activa", null);
            }

            if (!Sesion.getClienteActivo().getContrasenia().equals(contrasenia)) {
                throw new NegocioException("Contraseña incorrecta", null);
            }

            cuentaDAO.actualizarEstado(idCuenta, "ACTIVA");

        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al activar la cuenta", ex);
        }
    }

    /**
     * Desactiva una cuenta específica después de validar la sesión y la contraseña.
     * 
     * @param idCuenta ID de la cuenta a desactivar.
     * @param contrasenia Contraseña del cliente activo.
     * @throws NegocioException si no hay sesión activa, la cuenta no existe,
     *         ya está inactiva o la contraseña es incorrecta.
     */
    @Override
    public void desactivarCuenta(Integer idCuenta, String contrasenia)
            throws NegocioException {

        if (Sesion.getClienteActivo() == null) {
            throw new NegocioException("No hay sesión activa", null);
        }

        try {
            Cuenta cuenta = cuentaDAO.obtenerCuentaPorId(idCuenta);

            if (cuenta == null) {
                throw new NegocioException("La cuenta no existe", null);
            }

            if (!cuenta.getCliente().getIdCliente().equals(Sesion.getIdCliente())) {
                throw new NegocioException("La cuenta no pertenece al cliente", null);
            }

            if (cuenta.getEstado().equalsIgnoreCase("INACTIVA")) {
                throw new NegocioException("La cuenta ya está inactiva", null);
            }

            if (!Sesion.getClienteActivo().getContrasenia().equals(contrasenia)) {
                throw new NegocioException("Contraseña incorrecta", null);
            }

            cuentaDAO.actualizarEstado(idCuenta, "INACTIVA");

        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al desactivar la cuenta", ex);
        }
    }
}