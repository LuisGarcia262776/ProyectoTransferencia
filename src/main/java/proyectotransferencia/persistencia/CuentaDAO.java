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
            PreparedStatement comando = conexion.prepareStatement(comandoSQL);

            SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
            String fechaApertura = formateador.format(nuevaCuenta.getFechaApertura().getTime());

            comando.setString(1, nuevaCuenta.getNumeroCuenta());
            comando.setString(2, fechaApertura);
            comando.setDouble(3, nuevaCuenta.getSaldo());
            comando.setString(4, nuevaCuenta.getEstado());
            comando.setInt(5, nuevaCuenta.getIdCliente());

            boolean resultado = comando.execute();

            LOGGER.fine("Se registró la cuenta");

            return new Cuenta(null, nuevaCuenta.getNumeroCuenta(), nuevaCuenta.getFechaApertura(), nuevaCuenta.getSaldo(), nuevaCuenta.getEstado(), null);

        }catch (SQLException ex) {
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
   
        }catch(SQLException ex) {
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

        }catch(SQLException ex) {
            throw new PersistenciaException("Error al obtener la cuenta por número", ex);
        }
        
    }

    
        
}
    
