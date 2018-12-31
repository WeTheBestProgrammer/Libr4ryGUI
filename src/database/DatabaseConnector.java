/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import gui.AdminTransaksiGUI;
import java.awt.HeadlessException;
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
    public static int harga = 0, tempCode, temp, total;
    static Date date, dtDate;
    
    public static void register(String fName, String lName, String username, String password, String alamat){
        Connector.buka_koneksi();
        PreparedStatement ps;
        String query = "INSERT INTO `admin`(`fname`, `lname`, `username`, `password`,`alamat`) VALUES (?,?,?,?,?);";
        try {
            ps = Connector.koneksi.prepareStatement(query);
            ps.setString(1, fName);
            ps.setString(2, lName);
            ps.setString(3, username);
            ps.setString(4, password);
            ps.setString(5, alamat);
            if(ps.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Data telah ditambah");
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    public static void setHarga(String kategori, String judul){
        Connector.buka_koneksi();
        ResultSet rs = null;
        
        String sql = "SELECT harga_sat from buku";
                    
        try {
            PreparedStatement mStatement = Connector.koneksi.prepareStatement(sql);
            Statement state = Connector.koneksi.createStatement();
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
        Connector.buka_koneksi();
        ResultSet rs = null;
        String sql = "SELECT harga_sat from buku";
        try {
            PreparedStatement mStatement = Connector.koneksi.prepareStatement(sql);
            Statement state = Connector.koneksi.createStatement();
            rs =  state.executeQuery("select harga_sat from buku where kategori = '" +kategori+ "' and judul ='" + judul + "'");
            while (rs.next()) {                
                harga = rs.getInt("harga_sat");
                AdminTransaksiGUI.harga = harga;
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
            Connector.buka_koneksi();
            ResultSet rs = null;
            Date datekembali = null, datenow;

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            datenow = date;
            int dendaterlambat = 0;
            String sql = "SELECT tanggalpinjam, tanggalkembali, dendaKeterlambatan from datatransaksi";
            PreparedStatement mStatement = Connector.koneksi.prepareStatement(sql);
            Statement state = Connector.koneksi.createStatement();
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
        Connector.buka_koneksi();
        ResultSet rs = null;
        
        String sql = "SELECT nomorPeminjam from datatransaksi";
                    
        try {
            PreparedStatement mStatement = Connector.koneksi.prepareStatement(sql);
            Statement state = Connector.koneksi.createStatement();
            rs =  state.executeQuery("select max(nomorPeminjam) from datatransaksi");
            while (rs.next()) {                
                tempCode = rs.getInt("max(nomorPeminjam)");
            }
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
    
    public static String getHarga(String kategori, String judul){
        Connector.buka_koneksi();
        ResultSet rs = null;
        String sql = "SELECT harga_sat from buku";
        try {
            PreparedStatement mStatement = Connector.koneksi.prepareStatement(sql);
            Statement state = Connector.koneksi.createStatement();
            rs =  state.executeQuery("select harga_sat from buku where kategori = '" + kategori + "' and judul ='" + judul + "'");
            while (rs.next()) {                
                return rs.getString("harga_sat");
            }
            mStatement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE); 
        }
        return null;
    }
    
    public static void getUpdateBuku(String kategori, String judul){
        ResultSet rs = null;
        String sql3 = "SELECT jml_buku from buku";
        try {
            int tempjumlah = 0;
            PreparedStatement updateStatement = Connector.koneksi.prepareStatement(sql3);
            Statement state = Connector.koneksi.createStatement();
            rs = state.executeQuery("select jml_buku from buku where kategori = '" + kategori + "' and judul ='" + judul + "'");
            while (rs.next()) {                
                tempjumlah = rs.getInt("jml_buku");
            }
            
            String updatejmlbuku = "UPDATE `buku` SET `jml_buku`= " + (tempjumlah-1) + " WHERE kategori = '" + kategori + "' and judul ='" + judul + "'";
            PreparedStatement pst = Connector.koneksi.prepareStatement(updatejmlbuku);
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
            Connector.buka_koneksi();
            Statement state = Connector.koneksi.createStatement();
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
            PreparedStatement mStatementIn = Connector.koneksi.prepareStatement(sqlin);
            mStatementIn.execute();
            mStatementIn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
    
    public static int setTextHarga(String kategori, String judul){
        Connector.buka_koneksi();
        ResultSet rs = null;
        String sql = "SELECT harga_sat from buku";
        try {
            PreparedStatement mStatement = Connector.koneksi.prepareStatement(sql);
            Statement state = Connector.koneksi.createStatement();
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
    
    public static int getJumlahBuku(String kategori, String judul){
        Connector.buka_koneksi();
        ResultSet rs = null;
        String sql = "select jml_buku from buku";
        
        try {
            PreparedStatement mStatement = Connector.koneksi.prepareStatement(sql);
            Statement state = Connector.koneksi.createStatement();
            rs = state.executeQuery("select jml_buku from buku where kategori = '" + kategori + "' and judul ='" + judul + "'");
            while (rs.next()) {
                return rs.getInt("jml_buku");
            }
            mStatement.close();
        } catch (Exception l) {
            System.err.println(l);
        }
        return 0;
    }
    
    public static int getDenda(String kategori, String judul){
        Connector.buka_koneksi();
        ResultSet rs = null;
        String sql = "select dendaKeterlambatan from buku";
        
        try {
            PreparedStatement mStatement = Connector.koneksi.prepareStatement(sql);
            Statement state = Connector.koneksi.createStatement();
            rs = state.executeQuery("select dendaKeterlambatan from buku where kategori = '" + kategori + "' and judul ='" + judul + "'");
            while (rs.next()) {
                return rs.getInt("dendaKeterlambatan");
            }
            mStatement.close();
        } catch (Exception l) {
            System.err.println(l);
        }
        return 0;
    }
    
    public static void addBuku(String kategori, String judul, String jumlahBuku, String hargaSat, String denda){
        Connector.buka_koneksi();
        try {
            String sql = "insert into buku (kategori, judul, jml_buku, harga_sat, dendaKeterlambatan) values "
                        + "('"+ kategori +"','"+ judul +"',"
                        + "'"+ jumlahBuku +"','"+ hargaSat +"',"
                        + "'" + denda +"')";
            PreparedStatement pst = Connector.koneksi.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "berhasil disimpan");
            pst.close();
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }   
    }
    
    public static void updateBuku(String kategori, String judul, String jumlahBuku, String hargaSat, String denda){
        Connector.buka_koneksi();
        try {
            String sql = "update buku SET kategori='"+ kategori +
                        "',judul='"+ judul +"',jml_buku='"+ jumlahBuku +
                        "',harga_sat='"+ hargaSat +
                        "',dendaKeterlambatan='" + denda +
                        "' where judul = '" + judul + "'";

            PreparedStatement pst = Connector.koneksi.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "berhasil disimpan");
            pst.close();
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}