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
public class Modificar {
    
    Connection conexion;
    Conection c = new Conection();
    Statement st;
    ResultSet rs;
    
    public Modificar(){
        conexion=c.conectar();
    }
    
    
//    public void modificar_profesor(String nombre_p, String ap_pat, String ap_mat, String num_plaza){
//        try
//        {
//            st=conexion.createStatement();
//            String sql ="update profesores set nombre_p = '"+nombre_p+"', ap_pat = '"+ap_pat+"', ap_mat = '"+ap_mat+"' where num_plaza = '"+num_plaza+"';";
//            st.execute(sql);
//            st.close();
//            JOptionPane.showMessageDialog(null, "El registro se actualizo", "Exito", JOptionPane.INFORMATION_MESSAGE);
//            
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "Error al actualizar " + e, "Error", JOptionPane.ERROR_MESSAGE);
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }
    
//    public void modificar_profesor(String nombre_p, String ap_pat, String ap_mat, String num_plaza){
//        try
//        {
//            st=conexion.createStatement();
//            String sql ="update profesores set nombre_p ='"+nombre_p+"', ap_pat = '"+ap_pat+"', ap_mat = '"+ap_mat+"' where num_plaza = '"+num_plaza+"';";
//            st.execute(sql);
//            st.close();
//            JOptionPane.showMessageDialog(null, "El registro se actualizo", "Exito", JOptionPane.INFORMATION_MESSAGE);
//            
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "Error al actualizar " + e, "Error", JOptionPane.ERROR_MESSAGE);
//            JOptionPane.showMessageDialog(null, e);
//        }
//    }  
    
        public void modificar_profesor (String nombre_p, String ap_pat, String ap_mat, String num_plaza) {
        
        try {
            st = conexion.createStatement();
            String sql = "update profesores set nombre_p='" + nombre_p +"', ap_pat='" + ap_pat + "',ap_mat='" + ap_mat + "' where num_plaza ='" + num_plaza + "'; ";
            st.executeUpdate(sql);
            st.close();
            
            JOptionPane.showMessageDialog(null, "El registro se actualizo", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
