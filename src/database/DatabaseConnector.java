/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;

/**
 *
 * @author KINTUL
 */
public class DatabaseConnector {
    private static Connection koneksi;
    int harga = 0;
    
    private static void buka_koneksi(){
        if (koneksi == null) {
            try {
//                String url = "jdbc:mysql://localhost/perpustakaan";
                String url = "jdbc:mysql://192.168.100.4:3306/perpustakaan";
                String user = "root";
                String password = "pass";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, user, password);
            } catch (SQLException t) {
//                System.out.println("Error membuat koneksi");
                System.err.print(t);
            }
        }
    }
    
    public void setHarga(String kategori, String judul){
        buka_koneksi();
        ResultSet rs = null;
        
        String sql = "SELECT harga_sat from buku";
                    
        try {
            PreparedStatement mStatement = koneksi.prepareStatement(sql);
            Statement state = koneksi.createStatement();
            rs =  state.executeQuery("select harga_sat from buku where kategori = '" + kategori + "' and judul ='" + judul + "'");
            while (rs.next()) {                
                harga = rs.getInt("harga_sat");
            }
                mStatement.close();
        } catch (Exception l) {
            System.err.println(l);
        }
    }
}
