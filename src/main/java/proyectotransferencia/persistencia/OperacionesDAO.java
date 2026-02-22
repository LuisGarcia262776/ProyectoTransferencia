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
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Logger;
import proyectotransferencia.conexion.ConexionBD;
import proyectotransferencia.dtos.NuevaOperacionDTO;
import proyectotransferencia.entidades.Cuenta;
import proyectotransferencia.entidades.Operaciones;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class OperacionesDAO implements IOperacionesDAO{

    private static final Logger LOGGER = Logger.getLogger(OperacionesDAO.class.getName());
    
    @Override
    public Operaciones crearOperacion(NuevaOperacionDTO nuevaOperacion) throws PersistenciaException {
        try{
            String sql ="""
                    INSERT INTO Operaciones (fechaHora, tipoOperacion, idCuenta) VALUES (?, ?, ?);
                    """;
        
            Connection conexion = ConexionBD.crearConexion();

            PreparedStatement ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            ps.setTimestamp(1, new Timestamp(nuevaOperacion.getFechaHora().getTimeInMillis()));

            ps.setString(2,nuevaOperacion.getTipoOperacion());

            ps.setInt(3,nuevaOperacion.getIdCuenta());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if(rs.next()){
                Integer idOperacion = rs.getInt(1);

                Operaciones operacion = new Operaciones();

                operacion.setIdOperacion(idOperacion);
                operacion.setFechaHora(nuevaOperacion.getFechaHora());
                operacion.setTipoOperacion(nuevaOperacion.getTipoOperacion());
                Cuenta cuenta = new Cuenta();
                cuenta.setIdCuenta(nuevaOperacion.getIdCuenta());
                operacion.setCuenta(cuenta); 

                return operacion;
            }

            throw new PersistenciaException("No se pudo obtener el ID de la operación", null);

        }catch(SQLException ex){
            throw new PersistenciaException("Error al crear operación", ex);
        }
    }

    @Override
    public List<Operaciones> obtenerHistorialPorCliente(Integer idCliente) throws PersistenciaException {
           List<Operaciones> historial = new ArrayList<>();
            String sql = "SELECT o.idOperacion, o.fechaHora, o.tipoOperacion, o.idCuenta " +
                         "FROM Operaciones o " +
                         "INNER JOIN Cuentas c ON o.idCuenta = c.idCuenta " +
                         "WHERE c.idCliente = ? " +
                         "ORDER BY o.fechaHora DESC"; 

            try (Connection conexion = ConexionBD.crearConexion();
                 PreparedStatement ps = conexion.prepareStatement(sql)) {

                ps.setInt(1, idCliente);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    Operaciones op = new Operaciones();
                    op.setIdOperacion(rs.getInt("idOperacion"));

                    Timestamp ts = rs.getTimestamp("fechaHora");
                    if (ts != null) {
                        GregorianCalendar cal = new GregorianCalendar();
                        cal.setTimeInMillis(ts.getTime());
                        op.setFechaHora(cal);
                    }

                    op.setTipoOperacion(rs.getString("tipoOperacion"));

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
       
   
