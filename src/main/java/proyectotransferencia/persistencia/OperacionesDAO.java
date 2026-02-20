/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotransferencia.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;
import proyectotransferencia.conexion.ConexionBD;
import proyectotransferencia.dtos.NuevaOperacionDTO;
import proyectotransferencia.entidades.Operaciones;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class OperacionesDAO implements IOperacionesDAO{

    private static final Logger LOGGER = Logger.getLogger(OperacionesDAO.class.getName());
    
    @Override
    public Operaciones crearOperacion(NuevaOperacionDTO nuevaOperacion) throws PersistenciaException {
        try {
            String comandoSQL = """
                                INSERT INTO Operaciones(FechaHora, TipoOperacion, IdCuenta)
                                VALUES (?, ?, ?);
                                """;

            Connection conexion = ConexionBD.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(comandoSQL);

            SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaHoraFormateada = formateador.format(nuevaOperacion.getFechaHora().getTime());

            comando.setString(1, fechaHoraFormateada);
            comando.setString(2, nuevaOperacion.getTipoOperacion());
            comando.setInt(3, nuevaOperacion.getIdCuenta());

            int filas = comando.executeUpdate();

            if (filas == 0) {
                throw new PersistenciaException("No se Pudo Insertar La Operacion", null);
            }
            
            LOGGER.fine("Se Registro La Operacion");
            return new Operaciones(null, nuevaOperacion.getFechaHora(), nuevaOperacion.getTipoOperacion(), null);
            
        } catch (SQLException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("Error al Crear la Operacion", ex);
        }
    }
        
        

        
}
       
   
