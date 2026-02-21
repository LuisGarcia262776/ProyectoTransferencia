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
        
        

        
}
       
   
