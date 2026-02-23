/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotransferencia.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Logger;
import proyectotransferencia.conexion.ConexionBD;
import proyectotransferencia.dtos.NuevaCuentaDTO;
import proyectotransferencia.entidades.Cliente;
import proyectotransferencia.entidades.Cuenta;

/**
 * Clase que maneja la persistencia de las cuentas bancarias en la base de datos.
 * Implementa la interfaz ICuentaDAO para definir las operaciones CRUD y transacciones.
 * @author PC GAMER MASTER RACE
 */
public class CuentaDAO implements ICuentaDAO {

    // Logger para registrar información y errores
    private static final Logger LOGGER = Logger.getLogger(CuentaDAO.class.getName());

    /**
     * Crea una nueva cuenta bancaria en la base de datos.
     * @param nuevaCuenta DTO con la información de la cuenta a registrar
     * @return Objeto Cuenta con los datos registrados, incluyendo el ID generado
     * @throws PersistenciaException si ocurre algún error en la base de datos
     */
    @Override
    public Cuenta crearCuenta(NuevaCuentaDTO nuevaCuenta) throws PersistenciaException {
        try {
            // Comando SQL para insertar una nueva cuenta
            String comandoSQL = """
                INSERT INTO Cuentas(numeroCuenta, fechaApertura, saldo, estado, IdCliente)
                VALUES(?, ?, ?, ?, ?);
            """;

            // Crear conexión a la base de datos
            Connection conexion = ConexionBD.crearConexion();
            
            // Preparar statement con retorno de claves generadas
            PreparedStatement comando = conexion.prepareStatement(comandoSQL, Statement.RETURN_GENERATED_KEYS);

            // Formatear la fecha de apertura para SQL
            SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
            String fechaApertura = formateador.format(nuevaCuenta.getFechaApertura().getTime());

            // Asignar valores al statement
            comando.setString(1, nuevaCuenta.getNumeroCuenta());
            comando.setString(2, fechaApertura);
            comando.setDouble(3, nuevaCuenta.getSaldo());
            comando.setString(4, nuevaCuenta.getEstado());
            comando.setInt(5, nuevaCuenta.getIdCliente());

            // Ejecutar inserción
            int filas = comando.executeUpdate();

            // Obtener el ID generado automáticamente
            ResultSet rs = comando.getGeneratedKeys();
            Integer idCuenta = null;
            if (rs.next()) {
                idCuenta = rs.getInt(1);
            }

            LOGGER.fine("Se registró la cuenta");

            // Retornar objeto Cuenta con los datos registrados
            return new Cuenta(idCuenta, nuevaCuenta.getNumeroCuenta(), nuevaCuenta.getFechaApertura(), nuevaCuenta.getSaldo(), nuevaCuenta.getEstado(), null);

        } catch (SQLException ex) {
            // Capturar errores SQL y lanzar excepción personalizada
            throw new PersistenciaException("No fue posible agregar la cuenta", ex);
        }
    }

    /**
     * Obtiene todas las cuentas registradas en la base de datos.
     * @return Lista de objetos Cuenta
     * @throws PersistenciaException si ocurre un error al consultar la base de datos
     */
    @Override
    public List<Cuenta> obtenerCuenta() throws PersistenciaException {
        List<Cuenta> lista = new ArrayList<>();

        try {
            // Comando SQL para obtener todas las cuentas
            String sql = "SELECT * FROM cuentas";
            Connection conexion = ConexionBD.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();

            // Recorrer resultados y crear objetos Cuenta
            while (resultado.next()) {
                Integer idCuenta = resultado.getInt("IdCuenta");
                String numeroCuenta = resultado.getString("NumeroCuenta");
                
                // Convertir fecha SQL a GregorianCalendar
                Date fechaAperturaBD = resultado.getDate("FechaApertura");
                GregorianCalendar fechaApertura = new GregorianCalendar();
                fechaApertura.setTime(fechaAperturaBD);
                
                Double saldo = resultado.getDouble("Saldo");
                String estado = resultado.getString("Estado");
                Integer idCliente = resultado.getInt("IdCliente");

                // Crear objeto Cliente solo con ID
                Cliente cliente = new Cliente();
                cliente.setIdCliente(idCliente);

                // Crear objeto Cuenta y agregarlo a la lista
                Cuenta cuenta = new Cuenta(idCuenta, numeroCuenta, fechaApertura, saldo, estado, cliente);
                lista.add(cuenta);
            }

            return lista;

        } catch (SQLException ex) {
            throw new PersistenciaException("Error al obtener las Cuentas", ex);
        }
    }

    /**
     * Obtiene una cuenta específica por su número de cuenta.
     * @param numeroCuenta Número de la cuenta a buscar
     * @return Objeto Cuenta si se encuentra, null si no existe
     * @throws PersistenciaException si ocurre un error al consultar la base de datos
     */
    @Override
    public Cuenta obtenerCuentaNumero(String numeroCuenta) throws PersistenciaException {
        try {
            // Comando SQL para buscar cuenta por número
            String sql = "SELECT * FROM Cuentas WHERE numeroCuenta = ?";
            Connection conexion = ConexionBD.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(sql);

            // Asignar parámetro
            comando.setString(1, numeroCuenta);
            ResultSet resultado = comando.executeQuery();

            // Si existe la cuenta, crear objeto Cuenta
            if (resultado.next()) {
                Integer idCuenta = resultado.getInt("IdCuenta");
                Date fechaAperturaBD = resultado.getDate("FechaApertura");
                GregorianCalendar fechaApertura = new GregorianCalendar();
                fechaApertura.setTime(fechaAperturaBD);

                Double saldo = resultado.getDouble("Saldo");
                String estado = resultado.getString("Estado");
                Integer idCliente = resultado.getInt("IdCliente");

                Cliente cliente = new Cliente();
                cliente.setIdCliente(idCliente);

                return new Cuenta(idCuenta, numeroCuenta, fechaApertura, saldo, estado, cliente);
            }

            return null;

        } catch (SQLException ex) {
            throw new PersistenciaException("Error al obtener la cuenta por número", ex);
        }
    }

