/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotransferencia.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.GregorianCalendar;
import java.util.logging.Logger;
import proyectotransferencia.conexion.ConexionBD;
import proyectotransferencia.dtos.NuevoRetiroSinCuentaDTO;
import proyectotransferencia.entidades.Cuenta;
import proyectotransferencia.entidades.Operaciones;
import proyectotransferencia.entidades.RetiroSinCuenta;

/**
 * Clase que implementa la interfaz IRetiroSinCuentaDAO.
 * Gestiona la persistencia de retiros realizados sin una cuenta bancaria asociada.
 * Permite registrar, consultar y actualizar la fecha de cobro de estos retiros en la base de datos.
 * 
 * Autor: PC GAMER MASTER RACE
 */
public class RetiroSinCuentaDAO implements IRetiroSinCuentaDAO {

    // Logger para registrar información y errores
    private static final Logger LOGGER = Logger.getLogger(RetiroSinCuentaDAO.class.getName());
    
    /**
     * Registra un nuevo retiro sin cuenta en la base de datos.
     * @param nuevoRetiroSinCuenta DTO que contiene los datos del retiro a crear
     * @return Objeto RetiroSinCuenta con los datos registrados
     * @throws PersistenciaException si ocurre un error al acceder a la base de datos
     */
    @Override
    public RetiroSinCuenta crearRetiroSinCuenta(NuevoRetiroSinCuentaDTO nuevoRetiroSinCuenta) throws PersistenciaException {
        try {
            // SQL para insertar un retiro sin cuenta
            String sql = """
                        INSERT INTO RetirosSinCuenta(IdOperacion, Folio, ContraseñaRetiro, Monto, FechaHoraSolicitud, FechaHoraCobro)
                        VALUES (?, ?, ?, ?, ?, ?)
                        """;

            Connection conexion = ConexionBD.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(sql);

            // Asignar valores al statement
            comando.setInt(1, nuevoRetiroSinCuenta.getIdOperacion().getIdOperacion());
            comando.setInt(2, nuevoRetiroSinCuenta.getFolio());
            comando.setString(3, nuevoRetiroSinCuenta.getContraseñaRetiro());
            comando.setFloat(4, nuevoRetiroSinCuenta.getMonto());
            comando.setTimestamp(5, new Timestamp(nuevoRetiroSinCuenta.getFechaHoraSolicitud().getTimeInMillis()));
            comando.setTimestamp(6, null); // Fecha de cobro inicialmente nula
            comando.executeUpdate();

            LOGGER.info("Retiro creado correctamente. Folio: " + nuevoRetiroSinCuenta.getFolio());

            // Retornar objeto RetiroSinCuenta con datos iniciales
            return new RetiroSinCuenta(
                    nuevoRetiroSinCuenta.getFolio(),
                    nuevoRetiroSinCuenta.getContraseñaRetiro(),
                    nuevoRetiroSinCuenta.getMonto(),
                    nuevoRetiroSinCuenta.getFechaHoraSolicitud(),
                    null,
                    nuevoRetiroSinCuenta.getIdOperacion()
            );
        } catch(SQLException ex) {
            throw new PersistenciaException("Error al crear retiro sin cuenta", ex);
        }
    }

    /**
     * Obtiene un retiro sin cuenta mediante su folio y contraseña.
     * @param folio Folio del retiro
     * @param Contrasenia Contraseña asociada al retiro
     * @return Objeto RetiroSinCuenta si se encuentra, null si no existe
     * @throws PersistenciaException si ocurre un error al consultar la base de datos
     */
    @Override
    public RetiroSinCuenta obtenerReitroPorFolioYContraseña(Integer folio, String Contrasenia) throws PersistenciaException {
        try {
            // SQL para consultar retiro y su operación asociada
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

                // Convertir Timestamp a GregorianCalendar
                GregorianCalendar fecha = new GregorianCalendar();
                fecha.setTime(rs.getTimestamp("FechaHoraSolicitud"));
                retiro.setFechaHoraSolicitud(fecha);

                // Crear objeto Cuenta solo con ID
                Cuenta cuenta = new Cuenta();
                cuenta.setIdCuenta(rs.getInt("IdCuenta"));

                // Crear objeto Operaciones asociado al retiro
                Operaciones operacion = new Operaciones();
                operacion.setIdOperacion(rs.getInt("IdOperacion"));
                operacion.setCuenta(cuenta);

                retiro.setOperacion(operacion);
                return retiro;
            }
            return null;
        } catch(SQLException ex) {
            throw new PersistenciaException("Error al buscar retiro", ex);
        }
    }

    /**
     * Actualiza la fecha de cobro de un retiro sin cuenta.
     * @param folio Folio del retiro a actualizar
     * @param fechaCobro Nueva fecha de cobro
     * @return Objeto RetiroSinCuenta con la fecha de cobro actualizada
     * @throws PersistenciaException si ocurre un error al actualizar la base de datos
     */
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

            // Retornar objeto con folio y fecha actualizada
            RetiroSinCuenta retiro = new RetiroSinCuenta();
            retiro.setFolio(folio);
            retiro.setFechaHoraCobro(fechaCobro);

            return retiro;
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al actualizar retiro", ex);
        }   
    }   
}