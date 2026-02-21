/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotransferencia.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import proyectotransferencia.conexion.ConexionBD;
import proyectotransferencia.dtos.NuevaTransferenciaDTO;
import proyectotransferencia.entidades.Operaciones;
import proyectotransferencia.entidades.Transferencia;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class TransferenciaDAO implements ITransferenciaDAO {
    private static final Logger LOGGER = Logger.getLogger(TransferenciaDAO.class.getName());

    @Override
    public Transferencia crearTransferencia(NuevaTransferenciaDTO nuevaTransferencia) throws PersistenciaException {
        try {
            String sql = """
                        INSERT INTO Transferencias(IdOperacion, Monto, Concepto)
                        VALUES (?, ?, ?);
                        """;
            
            Connection conexion = ConexionBD.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(sql);
            comando.setInt(1, nuevaTransferencia.getIdOperacion());

            comando.setFloat(2, nuevaTransferencia.getMonto());

            comando.setString(3, nuevaTransferencia.getConcepto());

            comando.executeUpdate();

            LOGGER.fine("Transferencia creada correctamente");
            
            Operaciones operacion = new Operaciones();
            operacion.setIdOperacion(nuevaTransferencia.getIdOperacion());

            return new Transferencia(nuevaTransferencia.getMonto(), nuevaTransferencia.getConcepto(), operacion);

        }catch(SQLException ex){
            throw new PersistenciaException("Error al crear transferencia", ex);
        }
    }
        
    
}
