/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author alexh_000
 */
public class Conex {
    
    public static Connection getConnection(){
        
        Connection conn;
        
        try {
            //conectar com banco de dados
            Class.forName("com.mysql.jdbc.Driver");
            String host = "jdbc:mysql://localhost/alfajava";
            String user = "root";
            String pass = "";
            conn = DriverManager.getConnection(host, user, pass);
        }
        catch (Exception e) {
            conn = null;
        }
        return conn;
    }
    
}
