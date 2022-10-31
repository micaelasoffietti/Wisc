
package Negocio;

import Datos.Datos;
import static Datos.Datos.connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Detalle {
    protected int idDetalle;
    protected String servicio;
    protected float precioServicio;
    protected int cantidad;
    protected float precioUnitario;
    protected int idFactura;
    
public Detalle(){
    this.idDetalle=0;
    this.servicio=" ";
    this.precioServicio=0;
    this.cantidad=0;
    this.precioUnitario=0;
    this.idFactura=0;
}

public Detalle(int id) throws SQLException{
    String selecString2=null;
    selecString2=("select * from DetalleFactura where idFactura= "+id);
    ResultSet result2=null;
    DefaultTableModel model = new DefaultTableModel();
    PreparedStatement st= connect.prepareStatement(selecString2);
    result2= st.executeQuery();
        while (result2.next()){
            model.addRow(
                    new Object[]{
                    this.idDetalle=result2.getInt("IdDetalle"),// en el id que declaramos guarda eso       
                    this.servicio=result2.getString("Servicio"),
                    this.precioServicio=result2.getFloat("PrecioServicio"),
                    this.cantidad=result2.getInt("Cantidad"),
                    this.precioUnitario=result2.getFloat("PrecioUnitario"),
                    this.idFactura=result2.getInt("IdFactura")
                    }
            );
    
    }
}
public DefaultTableModel getFacturaDetalle(String url, String nroFactura) throws SQLException{
        DefaultTableModel dat=new DefaultTableModel();
        dat.addColumn("IdFactura");
        dat.addColumn("Servicio");
        dat.addColumn("PrecioServicio");
        dat.addColumn ("Cantidad");
        dat.addColumn("PrecioUnitario");
        dat.addColumn("IdDetalle");
        Datos d = new Datos();
        d.conectarBase(url);
        PreparedStatement sql= connect.prepareStatement("select * from DetalleFactura where IdFactura=? ");
        sql.setString(1,nroFactura);
        ResultSet resu = null;
       try{
        resu=d.selec(sql);
        dat.getDataVector().removeAllElements();
       while (resu.next()){
                    Object[] fila =new Object[6];
                    fila[0]=resu.getString("idFactura");
                    fila[1]=resu.getString("Servicio");
                    fila[2]=resu.getString("PrecioServicio");
                    fila[3]=resu.getString("Cantidad");
                    fila[4]=resu.getString("PrecioUnitario");
                    fila[5]=resu.getString("IdDetalle");
                    dat.addRow(fila);
                        
                    }   
        }
    catch(Exception x){
        JOptionPane.showMessageDialog(null, x.getMessage().toString());  
    }
       return dat;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public float getPrecioServicio() {
        return precioServicio;
    }

    public void setPrecioServicio(float precioServicio) {
        this.precioServicio = precioServicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }
    
    public void agregarDetalle() throws SQLException{
       //int factura=3;
       Datos dat = new Datos();
       PreparedStatement agregarDetalle = connect.prepareStatement ("insert into DetalleFactura(Servicio,PrecioServicio,Cantidad,PrecioUnitario,IdFactura) values ('"+servicio+"','"+precioServicio+"','"+cantidad+"','"+precioUnitario+"','"+idFactura+"')");
       dat.insertar(agregarDetalle);
       //agregarPaciente.setString(1,numero);
       
    }
     public void borrarDetalle() throws SQLException{//no va parametro pq toma de la propiedad
        PreparedStatement elimi= connect.prepareStatement("DELETE FROM DetalleFactura WHERE IdFactura='"+this.idFactura+"'");//this.id
        Datos dat= new Datos();
        dat.borrar(elimi);
    }
     
    public void modificarDetalle() throws SQLException{
       Datos dat = new Datos();
       PreparedStatement modifpaciente = connect.prepareStatement("update DetalleFactura set Servicio = '"+servicio+"', PrecioServicio ='"+precioServicio+"', Cantidad ='"+cantidad+"', PrecioUnitario ='"+precioUnitario+"' where IdDetalle='"+idDetalle+"'");
       dat.actualizar(modifpaciente);
    }
    
}
