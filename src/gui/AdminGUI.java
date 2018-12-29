/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import database.Connector;
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
    int jml = 0, harga = 0, denda = 0;
    /**
     * Creates new form AdminGUI
     */
    public AdminGUI() {
        initComponents();
        ButtonGroup group = new ButtonGroup();
        group.add(ubahDataBukuRadioButton);
        group.add(tambahDataBukuRadioButton);
        group.add(hapusDataBukuRadioButton);
        jenisBukuComboBox.setEnabled(false);
        jenisBukuTambahComboBox.setEnabled(false);
        judulBukuComboBox.setEnabled(false);
        judulTambahTextField.setEnabled(false);
        jumlahBukuTextField.setEnabled(false);
        jumlahBukuTambahTextField.setEnabled(false);
        biayaPeminjamanTextField.setEnabled(false);
        biayaPeminjamanTambahTextField.setEnabled(false);
        dendaPeminjamanTextField.setEnabled(false);
        dendaPeminjamanTambahTextField.setEnabled(false);
        logoutButton.setEnabled(false);
        saveButton.setEnabled(false);
        cancelButton.setEnabled(false);
        jenisBukuComboBox.setEnabled(false);
        saveTambahButton.setEnabled(false);
        cancelTambahButton.setEnabled(false);
        jenisBukuHapusComboBox.setEnabled(false);
        judulBukuHapusComboBox.setEnabled(false);
        saveHapusButton.setEnabled(false);
        cancelHapusButton.setEnabled(false);
        jenisBukuTambahComboBox.addItemListener(e -> {
        Object selectedItem = jenisBukuTambahComboBox.getSelectedItem();
        boolean editable = selectedItem instanceof String
            && ((String) selectedItem).equals("Other");
        jenisBukuTambahComboBox.setEditable(editable);
    });
 
    }
    
    private static void buka_koneksi(){
        if (koneksi == null) {
            try {
                String url = "jdbc:mysql://localhost/perpustakaan";
//                String url = "jdbc:mysql://192.168.80.103:3306/perpustakaan";
                String user = "root";
                String password = "";
//                String password = "pass";
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
            System.err.println(e);
        }
        jenisBukuTambahComboBox.addItem("Other");
    }
    
    private void isiComboBoxUbah(){
        buka_koneksi();
        ResultSet rs = null;
        String sql = "SELECT kategori from buku";
        try {
            PreparedStatement mStatement = koneksi.prepareStatement(sql);
            Statement state = koneksi.createStatement();
            rs =  state.executeQuery("select distinct kategori from buku");
            while (rs.next()) {                
                jenisBukuComboBox.addItem(rs.getString("kategori"));
            }
            mStatement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE); 
        }    
    }
    
    private void isiComboBoxHapus(){
        buka_koneksi();
        ResultSet rs = null;
        String sql = "SELECT kategori from buku";
        try {
            PreparedStatement mStatement = koneksi.prepareStatement(sql);
            Statement state = koneksi.createStatement();
            rs =  state.executeQuery("select distinct kategori from buku");
            while (rs.next()) {                
                jenisBukuHapusComboBox.addItem(rs.getString("kategori"));
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
        hapusDataBukuRadioButton = new javax.swing.JRadioButton();
        jenisBukuHapusComboBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        judulBukuHapusComboBox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cancelHapusButton = new javax.swing.JButton();
        saveHapusButton = new javax.swing.JButton();
        dendaPeminjamanTambahTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        dendaPeminjamanTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelJenisBuku.setText("Jenis Buku");

        jenisBukuComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jenisBukuComboBoxItemStateChanged(evt);
            }
        });
        jenisBukuComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenisBukuComboBoxActionPerformed(evt);
            }
        });

        jLabelJudulBuku.setText("Judul Buku");

        judulBukuComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                judulBukuComboBoxItemStateChanged(evt);
            }
        });
        judulBukuComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                judulBukuComboBoxActionPerformed(evt);
            }
        });

        jLabelJumlahBuku.setText("Jumlah Buku");

        jumlahBukuTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahBukuTextFieldActionPerformed(evt);
            }
        });

        jLabelBiayaPeminjaman.setText("Biaya Peminjaman");

        biayaPeminjamanTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                biayaPeminjamanTextFieldActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

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
        cancelTambahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelTambahButtonActionPerformed(evt);
            }
        });

        saveTambahButton.setText("Save");
        saveTambahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveTambahButtonActionPerformed(evt);
            }
        });

        hapusDataBukuRadioButton.setText("Hapus Data Buku");
        hapusDataBukuRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusDataBukuRadioButtonActionPerformed(evt);
            }
        });

        jenisBukuHapusComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jenisBukuHapusComboBoxItemStateChanged(evt);
            }
        });

        jLabel6.setText("Jenis Buku");

        judulBukuHapusComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                judulBukuHapusComboBoxItemStateChanged(evt);
            }
        });
        judulBukuHapusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                judulBukuHapusComboBoxActionPerformed(evt);
            }
        });

        jLabel7.setText("Judul Buku");

        cancelHapusButton.setText("Cancel");
        cancelHapusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelHapusButtonActionPerformed(evt);
            }
        });

        saveHapusButton.setText("Save");
        saveHapusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveHapusButtonActionPerformed(evt);
            }
        });

        jLabel8.setText("Denda Keterlambatan");

        dendaPeminjamanTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dendaPeminjamanTextFieldActionPerformed(evt);
            }
        });

        jLabel9.setText("Denda Keterlambatan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelJenisBuku)
                                    .addComponent(jLabelJudulBuku)
                                    .addComponent(jLabelJumlahBuku))
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jenisBukuComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(judulBukuComboBox, 0, 189, Short.MAX_VALUE)
                                        .addComponent(jumlahBukuTextField)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelBiayaPeminjaman)
                                    .addComponent(jLabel9))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(biayaPeminjamanTextField)
                                    .addComponent(dendaPeminjamanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(logoutButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(saveButton)
                                        .addGap(101, 101, 101))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(86, 86, 86)
                                        .addComponent(cancelButton)
                                        .addGap(1, 1, 1)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 187, Short.MAX_VALUE)
                                .addComponent(saveTambahButton)
                                .addGap(18, 18, 18)
                                .addComponent(cancelTambahButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(164, 164, 164)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jumlahBukuTambahTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(judulTambahTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jenisBukuTambahComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(biayaPeminjamanTambahTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                    .addComponent(dendaPeminjamanTambahTextField))))
                        .addGap(66, 66, 66))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ubahDataBukuRadioButton)
                        .addGap(238, 238, 238)
                        .addComponent(tambahDataBukuRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(judulBukuHapusComboBox, 0, 195, Short.MAX_VALUE)
                            .addComponent(jenisBukuHapusComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hapusDataBukuRadioButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(saveHapusButton)
                                .addGap(18, 18, 18)
                                .addComponent(cancelHapusButton)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ubahDataBukuRadioButton)
                    .addComponent(tambahDataBukuRadioButton)
                    .addComponent(hapusDataBukuRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelJenisBuku)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jenisBukuComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jenisBukuTambahComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jenisBukuHapusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(judulTambahTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(judulBukuHapusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelHapusButton)
                            .addComponent(saveHapusButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(judulBukuComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelJudulBuku))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jumlahBukuTambahTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jumlahBukuTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelJumlahBuku))))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(biayaPeminjamanTambahTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(biayaPeminjamanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBiayaPeminjaman))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dendaPeminjamanTambahTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(dendaPeminjamanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cancelTambahButton)
                        .addComponent(saveTambahButton))
                    .addComponent(cancelButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(saveButton)
                        .addComponent(logoutButton)))
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
        dendaPeminjamanTambahTextField.setEnabled(true);
        saveTambahButton.setEnabled(true);
        cancelTambahButton.setEnabled(true);
        logoutButton.setEnabled(true);
        jenisBukuComboBox.setEnabled(false);
        jenisBukuComboBox.removeAllItems();
        judulBukuComboBox.setEnabled(false);
        judulBukuComboBox.removeAllItems();
        jumlahBukuTextField.setEnabled(false);
        jumlahBukuTextField.setText("");
        biayaPeminjamanTextField.setEnabled(false);
        biayaPeminjamanTextField.setText("");
        dendaPeminjamanTextField.setEnabled(false);
        dendaPeminjamanTextField.setText("");
        saveButton.setEnabled(false);
        cancelButton.setEnabled(false);
        jenisBukuHapusComboBox.setEnabled(false);
        jenisBukuHapusComboBox.removeAllItems();
        judulBukuHapusComboBox.setEnabled(false);
        judulBukuHapusComboBox.removeAllItems();
        saveHapusButton.setEnabled(false);
        cancelHapusButton.setEnabled(false);
        isiComboBoxKategori();
    }//GEN-LAST:event_tambahDataBukuRadioButtonActionPerformed

    private void ubahDataBukuRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahDataBukuRadioButtonActionPerformed
        // TODO add your handling code here:
        jenisBukuComboBox.setEnabled(true);
        judulBukuComboBox.setEnabled(true);
        jumlahBukuTextField.setEnabled(true);
        biayaPeminjamanTextField.setEnabled(true);
        dendaPeminjamanTextField.setEnabled(true);
        saveButton.setEnabled(true);
        cancelButton.setEnabled(true);
        logoutButton.setEnabled(true);
        jenisBukuTambahComboBox.setEnabled(false);
        jenisBukuTambahComboBox.removeAllItems();
        judulTambahTextField.setEnabled(false);
        judulTambahTextField.setText("");
        jumlahBukuTambahTextField.setEnabled(false);
        jumlahBukuTambahTextField.setText("");
        biayaPeminjamanTambahTextField.setEnabled(false);
        biayaPeminjamanTambahTextField.setText("");
        dendaPeminjamanTambahTextField.setEnabled(false);
        dendaPeminjamanTambahTextField.setText("");
        saveTambahButton.setEnabled(false);
        cancelTambahButton.setEnabled(false);
        jenisBukuHapusComboBox.setEnabled(false);
        jenisBukuHapusComboBox.removeAllItems();
        judulBukuHapusComboBox.setEnabled(false);
        judulBukuHapusComboBox.removeAllItems();
        saveHapusButton.setEnabled(false);
        cancelHapusButton.setEnabled(false);
        isiComboBoxUbah();
    }//GEN-LAST:event_ubahDataBukuRadioButtonActionPerformed

    private void jenisBukuTambahComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenisBukuTambahComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jenisBukuTambahComboBoxActionPerformed

    private void jenisBukuTambahComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jenisBukuTambahComboBoxItemStateChanged
        // TODO add your handling code here:
