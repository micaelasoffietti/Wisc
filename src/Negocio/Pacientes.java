
package Negocio;

import Datos.Datos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import Presentacion.MostrarPacientes;

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
        this.id = id;
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

    //conectar la base de datos
     public void conectar(String URL){
       Datos dat = new Datos();
       dat.conectarBase(URL);
    }
    //busca todos los pacientes
    public void mostrar (DefaultTableModel model){
       Datos dat = new Datos();
       dat.seleccionar(model);
    }
   
    //busca un paciente por id
    //pusimos buscar el dni solamente a modo de ejemplo
    public void buscarId (int id){
       Datos dat = new Datos();
       dat.seleccionarId(id);
    }
    
    //ingresa paciente
    public void agregarPaciente (){
       Datos dat = new Datos();
       int obra = obraSocial ? 1:0;
       String nuevopaciente = ("insert into Pacientes (NombreApellido,Dni,Localidad,FechaNac,Curso,Escuela,PesoNacimiento,Edad,FamiliaDirecta,ObraSocial) values ('"+nombreApellido+"','"+dni+"','"+localidad+"','"+fechaNac+"','"+curso+"','"+escuela+"',"+pesoNac+","+edad+","+nroFamilia+","+obra+")");
       dat.insertar(nuevopaciente);
       
    }
    //borra la fila completa
    public void borrarPaciente(String y){
        Datos dat= new Datos();
        dat.borrar(y);
    }
    
    //modificar una columna de la fila
    public void actualizarPaciente(int id, String nombreApe, String dni, String curso, String escuela,String fechaNac,boolean obraSocial, int edad, float pesoNac, String localidad ){
        Datos dat= new Datos();
        dat.actualizar(id,nombreApe,dni,curso,escuela,fechaNac,obraSocial,edad,pesoNac,localidad);
    
    }
}
