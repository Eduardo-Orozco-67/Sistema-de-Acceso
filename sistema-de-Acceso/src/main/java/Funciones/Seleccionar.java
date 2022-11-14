/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import coneccion.Conection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Emili
 */
public class Seleccionar {
    
    Statement st;
    ResultSet res;
    Connection conexion;
    //Connection cone = null;
    private final Conection c = new Conection();
    public Seleccionar (){
        Conection c = new Conection();
        conexion = c.conectar();
    }
    
     public Seleccionar (Connection conexion){
        this.conexion = conexion;
    }
     
    public String [] numplaza_profesor(){
        String sql = "select num_plaza from profesores;";
        String []x = new String[1];
        try{
           st=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
           res=st.executeQuery(sql);
           res.last();
           int filas = res.getRow();
           res.beforeFirst();
           x = new String[filas];
           filas = 0;
           while(res.next()){
               x[filas]=res.getString("num_plaza");
               filas++;
           }  
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e.getMessage() );
           System.out.println(e.getMessage());
        }finally{
            try {
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage() );
            }
        }
        return x;
    }
    
    public String [] profesor_plazabusq(String plaza){
        String sql = "select nombre_p, ap_pat, ap_mat from profesores where num_plaza = '"+plaza+"' ;";      
        String []x = new String[4];
        try{
           st=conexion.createStatement();   
           res=st.executeQuery(sql);
           while(res.next())
           {
               x[0]=res.getString("nombre_p");
               x[1]=res.getString("ap_pat");
               x[2]=res.getString("ap_mat");
           }  
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e.getMessage() );
           System.out.println(e.getMessage());
        }finally{
            try {
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage() );
            }
        }
        return x;
    }
    
    public String [] datos_visita (String matricula){ 
        String sql = "select l.nombre_lab, v.hora, v.fecha from alumnos as a inner join visitas as v on a.id_alumno = v.id_alumno inner join laboratorio as l on v.id_lab = l.id_lab where a.matricula = '"+matricula+"';";      
        String []x = new String[3];
        try{
           st=conexion.createStatement();   
           res=st.executeQuery(sql);
           while(res.next())
           {
               x[0]=res.getString("nombre_lab");
               x[1]=res.getString("hora");
               x[2]=res.getString("fecha");
           }  
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e.getMessage() );
           System.out.println(e.getMessage());
        }finally{
            try {
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage() );
            }
        }
        return x;
    }
    
    /// PEDRO OCTAVIO CULEBRO PRADO
    
    public String [] seleccionar_carrera(){
        String sql = "select * from carrera;";      
        String []x = new String[2];
        try{
           st=conexion.createStatement();   
           res=st.executeQuery(sql);
           while(res.next())
           {
               x[0]=res.getString("id_carrera");
               x[1]=res.getString("nom_carrera");

           }  
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e.getMessage() );
           System.out.println(e.getMessage());
        }finally{
            try {
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage() );
            }
        }
        return x;
        
    }
    
    //Para el j text de alumnos
    public String [] matricula_alumno(){
        String sql = "select matricula from alumnos;";
        String []x = new String[1];
        try{
           st=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
           res=st.executeQuery(sql);
           res.last();
           int filas = res.getRow();
           res.beforeFirst();
           x = new String[filas];
           filas = 0;
           while(res.next()){
               x[filas]=res.getString("matricula");
               filas++;
           }  
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e.getMessage() );
           System.out.println(e.getMessage());
        }finally{
            try {
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage() );
            }
        }
        return x;
    }
    
    public String [] seleccionar_alumno(String matricula){
        String sql = "select al.nombre_a, al.ap_pat, al.ap_mat, al.semestre, al.grupo, al.telefono_a, al.correo_a, carr.nom_carrera, al.tipo_alumno from Alumnos al INNER JOIN carrera carr ON al.id_carrera = carr.id_carrera where matricula = '"+matricula+"';";      
        String []x = new String[10];
        try{
           st=conexion.createStatement();   
           res=st.executeQuery(sql);
           while(res.next())
           {
               
               
               x[1]=res.getString("nombre_a");
               x[2]=res.getString("ap_pat");
               x[3]=res.getString("ap_mat");
               x[4]=res.getString("semestre");
               x[5]=res.getString("grupo");
               x[6]=res.getString("telefono_a");
               x[7]=res.getString("correo_a");
               x[8]=res.getString("nom_carrera");
               x[9]=res.getString("tipo_alumno");
           }  
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e.getMessage() );
           System.out.println(e.getMessage());
        }finally{
            try {
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage() );
            }
        }
        return x;
    }
        public String [] seleccionar_alumnos(){
        String sql = "select al.matricula, al.nombre_a, al.ap_pat, al.ap_mat, al.semestre, al.grupo, al.telefono_a, al.correo_a, carr.nom_carrera, al.tipo_alumno from Alumnos al INNER JOIN carrera carr ON carr.id_carrera = carr.id_carrera;";      
        String []x = new String[10];
        try{
           st=conexion.createStatement();   
           res=st.executeQuery(sql);
           while(res.next())
           {
               
               x[0]=res.getString("matricula");
               x[1]=res.getString("nombre_a");
               x[2]=res.getString("ap_pat");
               x[3]=res.getString("ap_mat");
               x[4]=res.getString("semestre");
               x[5]=res.getString("grupo");
               x[6]=res.getString("telefono_a");
               x[7]=res.getString("correo_a");
               x[8]=res.getString("nom_carrera");

           }  
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e.getMessage() );
           System.out.println(e.getMessage());
        }finally{
            try {
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage() );
            }
        }
        return x;
        }
        

        public String [] seleccionar_administrativo(String id_admin){
        String sql = "select * from administrativo where id_admin = '"+id_admin+"';";      
        String []x = new String[4];
        try{
           st=conexion.createStatement();   
           res=st.executeQuery(sql);
           while(res.next())
           {
               x[0]=res.getString("id_admin");
               x[1]=res.getString("nombre_admin");
               x[2]=res.getString("ap_pat");
               x[3]=res.getString("ap_mat");

           }  
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e.getMessage() );
           System.out.println(e.getMessage());
        }finally{
            try {
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage() );
            }
        }
        return x;
    
        }
        
       public String [] id_admin(){
        String sql = "select id_admin from administrativo;";
        String []x = new String[1];
        try{
           st=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
           res=st.executeQuery(sql);
           res.last();
           int filas = res.getRow();
           res.beforeFirst();
           x = new String[filas];
           filas = 0;
           while(res.next()){
               x[filas]=res.getString("id_admin");
               filas++;
           }  
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e.getMessage() );
           System.out.println(e.getMessage());
        }finally{
            try {
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage() );
            }
        }
        return x;
    } 

    public String [] nombre_materia(){
        String sql = "select nom_materia from materias;";
        String []x = new String[1];
        try{
           st=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
           res=st.executeQuery(sql);
           res.last();
           int filas = res.getRow();
           res.beforeFirst();
           x = new String[filas];
           filas = 0;
           while(res.next()){
               x[filas]=res.getString("nom_materia");
               filas++;
           }  
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e.getMessage() );
           System.out.println(e.getMessage());
        }finally{
            try {
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage() );
            }
        }
        return x;
    }
    
        public String [] seleccionar_materias(String nom_materia){
        String sql = "select ma.nom_materia, ma.semestre, carr.nom_carrera from materias ma INNER JOIN carrera carr ON carr.id_carrera = ma.id_carrera WHERE nom_materia = '"+nom_materia+"';";      
        String []x = new String[4];
        try{
           st=conexion.createStatement();   
           res=st.executeQuery(sql);
           while(res.next())
           {
               x[0]=res.getString("nom_materia");
               x[1]=res.getString("semestre");
               x[2]=res.getString("nom_carrera");

           }  
        }catch(Exception e){
           JOptionPane.showMessageDialog(null,e.getMessage() );
           System.out.println(e.getMessage());
        }finally{
            try {
                st.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage() );
            }
        }
        return x;
    
        }   
}
