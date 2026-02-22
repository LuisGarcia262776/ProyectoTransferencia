package proyectotransferencia.negocio;

import java.util.List;
import proyectotransferencia.dtos.NuevaCuentaDTO;
import proyectotransferencia.entidades.Cuenta;

public interface ICuentaBO {

    Cuenta crearCuenta(NuevaCuentaDTO nuevaCuenta)
            throws NegocioException;

    List<Cuenta> obtenerCuenta()
            throws NegocioException;

    Cuenta obtenerCuentaNumero(String numeroCuenta)
            throws NegocioException;

    void retirar(Integer idCuenta, Float monto)
            throws NegocioException;

    void depositar(Integer idCuenta, Float monto)
            throws NegocioException;

    List<Cuenta> obtenerCuentasDelCliente()
            throws NegocioException;

    void activarCuenta(Integer idCuenta, String contrasenia)
            throws NegocioException;

    void desactivarCuenta(Integer idCuenta, String contrasenia)
            throws NegocioException;
}