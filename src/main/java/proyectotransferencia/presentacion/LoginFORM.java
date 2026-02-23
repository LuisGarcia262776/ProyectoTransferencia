/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectotransferencia.presentacion;

import proyectotransferencia.negocio.IClientesBO;
import proyectotransferencia.negocio.ICuentaBO;
import proyectotransferencia.negocio.IOperacionesBO;
import proyectotransferencia.negocio.IRetiroSinCuentaBO;
import proyectotransferencia.negocio.ITransferenciaBO;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class LoginFORM extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(LoginFORM.class.getName());
    private final IClientesBO clientesBO;
    private final ICuentaBO cuentaBO;
    private final ITransferenciaBO transferenciaBO;
    private final IOperacionesBO operacionesBO;
    private final IRetiroSinCuentaBO retiroBO;

    public LoginFORM(IClientesBO clientesBO, ICuentaBO cuentaBO, ITransferenciaBO transferenciaBO, IOperacionesBO operacionesBO, IRetiroSinCuentaBO retiroBO) {
        this.clientesBO = clientesBO;
        this.cuentaBO = cuentaBO;
        this.transferenciaBO = transferenciaBO;
        this.operacionesBO = operacionesBO;
        this.retiroBO = retiroBO;
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblInicioSesion = new javax.swing.JLabel();
        btnCrearCuenta = new javax.swing.JButton();
        btnIniciarSesion = new javax.swing.JButton();
        btnRetiroSinCuenta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblInicioSesion.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblInicioSesion.setText("INICIO DE SESION");

        btnCrearCuenta.setText("Crear Cuenta");
        btnCrearCuenta.addActionListener(this::btnCrearCuentaActionPerformed);

        btnIniciarSesion.setText("Iniciar Sesion");
        btnIniciarSesion.addActionListener(this::btnIniciarSesionActionPerformed);

        btnRetiroSinCuenta.setText("Retiro Sin Cuenta");
        btnRetiroSinCuenta.addActionListener(this::btnRetiroSinCuentaActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lblInicioSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(btnCrearCuenta)
                        .addGap(62, 62, 62)
                        .addComponent(btnIniciarSesion))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(btnRetiroSinCuenta)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblInicioSesion)
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciarSesion)
                    .addComponent(btnCrearCuenta))
                .addGap(47, 47, 47)
                .addComponent(btnRetiroSinCuenta)
                .addGap(0, 72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearCuentaActionPerformed
        NuevoClienteFORM nue = new NuevoClienteFORM(clientesBO, cuentaBO, transferenciaBO, operacionesBO, retiroBO);
        nue.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCrearCuentaActionPerformed

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        InicioDeSesionDatosFORM nue = new InicioDeSesionDatosFORM(clientesBO, cuentaBO, transferenciaBO, operacionesBO, retiroBO);
        nue.setVisible(true);
        this.dispose(); // cierra Login
    }//GEN-LAST:event_btnIniciarSesionActionPerformed

    private void btnRetiroSinCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetiroSinCuentaActionPerformed
        ConfirmacionRetiroSinCuentaFORM form = new ConfirmacionRetiroSinCuentaFORM(retiroBO, cuentaBO, operacionesBO, transferenciaBO, clientesBO);
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRetiroSinCuentaActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearCuenta;
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnRetiroSinCuenta;
    private javax.swing.JLabel lblInicioSesion;
    // End of variables declaration//GEN-END:variables
}
