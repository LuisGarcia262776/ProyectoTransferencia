/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotransferencia.negocio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import proyectotransferencia.dtos.NuevoClienteDTO;
import proyectotransferencia.entidades.Cliente;
import proyectotransferencia.persistencia.IClientesDAO;
import proyectotransferencia.persistencia.PersistenciaException;

/**
 * Clase de negocio que implementa la lógica para la gestión de clientes.
 * Se encarga de validar los datos del cliente antes de enviarlos a la capa de persistencia
 * y de manejar la creación, obtención y autenticación de clientes.
 * 
 * Implementa la interfaz {@link IClientesBO}.
 * 
 * @author PC GAMER MASTER RACE
 */
public class ClientesBO implements IClientesBO {

    /** DAO de clientes para interactuar con la base de datos */
    private final IClientesDAO clientesDAO;

    /**
     * Constructor de la clase.
     * @param clientesDAO DAO de clientes a utilizar.
     */
    public ClientesBO(IClientesDAO clientesDAO) {
        this.clientesDAO = clientesDAO;
    }
    
    /**
     * Crea un nuevo cliente en el sistema después de validar los datos ingresados.
     * Realiza validaciones de campos obligatorios, longitud de cadenas y fechas.
     * 
     * @param nuevoCliente DTO con los datos del nuevo cliente.
     * @return Cliente creado con el ID generado por la base de datos.
     * @throws NegocioException si alguna validación falla o ocurre un error de persistencia.
     */
    @Override
    public Cliente crearCliente(NuevoClienteDTO nuevoCliente) throws NegocioException {
        // Validación de objeto nulo
        if (nuevoCliente == null) {
            throw new NegocioException("El Cliente No Puede Ser Nulo", null);
        }

        // Validación del nombre
        if (nuevoCliente.getNombre() == null) {
            throw new NegocioException("El Nombre es Obligatorio", null);
        }
        
        if(nuevoCliente.getNombre().isEmpty()){
            throw new NegocioException("El Nombre del Cliente no Puede Estar Vacio", null);
        }
        if (nuevoCliente.getNombre().length() > 15) {
            throw new NegocioException("El Nombre es muy Largo Excede los 15 Caracteres", null);
        }

        // Validación del apellido paterno
        if (nuevoCliente.getApellidoPaterno() == null) {
            throw new NegocioException("El Apellido Paterno es Obligatorio", null);
        }
        
        if(nuevoCliente.getApellidoPaterno().isEmpty()){
            throw new NegocioException("El Apellido Paterno no Puede Estar Vacio", null);
        }
                
        if (nuevoCliente.getApellidoPaterno().length() > 30) {
            throw new NegocioException("El Apellido Paterno es Muy Largo Excede los 30 Caracteres", null);
        }

        // Validación del apellido materno
        if (nuevoCliente.getApellidoMaterno() == null) {
            throw new NegocioException("El Apellido Materno es Obligatorio", null);
        }
        
        if(nuevoCliente.getApellidoMaterno().isEmpty()){
            throw new NegocioException("El Apellido Maternos es Obligatorio No Puede Estar Vacio", null);
        }
        if (nuevoCliente.getApellidoMaterno().length() > 30) {
            throw new NegocioException("El Apellido Materno es Muy Largo Excede los 30 Caracteres", null);
        }

        // Validación del domicilio
        if (nuevoCliente.getDomicilio() == null) {
            throw new NegocioException("El Domicilio es Obligatorio", null);
        }
        if (nuevoCliente.getDomicilio().length() > 80) {
            throw new NegocioException("El Domicilio es muy Largo Excede los 80 Caracteres", null);
        }
        
        if(nuevoCliente.getDomicilio().isEmpty()){
            throw new NegocioException("El Domicilio no Puede Estar Vacio", null);
        }

        // Validación de fecha de nacimiento
        if (nuevoCliente.getFechaNacimiento() == null) {
            throw new NegocioException("La Fecha de Nacimiento es Obligatoria", null);
        }
        
        GregorianCalendar calendario = new GregorianCalendar();
        Date fechaHoy = calendario.getTime();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = formato.format(fechaHoy);

        // Validación de contraseña
        if (nuevoCliente.getContrasenia() == null) {
            throw new NegocioException("La Contraseña es Obligatoria", null);
        }
        
        if(nuevoCliente.getContrasenia().isEmpty()){
            throw new NegocioException("La Contraseña no Puede Estar Vacia", null);
        }
        if (nuevoCliente.getContrasenia().length() > 12) {
            throw new NegocioException("La Contraseña no Puede Exceder 12 Caracteres", null);
        }
        
        // Validación de fecha de registro
        if(nuevoCliente.getFechaRegistro().after(fechaFormateada)){
            throw new NegocioException("La Fecha de Registro no Puede ser Futura", null);
        }
        
        if(nuevoCliente.getFechaRegistro().before(fechaFormateada)){
            throw new NegocioException("La Fecha de Registro no Puede ser Pasada", null);
        }
        
        try{
            // Llamada al DAO para crear el cliente en la base de datos
            Cliente cliente = this.clientesDAO.crearCliente(nuevoCliente);
            return cliente;
        }catch(PersistenciaException ex){
            throw new NegocioException("Error al Crear al Cliente", ex);
        }   
    }

    /**
     * Obtiene la lista de todos los clientes del sistema.
     * 
     * @return Lista de clientes.
     * @throws NegocioException si ocurre un error de persistencia.
     */
    @Override
    public List<Cliente> obtenerClientes() throws NegocioException {
        try {
            return clientesDAO.obtenerClientes();
        }catch (PersistenciaException ex) {
            throw new NegocioException("No se pudieron obtener los clientes", ex);
        }
    }

    /**
     * Inicia sesión de un cliente usando su ID y contraseña.
     * 
     * @param idCliente ID del cliente.
     * @param contrasenia Contraseña del cliente.
     * @return Objeto Cliente si las credenciales son correctas.
     * @throws NegocioException si las credenciales son incorrectas o ocurre un error de persistencia.
     */
    @Override
    public Cliente iniciarSesion(Integer idCliente, String contrasenia) throws NegocioException {
        try {
            // Validaciones de entrada
            if(idCliente == null){
            throw new NegocioException("Ingrese el ID", null);
            }

            if(contrasenia == null || contrasenia.isEmpty()){
                throw new NegocioException("Ingrese la contraseña", null);
            }

            // Consulta al DAO
            Cliente cliente =
                    clientesDAO.iniciarSesion(idCliente, contrasenia);

            if(cliente == null){
                throw new NegocioException("ID o contraseña incorrectos", null);
            }

            return cliente;

        }catch(PersistenciaException ex){
            throw new NegocioException("Error al iniciar sesion", ex);
            }
    }
    
}