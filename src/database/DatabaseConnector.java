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
import javax.swing.JOptionPane;

/**
 *
 * @author KINTUL
 */
public class DatabaseConnector {
    private static Connection koneksi;
    public static int harga = 0, tempCode, temp, total;
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
                total = harga*lamaPinjam;
                return harga + " X " + lamaPinjam + " = " + total;
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
            rs =  state.executeQuery("select max(nomorPeminjam) from datatransaksi");
            while (rs.next()) {                
                tempCode = rs.getInt("max(nomorPeminjam)");
            }
            System.out.println(tempCode);
            if (tempCode >= Integer.parseInt(code)) {
                tempCode++;
                return String.valueOf(tempCode);
            } else {
                return String.valueOf(code);
            }
//            mStatement.close();
        } catch (Exception l) {
            System.err.println(l);
        }
        return String.valueOf(tempCode);
    }
    
    public static int getHarga(String kategori, String judul){
        Conector.buka_koneksi();
        ResultSet rs = null;
        String sql = "SELECT harga_sat from buku";
        try {
            PreparedStatement mStatement = Conector.koneksi.prepareStatement(sql);
            Statement state = Conector.koneksi.createStatement();
            rs =  state.executeQuery("select harga_sat from buku where kategori = '" + kategori + "' and judul ='" + judul + "'");
            while (rs.next()) {                
                return harga = rs.getInt("harga_sat");
            }
            mStatement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE); 
        }
        return 0;
    }
    
    public static void getUpdateBuku(String kategori, String judul){
        ResultSet rs = null;
        String sql3 = "SELECT jml_buku from buku";
        try {
            int tempjumlah = 0;
            PreparedStatement updateStatement = Conector.koneksi.prepareStatement(sql3);
            Statement state = Conector.koneksi.createStatement();
            rs = state.executeQuery("select jml_buku from buku where kategori = '" + kategori + "' and judul ='" + judul + "'");
            while (rs.next()) {                
                tempjumlah = rs.getInt("jml_buku");
            }
            
            String updatejmlbuku = "UPDATE `buku` SET `jml_buku`= " + (tempjumlah-1) + " WHERE kategori = '" + kategori + "' and judul ='" + judul + "'";
            PreparedStatement pst = Conector.koneksi.prepareStatement(updatejmlbuku);
            pst.execute();
            pst.close();
        } catch (Exception e) {
            System.err.print(e);
        }
    }
    
    public static void insertDataTransaksi(String judul, String kategori, int nomorPinjam,
            String nama, String tanggalPinjam, String tanggalKembali, int lamaPinjam){
        int dendaString = 0;
        try {
            Conector.buka_koneksi();
            Statement state = Conector.koneksi.createStatement();
            ResultSet denda = state.executeQuery("select dendaKeterlambatan from buku where judul = '" 
                              + judul + "' and kategori = '" + kategori + "'");
             
            while (denda.next()) {                
                dendaString = denda.getInt("dendaKeterlambatan");
            }
            String sqlin = "INSERT INTO `datatransaksi`(`nomorPeminjam`, `nama`, `judul`, `tanggalpinjam`, `tanggalkembali`, `lamaPinjam`, `biaya`, `dendaKeterlambatan`)"
                            + " VALUES ("+ nomorPinjam + ",' "
                            + nama +"', '"
                            + judul + "', "
                            + tanggalPinjam + ", "
                            + tanggalKembali + ", "
                            + lamaPinjam + ", "
                            + total + ", "
                            + dendaString + ")";
            PreparedStatement mStatementIn = Conector.koneksi.prepareStatement(sqlin);
            mStatementIn.execute();
            mStatementIn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
    
    public static int setTextHarga(String kategori, String judul){
        buka_koneksi();
        ResultSet rs = null;
        String sql = "SELECT harga_sat from buku";
        try {
            PreparedStatement mStatement = Conector.koneksi.prepareStatement(sql);
            Statement state = Conector.koneksi.createStatement();
            rs =  state.executeQuery("select harga_sat from buku where kategori = '" + kategori + "' and judul ='" + judul + "'");
            while (rs.next()) {                
                harga = rs.getInt("harga_sat");
                return harga;
            }
            mStatement.close();
        } catch (Exception l) {
            JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE); 
        }
        return 0;
    }
}