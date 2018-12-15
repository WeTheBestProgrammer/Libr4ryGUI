/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import database.Conector;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author KINTUL
 */
public class AdminGUI extends javax.swing.JFrame {
    private static Connection koneksi;
    public boolean databaru;
    /**
     * Creates new form AdminGUI
     */
    public AdminGUI() {
        initComponents();
        ButtonGroup group = new ButtonGroup();
        group.add(ubahDataBukuRadioButton);
        group.add(tambahDataBukuRadioButton);
        jenisBukuComboBox.setEnabled(false);
        jenisBukuTambahComboBox.setEnabled(false);
        judulBukuComboBox.setEnabled(false);
        judulTambahTextField.setEnabled(false);
        jumlahBukuTextField.setEnabled(false);
        jumlahBukuTambahTextField.setEnabled(false);
        biayaPeminjamanTextField.setEnabled(false);
        biayaPeminjamanTambahTextField.setEnabled(false);
        logoutButton.setEnabled(false);
        saveButton.setEnabled(false);
        cancelButton.setEnabled(false);
        jenisBukuComboBox.setEnabled(false);
        saveTambahButton.setEnabled(false);
        cancelTambahButton.setEnabled(false);
        
    }
    
    private static void buka_koneksi(){
        if (koneksi == null) {
            try {
                String url = "jdbc:mysql://localhost/perpustakaan";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, user, password);
            } catch (SQLException t) {
                System.out.println("Error membuat koneksi");
            }
        }
    }
    
    private void isiComboBoxKategori(){
       buka_koneksi();
        ResultSet rs = null;
        String sql = "SELECT kategori from buku";
        try {
            PreparedStatement mStatement = koneksi.prepareStatement(sql);
            Statement state = koneksi.createStatement();
            rs =  state.executeQuery("select distinct kategori from buku");
            while (rs.next()) {                
                jenisBukuTambahComboBox.addItem(rs.getString("kategori"));
            }
            mStatement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE); 
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jMenu1 = new javax.swing.JMenu();
        buttonGroup = new javax.swing.ButtonGroup();
        jLabelJenisBuku = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jenisBukuComboBox = new javax.swing.JComboBox<>();
        jLabelJudulBuku = new javax.swing.JLabel();
        judulBukuComboBox = new javax.swing.JComboBox<>();
        jLabelJumlahBuku = new javax.swing.JLabel();
        jumlahBukuTextField = new javax.swing.JTextField();
        jLabelBiayaPeminjaman = new javax.swing.JLabel();
        biayaPeminjamanTextField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        ubahDataBukuRadioButton = new javax.swing.JRadioButton();
        tambahDataBukuRadioButton = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jenisBukuTambahComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jumlahBukuTambahTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        biayaPeminjamanTambahTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cancelTambahButton = new javax.swing.JButton();
        saveTambahButton = new javax.swing.JButton();
        judulTambahTextField = new javax.swing.JTextField();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelJenisBuku.setText("Jenis Buku");

        jenisBukuComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenisBukuComboBoxActionPerformed(evt);
            }
        });

        jLabelJudulBuku.setText("Judul Buku");

        jLabelJumlahBuku.setText("Jumlah Buku");

        jumlahBukuTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahBukuTextFieldActionPerformed(evt);
            }
        });

        jLabelBiayaPeminjaman.setText("Biaya Peminjaman");

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");

        logoutButton.setText("Logout");

        ubahDataBukuRadioButton.setText("Ubah Data Buku");
        ubahDataBukuRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahDataBukuRadioButtonActionPerformed(evt);
            }
        });

        tambahDataBukuRadioButton.setText("Tambah Data Buku");
        tambahDataBukuRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahDataBukuRadioButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Jenis Buku");

        jenisBukuTambahComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jenisBukuTambahComboBoxItemStateChanged(evt);
            }
        });
        jenisBukuTambahComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenisBukuTambahComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setText("Judul Buku");

        jLabel4.setText("Jumlah Buku");

        jLabel5.setText("Biaya Peminjaman");

        cancelTambahButton.setText("Cancel");

        saveTambahButton.setText("Save");
        saveTambahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveTambahButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(logoutButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(saveButton)
                                .addGap(18, 18, 18)
                                .addComponent(cancelButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelJenisBuku)
                                    .addComponent(jLabelJudulBuku)
                                    .addComponent(jLabelJumlahBuku))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jenisBukuComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(judulBukuComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jumlahBukuTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabelBiayaPeminjaman)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(biayaPeminjamanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(73, 73, 73)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2)
                                        .addGap(164, 164, 164)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(biayaPeminjamanTambahTextField)
                                    .addComponent(jumlahBukuTambahTextField)
                                    .addComponent(jenisBukuTambahComboBox, 0, 218, Short.MAX_VALUE)
                                    .addComponent(judulTambahTextField)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(saveTambahButton)
                                .addGap(18, 18, 18)
                                .addComponent(cancelTambahButton)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ubahDataBukuRadioButton)
                        .addGap(322, 322, 322)
                        .addComponent(tambahDataBukuRadioButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ubahDataBukuRadioButton)
                    .addComponent(tambahDataBukuRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelJenisBuku)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jenisBukuComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jenisBukuTambahComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelJudulBuku)
                            .addComponent(judulBukuComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelJumlahBuku)
                            .addComponent(jumlahBukuTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelBiayaPeminjaman)
                            .addComponent(biayaPeminjamanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveButton)
                            .addComponent(cancelButton)
                            .addComponent(logoutButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(judulTambahTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jumlahBukuTambahTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(biayaPeminjamanTambahTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelTambahButton)
                            .addComponent(saveTambahButton))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jumlahBukuTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahBukuTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jumlahBukuTextFieldActionPerformed

    private void jenisBukuComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenisBukuComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jenisBukuComboBoxActionPerformed

    private void tambahDataBukuRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahDataBukuRadioButtonActionPerformed
        // TODO add your handling code here:
        
        jenisBukuTambahComboBox.setEnabled(true);
        judulTambahTextField.setEnabled(true);
        jumlahBukuTambahTextField.setEnabled(true);
        biayaPeminjamanTambahTextField.setEnabled(true);
        saveTambahButton.setEnabled(true);
        cancelTambahButton.setEnabled(true);
        logoutButton.setEnabled(true);
        jenisBukuComboBox.setEnabled(false);
        judulBukuComboBox.setEnabled(false);
        jumlahBukuTextField.setEnabled(false);
        biayaPeminjamanTextField.setEnabled(false);
        saveButton.setEnabled(false);
        cancelButton.setEnabled(false);
        isiComboBoxKategori();
    }//GEN-LAST:event_tambahDataBukuRadioButtonActionPerformed

    private void ubahDataBukuRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahDataBukuRadioButtonActionPerformed
        // TODO add your handling code here:
        jenisBukuComboBox.setEnabled(true);
        judulBukuComboBox.setEnabled(true);
        jumlahBukuTextField.setEnabled(true);
        biayaPeminjamanTextField.setEnabled(true);
        saveButton.setEnabled(true);
        cancelButton.setEnabled(true);
        logoutButton.setEnabled(true);
        jenisBukuTambahComboBox.setEnabled(false);
        judulTambahTextField.setEnabled(false);
        jumlahBukuTambahTextField.setEnabled(false);
        biayaPeminjamanTambahTextField.setEnabled(false);
        saveTambahButton.setEnabled(false);
        cancelTambahButton.setEnabled(false);
        
    }//GEN-LAST:event_ubahDataBukuRadioButtonActionPerformed

    private void jenisBukuTambahComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenisBukuTambahComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jenisBukuTambahComboBoxActionPerformed

    private void jenisBukuTambahComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jenisBukuTambahComboBoxItemStateChanged
        // TODO add your handling code here:
