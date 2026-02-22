package proyectotransferencia.negocio;

import java.util.GregorianCalendar;
import java.util.List;
import proyectotransferencia.dtos.NuevaCuentaDTO;
import proyectotransferencia.entidades.Cuenta;
import proyectotransferencia.persistencia.ICuentaDAO;
import proyectotransferencia.persistencia.PersistenciaException;
import proyectotransferencia.sesion.Sesion;

public class CuentaBO implements ICuentaBO {

    private final ICuentaDAO cuentaDAO;

    public CuentaBO(ICuentaDAO cuentaDAO) {
        this.cuentaDAO = cuentaDAO;
    }

    @Override
    public Cuenta crearCuenta(NuevaCuentaDTO nuevaCuenta) throws NegocioException {

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
            return cuentaDAO.crearCuenta(nuevaCuenta);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al Crear La Cuenta", ex);
        }
    }

    @Override
    public List<Cuenta> obtenerCuenta() throws NegocioException {
        try {
            return cuentaDAO.obtenerCuenta();
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se Pudieron Obtener Las Cuentas", ex);
        }
    }

    @Override
    public Cuenta obtenerCuentaNumero(String numeroCuenta) throws NegocioException {
        try {
            return cuentaDAO.obtenerCuentaNumero(numeroCuenta);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se Pudo Obtener El Numero de Cuenta", ex);
        }
    }

    @Override
    public void retirar(Integer idCuenta, Float monto) throws NegocioException {
        try {
            cuentaDAO.retirar(idCuenta, monto);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al retirar dinero", ex);
        }
    }

    @Override
    public void depositar(Integer idCuenta, Float monto) throws NegocioException {
        try {
            cuentaDAO.depositar(idCuenta, monto);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al depositar dinero", ex);
        }
    }

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