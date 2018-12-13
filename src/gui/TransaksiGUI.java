package gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.text.*;
import java.util.Date;
import javax.swing.*;
/**
 *
 * @author KINTUL
 */
public class TransaksiGUI extends javax.swing.JFrame {
    int code;
    DateFormat dateFormat;
    Date date;
    /**
     * Creates new form TransaksiGUI
     */
    public TransaksiGUI() {
        initComponents();
        ButtonGroup group = new ButtonGroup();
        group.add(jRadioButtonPeminjaman);
        group.add(jRadioButtonPengembalian);
        nomorPeminjamanPeminjaman.setEnabled(false);
        nomorPeminjamanPengembalian.setEnabled(false);
        namaMahasiswaTextField.setEnabled(false);
        tanggalPeminjamanTextField.setEnabled(false);
        tanggalKembaliTextField.setEnabled(false);
        kategoriBukuComboBox.setEnabled(false);
        judulBukuComboBox.setEnabled(false);
        keterlambatanTextField.setEnabled(false);
        biayaTextField.setEnabled(false);
        dendaTextField.setEnabled(false);
        prosesButton.setEnabled(false);
        pinjamButton.setEnabled(false);
        jButtonSave.setEnabled(false);
        jButtonCancel.setEnabled(false);
        
        code = 0; //untuk code transaksi digit terakhir
        dateFormat = new SimpleDateFormat("yyMMdd"); //format tanggal untuk code transaksi
	date = new Date();
    }

