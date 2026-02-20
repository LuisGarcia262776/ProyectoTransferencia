/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotransferencia.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;
import proyectotransferencia.conexion.ConexionBD;
import proyectotransferencia.dtos.NuevaCuentaDTO;
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

            System.out.println("ID QUE LLEGA AL DAO: " + nuevaCuenta.getIdCliente());

            comando.setString(1, nuevaCuenta.getNumeroCuenta());
            comando.setString(2, fechaApertura);
            comando.setDouble(3, nuevaCuenta.getSaldo());
            comando.setString(4, nuevaCuenta.getEstado());
            comando.setInt(5, nuevaCuenta.getIdCliente());

            int filas = comando.executeUpdate();

            LOGGER.fine("Se registró la cuenta");

            return new Cuenta(null, nuevaCuenta.getNumeroCuenta(), nuevaCuenta.getFechaApertura(), nuevaCuenta.getSaldo(), nuevaCuenta.getEstado(), null);

        }catch (SQLException ex) {
            throw new PersistenciaException("No fue posible agregar la cuenta", ex);
        }
    
    }
        
}
    
