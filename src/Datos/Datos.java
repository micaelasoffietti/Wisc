
package Datos;


import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import Negocio.Pacientes;
import Presentacion.MostrarPacientes;
import java.time.LocalDate;



public class Datos {
    public static Connection connect ;
    
    public void conectarBase(String url){
        try{
        Class.forName("org.sqlite.JDBC");
        connect = DriverManager.getConnection(url);
        }catch(Exception x){
            JOptionPane.showMessageDialog(null, x.getMessage());
        }   
    }
    
    public void seleccionar(DefaultTableModel model){
            model.setRowCount(0);
            ResultSet result=null;
            try{
                    PreparedStatement st= connect.prepareStatement("Select * From Pacientes");
                    result= st.executeQuery();

                    while (result.next()){
                        model.addRow(
                                new Object[]{
                                    result.getInt("PacienteID"),
                                    result.getString("NombreApellido"),
                                    result.getString("DNI"),
                                    result.getString("Curso"),
                                    result.getString("Escuela"),
                                    result.getString("FechaNac"),
                                    result.getBoolean("ObraSocial"),
                                    result.getInt("Edad"),
                                    result.getFloat("PesoNacimiento"),
                                    result.getString("Localidad"),
                                    result.getInt("FamiliaDirecta"),
                                }
                        );
                    }
                }
                catch(Exception x){
                    JOptionPane.showMessageDialog(null, x.getMessage().toString());
                }
    }
    
     public void seleccionarId(int id){
            String dni;
            ResultSet result=null;
            try{
                    PreparedStatement st= connect.prepareStatement("Select Dni From Pacientes where PacienteID = "+id);
                    result= st.executeQuery();
                    
                    dni = result.getString("Dni");
                    JOptionPane.showMessageDialog(null, dni);
                    
                }
                catch(Exception x){
                    JOptionPane.showMessageDialog(null, x.getMessage().toString());
                }
    }
    
    
    
     public void run() {
                new MostrarPacientes().setVisible(true);
            }
     
      public void insertar(String nuevopaciente){
        try {
                
                 PreparedStatement st= connect.prepareStatement(nuevopaciente);
                 st.execute();
                 JOptionPane.showMessageDialog(null, "Datos guardados");

            }catch(Exception x){
                JOptionPane.showMessageDialog(null, x.getMessage().toString());
            }
        }  
      
      public void borrar(String valor){
        try{
            PreparedStatement elimi= connect.prepareStatement("DELETE FROM Pacientes WHERE pacienteID='"+valor+"'");
            elimi.executeUpdate();
            JOptionPane.showMessageDialog(null,"¡Eliminado!");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e+ "No se logró eliminar la fila");
        }
      }
      
      public void actualizar(int id, String nombreApe, String dni, String curso, String escuela,String fechaNac, boolean obraSocial, int edad, float pesoNac, String localidad,int nroFam){
          try {
              // pasamos a boleeano que lee 1 o 0 en la base de datos SQLITE. (No true ni false)
              int obra = obraSocial ? 1:0;
              //Pasamos del tipo de dato String al fecha. El table model no tiene tipo de dato fecha, por eso vamos convirtiendo.
              LocalDate fecha= LocalDate.parse(fechaNac);
              PreparedStatement actu= connect.prepareStatement("UPDATE Pacientes SET NombreApellido='"+nombreApe+"',Dni='"+dni+"',Curso='"+curso+"',Escuela='"+escuela+"',FechaNac='"+fecha+"',ObraSocial='"+obra+"',PesoNacimiento='"+pesoNac+"',Localidad='"+localidad+"',FamiliaDirecta='"+nroFam+"'WHERE PacienteID='"+id+"'");
              actu.executeUpdate();
              JOptionPane.showMessageDialog(null,"¡Modificado!");
              //Seleccionar(0,null);
          } catch (SQLException e) {
              JOptionPane.showMessageDialog(null,e+ "ERROR");
          }
 
      
      }

}
