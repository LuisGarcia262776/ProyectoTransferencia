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
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Logger;
import proyectotransferencia.conexion.ConexionBD;
import proyectotransferencia.dtos.NuevaOperacionDTO;
import proyectotransferencia.entidades.Cuenta;
import proyectotransferencia.entidades.Operaciones;

/**
 * Clase que implementa la interfaz IOperacionesDAO.
 * Permite registrar nuevas operaciones en la base de datos y consultar
 * el historial de operaciones de un cliente específico.
 * Gestiona la persistencia de las transacciones de cuentas.
 * 
 * @author PC GAMER MASTER RACE
 */
public class OperacionesDAO implements IOperacionesDAO {

    // Logger para registrar información y errores
    private static final Logger LOGGER = Logger.getLogger(OperacionesDAO.class.getName());
    
    /**
     * Registra una nueva operación (retiro, depósito, transferencia) en la base de datos.
     * @param nuevaOperacion DTO con los datos de la operación a registrar
     * @return Objeto Operaciones con los datos guardados, incluyendo el ID generado
     * @throws PersistenciaException si ocurre un error al acceder a la base de datos
     */
    @Override
    public Operaciones crearOperacion(NuevaOperacionDTO nuevaOperacion) throws PersistenciaException {
        try {
            // SQL para insertar una nueva operación
            String sql = """
                    INSERT INTO Operaciones (fechaHora, tipoOperacion, idCuenta) VALUES (?, ?, ?);
                    """;
        
            // Crear conexión a la base de datos
            Connection conexion = ConexionBD.crearConexion();

            // Preparar statement con retorno de claves generadas
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // Asignar valores al statement
            // Convertir GregorianCalendar a Timestamp para SQL
            ps.setTimestamp(1, new Timestamp(nuevaOperacion.getFechaHora().getTimeInMillis()));
            ps.setString(2, nuevaOperacion.getTipoOperacion());
            ps.setInt(3, nuevaOperacion.getIdCuenta());

            // Ejecutar inserción
            ps.executeUpdate();

            // Obtener el ID generado automáticamente
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                Integer idOperacion = rs.getInt(1);

                // Crear objeto Operaciones con los datos registrados
                Operaciones operacion = new Operaciones();
                operacion.setIdOperacion(idOperacion);
                operacion.setFechaHora(nuevaOperacion.getFechaHora());
                operacion.setTipoOperacion(nuevaOperacion.getTipoOperacion());

                // Crear objeto Cuenta solo con ID
                Cuenta cuenta = new Cuenta();
                cuenta.setIdCuenta(nuevaOperacion.getIdCuenta());
                operacion.setCuenta(cuenta); 

                return operacion;
            }

            // Si no se obtuvo el ID generado, lanzar excepción
            throw new PersistenciaException("No se pudo obtener el ID de la operación", null);

        } catch (SQLException ex) {
            throw new PersistenciaException("Error al crear operación", ex);
        }
    }

    /**
     * Obtiene el historial de operaciones de un cliente específico.
     * Se ordena de forma descendente por fecha y hora.
     * @param idCliente ID del cliente
     * @return Lista de objetos Operaciones correspondientes a las transacciones del cliente
     * @throws PersistenciaException si ocurre un error al consultar la base de datos
     */
    @Override
    public List<Operaciones> obtenerHistorialPorCliente(Integer idCliente) throws PersistenciaException {
        List<Operaciones> historial = new ArrayList<>();

        // SQL que une Operaciones con Cuentas para filtrar por cliente
        String sql = "SELECT o.idOperacion, o.fechaHora, o.tipoOperacion, o.idCuenta " +
                     "FROM Operaciones o " +
                     "INNER JOIN Cuentas c ON o.idCuenta = c.idCuenta " +
                     "WHERE c.idCliente = ? " +
                     "ORDER BY o.fechaHora DESC"; 

        // Usar try-with-resources para cerrar automáticamente la conexión y el statement
        try (Connection conexion = ConexionBD.crearConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();

            // Recorrer resultados y crear objetos Operaciones
            while (rs.next()) {
                Operaciones op = new Operaciones();
                op.setIdOperacion(rs.getInt("idOperacion"));

                // Convertir Timestamp SQL a GregorianCalendar
                Timestamp ts = rs.getTimestamp("fechaHora");
                if (ts != null) {
                    GregorianCalendar cal = new GregorianCalendar();
                    cal.setTimeInMillis(ts.getTime());
                    op.setFechaHora(cal);
                }

                op.setTipoOperacion(rs.getString("tipoOperacion"));

                // Asociar la cuenta correspondiente solo con ID
                Cuenta cuenta = new Cuenta();
                cuenta.setIdCuenta(rs.getInt("idCuenta"));
                op.setCuenta(cuenta); 

                historial.add(op);
            }
        } catch (SQLException ex) {
            throw new PersistenciaException("Error al consultar el historial de operaciones", ex);
        }

        return historial;
    }        
}