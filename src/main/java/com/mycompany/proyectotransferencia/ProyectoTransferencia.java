/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectotransferencia;

import proyectotransferencia.negocio.ClientesBO;
import proyectotransferencia.negocio.CuentaBO;
import proyectotransferencia.negocio.IClientesBO;
import proyectotransferencia.negocio.ICuentaBO;
import proyectotransferencia.persistencia.ClientesDAO;
import proyectotransferencia.persistencia.CuentaDAO;
import proyectotransferencia.persistencia.IClientesDAO;
import proyectotransferencia.persistencia.ICuentaDAO;
import proyectotransferencia.presentacion.NuevaCuentaFORM;
import proyectotransferencia.presentacion.NuevoClienteFORM;

public class ProyectoTransferencia {

    public static void main(String[] args) {
        // DAO
    ICuentaDAO cuentaDAO = new CuentaDAO();
    IClientesDAO clientesDAO = new ClientesDAO();

    // BO
    ICuentaBO cuentaBO = new CuentaBO(cuentaDAO);
    IClientesBO clientesBO = new ClientesBO(clientesDAO);

    // FORM
    NuevaCuentaFORM nuevaCuentaForm = new NuevaCuentaFORM(cuentaBO, clientesBO);
    nuevaCuentaForm.setVisible(true);
    }
}
