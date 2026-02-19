/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectotransferencia;

import proyectotransferencia.negocio.ClientesBO;
import proyectotransferencia.negocio.IClientesBO;
import proyectotransferencia.persistencia.ClientesDAO;
import proyectotransferencia.persistencia.IClientesDAO;
import proyectotransferencia.presentacion.NuevoClienteFORM;

public class ProyectoTransferencia {

    public static void main(String[] args) {
        IClientesDAO nuevoClienteDAO = new ClientesDAO();  
        IClientesBO clienteBO = new ClientesBO(nuevoClienteDAO);
        NuevoClienteFORM nuevoautomovilForm = new  NuevoClienteFORM(clienteBO);
          nuevoautomovilForm.setVisible(true);
    }
}