//        judulBukuTambahComboBox.removeAllItems();
    }//GEN-LAST:event_jenisBukuTambahComboBoxItemStateChanged

    private void saveTambahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveTambahButtonActionPerformed
        // TODO add your handling code here:
        buka_koneksi();
            try {
                String sql = "insert into buku (kategori, judul, jml_buku, harga_sat, dendaKeterlambatan) values "
                        + "('"+jenisBukuTambahComboBox.getSelectedItem()+"','"+judulTambahTextField.getText()+"',"
                        + "'"+jumlahBukuTambahTextField.getText()+"','"+biayaPeminjamanTambahTextField.getText()+"',"
                        + "'" +dendaPeminjamanTambahTextField.getText()+"')";
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
                String sql = "update buku SET kategori='"+jenisBukuComboBox.getSelectedItem()+
                        "',judul='"+judulBukuComboBox.getSelectedItem()+"',jml_buku='"+jumlahBukuTextField.getText()+
                        "',harga_sat='"+biayaPeminjamanTextField.getText()+
                        "',dendaKeterlambatan='" + dendaPeminjamanTextField.getText()+
                        "' where judul = '" + judulBukuComboBox.getSelectedItem() + "'";

                PreparedStatement pst = koneksi.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "berhasil disimpan");
                pst.close();
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void jenisBukuComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jenisBukuComboBoxItemStateChanged
        // TODO add your handling code here:
        judulBukuComboBox.removeAllItems();
        buka_koneksi();
        ResultSet rs = null;
        String ktgr = String.valueOf(jenisBukuComboBox.getSelectedItem());
        String sql = "SELECT judul from buku";
        try {
            PreparedStatement mStatement = koneksi.prepareStatement(sql);
            Statement state = koneksi.createStatement();
            rs =  state.executeQuery("select judul from buku where kategori = '" +ktgr+ "'");
            while (rs.next()) {                
                judulBukuComboBox.addItem(rs.getString("judul"));
            }
            mStatement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE); 
        }
    }//GEN-LAST:event_jenisBukuComboBoxItemStateChanged

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        LoginGUI s =  new LoginGUI();
        s.setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        new AdminGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void cancelTambahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelTambahButtonActionPerformed
        // TODO add your handling code here:
        new AdminGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelTambahButtonActionPerformed

    private void saveHapusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveHapusButtonActionPerformed
        // TODO add your handling code here:
        buka_koneksi();
            try {
                String sql = "delete from buku where judul='"+judulBukuHapusComboBox.getSelectedItem()+"'";
                PreparedStatement pst = koneksi.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "berhasil dihapus");
                pst.close();
                jenisBukuHapusComboBox.setSelectedItem("");
                judulBukuHapusComboBox.setSelectedItem("");
            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
    }//GEN-LAST:event_saveHapusButtonActionPerformed

    private void hapusDataBukuRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusDataBukuRadioButtonActionPerformed
        // TODO add your handling code here:
        jenisBukuHapusComboBox.setEnabled(true);
        judulBukuHapusComboBox.setEnabled(true);
        saveHapusButton.setEnabled(true);
        cancelHapusButton.setEnabled(true);
        logoutButton.setEnabled(true);
        jenisBukuComboBox.setEnabled(false);
        jenisBukuComboBox.removeAllItems();
        judulBukuComboBox.setEnabled(false);
        judulBukuComboBox.removeAllItems();
        jumlahBukuTextField.setEnabled(false);
        jumlahBukuTextField.setText("");
        biayaPeminjamanTextField.setEnabled(false);
        biayaPeminjamanTextField.setText("");
        dendaPeminjamanTextField.setEnabled(false);
        dendaPeminjamanTextField.setText("");
        saveButton.setEnabled(false);
        cancelButton.setEnabled(false);
        jenisBukuTambahComboBox.setEnabled(false);
        jenisBukuTambahComboBox.removeAllItems();
        judulTambahTextField.setEnabled(false);
        judulTambahTextField.removeAll();
        jumlahBukuTambahTextField.setEnabled(false);
        jumlahBukuTambahTextField.setText("");
        biayaPeminjamanTambahTextField.setEnabled(false);
        biayaPeminjamanTambahTextField.setText("");
        dendaPeminjamanTambahTextField.setEnabled(false);
        dendaPeminjamanTambahTextField.setText("");
        saveTambahButton.setEnabled(false);
        cancelTambahButton.setEnabled(false);
        isiComboBoxHapus();
    }//GEN-LAST:event_hapusDataBukuRadioButtonActionPerformed

    private void judulBukuComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_judulBukuComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_judulBukuComboBoxActionPerformed

    private void judulBukuHapusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_judulBukuHapusComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_judulBukuHapusComboBoxActionPerformed

    private void judulBukuHapusComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_judulBukuHapusComboBoxItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_judulBukuHapusComboBoxItemStateChanged

    private void jenisBukuHapusComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jenisBukuHapusComboBoxItemStateChanged
        // TODO add your handling code here:
        judulBukuHapusComboBox.removeAllItems();
        buka_koneksi();
        ResultSet rs = null;
        String ktgr = String.valueOf(jenisBukuHapusComboBox.getSelectedItem());
        String sql = "SELECT judul from buku";
        try {
            PreparedStatement mStatement = koneksi.prepareStatement(sql);
            Statement state = koneksi.createStatement();
            rs =  state.executeQuery("select judul from buku where kategori = '" +ktgr+ "'");
            while (rs.next()) {                
                judulBukuHapusComboBox.addItem(rs.getString("judul"));
            }
            mStatement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE); 
        }
    }//GEN-LAST:event_jenisBukuHapusComboBoxItemStateChanged

    private void cancelHapusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelHapusButtonActionPerformed
        // TODO add your handling code here:
        new AdminGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelHapusButtonActionPerformed

    private void dendaPeminjamanTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dendaPeminjamanTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dendaPeminjamanTextFieldActionPerformed

    private void biayaPeminjamanTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_biayaPeminjamanTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_biayaPeminjamanTextFieldActionPerformed

    private void judulBukuComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_judulBukuComboBoxItemStateChanged
        // TODO add your handling code here:
        Connector.buka_koneksi();
        ResultSet rs = null;
        String ktgr = String.valueOf(jenisBukuComboBox.getSelectedItem());
        String judul = String.valueOf(judulBukuComboBox.getSelectedItem());
        String sql = "select jml_buku, harga_sat, dendaKeterlambatan from buku";
        
        try {
            PreparedStatement mStatement = Connector.koneksi.prepareStatement(sql);
            Statement state = Connector.koneksi.createStatement();
            rs = state.executeQuery("select jml_buku, harga_sat, dendaKeterlambatan from buku where kategori = '" + ktgr + "' and judul ='" + judul + "'");
            while (rs.next()) {
                jml = rs.getInt("jml_buku");
                harga = rs.getInt("harga_sat");
                denda = rs.getInt("dendaKeterlambatan");
                jumlahBukuTextField.setText(jml + "");
                biayaPeminjamanTextField.setText(harga + "");
                dendaPeminjamanTextField.setText(denda + "");
            }
            mStatement.close();
        } catch (Exception l) {
            System.err.println(l);
        }
    }//GEN-LAST:event_judulBukuComboBoxItemStateChanged

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
    private javax.swing.JButton cancelHapusButton;
    private javax.swing.JButton cancelTambahButton;
    private javax.swing.JTextField dendaPeminjamanTambahTextField;
    private javax.swing.JTextField dendaPeminjamanTextField;
    private javax.swing.JRadioButton hapusDataBukuRadioButton;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelBiayaPeminjaman;
    private javax.swing.JLabel jLabelJenisBuku;
    private javax.swing.JLabel jLabelJudulBuku;
    private javax.swing.JLabel jLabelJumlahBuku;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> jenisBukuComboBox;
    private javax.swing.JComboBox<String> jenisBukuHapusComboBox;
    private javax.swing.JComboBox<String> jenisBukuTambahComboBox;
    private javax.swing.JComboBox<String> judulBukuComboBox;
    private javax.swing.JComboBox<String> judulBukuHapusComboBox;
    private javax.swing.JTextField judulTambahTextField;
    private javax.swing.JTextField jumlahBukuTambahTextField;
    private javax.swing.JTextField jumlahBukuTextField;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton saveHapusButton;
    private javax.swing.JButton saveTambahButton;
    private javax.swing.JRadioButton tambahDataBukuRadioButton;
    private javax.swing.JRadioButton ubahDataBukuRadioButton;
    // End of variables declaration//GEN-END:variables
}
