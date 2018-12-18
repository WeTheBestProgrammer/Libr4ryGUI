/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;

/**
 *
 * @author Ahmad Musyadad A
 */
public class Conector {
    public static Connection koneksi;
    public static void buka_koneksi(){
        if (koneksi == null) {
            try {
//                String url = "jdbc:mysql://localhost/perpustakaan";
                
                String url = "jdbc:mysql://192.168.100.4:3306/perpustakaan";
                String user = "root";
//                String password = "";
                
                String password = "pass";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, user, password);
            } catch (SQLException t) {
                System.out.println("Error membuat koneksi");
            }
        }
    }
}
