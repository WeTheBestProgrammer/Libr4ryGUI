/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.Date;

/**
 *
 * @author KINTUL
 */
public class DatabaseConnector {
    private static Connection koneksi;
    public static int harga = 0, tempCode;
    static Date date, dtDate;
    
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
                System.err.print(t);
            }
        }
    }
    
    public static void setHarga(String kategori, String judul){
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
    
    public static String setTotalBiaya(String kategori, String judul, int lamaPinjam){
        buka_koneksi();
        ResultSet rs = null;
        String sql = "SELECT harga_sat from buku";
        try {
            PreparedStatement mStatement = koneksi.prepareStatement(sql);
            Statement state = koneksi.createStatement();
            rs =  state.executeQuery("select harga_sat from buku where kategori = '" +kategori+ "' and judul ='" + judul + "'");
            while (rs.next()) {                
                harga = rs.getInt("harga_sat");
                return harga + " X " + lamaPinjam + " = " + (harga*lamaPinjam);
            }
            mStatement.close();
        } catch (Exception l) {
            return harga + "";
        }
        return null;
    }
    
    public static void cekNomorPeminjaman(String nomorPinjam){
        try {
            buka_koneksi();
            ResultSet rs = null;
            Date datekembali = null, datenow;

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            datenow = date;
            int dendaterlambat = 0;
            String sql = "SELECT tanggalpinjam, tanggalkembali, dendaKeterlambatan from datatransaksi";
            PreparedStatement mStatement = koneksi.prepareStatement(sql);
            Statement state = koneksi.createStatement();
            rs =  state.executeQuery("SELECT tanggalpinjam, tanggalkembali, dendaKeterlambatan from datatransaksi where nomorPeminjam = " 
                + Integer.parseInt(nomorPinjam));

            while (rs.next()) {
                datekembali = sdf.parse(rs.getString("tanggalkembali"));
                dendaterlambat = rs.getInt("dendaKeterlambatan");
            }

            if (datekembali.before(datenow)) {
                long diffInMillies = Math.abs(datenow.getTime() - datekembali.getTime());
                long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                int denda = (int)diff * dendaterlambat;
            }
        } catch (Exception e) {
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());
        }
    }
    public static String checkCode(String code){
        buka_koneksi();
        ResultSet rs = null;
        
        String sql = "SELECT nomorPeminjam from datatransaksi";
                    
        try {
            PreparedStatement mStatement = koneksi.prepareStatement(sql);
            Statement state = koneksi.createStatement();
            rs =  state.executeQuery("select count(nomorPeminjam) from datatransaksi where nomorPeminjam = " + code + "");
            while (rs.next()) {                
                tempCode = rs.getInt("count(nomorPeminjam)");
            }
            System.out.println(tempCode);
            if (tempCode > 0) {
                int temp = Integer.parseInt(code);
                temp+= tempCode;
                return String.valueOf(temp);
            }
            mStatement.close();
        } catch (Exception l) {
            System.err.println(l);
        }
        return code;
    }
}