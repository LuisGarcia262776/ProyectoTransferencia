/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotransferencia.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Logger;
import proyectotransferencia.conexion.ConexionBD;
import proyectotransferencia.dtos.NuevoClienteDTO;
import proyectotransferencia.entidades.Cliente;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class ClientesDAO implements IClientesDAO{
    
    private static final Logger LOGGER = Logger.getLogger(ClientesDAO.class.getName());

    @Override
    public Cliente crearCliente(NuevoClienteDTO nuevoCliente) throws PersistenciaException {
        try{
            String comandoSQL = """
                                INSERT INTO Clientes(nombre, apellidoPaterno, apellidoMaterno, domicilio, contrasenia, fechaNacimiento, fechaRegistro)
                                VALUES(?, ?, ?, ?, ?, ?, ?);
                                """;
            Connection conexion = ConexionBD.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(comandoSQL); 
            SimpleDateFormat formateadorFechas = new SimpleDateFormat("yyyy-MM-dd");
            String fechaNaci = formateadorFechas.format(nuevoCliente.getFechaNacimiento().getTime());
            String fechaRegi = formateadorFechas.format(nuevoCliente.getFechaRegistro().getTime());
            
            comando.setString(1, nuevoCliente.getNombre());                   
            comando.setString(2, nuevoCliente.getApellidoPaterno());
            comando.setString(3, nuevoCliente.getApellidoMaterno());
            comando.setString(4, nuevoCliente.getDomicilio());
            comando.setString(5, nuevoCliente.getContrasenia());
            comando.setString(6, fechaNaci);
            comando.setString(7, fechaRegi);
            //Ejecutar comando y ver resultado
            boolean resultado = comando.execute();
            // TODO SETEAR EL ID QUE NOS DEVOLVIÓ LA BASE
            LOGGER.fine("Se registró el cliente");
            return new Cliente(null, nuevoCliente.getNombre(), nuevoCliente.getApellidoPaterno(), nuevoCliente.getApellidoMaterno(), nuevoCliente.getDomicilio(), nuevoCliente.getContrasenia(), nuevoCliente.getFechaNacimiento(), nuevoCliente.getFechaRegistro());
        }catch(SQLException ex){
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No fue posible agregar al cliente", ex);
        }
    }
    
    @Override
    public List<Cliente> obtenerClientes() throws PersistenciaException {
        List<Cliente> lista = new ArrayList<>();

        try {
            String sql = "SELECT * FROM clientes";
            Connection conexion = ConexionBD.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {

                Integer idCliente = resultado.getInt("IdCliente");
                String nombre = resultado.getString("nombre");
                String apellidoPaterno = resultado.getString("apellidoPaterno");
                String apellidoMaterno = resultado.getString("apellidoMaterno");
                String domicilio = resultado.getString("domicilio");
                String contrasenia = resultado.getString("contrasenia");

                Date fechaNacBD = resultado.getDate("fechaNacimiento");
                GregorianCalendar fechaNacimiento = new GregorianCalendar();
                fechaNacimiento.setTime(fechaNacBD);

                Date fechaRegBD = resultado.getDate("fechaRegistro");
                GregorianCalendar fechaRegistro = new GregorianCalendar();
                fechaRegistro.setTime(fechaRegBD);

                Cliente cliente = new Cliente(idCliente, nombre, apellidoPaterno, apellidoMaterno, domicilio, contrasenia, fechaNacimiento, fechaRegistro);

                lista.add(cliente);
            }

            return lista;

        }catch(SQLException ex) {
            throw new PersistenciaException("Error al obtener clientes", ex);
        }
    }

    @Override
    public Cliente iniciarSesion(String numeroCuenta, String contrasenia) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    

    
    
}
