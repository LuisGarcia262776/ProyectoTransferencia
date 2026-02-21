/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectotransferencia.presentacion;

import javax.swing.JOptionPane;
import proyectotransferencia.entidades.Cliente;
import proyectotransferencia.negocio.IClientesBO;
import proyectotransferencia.negocio.ICuentaBO;
import proyectotransferencia.negocio.IOperacionesBO;
import proyectotransferencia.negocio.ITransferenciaBO;
import proyectotransferencia.negocio.NegocioException;
import proyectotransferencia.sesion.Sesion;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class InicioDeSesionDatosFORM extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(InicioDeSesionDatosFORM.class.getName());
    private final IClientesBO clientesBO;
    private final ICuentaBO cuentaBO;
    private final ITransferenciaBO transferenciaBO;
    private final IOperacionesBO operacionesBO;
    
    public InicioDeSesionDatosFORM(IClientesBO clientesBO, ICuentaBO cuentaBO, ITransferenciaBO transferenciaBO, IOperacionesBO operacionesBO) {
        this.clientesBO = clientesBO;
        this.cuentaBO = cuentaBO;
        this.transferenciaBO = transferenciaBO;
        this.operacionesBO = operacionesBO;
        initComponents();
    }
    
    
    @SuppressWarnings("unchecked")
    
    private void iniciarSesion(){
        try{
            if(txtId.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(this,"Ingrese el ID");
                return;
            }

            if(txtContrasenia.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(this,"Ingrese la contraseña");
                return;
        }

            Integer id = Integer.parseInt(txtId.getText().trim());
            String contrasenia = txtContrasenia.getText().trim();

            Cliente cliente = clientesBO.iniciarSesion(id, contrasenia);
            
             Sesion.iniciarSesion(cliente);

            JOptionPane.showMessageDialog(this, "Bienvenido " + cliente.getNombre());

            PantallasOperacionesClienteFORM menu = new PantallasOperacionesClienteFORM(clientesBO, cuentaBO, transferenciaBO, operacionesBO);

            menu.setVisible(true);

            this.dispose();
        }catch(NegocioException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIngresaId = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtContrasenia = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnContinuar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblIngresaId.setText("Ingresa Tu ID:");

        lblContraseña.setText("Contraseña");

        txtId.addActionListener(this::txtIdActionPerformed);

        txtContrasenia.addActionListener(this::txtContraseniaActionPerformed);

        jLabel3.setFont(new java.awt.Font("MS UI Gothic", 0, 48)); // NOI18N
        jLabel3.setText("INICIO DE SESION");

        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(this::btnContinuarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 71, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIngresaId)
                            .addComponent(lblContraseña))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId)
                            .addComponent(txtContrasenia))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(btnContinuar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIngresaId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContraseña)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(btnContinuar)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseniaActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        this.iniciarSesion();
    }//GEN-LAST:event_btnContinuarActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContinuar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblIngresaId;
    private javax.swing.JTextField txtContrasenia;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
