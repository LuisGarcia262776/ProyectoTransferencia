/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectotransferencia.presentacion;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import proyectotransferencia.dtos.NuevaOperacionDTO;
import proyectotransferencia.dtos.NuevoRetiroSinCuentaDTO;
import proyectotransferencia.entidades.Cliente;
import proyectotransferencia.entidades.Cuenta;
import proyectotransferencia.entidades.Operaciones;
import proyectotransferencia.negocio.IClientesBO;
import proyectotransferencia.negocio.ICuentaBO;
import proyectotransferencia.negocio.IOperacionesBO;
import proyectotransferencia.negocio.IRetiroSinCuentaBO;
import proyectotransferencia.negocio.ITransferenciaBO;
import proyectotransferencia.negocio.NegocioException;
import proyectotransferencia.sesion.Sesion;

/**
 *
 * @author PC GAMER MASTER RACE
 */
public class RetiroSinCuentaFORM extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(RetiroSinCuentaFORM.class.getName());
    private final IRetiroSinCuentaBO retiroBO;
    private final ICuentaBO cuentaBO;
    private final IOperacionesBO operacionesBO;
    private final ITransferenciaBO transferenciaBO;
    private final IClientesBO clientesBO;

    public RetiroSinCuentaFORM(IRetiroSinCuentaBO retiroBO, ICuentaBO cuentaBO, IOperacionesBO operacionesBO, ITransferenciaBO transferenciaBO, IClientesBO clientesBO) {
        this.retiroBO = retiroBO;
        this.cuentaBO = cuentaBO;
        this.operacionesBO = operacionesBO;
        this.transferenciaBO = transferenciaBO;
        this.clientesBO = clientesBO;
        initComponents();
        Integer folioGenerado = generarFolio();
        String contraseñaGenerada = generarContraseña();
        GregorianCalendar fechaGenerada = generarFecha();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        txtFolio.setText(String.valueOf(folioGenerado));
        txtContraseñaGenerada.setText(contraseñaGenerada);
        txtFechaYHoraSolicitud.setText(formato.format(fechaGenerada.getTime()));
        txtFolio.setEditable(false);
        txtContraseñaGenerada.setEditable(false);
        txtFechaYHoraSolicitud.setEditable(false);
        
    }
    
    private String generarContraseña(){
        int numero = (int)(Math.random() * 90000000) + 10000000;
        return String.valueOf(numero);
    }
    
    private Integer generarFolio(){
        return (int)(System.currentTimeMillis() % 1000000000);
    }
    
    private GregorianCalendar generarFecha(){
        return new GregorianCalendar();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFolio = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        lblFolio = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        txtContraseñaGenerada = new javax.swing.JTextField();
        lbMonto = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        lblFechaHoraDeSolicitud = new javax.swing.JLabel();
        txtFechaYHoraSolicitud = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAceptar.setText("ACEPTAR");
        btnAceptar.addActionListener(this::btnAceptarActionPerformed);

        lblFolio.setText("FOLIO:");

        lblContraseña.setText("CONTRASEÑA:");

        txtContraseñaGenerada.addActionListener(this::txtContraseñaGeneradaActionPerformed);

        lbMonto.setText("MONTO:");

        lblFechaHoraDeSolicitud.setText("FECHA Y HORA SOLICITUD");

        txtFechaYHoraSolicitud.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFolio)
                            .addComponent(lblContraseña)
                            .addComponent(lbMonto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFolio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContraseñaGenerada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMonto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblFechaHoraDeSolicitud)
                        .addGap(18, 18, 18)
                        .addComponent(txtFechaYHoraSolicitud)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(btnAceptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaHoraDeSolicitud)
                    .addComponent(txtFechaYHoraSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFolio))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContraseña)
                    .addComponent(txtContraseñaGenerada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMonto)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btnAceptar)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtContraseñaGeneradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaGeneradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaGeneradaActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try {

            Cliente clienteActivo = Sesion.getClienteActivo();

            if(clienteActivo == null)
                throw new NegocioException("No hay sesión activa", null);

            if(txtMonto.getText().isEmpty())
                throw new NegocioException("Ingrese el monto", null);

            Float monto = Float.parseFloat(txtMonto.getText());


            Integer folio = generarFolio();
            String contraseña = generarContraseña();
            GregorianCalendar fechaSolicitud = generarFecha();

            List<Cuenta> cuentas = cuentaBO.obtenerCuenta();

            Cuenta cuentaOrigen = null;

            for(Cuenta cuenta : cuentas){
                if(cuenta.getCliente().getIdCliente().equals(clienteActivo.getIdCliente())){
                    cuentaOrigen = cuenta;
                    break;
                }
            }

            if(cuentaOrigen == null){
                throw new NegocioException("No tiene cuenta", null);
            }

            if(cuentaOrigen.getSaldo() < monto){
                throw new NegocioException("Saldo insuficiente", null);
            }

            NuevaOperacionDTO operacionDTO = new NuevaOperacionDTO(fechaSolicitud, "RETIROSINTARJETA", cuentaOrigen.getIdCuenta());
            Operaciones operacion = operacionesBO.crearOperacion(operacionDTO);
            NuevoRetiroSinCuentaDTO dto = new NuevoRetiroSinCuentaDTO(folio, contraseña, monto, fechaSolicitud, null, operacion);
            retiroBO.crearRetiroSinCuenta(dto);
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            JOptionPane.showMessageDialog(
                    this,
                    "RETIRO GENERADO\n\n"+
                    "Folio: " + folio + "\n"+
                    "Contraseña: " + contraseña + "\n"+
                    "Monto: $" + monto + "\n"+
                    "Fecha: " +
                    formato.format(fechaSolicitud.getTime()));
            
            LoginFORM form = new LoginFORM(clientesBO, cuentaBO, transferenciaBO, operacionesBO, retiroBO);
            form.setVisible(true);
            this.dispose();
        }catch(NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel lbMonto;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblFechaHoraDeSolicitud;
    private javax.swing.JLabel lblFolio;
    private javax.swing.JTextField txtContraseñaGenerada;
    private javax.swing.JTextField txtFechaYHoraSolicitud;
    private javax.swing.JTextField txtFolio;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
  
}
