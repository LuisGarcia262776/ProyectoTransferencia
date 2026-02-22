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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.logging.Logger;
import proyectotransferencia.conexion.ConexionBD;
import proyectotransferencia.dtos.NuevoRetiroSinCuentaDTO;
import proyectotransferencia.entidades.Cuenta;
import proyectotransferencia.entidades.Operaciones;
import proyectotransferencia.entidades.RetiroSinCuenta;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class RetiroSinCuentaDAO implements IRetiroSinCuentaDAO {
    
    private static final Logger LOGGER = Logger.getLogger(RetiroSinCuentaDAO.class.getName());
    
    @Override
    public RetiroSinCuenta crearRetiroSinCuenta(NuevoRetiroSinCuentaDTO nuevoRetiroSinCuenta) throws PersistenciaException {
        try{
            String sql = """
                        INSERT INTO RetirosSinCuenta(IdOperacion, Folio, ContraseñaRetiro, Monto, FechaHoraSolicitud, FechaHoraCobro)
                        VALUES (?, ?, ?, ?, ?, ?)
                        """;

            Connection conexion = ConexionBD.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(sql);

            comando.setInt(1, nuevoRetiroSinCuenta.getIdOperacion().getIdOperacion());
            comando.setInt(2, nuevoRetiroSinCuenta.getFolio());
            comando.setString(3, nuevoRetiroSinCuenta.getContraseñaRetiro());
            comando.setFloat(4, nuevoRetiroSinCuenta.getMonto());
            comando.setTimestamp(5, new Timestamp(nuevoRetiroSinCuenta.getFechaHoraSolicitud().getTimeInMillis()));
            comando.setTimestamp(6, null);
            comando.executeUpdate();

            LOGGER.info("Retiro creado correctamente. Folio: " + nuevoRetiroSinCuenta.getFolio());

            return new RetiroSinCuenta(nuevoRetiroSinCuenta.getFolio(), nuevoRetiroSinCuenta.getContraseñaRetiro(), nuevoRetiroSinCuenta.getMonto(), nuevoRetiroSinCuenta.getFechaHoraSolicitud(), null, nuevoRetiroSinCuenta.getIdOperacion());
        }catch(SQLException ex){
            throw new PersistenciaException("Error al crear retiro sin cuenta", ex);
        }
    }

    @Override
    public RetiroSinCuenta obtenerReitroPorFolioYContraseña(Integer folio, String Contrasenia) throws PersistenciaException {
        try {
            String sql = """
                        SELECT r.Folio, r.ContraseñaRetiro, r.Monto, r.FechaHoraSolicitud, o.IdOperacion, o.IdCuenta
                        FROM RetirosSinCuenta r
                        JOIN Operaciones o ON r.IdOperacion = o.IdOperacion
                        WHERE r.Folio = ?
                        AND r.ContraseñaRetiro = ?
                        """;

            Connection conexion = ConexionBD.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(sql);

            comando.setInt(1, folio);
            comando.setString(2, Contrasenia);

            ResultSet rs = comando.executeQuery();

            if (rs.next()) {
                RetiroSinCuenta retiro = new RetiroSinCuenta();

                retiro.setFolio(rs.getInt("Folio"));
                retiro.setContraseñaRetiro(rs.getString("ContraseñaRetiro"));
                retiro.setMonto(rs.getFloat("Monto"));

                GregorianCalendar fecha = new GregorianCalendar();
                fecha.setTime(rs.getTimestamp("FechaHoraSolicitud"));
                retiro.setFechaHoraSolicitud(fecha);

                // crear cuenta
                Cuenta cuenta = new Cuenta();
                cuenta.setIdCuenta(rs.getInt("IdCuenta"));

                // crear operacion
                Operaciones operacion = new Operaciones();
                operacion.setIdOperacion(rs.getInt("IdOperacion"));
                operacion.setCuenta(cuenta);

                retiro.setOperacion(operacion);
                return retiro;
            }
            return null;
        }catch(SQLException ex) {
            throw new PersistenciaException("Error al buscar retiro", ex);
        }
    }

    @Override
    public RetiroSinCuenta actualizarFechaCobro(Integer folio, GregorianCalendar fechaCobro) throws PersistenciaException {
        try {
            String sql = """
                        UPDATE RetirosSinCuenta
                        SET FechaHoraCobro = ?
                        WHERE Folio = ?
                        """;

            Connection con = ConexionBD.crearConexion();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setTimestamp(1, new Timestamp(fechaCobro.getTimeInMillis()));
            ps.setInt(2, folio);

            ps.executeUpdate();

            RetiroSinCuenta retiro = new RetiroSinCuenta();
            retiro.setFolio(folio);
            retiro.setFechaHoraCobro(fechaCobro);

            return retiro;
        }catch (SQLException ex) {
            throw new PersistenciaException("Error al actualizar retiro", ex);
        }   
    }

    
}