    /**
     * Realiza un retiro de dinero de una cuenta específica.
     * @param idCuenta ID de la cuenta
     * @param monto Cantidad a retirar
     * @throws PersistenciaException si ocurre un error al actualizar la base de datos
     */
    @Override
    public void retirar(Integer idCuenta, Float monto) throws PersistenciaException {
        try {
            // Comando SQL para actualizar saldo restando monto
            String sql = """
                        UPDATE Cuentas
                        SET Saldo = Saldo - ?
                        WHERE IdCuenta = ?
                        """;

            Connection conexion = ConexionBD.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(sql);

            comando.setFloat(1, monto);
            comando.setInt(2, idCuenta);
            comando.executeUpdate();
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al retirar dinero", ex);
        }
    }

    /**
     * Realiza un depósito de dinero a una cuenta específica.
     * @param idCuenta ID de la cuenta
     * @param monto Cantidad a depositar
     * @throws PersistenciaException si ocurre un error al actualizar la base de datos
     */
    @Override
    public void depositar(Integer idCuenta, Float monto) throws PersistenciaException {
        try {
            // Comando SQL para actualizar saldo sumando monto
            String sql = """
                        UPDATE Cuentas
                        SET Saldo = Saldo + ?
                        WHERE IdCuenta = ?
                        """;

            Connection conexion = ConexionBD.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(sql);

            comando.setFloat(1, monto);
            comando.setInt(2, idCuenta);
            comando.executeUpdate();

        } catch (SQLException ex) {
            throw new PersistenciaException("Error al depositar dinero", ex);
        }
    }

    /**
     * Obtiene una cuenta por su ID.
     * @param idCuenta ID de la cuenta
     * @return Objeto Cuenta si se encuentra, null si no existe
     * @throws PersistenciaException si ocurre un error al consultar la base de datos
     */
    @Override
    public Cuenta obtenerCuentaPorId(Integer idCuenta) throws PersistenciaException {
        try {
            String sql = "SELECT * FROM Cuentas WHERE IdCuenta = ?";
            Connection conexion = ConexionBD.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(sql);

            comando.setInt(1, idCuenta);
            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                Integer id = resultado.getInt("IdCuenta");
                String numero = resultado.getString("NumeroCuenta");

                Date fechaBD = resultado.getDate("FechaApertura");
                GregorianCalendar fecha = new GregorianCalendar();
                fecha.setTime(fechaBD);

                Double saldo = resultado.getDouble("Saldo");
                String estado = resultado.getString("Estado");
                Integer idCliente = resultado.getInt("IdCliente");

                Cliente cliente = new Cliente();
                cliente.setIdCliente(idCliente);

                return new Cuenta(id, numero, fecha, saldo, estado, cliente);
            }

            return null;

        } catch (SQLException ex) {
            throw new PersistenciaException("Error al obtener cuenta por ID", ex);
        }
    }

    /**
     * Actualiza el estado de una cuenta específica.
     * @param idCuenta ID de la cuenta
     * @param estado Nuevo estado a asignar
     * @throws PersistenciaException si ocurre un error al actualizar la base de datos
     */
    @Override
    public void actualizarEstado(Integer idCuenta, String estado) throws PersistenciaException {
        try {
            // Comando SQL para actualizar estado de la cuenta
            String sql = """
                     UPDATE Cuentas
                     SET Estado = ?
                     WHERE IdCuenta = ?
                     """;

            Connection conexion = ConexionBD.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(sql);

            comando.setString(1, estado);
            comando.setInt(2, idCuenta);

            comando.executeUpdate();

        } catch (SQLException ex) {
            throw new PersistenciaException("Error al actualizar estado", ex);
        }
    }

    /**
     * Obtiene todas las cuentas de un cliente específico.
     * @param idCliente ID del cliente
     * @return Lista de objetos Cuenta
     * @throws PersistenciaException si ocurre un error al consultar la base de datos
     */
    @Override
    public List<Cuenta> obtenerCuentasPorCliente(Integer idCliente)
            throws PersistenciaException {

        List<Cuenta> lista = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Cuentas WHERE IdCliente = ?";
            Connection conexion = ConexionBD.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(sql);

            comando.setInt(1, idCliente);
            ResultSet rs = comando.executeQuery();

            // Recorrer resultados y crear objetos Cuenta
            while (rs.next()) {
                Integer idCuenta = rs.getInt("IdCuenta");
                String numeroCuenta = rs.getString("NumeroCuenta");

                Date fechaBD = rs.getDate("FechaApertura");
                GregorianCalendar fecha = new GregorianCalendar();
                fecha.setTime(fechaBD);

                Double saldo = rs.getDouble("Saldo");
                String estado = rs.getString("Estado");

                Cliente cliente = new Cliente();
                cliente.setIdCliente(idCliente);

                Cuenta cuenta = new Cuenta(idCuenta, numeroCuenta, fecha, saldo, estado, cliente);
                lista.add(cuenta);
            }

            return lista;

        } catch (SQLException ex) {
            throw new PersistenciaException(
                    "Error al obtener cuentas del cliente", ex);
        }
    }

}