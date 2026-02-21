/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotransferencia.negocio;

import java.util.GregorianCalendar;
import java.util.logging.Logger;
import proyectotransferencia.dtos.NuevoRetiroSinCuentaDTO;
import proyectotransferencia.entidades.RetiroSinCuenta;
import proyectotransferencia.persistencia.IRetiroSinCuentaDAO;
import proyectotransferencia.persistencia.PersistenciaException;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class RetiroSinCuentaBO implements IRetiroSinCuentaBO {
    private final IRetiroSinCuentaDAO reitroSinCuentaDAO;

    public RetiroSinCuentaBO(IRetiroSinCuentaDAO reitroSinCuentaDAO) {
        this.reitroSinCuentaDAO = reitroSinCuentaDAO;
    }
    
    @Override
    public RetiroSinCuenta crearRetiroSinCuenta(NuevoRetiroSinCuentaDTO nuevoRetiroSinCuenta) throws NegocioException {
        if(nuevoRetiroSinCuenta == null){
            throw new NegocioException("Datos Invalidos", null);
        }

        if(nuevoRetiroSinCuenta.getMonto() == null){ 
            throw new NegocioException("El Monto no Puede ser Nulo", null);
        }

        if(nuevoRetiroSinCuenta.getMonto() <= 0){
            throw new NegocioException("El Monto Debe ser Mayor a 0", null);
        }

        if(nuevoRetiroSinCuenta.getMonto() > 31000){
            throw new NegocioException("El Monto Excede el Limite Permitido", null);
        }

        if(nuevoRetiroSinCuenta.getContraseñaRetiro() == null){
            throw new NegocioException("Contraseña Requerida", null);
        }

        if(nuevoRetiroSinCuenta.getContraseñaRetiro().isEmpty()){
            throw new NegocioException("Contraseña Requerida", null);
        }

        
        if(nuevoRetiroSinCuenta.getContraseñaRetiro().length() != 8){
            throw new NegocioException("La Contraseña debe Tener 8 Digitos", null);
        }

        if(nuevoRetiroSinCuenta.getIdOperacion()== null){
            throw new NegocioException("Debe Existir un IdOperacion",null);
        }

        // 5. Fecha solicitud obligatoria
        if(nuevoRetiroSinCuenta.getFechaHoraSolicitud() == null){
            throw new NegocioException("Fecha de Solicitud Requerida", null);
        }
        try{
            RetiroSinCuenta retiroSinCuenta = this.reitroSinCuentaDAO.crearRetiroSinCuenta(nuevoRetiroSinCuenta);
            return retiroSinCuenta;
        }catch(PersistenciaException ex){
            throw new NegocioException("Error al crear retiro", ex);
        }
    }

    @Override
    public RetiroSinCuenta obtenerReitroPorFolioYContraseña(Integer folio, String Contrasenia) throws NegocioException {
        try{
            RetiroSinCuenta retiroSinCuenta = reitroSinCuentaDAO.obtenerReitroPorFolioYContraseña(folio, Contrasenia);
            return retiroSinCuenta;
        }catch(PersistenciaException ex){
            throw new NegocioException("Error al buscar retiro", ex);
        }
    }

    @Override
    public RetiroSinCuenta actualizarFechaCobro(Integer folio, GregorianCalendar fechaCobro) throws NegocioException {
        try{
           RetiroSinCuenta retiroSinCuenta =  reitroSinCuentaDAO.actualizarFechaCobro(folio, fechaCobro);
           return retiroSinCuenta;
        }catch(PersistenciaException ex){
            throw new NegocioException("Error al actualizar fecha cobro", ex);
        }
    }

    
    
}
