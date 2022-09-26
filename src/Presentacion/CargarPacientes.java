
package Presentacion;

import Negocio.Pacientes;
import Datos.Datos;
import static Presentacion.MostrarPacientes.model;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class CargarPacientes extends javax.swing.JFrame {

  
    public CargarPacientes() {
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
   
    String url="jdbc:sqlite:C:/Users/Micaela/Desktop/Base de datos/Pacientes.s3db";
     
     public void conectar (String url){
        Pacientes conexion= new Pacientes();
        conexion.conectar(url);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addComponent(textPesoNac, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(302, 302, 302)
                                        .addComponent(jLabel7))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMostrarPacientes)))
                        .addGap(200, 200, 200))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Nombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textNomApe, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6))
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textDni, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelFechaNac)
                                            .addComponent(jLabel1))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(textCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(91, 91, 91)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnSi)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnNo))
                                            .addComponent(textEsc, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(101, 101, 101))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textNroFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 43, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelFechaNac))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textEsc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(btnSi)
                                    .addComponent(btnNo))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textNomApe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(textDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(textPesoNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(textNroFamiliares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar)
                            .addComponent(btnMostrarPacientes)))
                    .addComponent(jLabel8))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarPacientesActionPerformed
        // TODO add your handling code here:
        Datos dat= new Datos();
        dat.run();       
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
        agregar.agregarPaciente();
   
        this.dispose();
    }//GEN-LAST:event_btnAgregarMouseClicked
    }
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        conectar(url);
    }//GEN-LAST:event_formWindowActivated

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        this.setVisible(false);
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

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CargarPacientes().setVisible(true);      
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nombre;
    private javax.swing.JButton btnAgregar;
    private javax.swing.ButtonGroup btnGruObraSocial;
    private javax.swing.JButton btnMostrarPacientes;
    private javax.swing.JRadioButton btnNo;
    private javax.swing.JRadioButton btnSi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel labelFechaNac;
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

