/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectotransferencia;

import proyectotransferencia.negocio.ClientesBO;
import proyectotransferencia.negocio.CuentaBO;
import proyectotransferencia.negocio.IClientesBO;
import proyectotransferencia.negocio.ICuentaBO;
import proyectotransferencia.negocio.IOperacionesBO;
import proyectotransferencia.negocio.ITransferenciaBO;
import proyectotransferencia.negocio.OperacionesBO;
import proyectotransferencia.negocio.TransferenciaBO;
import proyectotransferencia.persistencia.ClientesDAO;
import proyectotransferencia.persistencia.CuentaDAO;
import proyectotransferencia.persistencia.IClientesDAO;
import proyectotransferencia.persistencia.ICuentaDAO;
import proyectotransferencia.persistencia.IOperacionesDAO;
import proyectotransferencia.persistencia.ITransferenciaDAO;
import proyectotransferencia.persistencia.OperacionesDAO;
import proyectotransferencia.persistencia.TransferenciaDAO;
import proyectotransferencia.presentacion.LoginFORM;


public class ProyectoTransferencia {

    public static void main(String[] args) {
        IClientesDAO clientesDAO = new ClientesDAO();
        ICuentaDAO cuentaDAO = new CuentaDAO();
        IOperacionesDAO operacionesDAO = new OperacionesDAO();
        ITransferenciaDAO transferenciaDAO = new TransferenciaDAO();

        IClientesBO clientesBO = new ClientesBO(clientesDAO);
        ICuentaBO cuentaBO = new CuentaBO(cuentaDAO);
        IOperacionesBO operacionesBO = new OperacionesBO(operacionesDAO);

        ITransferenciaBO transferenciaBO = new TransferenciaBO(transferenciaDAO);
        LoginFORM e = new LoginFORM(clientesBO, cuentaBO, transferenciaBO, operacionesBO);
       e.setVisible(true);
    }
}