    private void isiComboJenis(){
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField4 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonGroup = new javax.swing.ButtonGroup();
        jLabelNamaMahasiswa = new javax.swing.JLabel();
        namaMahasiswaTextField = new javax.swing.JTextField();
        kategoriBukuComboBox = new javax.swing.JComboBox<>();
        jLabelJenisBuku = new javax.swing.JLabel();
        jLabelJudulBuku = new javax.swing.JLabel();
        biayaTextField = new javax.swing.JTextField();
        jLabelBiaya = new javax.swing.JLabel();
        pinjamButton = new javax.swing.JButton();
        nomorPeminjamanPengembalian = new javax.swing.JTextField();
        jLabelNomorPeminjaman2 = new javax.swing.JLabel();
        jLabelTanggalPeminjaman = new javax.swing.JLabel();
        tanggalPeminjamanTextField = new javax.swing.JTextField();
        jLabelTanggalPengembalian = new javax.swing.JLabel();
        tanggalKembaliTextField = new javax.swing.JTextField();
        keterlambatanTextField = new javax.swing.JTextField();
        jLabelKeterlambatan = new javax.swing.JLabel();
        dendaTextField = new javax.swing.JTextField();
        jLabelDenda = new javax.swing.JLabel();
        prosesButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelTransaksi = new javax.swing.JTable();
        judulBukuComboBox = new javax.swing.JComboBox<>();
        jRadioButtonPeminjaman = new javax.swing.JRadioButton();
        jRadioButtonPengembalian = new javax.swing.JRadioButton();
        jButtonSave = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        nomorPeminjamanPeminjaman = new javax.swing.JTextField();
        jLabelNomorPeminjaman = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldLamaPeminjaman = new javax.swing.JTextField();
        jLabelHari = new javax.swing.JLabel();

        jTextField4.setText("jTextField4");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelNamaMahasiswa.setText("Nama Mahasiswa");

        jLabelJenisBuku.setText("Kategori Buku");

        jLabelJudulBuku.setText("Judul Buku");

        jLabelBiaya.setText("Biaya Peminjaman");

        pinjamButton.setText("Pinjam");
        pinjamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pinjamButtonActionPerformed(evt);
            }
        });

        jLabelNomorPeminjaman2.setText("Nomor Peminjaman");

        jLabelTanggalPeminjaman.setText("Tanggal Peminjaman");

        jLabelTanggalPengembalian.setText("Tanggal Pengembalian");

        jLabelKeterlambatan.setText("Keterlambatan");

        jLabelDenda.setText("Denda");

        prosesButton.setText("Proses");

        tabelTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabelTransaksi);

        jRadioButtonPeminjaman.setText("Peminjaman");
        jRadioButtonPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPeminjamanActionPerformed(evt);
            }
        });

        jRadioButtonPengembalian.setText("Pengembalian");
        jRadioButtonPengembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPengembalianActionPerformed(evt);
            }
        });

        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jLabelNomorPeminjaman.setText("Nomor Peminjaman");

        jLabel1.setText("Lama Peminjaman");

        jLabelHari.setText("Hari");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(213, 213, 213)
                                .addComponent(jRadioButtonPeminjaman))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelNamaMahasiswa)
                                    .addComponent(jLabelJenisBuku)
                                    .addComponent(jLabelJudulBuku)
                                    .addComponent(jLabelBiaya)
                                    .addComponent(jLabel1))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(kategoriBukuComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(judulBukuComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(namaMahasiswaTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                                            .addComponent(nomorPeminjamanPeminjaman)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextFieldLamaPeminjaman)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabelHari))
                                            .addComponent(biayaTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabelNomorPeminjaman))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelTanggalPeminjaman)
                                    .addComponent(jLabelTanggalPengembalian)
                                    .addComponent(jLabelKeterlambatan)
                                    .addComponent(jLabelDenda))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(165, 165, 165)
                                        .addComponent(jRadioButtonPengembalian))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(prosesButton)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(tanggalKembaliTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(keterlambatanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(dendaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(tanggalPeminjamanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelNomorPeminjaman2)
                                .addGap(69, 69, 69)
                                .addComponent(nomorPeminjamanPengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(408, 408, 408)
                                .addComponent(pinjamButton)
                                .addGap(536, 536, 536))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonPeminjaman)
                    .addComponent(jRadioButtonPengembalian))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelNomorPeminjaman)
                        .addComponent(nomorPeminjamanPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelNomorPeminjaman2)
                        .addComponent(nomorPeminjamanPengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTanggalPeminjaman)
                            .addComponent(tanggalPeminjamanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTanggalPengembalian)
                            .addComponent(tanggalKembaliTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(keterlambatanTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelKeterlambatan))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dendaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDenda))
                        .addGap(16, 16, 16)
                        .addComponent(prosesButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNamaMahasiswa)
                            .addComponent(namaMahasiswaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelJenisBuku)
                            .addComponent(kategoriBukuComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelJudulBuku)
                            .addComponent(judulBukuComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldLamaPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelHari))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelBiaya)
                            .addComponent(biayaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(pinjamButton)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pinjamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pinjamButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pinjamButtonActionPerformed

    private void jRadioButtonPengembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPengembalianActionPerformed
        // TODO add your handling code here:
        tanggalKembaliTextField.setEnabled(true);
        tanggalPeminjamanTextField.setEnabled(true);
        nomorPeminjamanPengembalian.setEnabled(true);
        keterlambatanTextField.setEnabled(true);
        dendaTextField.setEnabled(true);
        nomorPeminjamanPeminjaman.setEnabled(false);
        kategoriBukuComboBox.setEnabled(false);
        judulBukuComboBox.setEnabled(false);
        namaMahasiswaTextField.setEnabled(false);
        biayaTextField.setEnabled(false);
        jTextFieldLamaPeminjaman.setEnabled(false);
        prosesButton.setEnabled(false);
        pinjamButton.setEnabled(false);
        jButtonSave.setEnabled(false);
        jButtonCancel.setEnabled(false);
    }//GEN-LAST:event_jRadioButtonPengembalianActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jRadioButtonPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPeminjamanActionPerformed
        nomorPeminjamanPeminjaman.setEnabled(true);
        kategoriBukuComboBox.setEnabled(true);
        judulBukuComboBox.setEnabled(true);
        namaMahasiswaTextField.setEnabled(true);
        biayaTextField.setEnabled(true);
        jTextFieldLamaPeminjaman.setEnabled(true);
        tanggalKembaliTextField.setEnabled(false);
        tanggalPeminjamanTextField.setEnabled(false);
        nomorPeminjamanPengembalian.setEnabled(false);
        keterlambatanTextField.setEnabled(false);
        dendaTextField.setEnabled(false);
        prosesButton.setEnabled(false);
        pinjamButton.setEnabled(false);
        jButtonSave.setEnabled(false);
        jButtonCancel.setEnabled(false);
        
        nomorPeminjamanPeminjaman.setText(dateFormat.format(date)+String.format("%02d", code));
    }//GEN-LAST:event_jRadioButtonPeminjamanActionPerformed

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
            java.util.logging.Logger.getLogger(TransaksiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransaksiGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField biayaTextField;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JTextField dendaTextField;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelBiaya;
    private javax.swing.JLabel jLabelDenda;
    private javax.swing.JLabel jLabelHari;
    private javax.swing.JLabel jLabelJenisBuku;
    private javax.swing.JLabel jLabelJudulBuku;
    private javax.swing.JLabel jLabelKeterlambatan;
    private javax.swing.JLabel jLabelNamaMahasiswa;
    private javax.swing.JLabel jLabelNomorPeminjaman;
    private javax.swing.JLabel jLabelNomorPeminjaman2;
    private javax.swing.JLabel jLabelTanggalPeminjaman;
    private javax.swing.JLabel jLabelTanggalPengembalian;
    private javax.swing.JRadioButton jRadioButtonPeminjaman;
    private javax.swing.JRadioButton jRadioButtonPengembalian;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextFieldLamaPeminjaman;
    private javax.swing.JComboBox<String> judulBukuComboBox;
    private javax.swing.JComboBox<String> kategoriBukuComboBox;
    private javax.swing.JTextField keterlambatanTextField;
    private javax.swing.JTextField namaMahasiswaTextField;
    private javax.swing.JTextField nomorPeminjamanPeminjaman;
    private javax.swing.JTextField nomorPeminjamanPengembalian;
    private javax.swing.JButton pinjamButton;
    private javax.swing.JButton prosesButton;
    private javax.swing.JTable tabelTransaksi;
    private javax.swing.JTextField tanggalKembaliTextField;
    private javax.swing.JTextField tanggalPeminjamanTextField;
    // End of variables declaration//GEN-END:variables
}
