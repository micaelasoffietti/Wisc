
package Presentacion;

import Negocio.Pacientes;
import Datos.Datos;
import Negocio.Maestro;
//import static Presentacion.MostrarPacientes.tblPacientes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class CargarPacientes extends javax.swing.JFrame {

  
    public CargarPacientes() throws SQLException {
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        conectar(url);
        mostrarPacientes();
    }
   
    String url="jdbc:sqlite:C:/Users/Micaela/Desktop/BaseDatos/Pacientes.s3db";
     
     public void conectar (String url) throws SQLException{
        Pacientes conexion= new Pacientes();
        Maestro conec= new Maestro();
        conexion.conectar(url);
        conec.getFactura(url);
     }
     
     public void buscarPaciente(int id) throws SQLException{
         //model=(DefaultTableModel) this.tblPacientes.getModel();
         Pacientes buscarid = new Pacientes();
         buscarid.buscarId(id,model);
         //buscarid.mostrar(model);
         
         //mostrarPacientes();
     }
     
     
     public void mostrarPacientes() throws SQLException{
        model=(DefaultTableModel) this.tblPacientes.getModel();
        //model.getDataVector().removeAllElements();
        Pacientes mostrar= new Pacientes();
        mostrar.mostrar(model);
    }
    //new MostrarPacientes().setVisible(true);
    public static DefaultTableModel model;
    
    public void modificarPaciente() throws SQLException{
        int fila= tblPacientes.getSelectedRow(); //el numero de la fila que selecciono lo guardo en la variable fila.
        String valor= tblPacientes.getValueAt(fila,0).toString(); //.0 la columna es el ID, fila es la variable que guarda la fila que hacemos click.
        Pacientes modificar = new Pacientes(Integer.parseInt(valor));
        
        modificar.setNombreApellido(textNomApe.getText());
        modificar.setDni(textDni.getText());
        modificar.setEscuela(textEsc.getText());
        modificar.setCurso(textCurso.getText());
        modificar.setLocalidad(textLocalidad.getText());
        modificar.setEdad(Integer.parseInt(textEdad.getText()));
        DateTimeFormatter JEFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        modificar.setFechaNac(LocalDate.parse(textFechaNac.getText(), JEFormatter));
        modificar.setPesoNac(Float.parseFloat(textPesoNac.getText()));
        modificar.setNroFamilia(Integer.parseInt(textNroFamiliares.getText()));
        if (btnSi.isSelected() == true)
        {
            modificar.setObraSocial(true);
        }
        else
        {
            modificar.setObraSocial(false);
        }
        
        modificar.modificarPaciente();
        modificar.mostrar(model);
    }
    
     public void borrarPaciente() throws SQLException{
       int fila= tblPacientes.getSelectedRow(); //el numero de la fila que selecciono lo guardo en la variable fila.
       String valor= tblPacientes.getValueAt(fila,0).toString(); //.0 la columna es el ID, fila es la variable que guarda la fila que hacemos click.
        
       Pacientes borro= new Pacientes(Integer.parseInt(valor)); //.toString();//pasar a int
        
       borro.borrarPaciente();
       borro.mostrar(model);
  
    }
    @SuppressWarnings("unchecked")
     public void cerrar(){
        String [] botones ={"Aceptar","Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(this,"¿Desea abandonar la aplicación?","Mensaje de Confirmacion",
                0,0,null,botones,this);
        if(eleccion== JOptionPane.YES_OPTION){
            System.exit(0);
        }else if (eleccion==JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog (null,"Se canceló el cierre");
        }
            
        }
         
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGruObraSocial = new javax.swing.ButtonGroup();
        Nombre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textNomApe = new javax.swing.JTextField();
        textDni = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textEdad = new javax.swing.JTextField();
        labelFechaNac = new javax.swing.JLabel();
        textFechaNac = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textCurso = new javax.swing.JTextField();
        textEsc = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textLocalidad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        textPesoNac = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnMostrarPacientes = new javax.swing.JButton();
        btnSi = new javax.swing.JRadioButton();
        btnNo = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        textNroFamiliares = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPacientes = new javax.swing.JTable();
        btnBorrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBuscarId = new javax.swing.JButton();
        textBuscar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnFactura = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        Nombre.setText("Nombre y Apellido");

        jLabel2.setText("DNI");

        textDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textDniKeyTyped(evt);
            }
        });

        jLabel3.setText("Edad");

        textEdad.setEnabled(false);
        textEdad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textEdadMouseClicked(evt);
            }
        });

        labelFechaNac.setText("Fecha de Nacimiento");

        textFechaNac.setText("dd/mm/aaaa");
        textFechaNac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textFechaNacMouseClicked(evt);
            }
        });

        jLabel1.setText("Curso");

        jLabel5.setText("Escuela");

        jLabel6.setText("Localidad");

        jLabel7.setText("Obra Social");

        jLabel8.setText("Peso Nac");

        btnAgregar.setText("Agregar");
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnMostrarPacientes.setText("Mostrar Pacientes");
        btnMostrarPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarPacientesActionPerformed(evt);
            }
        });

        btnGruObraSocial.add(btnSi);
        btnSi.setSelected(true);
        btnSi.setText("Si");

        btnGruObraSocial.add(btnNo);
        btnNo.setText("No");

        jLabel4.setText("Numero de familiares directos:");

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
        tblPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPacientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPacientes);

        btnBorrar.setText("Borrar");
        btnBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBorrarMouseClicked(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnBuscarId.setText("Buscar");
        btnBuscarId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarIdMouseClicked(evt);
            }
        });

        jLabel10.setText("ID");

        btnFactura.setBackground(new java.awt.Color(0, 153, 153));
        btnFactura.setText("Factura");
        btnFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textDni, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(textEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(textLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Nombre)
                                .addGap(18, 18, 18)
                                .addComponent(textNomApe, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnMostrarPacientes)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(86, 86, 86)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscarId))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(31, 31, 31)
                                                .addComponent(btnSi)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnNo))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(18, 18, 18)
                                                .addComponent(textCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(labelFechaNac)
                                                .addGap(18, 18, 18)
                                                .addComponent(textFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(textEsc, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(btnBorrar)
                                .addGap(32, 32, 32)
                                .addComponent(btnModificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFactura)))
                        .addGap(69, 69, 69))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(textPesoNac, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textNroFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nombre)
                    .addComponent(textNomApe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFechaNac)
                    .addComponent(textFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(textCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textEsc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btnSi)
                    .addComponent(btnNo))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(textNroFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 6, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnBuscarId)
                                    .addComponent(textBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addGap(4, 4, 4)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textPesoNac, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(47, 47, 47)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnMostrarPacientes)
                    .addComponent(btnBorrar)
                    .addComponent(btnModificar)
                    .addComponent(btnFactura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarPacientesActionPerformed
        // TODO add your handling code here:
        Datos dat= new Datos();
        try {       
            dat.run();
        } catch (SQLException ex) {
            Logger.getLogger(CargarPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMostrarPacientesActionPerformed

    
    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
       
        //valido que el numero de documento sean solo numeros
        if ((textDni.getText()).matches("[+-]?\\d*(\\.\\d+)?") == false)
        {
            JOptionPane.showMessageDialog(null,"ingrese solo numeros para el dni");
        }
        else
        {
        Pacientes agregar= new Pacientes();
       
        agregar.setNombreApellido(textNomApe.getText());
        agregar.setDni(textDni.getText());
        agregar.setEscuela(textEsc.getText());
        agregar.setCurso(textCurso.getText());
        agregar.setLocalidad(textLocalidad.getText());
        agregar.setEdad(Integer.parseInt(textEdad.getText()));
        DateTimeFormatter JEFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        agregar.setFechaNac(LocalDate.parse(textFechaNac.getText(), JEFormatter));
        agregar.setPesoNac(Float.parseFloat(textPesoNac.getText()));
        agregar.setNroFamilia(Integer.parseInt(textNroFamiliares.getText()));
        if (btnSi.isSelected() == true)
        {
            agregar.setObraSocial(true);
        }
        else
        {
            agregar.setObraSocial(false);
        }
        try {
            agregar.agregarPaciente();
            //mostrarPacientes();
            } catch (SQLException ex) {
                Logger.getLogger(CargarPacientes.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnAgregarMouseClicked
    }
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            // TODO add your handling code here:
            conectar(url);
        } catch (SQLException ex) {
            Logger.getLogger(CargarPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowActivated

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        this.setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed
    
    //funcion para calcular edad
    public int calcularEdad(String fechanac)
    {
        int edad;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(fechanac, fmt);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNacimiento, ahora);
        edad = periodo.getYears();
        
        return edad;
    }
    
    //para validar que solo escriban 8 digitos maximo de dni
    private void textDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textDniKeyTyped
        if (textDni.getText().length() >= 8)
        {
            evt.consume();
        }
        
    }//GEN-LAST:event_textDniKeyTyped

    private void textFechaNacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textFechaNacMouseClicked
        textFechaNac.setText(null);
    }//GEN-LAST:event_textFechaNacMouseClicked

    private void textEdadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textEdadMouseClicked
        textEdad.setText(Integer.toString(calcularEdad(textFechaNac.getText())));
    }//GEN-LAST:event_textEdadMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cerrar();
    }//GEN-LAST:event_formWindowClosing
  
    private void btnBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBorrarMouseClicked
        try {
            borrarPaciente();
            mostrarPacientes();
        } catch (SQLException ex) {
           Logger.getLogger(CargarPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBorrarMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
        modificarPaciente();
       // mostrarPacientes();
        } catch (SQLException ex) {
            Logger.getLogger(CargarPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBuscarIdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarIdMouseClicked

         try {
            buscarPaciente(Integer.parseInt(textBuscar.getText()));
        } catch (SQLException ex) {
            Logger.getLogger(CargarPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarIdMouseClicked

    private void tblPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPacientesMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1)
        {
            JTable receptor = (JTable)evt.getSource();
            int id = Integer.parseInt(receptor.getModel().getValueAt(receptor.getSelectedRow(),0).toString());
            textNomApe.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(),1).toString());
            textDni.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(),2).toString());
            textCurso.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(),3).toString());
            textEsc.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(),4).toString());
            DateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
            DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            String inputText = receptor.getModel().getValueAt(receptor.getSelectedRow(),5).toString();
            Date date;
            try {
                date = inputFormat.parse(inputText);
                String outputText = outputFormat.format(date);
                textFechaNac.setText(outputText);
            } catch (ParseException ex) {
                Logger.getLogger(CargarPacientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            //agregar obra social
            textEdad.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(),7).toString());
            textPesoNac.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(),8).toString());
            textLocalidad.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(),9).toString());
            textNroFamiliares.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(),10).toString());
            
        }
    }//GEN-LAST:event_tblPacientesMouseClicked

    private void btnFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturaActionPerformed
        try {
            // TODO add your handling code here:
            MaestroDetalle maestro = new MaestroDetalle();
            maestro.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(CargarPacientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFacturaActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {      
                    new CargarPacientes().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(CargarPacientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nombre;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscarId;
    private javax.swing.JButton btnFactura;
    private javax.swing.ButtonGroup btnGruObraSocial;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnMostrarPacientes;
    private javax.swing.JRadioButton btnNo;
    private javax.swing.JRadioButton btnSi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelFechaNac;
    protected static javax.swing.JTable tblPacientes;
    private javax.swing.JTextField textBuscar;
    protected static javax.swing.JTextField textCurso;
    protected static javax.swing.JTextField textDni;
    protected static javax.swing.JTextField textEdad;
    protected static javax.swing.JTextField textEsc;
    protected static javax.swing.JTextField textFechaNac;
    protected static javax.swing.JTextField textLocalidad;
    protected static javax.swing.JTextField textNomApe;
    protected static javax.swing.JTextField textNroFamiliares;
    protected static javax.swing.JTextField textPesoNac;
    // End of variables declaration//GEN-END:variables

}

