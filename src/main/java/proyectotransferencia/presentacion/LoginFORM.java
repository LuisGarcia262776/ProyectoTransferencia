/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectotransferencia.presentacion;

import proyectotransferencia.negocio.IClientesBO;
import proyectotransferencia.negocio.ICuentaBO;
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

    public LoginFORM(IClientesBO clientesBO, ICuentaBO cuentaBO, ITransferenciaBO transferenciaBO) {
        this.clientesBO = clientesBO;
        this.cuentaBO = cuentaBO;
        this.transferenciaBO = transferenciaBO;

        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblInicioSesion = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnIniciarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblInicioSesion.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblInicioSesion.setText("INICIO DE SESION");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(this::btnSalirActionPerformed);

        btnIniciarSesion.setText("IniciarSesion");
        btnIniciarSesion.addActionListener(this::btnIniciarSesionActionPerformed);

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
                        .addComponent(btnSalir)
                        .addGap(62, 62, 62)
                        .addComponent(btnIniciarSesion)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblInicioSesion)
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciarSesion)
                    .addComponent(btnSalir))
                .addGap(0, 142, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed
        PantallaInicioFORM menu = new PantallaInicioFORM(clientesBO, cuentaBO, transferenciaBO);

        menu.setVisible(true);

        this.dispose(); // cierra Login
    }//GEN-LAST:event_btnIniciarSesionActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel lblInicioSesion;
    // End of variables declaration//GEN-END:variables
}
