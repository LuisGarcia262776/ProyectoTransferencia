package proyectotransferencia.negocio;

import java.util.List;
import proyectotransferencia.dtos.NuevaCuentaDTO;
import proyectotransferencia.entidades.Cuenta;

/**
 * Interfaz que define las operaciones de negocio relacionadas con la gestión de cuentas.
 * Permite crear cuentas, consultar información, realizar operaciones de retiro y depósito,
 * así como activar o desactivar cuentas de clientes.
 * 
 * Las implementaciones deben encargarse de validar los datos antes de llamar a la capa de persistencia
 * y de lanzar {@link NegocioException} en caso de errores de negocio.
 */
public interface ICuentaBO {

    /**
     * Crea una nueva cuenta para un cliente.
     * 
     * @param nuevaCuenta DTO con los datos de la cuenta a crear.
     * @return La cuenta creada con su ID asignado.
     * @throws NegocioException si los datos son inválidos o ocurre un error de persistencia.
     */
    Cuenta crearCuenta(NuevaCuentaDTO nuevaCuenta)
            throws NegocioException;

    /**
     * Obtiene todas las cuentas registradas en el sistema.
     * 
     * @return Lista de cuentas.
     * @throws NegocioException si ocurre un error al consultar la base de datos.
     */
    List<Cuenta> obtenerCuenta()
            throws NegocioException;

    /**
     * Obtiene una cuenta específica a partir de su número de cuenta.
     * 
     * @param numeroCuenta Número de la cuenta a consultar.
     * @return La cuenta correspondiente al número proporcionado.
     * @throws NegocioException si la cuenta no existe o hay un error de persistencia.
     */
    Cuenta obtenerCuentaNumero(String numeroCuenta)
            throws NegocioException;

    /**
     * Realiza un retiro de dinero de la cuenta especificada.
     * 
     * @param idCuenta ID de la cuenta desde la que se retirará el dinero.
     * @param monto Cantidad a retirar.
     * @throws NegocioException si ocurre un error de validación o de persistencia.
     */
    void retirar(Integer idCuenta, Float monto)
            throws NegocioException;

    /**
     * Realiza un depósito de dinero en la cuenta especificada.
     * 
     * @param idCuenta ID de la cuenta donde se depositará el dinero.
     * @param monto Cantidad a depositar.
     * @throws NegocioException si ocurre un error de validación o de persistencia.
     */
    void depositar(Integer idCuenta, Float monto)
            throws NegocioException;

    /**
     * Obtiene todas las cuentas asociadas al cliente actualmente en sesión.
     * 
     * @return Lista de cuentas del cliente activo.
     * @throws NegocioException si no hay sesión activa o ocurre un error de persistencia.
     */
    List<Cuenta> obtenerCuentasDelCliente()
            throws NegocioException;

    /**
     * Activa una cuenta asociada al cliente actualmente en sesión.
     * 
     * @param idCuenta ID de la cuenta a activar.
     * @param contrasenia Contraseña del cliente para validar la operación.
     * @throws NegocioException si la cuenta no existe, no pertenece al cliente,
     *         ya está activa, la contraseña es incorrecta o hay un error de persistencia.
     */
    void activarCuenta(Integer idCuenta, String contrasenia)
            throws NegocioException;

    /**
     * Desactiva una cuenta asociada al cliente actualmente en sesión.
     * 
     * @param idCuenta ID de la cuenta a desactivar.
     * @param contrasenia Contraseña del cliente para validar la operación.
     * @throws NegocioException si la cuenta no existe, no pertenece al cliente,
     *         ya está inactiva, la contraseña es incorrecta o hay un error de persistencia.
     */
    void desactivarCuenta(Integer idCuenta, String contrasenia)
            throws NegocioException;
}