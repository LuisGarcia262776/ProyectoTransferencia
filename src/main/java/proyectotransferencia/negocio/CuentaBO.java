/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotransferencia.negocio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import proyectotransferencia.dtos.NuevaCuentaDTO;
import proyectotransferencia.entidades.Cuenta;
import proyectotransferencia.persistencia.ICuentaDAO;
import proyectotransferencia.persistencia.PersistenciaException;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class CuentaBO implements ICuentaBO {
    private final ICuentaDAO cuentaDAO;

    public CuentaBO(ICuentaDAO cuentaDAO) {
        this.cuentaDAO = cuentaDAO;
    }
    
    @Override
    public Cuenta crearCuenta(NuevaCuentaDTO nuevaCuenta) throws NegocioException {
        if(nuevaCuenta == null){
            throw new NegocioException("Los Datos de la Cuenta no Pueden ser Nulos",null);
        }
        
        if(nuevaCuenta.getNumeroCuenta() == null){
            throw new NegocioException("El Numero de Cuenta No Puede ser Nulo", null);
        }
        
        if(nuevaCuenta.getNumeroCuenta().isEmpty()){
            throw new NegocioException("El Numero de Cuenta No Puede Estar Vacio", null);
        }
        
        if(nuevaCuenta.getFechaApertura() == null){
            throw new NegocioException("La Fecha de Registro No Puede ser Nula", null);
        }
        
        GregorianCalendar hoy = new GregorianCalendar();

        if(nuevaCuenta.getFechaApertura().after(hoy)){
            throw new NegocioException("La Fecha No Puede Ser Futura", null);
        }
       
        
        if(nuevaCuenta.getSaldo() == null){
            throw new NegocioException("El Saldo No Puede Ser Nulo", null);
        }
        
        if(nuevaCuenta.getSaldo() < 0){
            throw new NegocioException("El Saldo No Puede Ser Negativo", null);
        }
        
        if(nuevaCuenta.getEstado() == null){
            throw new NegocioException("El Estado no Puede Ser Nulo", null);
        }
        
        if(!nuevaCuenta.getEstado().equalsIgnoreCase("ACTIVA") && !nuevaCuenta.getEstado().equalsIgnoreCase("INACTIVA")){
            throw new NegocioException("El Estado debe ser ACTIVA o INACTIVA", null);
        }
        
        if(nuevaCuenta.getIdCliente() == null){
            throw new NegocioException("Debe Proporcionar Un Cliente Valido", null);
        }
        
        try{
           Cuenta cuenta = this.cuentaDAO.crearCuenta(nuevaCuenta);
            return cuenta;
        }catch(PersistenciaException ex){
            throw new NegocioException("Error al Crear La Cuenta", ex);
        }

    }

    @Override
    public List<Cuenta> obtenerCuenta() throws NegocioException {
        try {
            return cuentaDAO.obtenerCuenta();
        }catch (PersistenciaException ex) {
            throw new NegocioException("No se Pudieron Obtener Las Cuentas", ex);
        }
    }

    @Override
    public Cuenta obtenerCuentaNumero(String numeroCuenta) throws NegocioException {
        try {
            return cuentaDAO.obtenerCuentaNumero(numeroCuenta);
        }catch (PersistenciaException ex) {
            throw new NegocioException("No se Pudieron Obtener El Numero de Cuenta", ex);
        }
        
    }

    @Override
    public void retirar(Integer idCuenta, Float monto) throws NegocioException {
        try {
            cuentaDAO.retirar(idCuenta, monto);
        }catch(PersistenciaException ex){
            throw new NegocioException("Error al retirar dinero", ex);
        }
    }

    @Override
    public void depositar(Integer idCuenta, Float monto) throws NegocioException {
        try {
            cuentaDAO.depositar(idCuenta, monto);
        }catch(PersistenciaException ex){
            throw new NegocioException("Error al depositar dinero", ex);
        }
    }
    
}
