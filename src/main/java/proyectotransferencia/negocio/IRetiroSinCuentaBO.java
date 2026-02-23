package proyectotransferencia.negocio;

import java.util.GregorianCalendar;
import proyectotransferencia.dtos.NuevoRetiroSinCuentaDTO;
import proyectotransferencia.entidades.RetiroSinCuenta;

/**
 * Interfaz que define las operaciones de negocio relacionadas con los retiros
 * que no requieren una cuenta bancaria.
 * 
 * Permite crear retiros, consultar un retiro por folio y contraseña,
 * y actualizar la fecha de cobro del retiro.
 * 
 * Las implementaciones deben validar los datos de negocio y lanzar
 * {@link NegocioException} si ocurre un error o los datos son inválidos.
 */
public interface IRetiroSinCuentaBO {

    /**
     * Crea un nuevo retiro sin cuenta basado en los datos proporcionados.
     * 
     * @param nuevoRetiroSinCuenta DTO con los datos del retiro a crear.
     * @return El retiro creado con toda la información registrada.
     * @throws NegocioException si los datos son inválidos o ocurre un error en persistencia.
     */
    public abstract RetiroSinCuenta crearRetiroSinCuenta(NuevoRetiroSinCuentaDTO nuevoRetiroSinCuenta) throws NegocioException;

    /**
     * Obtiene un retiro usando su folio y la contraseña asociada.
     * 
     * @param folio Número de folio del retiro.
     * @param Contrasenia Contraseña asociada al retiro.
     * @return El retiro correspondiente, o null si no existe.
     * @throws NegocioException si hay errores de validación o de persistencia.
     */
    public abstract RetiroSinCuenta obtenerReitroPorFolioYContraseña(Integer folio, String Contrasenia) throws NegocioException;

    /**
     * Actualiza la fecha de cobro de un retiro específico.
     * 
     * @param folio Folio del retiro a actualizar.
     * @param fechaCobro Fecha en que se realizó el cobro.
     * @return El retiro actualizado con la nueva fecha de cobro.
     * @throws NegocioException si los datos son inválidos o ocurre un error de persistencia.
     */
    public abstract RetiroSinCuenta actualizarFechaCobro(Integer folio, GregorianCalendar fechaCobro) throws NegocioException;

}