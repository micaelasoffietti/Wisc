
package Negocio;

import Datos.Datos;
import static Datos.Datos.connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.time.LocalDate;
//import Presentacion.MostrarPacientes;
import java.lang.NoClassDefFoundError;
import java.util.ArrayList;

public class Pacientes {
    protected int id;
    protected String dni;
    protected int edad;
    protected int nroFamilia;
    protected String nombreApellido;
    protected LocalDate fechaNac;
    protected String curso;
    protected String escuela;
    protected String localidad;
    protected boolean obraSocial;
    protected float pesoNac;
    

    public Pacientes() {
        this.id = 0;
        this.dni = "";
        this.edad = 0;
        this.nroFamilia = 0;
        this.nombreApellido = "";
        this.fechaNac =LocalDate.now() ;
        this.curso = "";
        this.escuela = "";
        this.localidad = "";
        this.obraSocial = false;
        this.pesoNac = 0;
    }
    
    public Pacientes(int id) {
        String selecString=null;
        selecString = ("select * from Pacientes where PacienteID = " +id);//mostrar los datos del paciente con ese ID
        ResultSet result=null;
        DefaultTableModel model = new DefaultTableModel();
            try{
                    PreparedStatement st= connect.prepareStatement(selecString);
                    result= st.executeQuery();

                    while (result.next()){
                        model.addRow(
                                new Object[]{
                                    this.id=result.getInt("PacienteID"),// en el id que declaramos guarda eso
                                    this.nombreApellido=result.getString("NombreApellido"),
                                    this.dni=result.getString("DNI"),
                                    this.curso=result.getString("Curso"),
                                    this.escuela=result.getString("Escuela"),
                                    this.fechaNac=result.getDate("FechaNac").toLocalDate(),
                                    this.obraSocial=result.getBoolean("ObraSocial"),
                                    this.edad=result.getInt("Edad"),
                                    this.pesoNac=result.getFloat("PesoNacimiento"),
                                    this.localidad=result.getString("Localidad"),
                                    this.nroFamilia=result.getInt("FamiliaDirecta"),
                                }
                        );
                    }
                }
                catch(Exception x){
                    JOptionPane.showMessageDialog(null, x.getMessage().toString());
                }
        
        //armar selec con id buscarlo en la base y pegarselo a las propiedades 
        //new(1)
        
    }
    
    
    public Pacientes(int id, String nombre)
    {
        this.id = id;
        this.nombreApellido = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public int getNroFamilia() {
        return nroFamilia;
    }

    public void setNroFamilia(int nroFamilia) {
        this.nroFamilia = nroFamilia;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public boolean getObraSocial() {
        return obraSocial;
    }
    
    public void setObraSocial(boolean obraSocial) {
        this.obraSocial = obraSocial;
    }

    public float getPesoNac() {
        return pesoNac;
    }

    public void setPesoNac(float pesoNac) {
        this.pesoNac = pesoNac;
    }

    //para poder usar en el combobox
    @Override
    public String toString() {
        return nombreApellido;
    }

    //conectar la base de datos
     public void conectar(String URL){
       Datos dat = new Datos();
       dat.conectarBase(URL);
    }
    //busca todos los pacientes
    public void mostrar (DefaultTableModel model) throws SQLException{
       ResultSet result = null;
       PreparedStatement mostrarTabla= connect.prepareStatement("Select * From Pacientes");
       Datos dat = new Datos();
       try{
       result= dat.seleccionar(mostrarTabla);
       model.getDataVector().removeAllElements();
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
    }catch(Exception x){
        JOptionPane.showMessageDialog(null, x.getMessage().toString());  
    }}
   
    //busca un paciente por id
    //pusimos buscar el dni solamente a modo de ejemplo
    public void buscarId (int id,DefaultTableModel model) throws SQLException{
       ResultSet result = null;
       Datos dat = new Datos();
       PreparedStatement st= connect.prepareStatement("Select * From Pacientes where PacienteID = "+id);
       dat.seleccionarId(st);
       try{
       result= dat.seleccionar(st);
       model.getDataVector().removeAllElements();
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
    }catch(Exception x){
        JOptionPane.showMessageDialog(null, x.getMessage().toString());  
    }
   
    }
    
    //ingresa paciente
    public void agregarPaciente () throws SQLException{
       Datos dat = new Datos();
       int obra = obraSocial ? 1:0;
       PreparedStatement agregarPaciente = connect.prepareStatement ("insert into Pacientes (NombreApellido,Dni,Localidad,FechaNac,Curso,Escuela,PesoNacimiento,Edad,FamiliaDirecta,ObraSocial) values ('"+nombreApellido+"','"+dni+"','"+localidad+"','"+fechaNac+"','"+curso+"','"+escuela+"',"+pesoNac+","+edad+","+nroFamilia+","+obra+")");
       dat.insertar(agregarPaciente);
       
    }
    //borra la fila completa
    public void borrarPaciente() throws SQLException{//no va parametro pq toma de la propiedad
        PreparedStatement elimi= connect.prepareStatement("DELETE FROM Pacientes WHERE pacienteID='"+this.id+"'");//this.id
        Datos dat= new Datos();
        dat.borrar(elimi);
    }
    
    
    public void modificarPaciente () throws SQLException{
       Datos dat = new Datos();
       int obra = obraSocial ? 1:0;
       PreparedStatement modifpaciente = connect.prepareStatement("update Pacientes set NombreApellido = '"+nombreApellido+"',Dni = '"+dni+"' ,Localidad = '"+localidad+"',FechaNac ='"+fechaNac+"' ,Curso = '"+curso+"',Escuela ='"+escuela+"',PesoNacimiento ="+pesoNac+",Edad ="+edad+",FamiliaDirecta = "+nroFamilia+",ObraSocial="+obra+" where PacienteID ="+this.id+"");
       dat.actualizar(modifpaciente);
       
    }

    public ArrayList mostrarLista () throws SQLException{
       ResultSet result = null;
       PreparedStatement mostrarTabla= connect.prepareStatement("Select * From Pacientes");
       Datos dat = new Datos();
       ArrayList listaPacientes = new ArrayList();
       try{
       result= dat.seleccionar(mostrarTabla);
       while (result.next()){
                                Pacientes pac = new Pacientes();
                                pac.setId(result.getInt("PacienteID"));
                                pac.setNombreApellido(result.getString("NombreApellido"));
                                pac.setDni(result.getString("DNI"));
                                pac.setCurso(result.getString("Curso"));
                                pac.setEscuela(result.getString("Escuela"));
                                pac.setFechaNac(result.getDate("FechaNac").toLocalDate());
                                pac.setObraSocial(result.getBoolean("ObraSocial"));
                                pac.setEdad(result.getInt("Edad"));
                                pac.setPesoNac(result.getFloat("PesoNacimiento"));
                                pac.setLocalidad(result.getString("Localidad"));
                                pac.setNroFamilia(result.getInt("FamiliaDirecta"));
                                listaPacientes.add(pac);
                    }    
       
    }catch(Exception x){
        JOptionPane.showMessageDialog(null, x.getMessage().toString());  
    }
    return listaPacientes;
    }
}


