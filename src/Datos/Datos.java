
package Datos;


import java.sql.DriverManager;
import java.lang.NoClassDefFoundError;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import Negocio.Pacientes;
import Presentacion.CargarPacientes;
//import Presentacion.MostrarPacientes;
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
    
    public ResultSet seleccionar(PreparedStatement mostrar) throws SQLException{
       ResultSet result=null;
       result=mostrar.executeQuery();
       return result;
    }
    
    public ResultSet selec(PreparedStatement mostrar) throws SQLException{
       ResultSet result=null;
       result=mostrar.executeQuery();
       return result;
    }
    
     public ResultSet seleccionarId(PreparedStatement st) throws SQLException{
            ResultSet result=null;
            result=st.executeQuery();
            return result;
    }
    
     public void run() throws SQLException {
                new CargarPacientes().setVisible(true);
            }
     
      public void insertar(PreparedStatement agregarPaciente){
        try {
                 agregarPaciente.execute();
                 JOptionPane.showMessageDialog(null, "Datos guardados");

            }catch(Exception x){
                JOptionPane.showMessageDialog(null, x.getMessage().toString());
            }
        }  
      
      public void borrar(PreparedStatement elimi){// se le pasa un statement y que se haga el executeUpdate
        try{
            elimi.executeUpdate();
            JOptionPane.showMessageDialog(null,"¡Eliminado!");
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e+ "No se logró eliminar la fila");
        }
      }
      
      public void actualizar(PreparedStatement actu){
          try {
              actu.executeUpdate();
              JOptionPane.showMessageDialog(null,"¡Modificado!");
              //Seleccionar(0,null);
          } catch (SQLException e) {
              JOptionPane.showMessageDialog(null,e+ "ERROR");
          }
 
      
      }

    public Object getDataVector() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
