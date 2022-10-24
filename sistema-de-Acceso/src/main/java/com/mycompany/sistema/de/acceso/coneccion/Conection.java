/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistema.de.acceso.coneccion;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose Eduardo Orozco Cardenas <eduardo.orozco66@unach.mx>
 */
public class Conection {

    
    Connection con = null;
    String user="postgres";
    String password="12345";
    public Boolean ban = false;
    

    //variables para guardar los datos de acceso a la bd
    private final String url = "jdbc:postgresql://localhost:5432/aseguradora";

    //metodo para conectar la bd, es una clase de tipo Connection 
    public Connection conectar() {
        try {
            //manejo del Driver
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("BD CONECTADA");
            ban = true;
        } catch (ClassNotFoundException | SQLException e) {
            //excepcion sql
            JOptionPane.showMessageDialog(null, "Error en su conexion ", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
            ban = false;

        }
        return con;
    }

    public Statement getConexion() {
        Statement stmt = null;
        return stmt;
    }

    public Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

