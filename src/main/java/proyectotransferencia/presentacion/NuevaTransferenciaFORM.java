/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectotransferencia.presentacion;

import java.awt.event.ActionEvent;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;
import proyectotransferencia.dtos.NuevaOperacionDTO;
import proyectotransferencia.dtos.NuevaTransferenciaDTO;
import proyectotransferencia.entidades.Cliente;
import proyectotransferencia.entidades.Cuenta;
import proyectotransferencia.entidades.Operaciones;
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
public class NuevaTransferenciaFORM extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(NuevaTransferenciaFORM.class.getName());
    private final ITransferenciaBO transferenciaBO;
    private final ICuentaBO cuentaBO;
    private final IOperacionesBO operacionesBO;
    private final IClientesBO clientesBO;

    /**
     * Creates new form NuevaTransferencia
     */
    public NuevaTransferenciaFORM(ITransferenciaBO transferenciaBO, ICuentaBO cuentaBO, IOperacionesBO operacionesBO, IClientesBO clientesBO) {
        this.transferenciaBO = transferenciaBO;
        this.cuentaBO = cuentaBO;
        this.operacionesBO = operacionesBO;
        this.clientesBO = clientesBO;
        initComponents();
        txtSaldo.setEditable(false); 
        cargarCuentasDestino();
        cargarCuentasOrigen();
        actualizarSaldo();
    }
    
    
     private void cargarCuentasOrigen(){
        try{
            cmbCuentaOrigen.removeAllItems();

            Cliente clienteActivo = Sesion.getClienteActivo();

            if(clienteActivo == null){
                JOptionPane.showMessageDialog(this, "No hay sesión activa");
                return;
            }

            Integer idClienteActivo = clienteActivo.getIdCliente();

            List<Cuenta> cuentas = cuentaBO.obtenerCuenta();

            for(Cuenta cuenta : cuentas){

                if(cuenta.getCliente() != null &&
                   cuenta.getCliente().getIdCliente().equals(idClienteActivo)){
                   cmbCuentaOrigen.addItem(cuenta.getNumeroCuenta());
                }
            }

        }catch(NegocioException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    
    private void cargarCuentasDestino() {
        try{
            cmbCuentaDestino.removeAllItems();
            String numeroOrigenSeleccionado = (String) cmbCuentaOrigen.getSelectedItem();

            List<Cuenta> cuentas = cuentaBO.obtenerCuenta();

            for(Cuenta cuenta : cuentas){
                if(cuenta.getNumeroCuenta() == null){
                    continue;
                }
                //si todavia no se selecciona origen no agregues nada
                if(numeroOrigenSeleccionado == null){
                    continue;
                }

                //validacion de que cuentaorigen no sea igual a cuentadestino
                if(!cuenta.getNumeroCuenta().equals(numeroOrigenSeleccionado)){
                    cmbCuentaDestino.addItem(cuenta.getNumeroCuenta());
                }
            }
        }catch(NegocioException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    
    
    private void crearTransferencia() {
        try {
            Cliente clienteActivo = Sesion.getClienteActivo();

            if(clienteActivo == null){
                throw new NegocioException("Debe iniciar sesión", null);
            }
        
            String numeroOrigen = cmbCuentaOrigen.getSelectedItem().toString();

            if(numeroOrigen.isEmpty()){
                throw new NegocioException("Ingrese la cuenta origen", null);
            }

            if(cmbCuentaDestino.getSelectedItem() == null){
                throw new NegocioException("Seleccione la cuenta destino", null);
            }

            String numeroDestino = cmbCuentaDestino.getSelectedItem().toString();
            String montoTexto = txtMonto.getText().trim();

            if(montoTexto.isEmpty()){
                throw new NegocioException("Ingrese el monto", null);
            }

            Float monto = Float.parseFloat(montoTexto);
            String concepto = txtConcepto.getText();
            Cuenta cuentaOrigen = cuentaBO.obtenerCuentaNumero(numeroOrigen);
            Cuenta cuentaDestino = cuentaBO.obtenerCuentaNumero(numeroDestino);

            if(cuentaOrigen == null){
                throw new NegocioException("Cuenta origen no existe", null);
            }

            if(cuentaDestino == null){
                throw new NegocioException("Cuenta destino no existe", null);
            }

            if(cuentaOrigen.getSaldo() < monto){
                throw new NegocioException("Saldo insuficiente", null);
            }

            NuevaOperacionDTO operacionDTO = new NuevaOperacionDTO(new GregorianCalendar(), "TRANSFERENCIA", cuentaOrigen.getIdCuenta());
            Operaciones operacion = operacionesBO.crearOperacion(operacionDTO);

            NuevaTransferenciaDTO transferenciaDTO = new NuevaTransferenciaDTO(monto, concepto, operacion.getIdOperacion());
            transferenciaBO.crearTransferencia(transferenciaDTO);

            //Actualizamos los Salditos
            cuentaBO.retirar(cuentaOrigen.getIdCuenta(), monto);
            cuentaBO.depositar(cuentaDestino.getIdCuenta(), monto);

            JOptionPane.showMessageDialog(this, "Transferencia realizada correctamente");
           
            PantallasOperacionesClienteFORM menu = new PantallasOperacionesClienteFORM(clientesBO, cuentaBO, transferenciaBO, operacionesBO);
            menu.setVisible(true);
            this.dispose();
        }catch(NegocioException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCuentaOrigen = new javax.swing.JLabel();
        lblCuentaDestino = new javax.swing.JLabel();
        lblMonto = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        lblSaldo = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        lblConcepto = new javax.swing.JLabel();
        txtConcepto = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnContinuar = new javax.swing.JButton();
        cmbCuentaDestino = new javax.swing.JComboBox<>();
        cmbCuentaOrigen = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCuentaOrigen.setText("CuentaOrigen");

        lblCuentaDestino.setText("CuentaDestino");

        lblMonto.setText("Monto");

        lblSaldo.setText("Saldo");

        lblConcepto.setText("Concepto");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(this::btnContinuarActionPerformed);

        cmbCuentaDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cuentas" }));

        cmbCuentaOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cuentas" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCuentaOrigen)
                            .addComponent(lblCuentaDestino)
                            .addComponent(lblMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSaldo)
                            .addComponent(lblConcepto))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMonto)
                            .addComponent(txtSaldo)
                            .addComponent(txtConcepto, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                            .addComponent(cmbCuentaDestino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbCuentaOrigen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(btnCancelar)
                        .addGap(85, 85, 85)
                        .addComponent(btnContinuar)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCuentaOrigen)
                    .addComponent(cmbCuentaOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCuentaDestino)
                    .addComponent(cmbCuentaDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSaldo)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMonto))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConcepto)
                    .addComponent(txtConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnContinuar))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
    
    private void btnContinuarActionPerformed(ActionEvent e) {
        this.crearTransferencia();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JComboBox<String> cmbCuentaDestino;
    private javax.swing.JComboBox<String> cmbCuentaOrigen;
    private javax.swing.JLabel lblConcepto;
    private javax.swing.JLabel lblCuentaDestino;
    private javax.swing.JLabel lblCuentaOrigen;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JTextField txtConcepto;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables

    private void actualizarSaldo() {
        try{

            String numeroCuenta = (String) cmbCuentaOrigen.getSelectedItem();

            if(numeroCuenta == null){
                txtSaldo.setText("");
                return;
            }

            Cuenta cuenta = cuentaBO.obtenerCuentaNumero(numeroCuenta);

            if(cuenta != null){
                txtSaldo.setText(String.valueOf(cuenta.getSaldo()));
            }
        }catch(NegocioException ex){
            txtSaldo.setText("");
        }
        
        
    }
  
}
