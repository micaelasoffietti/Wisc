/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import Negocio.Detalle;
import Negocio.Maestro;
import Negocio.Pacientes;
import Presentacion.MaestroDetalle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Agregar extends javax.swing.JFrame{

    ArrayList<Pacientes> listaPacientes;
    int idPaciente;
    int idfactura;
    float totalfactura;
    
    DefaultTableModel modelo; 
    public Agregar() {
        initComponents();
        listaPacientes = new ArrayList();
        modelo = (DefaultTableModel) jTableDetalle.getModel();
        
    }

    public void guardarMaestro() throws SQLException{
        Maestro btnMaestro= new Maestro();
        String fecha;
        //int total;
        btnMaestro.setFechaFac(textFecha.getText());
        btnMaestro.setIdPaciente(cbPacientes.getItemAt(cbPacientes.getSelectedIndex()).getId());
        btnMaestro.agregarDato();
        idfactura = btnMaestro.obtenerIDMaestro();
        
        //JOptionPane.showMessageDialog(null,Integer.toString(maestro.getIdFactura()));
        //new MaestroDetalle().setVisible(true); 
        
               // fecha= textFecha.getText();//textTotal.getText(); 
        //dat.InsertarFactura(fecha);
    }
    public void guardarDetalle() throws SQLException{
        totalfactura=0;
        for(int i=0;i<jTableDetalle.getRowCount();i++)
        {
            Detalle detalle=new Detalle();
            detalle.setIdFactura(idfactura);
            detalle.setServicio(jTableDetalle.getValueAt(i,0).toString());
            int cantidad = Integer.parseInt(jTableDetalle.getValueAt(i,1).toString());
            detalle.setCantidad(cantidad);
            float preciounitario=Float.parseFloat(jTableDetalle.getValueAt(i,2).toString());
            detalle.setPrecioUnitario(preciounitario);
            float precioservicio = cantidad * preciounitario;
            detalle.setPrecioServicio(precioservicio);
            detalle.agregarDetalle();
            totalfactura += precioservicio;
            //this.dispose();     
        }    
        Maestro btnMaestro = new Maestro();
        btnMaestro.setIdFactura(idfactura);
        btnMaestro.setTotalFactura(totalfactura);
        btnMaestro.modificarTotal();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textFecha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        cbPacientes = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDetalle = new javax.swing.JTable();
        btnConfirmar = new javax.swing.JButton();
        btnAgregarRenglon = new javax.swing.JButton();
        btnEliminarRenglon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("FACTURA");

        jLabel2.setText("DETALLE");

        jLabel3.setText("Fecha");

        btnGuardar.setText("Guardar");
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
        });

        jLabel5.setText("Paciente");

        jTableDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Servicio", "Cantidad", "PrecioUnitario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableDetalle.setEnabled(false);
        jScrollPane1.setViewportView(jTableDetalle);

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmarMouseClicked(evt);
            }
        });

        btnAgregarRenglon.setText("Agregar Renglon");
        btnAgregarRenglon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarRenglonActionPerformed(evt);
            }
        });

        btnEliminarRenglon.setText("Eliminar Renglon");
        btnEliminarRenglon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarRenglonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addContainerGap(675, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(btnAgregarRenglon)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarRenglon, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(btnConfirmar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGuardar)
                            .addComponent(cbPacientes, 0, 228, Short.MAX_VALUE)
                            .addComponent(textFecha))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardar)
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConfirmar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEliminarRenglon)
                        .addComponent(btnAgregarRenglon)))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        // TODO add your handling code here:
         try {
        
            guardarMaestro();
            jTableDetalle.setEnabled(true);
 
        } catch (SQLException ex) {
            Logger.getLogger(Agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        Pacientes btnPaciente = new Pacientes();
        cbPacientes.removeAllItems();
        try {
            listaPacientes = btnPaciente.mostrarLista();
           for (int i = 0; i < listaPacientes.size(); i++)
           {
               cbPacientes.addItem(new Pacientes(listaPacientes.get(i).getId(),listaPacientes.get(i).getNombreApellido()));
           }
        } catch (SQLException ex) {
            Logger.getLogger(Agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened
    
    
 
    private void btnConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarMouseClicked
        // TODO add your handling code here:
          try {
            // TODO add your handling code here:
            guardarDetalle();
        } catch (SQLException ex) {
            Logger.getLogger(Agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConfirmarMouseClicked

    private void btnAgregarRenglonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarRenglonActionPerformed
        // TODO add your handling code here:
        modelo.addRow(new Object[]{"",0,0});
    }//GEN-LAST:event_btnAgregarRenglonActionPerformed

    private void btnEliminarRenglonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarRenglonActionPerformed
        // TODO add your handling code here:
        modelo.removeRow(modelo.getRowCount()-1);
    }//GEN-LAST:event_btnEliminarRenglonActionPerformed
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agregar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarRenglon;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnEliminarRenglon;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Pacientes> cbPacientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDetalle;
    private javax.swing.JTextField textFecha;
    // End of variables declaration//GEN-END:variables
}
