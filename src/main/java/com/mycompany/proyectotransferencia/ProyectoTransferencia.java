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
import proyectotransferencia.presentacion.CrearOperacionFORM;
import proyectotransferencia.presentacion.NuevaCuentaFORM;
import proyectotransferencia.presentacion.NuevoClienteFORM;
import proyectotransferencia.presentacion.PantallaInicioFORM;

public class ProyectoTransferencia {

    public static void main(String[] args) {
        // DAO
//    ICuentaDAO cuentaDAO = new CuentaDAO();
//    IClientesDAO clientesDAO = new ClientesDAO();
//
//    // BO
//    ICuentaBO cuentaBO = new CuentaBO(cuentaDAO);
//    IClientesBO clientesBO = new ClientesBO(clientesDAO);
//
//    // FORM
//    NuevaCuentaFORM nuevaCuentaForm = new NuevaCuentaFORM(cuentaBO, clientesBO);
//    nuevaCuentaForm.setVisible(true);

        ClientesDAO clientesDAO = new ClientesDAO();
        ICuentaDAO cuentaDAO = new CuentaDAO();
        ITransferenciaDAO transferenciaDAO = new TransferenciaDAO();

        IClientesBO clientesBO = new ClientesBO(clientesDAO);
        ICuentaBO cuentaBO = new CuentaBO(cuentaDAO);
        ITransferenciaBO transferenciaBO =
                new TransferenciaBO(transferenciaDAO);

        PantallaInicioFORM pantalla =
                new PantallaInicioFORM(
                        clientesBO,
                        cuentaBO,
                        transferenciaBO);

        pantalla.setVisible(true);
    }
}
