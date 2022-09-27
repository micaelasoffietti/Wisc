
package Presentacion;


import Negocio.Pacientes;
import Presentacion.CargarPacientes;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Datos.Datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;



public class MostrarPacientes extends CargarPacientes {

  
    public MostrarPacientes() {
        initComponents();
        mostrarPacientes();
        
    }
    
    public void mostrarPacientes(){
        model=(DefaultTableModel) this.tblPacientes.getModel();
        Pacientes mostrar= new Pacientes();
        mostrar.mostrar(model);
    }
    //new MostrarPacientes().setVisible(true);
    public static DefaultTableModel model;
    @SuppressWarnings("unchecked")
    
    public void borrarPaciente(){
        Pacientes borro= new Pacientes();
        int fila= tblPacientes.getSelectedRow(); //el numero de la fila que selecciono lo guardo en la variable fila.
        String valor= tblPacientes.getValueAt(fila,0).toString(); //.0 la columna es el ID, fila es la variable que guarda la fila que hacemos click.
        borro.borrarPaciente(valor);
        borro.mostrar(model);
  
    }
    public void actualizarDatos(){
        //guardamos la fila seleccionada
        int fila=tblPacientes.getSelectedRow();
        //obtenemos el valor que se encuentre almacenado en la fila que este seleccionando el usuario
        int id=Integer.parseInt(this.tblPacientes.getValueAt(fila,0).toString());
        String nombreApe= tblPacientes.getValueAt(fila,1).toString();
        String dni= tblPacientes.getValueAt(fila,2).toString();
        String curso= tblPacientes.getValueAt(fila,3).toString();
        String escuela= tblPacientes.getValueAt(fila,4).toString();
        String fechaNac= tblPacientes.getValueAt(fila,5).toString();
        boolean obraSocial= Boolean.parseBoolean(this.tblPacientes.getValueAt(fila,6).toString());
        int edad= Integer.parseInt(this.tblPacientes.getValueAt(fila,7).toString());
        float pesoNac= Float.parseFloat(this.tblPacientes.getValueAt(fila,8).toString());
        String localidad= tblPacientes.getValueAt(fila,9).toString();
        int nroFam= Integer.parseInt(this.tblPacientes.getValueAt(fila,10).toString());
        
        Pacientes actu=new Pacientes();
        actu.actualizarPaciente(id, nombreApe, dni, curso, escuela,fechaNac,obraSocial, edad, pesoNac, localidad,nroFam);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPacientes = new javax.swing.JTable();
        btnBorrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        panel1 = new java.awt.Panel();
        textID = new javax.swing.JTextField();
        btnConsulta = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre y Apellido", "DNI", "Curso", "Escuela", "FechaNac", "ObraSocial", "Edad", "PesoNac", "Localidad", "FamiliaDirecta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Integer.class, java.lang.Float.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPacientes);
        if (tblPacientes.getColumnModel().getColumnCount() > 0) {
            tblPacientes.getColumnModel().getColumn(10).setResizable(false);
        }

        btnBorrar.setText("Borrar");
        btnBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBorrarMouseClicked(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModificarMouseClicked(evt);
            }
        });

        btnConsulta.setText("consulta DNI");
        btnConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsultaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btnConsulta)
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsulta))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel2.setText("Busqueda por ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(83, 83, 83)
                        .addComponent(btnBorrar)
                        .addGap(61, 61, 61)
                        .addComponent(btnModificar)))
                .addContainerGap(232, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(254, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnModificar)
                        .addComponent(btnBorrar))
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultaMouseClicked
        // TODO add your handling code here:
        Pacientes mostrarid = new Pacientes();
        mostrarid.buscarId(Integer.parseInt(textID.getText()));

    }//GEN-LAST:event_btnConsultaMouseClicked

    private void btnBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBorrarMouseClicked
        // TODO add your handling code here:
        borrarPaciente();
        mostrarPacientes();
    }//GEN-LAST:event_btnBorrarMouseClicked

    private void btnModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModificarMouseClicked
        actualizarDatos();
        mostrarPacientes();
    }//GEN-LAST:event_btnModificarMouseClicked

   
    {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Panel panel1;
    protected static javax.swing.JTable tblPacientes;
    private javax.swing.JTextField textID;
    // End of variables declaration//GEN-END:variables
}
