/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotransferencia.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;
import proyectotransferencia.conexion.ConexionBD;
import proyectotransferencia.dtos.NuevaTransferenciaDTO;
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

            String comandoSQL = """
                                INSERT INTO Transferencias(monto, concepto, idOperacion)
                                VALUES(?, ?, ?);
                                """;

            Connection conexion = ConexionBD.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(comandoSQL);

            comando.setFloat(1, nuevaTransferencia.getMonto());
            comando.setString(2, nuevaTransferencia.getConcepto());
            comando.setInt(3, nuevaTransferencia.getIdOperacion());

            int filas = comando.executeUpdate();

            LOGGER.fine("Se Registró La Transferencia");
            return new Transferencia(nuevaTransferencia.getMonto(), nuevaTransferencia.getConcepto(), null);

        } catch (SQLException ex) {
            throw new PersistenciaException("No fue posible agregar la transferencia", ex);
        }
        
        
    }
    
}
