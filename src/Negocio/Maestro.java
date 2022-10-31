
package Negocio;

import Datos.Datos;
import static Datos.Datos.connect;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;



public class Maestro {
    protected int idFactura;
    protected String fechaFac;
    protected int idPaciente;
    protected float totalFactura;
    protected JTable tabla;
   
    public Maestro(){
        
        this.idFactura=0;
        //this.fechaFac=LocalDate.now();
        this.fechaFac="";
        this.idPaciente=1;
        this.totalFactura=0;
        //this.tabla=JTable;
        this.tabla = new JTable(0, 0);
    }
   
    
    public Maestro(int id){
        String selecString=null;
        String selecString2=null;
        selecString = ("select * from Factura where IdFactura = " +id);
        ResultSet result=null;
     
        DefaultTableModel model = new DefaultTableModel();
            try{
                    PreparedStatement st= connect.prepareStatement(selecString);
                    result= st.executeQuery();
                    while (result.next()){
                        model.addRow(
                                new Object[]{
                                    this.idFactura=result.getInt("IdFactura"),// en el id que declaramos guarda eso
                                    //this.fechaFac=result.getDate("FechaFac").toLocalDate(),
                                    this.fechaFac=result.getString("FechaFac"),
                                    this.idPaciente=result.getInt("IdPaciente"),
                                    this.totalFactura=result.getFloat("TotalFactura")
                                }
                        );
                    }
                }
                catch(Exception x){
                    JOptionPane.showMessageDialog(null, x.getMessage().toString());
                }
        
    
    }
    
    
    
    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getFechaFac() {
        return fechaFac;
    }

    public void setFechaFac(String fechaFac) {
        this.fechaFac = fechaFac;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public float getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(float totalFactura) {
        this.totalFactura = totalFactura;
    }
    
    public DefaultTableModel getFactura(String url) throws SQLException{
        DefaultTableModel dat=new DefaultTableModel();
        dat.addColumn("Numero");
        dat.addColumn("Fecha");
        dat.addColumn("Total");
        Datos d = new Datos();
        d.conectarBase(url);
        PreparedStatement mo= connect.prepareStatement("select * from Factura");
        ResultSet resu = null;
       try{
        resu=d.selec(mo);
        dat.getDataVector().removeAllElements();
       while (resu.next()){
                    Object[] fila =new Object[3];
                    fila[0]=resu.getString("idFactura");
                    fila[1]=resu.getString("fechaFac");
                    fila[2]=resu.getString("totalFactura");
                    dat.addRow(fila);
                        
                    }   
        }
    catch(Exception x){
        JOptionPane.showMessageDialog(null, x.getMessage().toString());  
    }
       return dat;
    }

public void agregarDato () throws SQLException{
       Datos dat = new Datos();
       PreparedStatement agregarFactura = connect.prepareStatement ("insert into Factura (FechaFac,IdPaciente) values ('"+fechaFac+"','"+idPaciente+"')");
       dat.insertar(agregarFactura);
       //agregarPaciente.setString(1,numero);
       
    }

public int obtenerIDMaestro() throws SQLException{
    Datos dat = new Datos();
       PreparedStatement select = connect.prepareStatement ("select IdFactura from Factura where FechaFac = '"+fechaFac+"'and IdPaciente ='"+idPaciente+"'");
       ResultSet resu = null;
       resu= dat.seleccionarId(select);
       int id = resu.getInt("IdFactura");
       return id;
}
public void borrarFactura() throws SQLException{//no va parametro pq toma de la propiedad
        PreparedStatement elimi= connect.prepareStatement("DELETE FROM Factura WHERE IdFactura='"+this.idFactura+"'");//this.id
        Datos dat= new Datos();
        dat.borrar(elimi);
    }
 public void modificarFactura() throws SQLException{
       Datos dat = new Datos();
       PreparedStatement modifpaciente = connect.prepareStatement("update Factura set FechaFac = '"+fechaFac+"',TotalFactura ='"+totalFactura+"' where IdFactura='"+idFactura+"'");
       dat.actualizar(modifpaciente);
 }
 
 public void modificarTotal() throws SQLException{
       Datos dat = new Datos();
       PreparedStatement modifpaciente = connect.prepareStatement("update Factura set TotalFactura ='"+totalFactura+"' where IdFactura='"+idFactura+"'");
       dat.actualizar(modifpaciente);
 }
 
}
    

