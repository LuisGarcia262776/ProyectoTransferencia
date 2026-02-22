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
 *
 * @author PC GAMER MASTER RACE
 */
public class CuentaDAO implements ICuentaDAO {

    private static final Logger LOGGER = Logger.getLogger(CuentaDAO.class.getName());

    @Override
    public Cuenta crearCuenta(NuevaCuentaDTO nuevaCuenta) throws PersistenciaException {
        try {
            String comandoSQL = """
                INSERT INTO Cuentas(numeroCuenta, fechaApertura, saldo, estado, IdCliente)
                VALUES(?, ?, ?, ?, ?);
            """;

            Connection conexion = ConexionBD.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(comandoSQL, Statement.RETURN_GENERATED_KEYS);

            SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
            String fechaApertura = formateador.format(nuevaCuenta.getFechaApertura().getTime());

            comando.setString(1, nuevaCuenta.getNumeroCuenta());
            comando.setString(2, fechaApertura);
            comando.setDouble(3, nuevaCuenta.getSaldo());
            comando.setString(4, nuevaCuenta.getEstado());
            comando.setInt(5, nuevaCuenta.getIdCliente());

            int filas = comando.executeUpdate();

            ResultSet rs = comando.getGeneratedKeys();

            Integer idCuenta = null;

            if (rs.next()) {
                idCuenta = rs.getInt(1);
            }

            LOGGER.fine("Se registró la cuenta");

            return new Cuenta(idCuenta, nuevaCuenta.getNumeroCuenta(), nuevaCuenta.getFechaApertura(), nuevaCuenta.getSaldo(), nuevaCuenta.getEstado(), null);

        } catch (SQLException ex) {
            throw new PersistenciaException("No fue posible agregar la cuenta", ex);
        }

    }

    @Override
    public List<Cuenta> obtenerCuenta() throws PersistenciaException {
        List<Cuenta> lista = new ArrayList<>();

        try {
            String sql = "SELECT * FROM cuentas";
            Connection conexion = ConexionBD.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                Integer idCuenta = resultado.getInt("IdCuenta");
                String numeroCuenta = resultado.getString("NumeroCuenta");
                Date fechaAperturaBD = resultado.getDate("FechaApertura");
                GregorianCalendar fechaApertura = new GregorianCalendar();
                fechaApertura.setTime(fechaAperturaBD);
                Double saldo = resultado.getDouble("Saldo");
                String estado = resultado.getString("Estado");
                Integer idCliente = resultado.getInt("IdCliente");

                Cliente cliente = new Cliente();
                cliente.setIdCliente(idCliente);

                Cuenta cuenta = new Cuenta(idCuenta, numeroCuenta, fechaApertura, saldo, estado, cliente);

                lista.add(cuenta);
            }

            return lista;

        } catch (SQLException ex) {
            throw new PersistenciaException("Error al obtener las Cuentas", ex);
        }
    }

    @Override
    public Cuenta obtenerCuentaNumero(String numeroCuenta) throws PersistenciaException {
        try {
            String sql = "SELECT * FROM Cuentas WHERE numeroCuenta = ?";
            Connection conexion = ConexionBD.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(sql);

            comando.setString(1, numeroCuenta);

            ResultSet resultado = comando.executeQuery();

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

    @Override
    public void retirar(Integer idCuenta, Float monto) throws PersistenciaException {
        try {
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

    @Override
    public void depositar(Integer idCuenta, Float monto) throws PersistenciaException {
        try {
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

    @Override
    public void actualizarEstado(Integer idCuenta, String estado) throws PersistenciaException {
        try {
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

                Cuenta cuenta = new Cuenta(
                        idCuenta, numeroCuenta, fecha, saldo, estado, cliente);

                lista.add(cuenta);
            }

            return lista;

        } catch (SQLException ex) {
            throw new PersistenciaException(
                    "Error al obtener cuentas del cliente", ex);
        }
    }

}
