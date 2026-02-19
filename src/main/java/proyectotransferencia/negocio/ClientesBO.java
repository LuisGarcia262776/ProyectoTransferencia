/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotransferencia.negocio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import proyectotransferencia.dtos.NuevoClienteDTO;
import proyectotransferencia.entidades.Cliente;
import proyectotransferencia.persistencia.IClientesDAO;
import proyectotransferencia.persistencia.PersistenciaException;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class ClientesBO implements IClientesBO {
    private final IClientesDAO clientesDAO;

    public ClientesBO(IClientesDAO clientesDAO) {
        this.clientesDAO = clientesDAO;
    }
    
    

    @Override
    public Cliente crearCliente(NuevoClienteDTO nuevoCliente) throws NegocioException {
        if (nuevoCliente == null) {
        throw new NegocioException("El Cliente No Puede Ser Nulo", null);
        }

        if (nuevoCliente.getNombre() == null) {
            throw new NegocioException("El Nombre es Obligatorio", null);
        }
        
        if(nuevoCliente.getNombre().isEmpty()){
            throw new NegocioException("El Nombre del Cliente no Puede Estar Vacio", null);
        }
        if (nuevoCliente.getNombre().length() > 15) {
            throw new NegocioException("El Nombre es muy Largo Excede los 15 Caracteres", null);
        }


        if (nuevoCliente.getApellidoPaterno() == null) {
            throw new NegocioException("El Apellido Paterno es Obligatorio", null);
        }
        
        if(nuevoCliente.getApellidoPaterno().isEmpty()){
            throw new NegocioException("El Apellido Paterno no Puede Estar Vacio", null);
        }
                
        if (nuevoCliente.getApellidoPaterno().length() > 30) {
            throw new NegocioException("El Apellido Paterno es Muy Largo Excede los 30 Caracteres", null);
        }

        
        if (nuevoCliente.getApellidoMaterno() == null) {
            throw new NegocioException("El Apellido Materno es Obligatorio", null);
        }
        
        if(nuevoCliente.getApellidoMaterno().isEmpty()){
            throw new NegocioException("El Apellido Maternos es Obligatorio No Puede Estar Vacio", null);
        }
        if (nuevoCliente.getApellidoMaterno().length() > 30) {
            throw new NegocioException("El Apellido Materno es Muy Largo Excede los 30 Caracteres", null);
        }

        
        if (nuevoCliente.getDomicilio() == null) {
            throw new NegocioException("El Domicilio es Obligatorio", null);
        }
        if (nuevoCliente.getDomicilio().length() > 80) {
            throw new NegocioException("El Domicilio es muy Largo Excede los 80 Caracteres", null);
        }
        
        if(nuevoCliente.getDomicilio().isEmpty()){
            throw new NegocioException("El Domicilio no Puede Estar Vacio", null);
        }

        
        if (nuevoCliente.getFechaNacimiento() == null) {
            throw new NegocioException("La Fecha de Nacimiento es Obligatoria", null);
        }
        
        GregorianCalendar calendario = new GregorianCalendar();
        Date fechaHoy = calendario.getTime();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = formato.format(fechaHoy);
        if (nuevoCliente.getFechaNacimiento().after(fechaFormateada)) {
            throw new NegocioException("La Fecha De Naciemiento No Puede Ser Futura", null);
        }

        if (nuevoCliente.getContrasenia() == null) {
            throw new NegocioException("La Contraseña es Obligatoria", null);
        }
        
        if(nuevoCliente.getContrasenia().isEmpty()){
            throw new NegocioException("La Contraseña no Puede Estar Vacia", null);
        }
        if (nuevoCliente.getContrasenia().length() > 12) {
            throw new NegocioException("La Contraseña no Puede Exceder 12 Caracteres", null);
        }
        
        if(nuevoCliente.getFechaRegistro().after(fechaFormateada)){
            throw new NegocioException("La Fecha de Registro no Puede ser Futura", null);
        }
        
        if(nuevoCliente.getFechaRegistro().before(fechaFormateada)){
            throw new NegocioException("La Fecha de Registro no Puede ser Pasada", null);
        }
        
        try{
            Cliente cliente = this.clientesDAO.crearCleinte(nuevoCliente);
            return cliente;
        }catch(PersistenciaException ex){
            throw new NegocioException("Error al Crear al Cliente", ex);
        }
    }
    
}
