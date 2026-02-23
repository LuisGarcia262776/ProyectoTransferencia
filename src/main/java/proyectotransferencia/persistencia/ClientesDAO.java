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
 * Clase encargada de manejar la persistencia de datos de clientes.
 * Implementa la interfaz IClientesDAO para definir las operaciones de acceso a datos.
 * @author PC GAMER MASTER RACE
 */
public class ClientesDAO implements IClientesDAO{
    
    // Logger para registrar información y errores en la aplicación
    private static final Logger LOGGER = Logger.getLogger(ClientesDAO.class.getName());

    /**
     * Crea un nuevo cliente en la base de datos.
     * @param nuevoCliente DTO con los datos del cliente a registrar
     * @return Objeto Cliente con los datos registrados, incluyendo el ID generado
     * @throws PersistenciaException si ocurre algún error en la base de datos
     */
    @Override
    public Cliente crearCliente(NuevoClienteDTO nuevoCliente) throws PersistenciaException {
        try{
            // Comando SQL para insertar un nuevo cliente
            String comandoSQL = """
                                INSERT INTO Clientes(nombre, apellidoPaterno, apellidoMaterno, domicilio, contrasenia, fechaNacimiento, fechaRegistro)
                                VALUES(?, ?, ?, ?, ?, ?, ?);
                                """;
            
            // Crear conexión a la base de datos
            Connection conexion = ConexionBD.crearConexion();
            
            // Preparar el statement con retorno de claves generadas
            PreparedStatement comando = conexion.prepareStatement(comandoSQL, Statement.RETURN_GENERATED_KEYS); 
            
            // Formatear fechas para que sean compatibles con SQL
            SimpleDateFormat formateadorFechas = new SimpleDateFormat("yyyy-MM-dd");
            String fechaNaci = formateadorFechas.format(nuevoCliente.getFechaNacimiento().getTime());
            String fechaRegi = formateadorFechas.format(nuevoCliente.getFechaRegistro().getTime());
            
            // Asignar valores al statement
            comando.setString(1, nuevoCliente.getNombre());                   
            comando.setString(2, nuevoCliente.getApellidoPaterno());
            comando.setString(3, nuevoCliente.getApellidoMaterno());
            comando.setString(4, nuevoCliente.getDomicilio());
            comando.setString(5, nuevoCliente.getContrasenia());
            comando.setString(6, fechaNaci);
            comando.setString(7, fechaRegi);
            
            // Ejecutar comando SQL
            boolean resultado = comando.execute();
            
            // Recuperar el ID generado por la base de datos
            ResultSet rs = comando.getGeneratedKeys();
            Integer idGenerado = null;
            if (rs.next()) {
                idGenerado = rs.getInt(1);
            }
            
            // Loguear el ID generado
            LOGGER.fine("Se registró el cliente con el ID: " + idGenerado);
            
            // Retornar el objeto Cliente con todos los datos
            return new Cliente(idGenerado, nuevoCliente.getNombre(), nuevoCliente.getApellidoPaterno(), nuevoCliente.getApellidoMaterno(), nuevoCliente.getDomicilio(), nuevoCliente.getContrasenia(), nuevoCliente.getFechaNacimiento(), nuevoCliente.getFechaRegistro());
        }catch(SQLException ex){
            // Capturar cualquier error SQL y lanzar excepción personalizada
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No fue posible agregar al cliente", ex);
        }
    }
    
    /**
     * Obtiene la lista de todos los clientes registrados en la base de datos.
     * @return Lista de objetos Cliente
     * @throws PersistenciaException si ocurre un error al consultar la base de datos
     */
    @Override
    public List<Cliente> obtenerClientes() throws PersistenciaException {
        List<Cliente> lista = new ArrayList<>();

        try {
            // Comando SQL para obtener todos los clientes
            String sql = "SELECT * FROM clientes";
            
            // Crear conexión y preparar statement
            Connection conexion = ConexionBD.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(sql);
            
            // Ejecutar consulta
            ResultSet resultado = comando.executeQuery();

            // Recorrer resultados y crear objetos Cliente
            while (resultado.next()) {
                Integer idCliente = resultado.getInt("IdCliente");
                String nombre = resultado.getString("nombre");
                String apellidoPaterno = resultado.getString("apellidoPaterno");
                String apellidoMaterno = resultado.getString("apellidoMaterno");
                String domicilio = resultado.getString("domicilio");
                String contrasenia = resultado.getString("contrasenia");

                // Convertir fechas de java.sql.Date a GregorianCalendar
                Date fechaNacBD = resultado.getDate("fechaNacimiento");
                GregorianCalendar fechaNacimiento = new GregorianCalendar();
                fechaNacimiento.setTime(fechaNacBD);

                Date fechaRegBD = resultado.getDate("fechaRegistro");
                GregorianCalendar fechaRegistro = new GregorianCalendar();
                fechaRegistro.setTime(fechaRegBD);

                // Crear objeto Cliente y agregarlo a la lista
                Cliente cliente = new Cliente(idCliente, nombre, apellidoPaterno, apellidoMaterno, domicilio, contrasenia, fechaNacimiento, fechaRegistro);
                lista.add(cliente);
            }

            return lista;

        }catch(SQLException ex) {
            // Capturar errores de consulta
            throw new PersistenciaException("Error al obtener clientes", ex);
        }
    }

    /**
     * Permite iniciar sesión de un cliente validando su ID y contraseña.
     * @param idCliente ID del cliente
     * @param contrasenia Contraseña del cliente
     * @return Objeto Cliente si los datos son correctos, null en caso contrario
     * @throws PersistenciaException si ocurre un error al consultar la base de datos
     */
    @Override
    public Cliente iniciarSesion(Integer idCliente, String contrasenia) throws PersistenciaException {
        try {
            // Comando SQL para validar credenciales
            String sql ="""
                        SELECT * FROM Clientes WHERE IdCliente = ? AND Contrasenia = ?;
                        """;
            
            // Crear conexión y preparar statement
            Connection conexion = ConexionBD.crearConexion();
            PreparedStatement comando = conexion.prepareStatement(sql);

            // Asignar parámetros
            comando.setInt(1, idCliente);
            comando.setString(2, contrasenia);
            
            // Ejecutar consulta
            ResultSet rs = comando.executeQuery();
            
            // Si se encuentra un cliente válido
            if(rs.next()){
                Integer id = rs.getInt("IdCliente");
                String nombre = rs.getString("Nombre");
                String apellidoP = rs.getString("ApellidoPaterno");
                String apellidoM = rs.getString("ApellidoMaterno");
                String domicilio = rs.getString("Domicilio");

                // Convertir fechas de java.sql.Date a GregorianCalendar
                Date fechaNacBD = rs.getDate("FechaNacimiento");
                GregorianCalendar fechaNacimiento = new GregorianCalendar();
                fechaNacimiento.setTime(fechaNacBD);

                Date fechaRegBD = rs.getDate("FechaRegistro");
                GregorianCalendar fechaRegistro = new GregorianCalendar();
                fechaRegistro.setTime(fechaRegBD);

                // Retornar objeto Cliente
                return new Cliente(id,nombre,apellidoP,apellidoM,domicilio,contrasenia,fechaNacimiento,fechaRegistro);
            }
            return null;
        }
        catch(SQLException ex){
            // Capturar errores de consulta
            throw new PersistenciaException("Error al iniciar sesión",ex);
        }
    }
    
}