//        judulBukuTambahComboBox.removeAllItems();
        buka_koneksi();
        ResultSet rs = null;
//        String ktgr = String.valueOf(jenisBukuTambahComboBox.getSelectedItem());
        String sql = "SELECT kategori from buku";
        try {
            PreparedStatement mStatement = koneksi.prepareStatement(sql);
            Statement state = koneksi.createStatement();
            rs =  state.executeQuery("select distinct kategori from buku");
                jenisBukuTambahComboBox.addItem(rs.getString("kategori"));
            mStatement.close();
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE); 
        }
    }//GEN-LAST:event_jenisBukuTambahComboBoxItemStateChanged

    private void saveTambahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveTambahButtonActionPerformed
        // TODO add your handling code here:
        buka_koneksi();
            try {
                String sql = "insert into buku (kategori, judul, harga_sat) values('"+jenisBukuTambahComboBox.getSelectedItem()+"','"+judulTambahTextField.getText()+"','"+biayaPeminjamanTambahTextField.getText()+"')";
    //            java.sql.Connection conn = (java.sql.Connection)gui.koneksi.koneksiDB();
                PreparedStatement pst = koneksi.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "berhasil disimpan");
                pst.close();
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }   
    }//GEN-LAST:event_saveTambahButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        buka_koneksi();
            try {
                String sql = "update buku SET kategori='"+jenisBukuComboBox.getSelectedItem()+"',judul='"+judulBukuComboBox.getSelectedItem()+"',harga_sat='"+biayaPeminjamanTextField.getText()+"'";
    //            java.sql.Connection conn = (java.sql.Connection)gui.koneksi.koneksiDB();
                PreparedStatement pst = koneksi.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "berhasil disimpan");
                pst.close();
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
    }//GEN-LAST:event_saveButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminGUI().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField biayaPeminjamanTambahTextField;
    private javax.swing.JTextField biayaPeminjamanTextField;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton cancelTambahButton;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelBiayaPeminjaman;
    private javax.swing.JLabel jLabelJenisBuku;
    private javax.swing.JLabel jLabelJudulBuku;
    private javax.swing.JLabel jLabelJumlahBuku;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> jenisBukuComboBox;
    private javax.swing.JComboBox<String> jenisBukuTambahComboBox;
    private javax.swing.JComboBox<String> judulBukuComboBox;
    private javax.swing.JTextField judulTambahTextField;
    private javax.swing.JTextField jumlahBukuTambahTextField;
    private javax.swing.JTextField jumlahBukuTextField;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton saveTambahButton;
    private javax.swing.JRadioButton tambahDataBukuRadioButton;
    private javax.swing.JRadioButton ubahDataBukuRadioButton;
    // End of variables declaration//GEN-END:variables
}
