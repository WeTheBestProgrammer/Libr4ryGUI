/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Angga Maulana A
 */
public class ConnectionPerpus {
    public static ConnectionPerpus koneksi1;
    public static Connection getConnection(){
        
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection("jdbc:mysql://localhost/perpustakaan", "root", "");
            conn = DriverManager.getConnection("jdbc:mysql://192.168.100.4:3306/perpustakaan", "root", "pass");
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return conn;
    }


}
