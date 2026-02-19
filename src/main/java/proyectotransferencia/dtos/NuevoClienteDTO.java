/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotransferencia.dtos;

import java.util.GregorianCalendar;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class NuevoClienteDTO {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String domicilio;
    private GregorianCalendar fechaNacimiento;      
    private String contrasenia;
    private GregorianCalendar fechaRegistro;        

    public NuevoClienteDTO() {
    }

    public NuevoClienteDTO(String nombre, String apellidoPaterno, String apellidoMaterno, String domicilio, GregorianCalendar fechaNacimiento, String contrasenia, GregorianCalendar fechaRegistro) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasenia = contrasenia;
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public GregorianCalendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public GregorianCalendar getFechaRegistro() {
        return fechaRegistro;
    }
    
    
    
}
