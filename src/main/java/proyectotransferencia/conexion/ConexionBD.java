/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotransferencia.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class ConexionBD {
    private static final String CADENA_CONEXION = "jdbc:mysql://localhost:3306/bancodb";
    private static final String USUARIO = "root";
    private static final String CONTRASENIA = "said2111";
    
    public static Connection crearConexion() throws SQLException{
         Connection conexion = DriverManager.getConnection(
            ConexionBD.CADENA_CONEXION, 
            ConexionBD.USUARIO, 
            ConexionBD.CONTRASENIA
        );
        return conexion;
    }
    
}
