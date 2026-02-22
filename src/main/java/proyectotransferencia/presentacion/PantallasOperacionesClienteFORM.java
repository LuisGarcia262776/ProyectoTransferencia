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
public class PantallasOperacionesClienteFORM extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PantallasOperacionesClienteFORM.class.getName());
    private final IClientesBO clientesBO;
    private final ICuentaBO cuentaBO;
    private final ITransferenciaBO transferenciaBO;
    private final IOperacionesBO operacionesBO;
    private final IRetiroSinCuentaBO retiroBO;

    public PantallasOperacionesClienteFORM(IClientesBO clientesBO, ICuentaBO cuentaBO, ITransferenciaBO transferenciaBO, IOperacionesBO operacionesBO, IRetiroSinCuentaBO retiroBO, proyectotransferencia.negocio.IRetiroSinCuentaBO retiroBO1) {
        this.clientesBO = clientesBO;
        this.cuentaBO = cuentaBO;
        this.transferenciaBO = transferenciaBO;
        this.operacionesBO = operacionesBO;
        initComponents();
        this.retiroBO = retiroBO;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnTransferencia = new javax.swing.JButton();
        btnMisCuentas = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnRetiroSinCuenta1 = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Courier New", 0, 48)); // NOI18N
        jLabel1.setText("MenuPrincipal");

        btnTransferencia.setText("Transferencia");
        btnTransferencia.addActionListener(this::btnTransferenciaActionPerformed);

        btnMisCuentas.setText("Mis Cuentas");
        btnMisCuentas.setActionCommand("btnManejarCuentas");
        btnMisCuentas.addActionListener(this::btnMisCuentasActionPerformed);

        btnSalir.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(this::btnSalirActionPerformed);

        btnRetiroSinCuenta1.setText("Retiro Sin Cuenta");
        btnRetiroSinCuenta1.addActionListener(this::btnRetiroSinCuenta1ActionPerformed);

        btnHistorial.setText("Historial");
        btnHistorial.addActionListener(this::btnHistorialActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnRetiroSinCuenta1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTransferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnMisCuentas, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                    .addComponent(btnHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))))))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTransferencia, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(btnHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMisCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRetiroSinCuenta1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferenciaActionPerformed
        CrearOperacionFORM form = new CrearOperacionFORM(operacionesBO, cuentaBO, transferenciaBO, clientesBO, retiroBO);

        form.setVisible(true);

        this.setVisible(false);
    }//GEN-LAST:event_btnTransferenciaActionPerformed

    private void btnMisCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMisCuentasActionPerformed
        GestionDeCuentasFORM form = new GestionDeCuentasFORM(cuentaBO);

        form.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_btnMisCuentasActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRetiroSinCuenta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetiroSinCuenta1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRetiroSinCuenta1ActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        HistorialOperacionesFORM form = new HistorialOperacionesFORM(operacionesBO, this);
        form.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnHistorialActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnMisCuentas;
    private javax.swing.JButton btnRetiroSinCuenta1;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTransferencia;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
