
package Presentacion;


import Negocio.Detalle;
import Negocio.Maestro;
import Negocio.Pacientes;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.lang.ExceptionInInitializerError;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MaestroDetalle extends javax.swing.JFrame {

    String url="jdbc:sqlite:C:/Users/Micaela/Desktop/BaseDatos/Pacientes.s3db";
    
    public MaestroDetalle() throws SQLException {
        initComponents();
        jTable1.setModel(new Maestro().getFactura(url));
        jTable2.setModel(new Detalle().getFacturaDetalle(url, ""));
        
    }
 
    @SuppressWarnings("unchecked")
    public void InsertarFactura() throws SQLException{
        Maestro objAgregar= new Maestro();
        objAgregar.agregarDato();
        
        jTable1.setModel(new Maestro().getFactura(url));
        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnAgregarFactura = new javax.swing.JButton();
        btnBorrarFactura = new javax.swing.JButton();
        btnModificarFactura = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnBorrarDetalle = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTable1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 51));
        jLabel1.setText("Factura");

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 102));
        jLabel2.setText("Detalle Factura");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 51)));

        btnAgregarFactura.setText("Agregar");
        btnAgregarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFacturaActionPerformed(evt);
            }
        });

        btnBorrarFactura.setText("Borrar");
        btnBorrarFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBorrarFacturaMouseClicked(evt);
            }
        });

        btnModificarFactura.setText("Modificar");
        btnModificarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarFacturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarFactura)
                    .addComponent(btnBorrarFactura)
                    .addComponent(btnModificarFactura))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregarFactura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBorrarFactura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(btnModificarFactura)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 51)));

        btnBorrarDetalle.setText("Borrar Detalle");
        btnBorrarDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBorrarDetalleMouseClicked(evt);
            }
        });

        btnModificar.setText("Modificar Detalle");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBorrarDetalle)
                    .addComponent(btnModificar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBorrarDetalle)
                .addGap(18, 18, 18)
                .addComponent(btnModificar)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(143, 143, 143)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFacturaActionPerformed
        // TODO add your handling code here:
        Agregar objInsert= new Agregar();
        objInsert.setVisible(true);
        try {
            jTable1.setModel(new Maestro().getFactura(url));
        } catch (SQLException ex) {
            Logger.getLogger(MaestroDetalle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnAgregarFacturaActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int fila= jTable1.getSelectedRow();//se guarda en fila el valor
        String numero= jTable1.getValueAt(fila,0).toString();// de la fila seleccionada obtengo el valor de la columna cero y lo guardo en la variable
        try {
            jTable2.setModel(new Detalle().getFacturaDetalle(url,numero));
        } catch (SQLException ex) {
            Logger.getLogger(MaestroDetalle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnBorrarFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBorrarFacturaMouseClicked
        // TODO add your handling code here:
        int filaFactura= jTable1.getSelectedRow(); //el numero de la fila que selecciono lo guardo en la variable fila.
        String valor=jTable1.getValueAt(filaFactura,0).toString(); //.0 la columna es el ID, fila es la variable que guarda la fila que hacemos click.
        Maestro objBorro= new Maestro(Integer.parseInt(valor)); //.toString();//pasar a int
        Detalle objBorro1=new Detalle();
        try {
            objBorro.borrarFactura();
            objBorro1.borrarDetalle();
            jTable1.setModel(new Maestro().getFactura(url));
            jTable2.setModel(new Detalle().getFacturaDetalle(url, valor));
        } catch (SQLException ex) {
            Logger.getLogger(MaestroDetalle.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_btnBorrarFacturaMouseClicked

    private void btnBorrarDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBorrarDetalleMouseClicked
        // TODO add your handling code here:
        DefaultTableModel objDtm = (DefaultTableModel) jTable2.getModel(); //TableProducto es el nombre de mi tabla ;)
        objDtm.removeRow(jTable2.getSelectedRow());
    }//GEN-LAST:event_btnBorrarDetalleMouseClicked

    private void btnModificarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarFacturaActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
        //aca capturo el primer dato de la celda seleccionada 
        int filaFactura= jTable1.getSelectedRow(); //el numero de la fila que selecciono lo guardo en la variable fila.
        int id = Integer.parseInt(jTable1.getValueAt(filaFactura,0).toString());
        String fechamodificacion = jTable1.getValueAt(filaFactura,1).toString();
        Maestro objMaestro = new Maestro();
        objMaestro.setFechaFac(fechamodificacion);
        objMaestro.setIdFactura(id);
        try {
            objMaestro.modificarFactura();
        } catch (SQLException ex) {
            Logger.getLogger(MaestroDetalle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnModificarFacturaActionPerformed

    
    //boton modificar detalle
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
         DefaultTableModel tm = (DefaultTableModel) jTable2.getModel();
        //aca capturo el primer dato de la celda seleccionada 
        int filaDetalle= jTable2.getSelectedRow(); //el numero de la fila que selecciono lo guardo en la variable fila.
        int id = Integer.parseInt(jTable2.getValueAt(filaDetalle,5).toString());
        String servicio = jTable2.getValueAt(filaDetalle,1).toString();
        float precioservicio = Float.parseFloat(jTable2.getValueAt(filaDetalle,2).toString());
        int cantidad = Integer.parseInt(jTable2.getValueAt(filaDetalle,3).toString());
        float preciounitario = Float.parseFloat(jTable2.getValueAt(filaDetalle,4).toString());
        Detalle objDetalle = new Detalle();
        objDetalle.setCantidad(cantidad);
        objDetalle.setPrecioServicio(precioservicio);
        objDetalle.setPrecioUnitario(preciounitario);
        objDetalle.setServicio(servicio);
        objDetalle.setIdDetalle(id);
        try {
            objDetalle.modificarDetalle();
        } catch (SQLException ex) {
            Logger.getLogger(MaestroDetalle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            // TODO add your handling code here:
            jTable1.setModel(new Maestro().getFactura(url));
        } catch (SQLException ex) {
            Logger.getLogger(MaestroDetalle.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            jTable2.setModel(new Detalle().getFacturaDetalle(url, ""));
        } catch (SQLException ex) {
            Logger.getLogger(MaestroDetalle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowActivated

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Pacientes objPac= new Pacientes();
        objPac.Cerra();
        
    }//GEN-LAST:event_formWindowClosing

    public static void main(String args[]) {
       
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MaestroDetalle().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MaestroDetalle.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarFactura;
    private javax.swing.JButton btnBorrarDetalle;
    private javax.swing.JButton btnBorrarFactura;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnModificarFactura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
