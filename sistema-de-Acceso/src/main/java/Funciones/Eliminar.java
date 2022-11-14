/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funciones;

import coneccion.Conection;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Emili
 */
public class Eliminar {

    private final Conection c = new Conection();

    Statement st; //Para uso de sentencia Sql
    Connection conexion;

    public void eliminar_profesor(String numero_plaza) {
        try {
            Connection conexiion = c.conectar();
            st = conexiion.createStatement();
            String sql = "Delete from profesores where num_plaza = '" + numero_plaza + "';";
            st.execute(sql);
            st.close();
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar");
        }
    }

}
