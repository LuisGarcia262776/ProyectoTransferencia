/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotransferencia.sesion;

import proyectotransferencia.entidades.Cliente;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class Sesion {
    private static Cliente clienteActivo;

    public static void iniciarSesion(Cliente cliente){
        clienteActivo = cliente;
    }

    public static Cliente getClienteActivo(){
        return clienteActivo;
    }

    public static Integer getIdCliente(){
        if(clienteActivo == null){
            return null;
        }
        return clienteActivo.getIdCliente();
    }

    public static void cerrarSesion(){
        clienteActivo = null;
    }

   
    
    
}
