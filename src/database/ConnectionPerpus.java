/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Angga Maulana A
 */
public class ConnectionPerpus {
    public static Connection koneksi2;
    public static void buka_koneksi(){
        if (koneksi2 == null) {
            try {
//                String url = "jdbc:mysql://localhost/perpustakaan";
                String url = "jdbc:mysql://192.168.100.4:3306/perpustakaan";
                String user = "root";
//                String password = "";
                String password = "pass";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi2 = DriverManager.getConnection(url, user, password);
            } catch (SQLException t) {
                System.out.println("Error membuat koneksi");
            }
        }
    }
}
//public class ConnectionPerpus {
//    public static ConnectionPerpus koneksi1;
//    public static Connection getConnection(){
//        
//        Connection conn = null;
//        try{
//            Class.forName("com.mysql.jdbc.Driver");
////            conn = DriverManager.getConnection("jdbc:mysql://localhost/perpustakaan", "root", "");
//            conn = DriverManager.getConnection("jdbc:mysql://192.168.100.4:3306/perpustakaan", "root", "pass");
//        } catch (Exception ex){
//            System.out.println(ex.getMessage());
//        }
//        return conn;
//    }
//
//    public PreparedStatement prepareStatement(String queryString) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }



