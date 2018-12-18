package gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import buku.InputData;
import buku.Item;
import database.DatabaseConnector;
import database.Conector;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.*;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author KINTUL
 */
public class TransaksiGUI extends javax.swing.JFrame {
    private static Connection koneksi;
    int code;
    int harga = 0;
    int total = 0;
    String dendastrng = null;
    DateFormat dateFormat;
    SimpleDateFormat simpleDateFormat;
    Date date, dtDate;
    InputData input;
    DefaultTableModel tabel;
    Item item;
    
    /**
     * Creates new form TransaksiGUI
     */
    public TransaksiGUI() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
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
        jTextFieldLamaPeminjaman.setEnabled(false);
        biayaTextField.setEnabled(false);
        dendaTextField.setEnabled(false);
        prosesButton.setEnabled(false);
        pinjamButton.setEnabled(false);
        jButtonSave.setEnabled(false);
        jButtonCancel.setEnabled(false);
        
        code = 0; //untuk code transaksi digit terakhir
        dateFormat = new SimpleDateFormat("yyMMdd"); //format tanggal untuk code transaksi
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	date = new Date();
        input = new InputData();
        
        
        
        jTextFieldLamaPeminjaman.addKeyListener(new KeyAdapter() {     
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c < 0))) {
                    e.consume();
                } else {
                    database.DatabaseConnector.setHarga(dendastrng, dendastrng);
                }
                
            }
        });
        
        jTextFieldLamaPeminjaman.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                warn();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                warn();
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                warn();
            }

            public void warn() {
                String ktgr = String.valueOf(kategoriBukuComboBox.getSelectedItem());
                String judul = String.valueOf(judulBukuComboBox.getSelectedItem());
                try {
                    int lamaPinjam = Integer.parseInt(jTextFieldLamaPeminjaman.getText());
                    biayaTextField.setText(String.valueOf(database.DatabaseConnector.setTotalBiaya(ktgr, judul, lamaPinjam)));
                } catch (Exception e) {
                    biayaTextField.setText(harga + "");
                }
                
            }
        });
                
        
        nomorPeminjamanPengembalian.getDocument().addDocumentListener(new DocumentListener() {
            private Object Days;
            @Override
            public void changedUpdate(DocumentEvent e) {
                warn();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                warn();
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                warn();
            }

            public void warn() {
                tanggalPeminjamanTextField.setText("");
                tanggalKembaliTextField.setText("");
                String nomorPinjam = nomorPeminjamanPengembalian.getText();
                database.DatabaseConnector.cekNomorPeminjaman(nomorPinjam);
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
                    tanggalPeminjamanTextField.setText(rs.getString("tanggalpinjam"));
                    tanggalKembaliTextField.setText(rs.getString("tanggalkembali"));
                    datekembali = sdf.parse(rs.getString("tanggalkembali"));
                    dendaterlambat = rs.getInt("dendaKeterlambatan");
                }
                
                if (datekembali.before(datenow)) {
//                    System.err.println("Date specified [" + datekembali + "] is before today [" + datenow + "]");
                    keterlambatanTextField.setText("Terlambat!");
                    long diffInMillies = Math.abs(datenow.getTime() - datekembali.getTime());
                    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                    int denda = (int)diff * dendaterlambat;
//                    var diffDays = Math.round(Math.abs((firstDate.getTime() - secondDate.getTime())/(oneDay)));
                    dendaTextField.setText(denda + "");
                } else {
//                    System.err.println("Date specified [" + datekembali + "] is NOT before today [" + datenow + "]");
                    keterlambatanTextField.setText("Tidak Terlambat");
                    dendaTextField.setText("-");
                }
                
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
                prosesButton.setEnabled(true);
                pinjamButton.setEnabled(false);
                jButtonSave.setEnabled(false);
                jButtonCancel.setEnabled(false);
            } catch (Exception e) {
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());
                tanggalPeminjamanTextField.setText("");
                tanggalKembaliTextField.setText("");
                }
            }
        });
        
        nomorPeminjamanPengembalian.addKeyListener(new KeyAdapter() {     
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE) || (c < 0))) {
                    e.consume();
                } else {
                }
                
            }
        });
    }

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
    
    private void isiComboBoxKategori(){
        buka_koneksi();
        ResultSet rs = null;
        String sql = "SELECT kategori from buku";
        try {
            PreparedStatement mStatement = koneksi.prepareStatement(sql);
            Statement state = koneksi.createStatement();
            rs =  state.executeQuery("select distinct kategori from buku");
            while (rs.next()) {                
                kategoriBukuComboBox.addItem(rs.getString("kategori"));
            }
            mStatement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE); 
        }
    }
    
    public final void LihatDataMahasiswa(){
        String[] namaKolom = {"Nomor Peminjaman", "Nama Mahasiswa", "Kategori Buku", "Judul Buku", "Lama Peminjaman",
            "Tanggal Penyewaan", "Tanggal Pengembalian", "Harga per hari", "Biaya Peminjaman"};
        Object[][] objekMahasiswa = new Object [input.getData().size()][namaKolom.length];
        int i = 0;
        for (Item item: input.getData()) {
            String arrayTransaksi[] = {String.valueOf(item.getCodePinjam()),
                                        item.getNamaMahasiswa(), item.getKategoriBuku(), item.getJudulBuku(),
                                        String.valueOf(item.getLamaPinjam()) + " Hari",
                                        String.valueOf(item.getTanggalPinjam()),
                                        String.valueOf(item.getTanggalKembali()),
                                        String.valueOf(item.getHarga()),
                                        String.valueOf(item.getBiaya())
                                        };
            objekMahasiswa[i] = arrayTransaksi;
            i++;
        }
        tabel = new DefaultTableModel(objekMahasiswa, namaKolom);
        tabelTransaksi.setModel(tabel);
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

        kategoriBukuComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                kategoriBukuComboBoxItemStateChanged(evt);
            }
        });
        kategoriBukuComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kategoriBukuComboBoxActionPerformed(evt);
            }
        });

        jLabelJenisBuku.setText("Kategori Buku");

        jLabelJudulBuku.setText("Judul Buku");

        biayaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                biayaTextFieldActionPerformed(evt);
            }
        });

        jLabelBiaya.setText("Biaya Peminjaman");

        pinjamButton.setText("Pinjam");
        pinjamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pinjamButtonActionPerformed(evt);
            }
        });

        nomorPeminjamanPengembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomorPeminjamanPengembalianActionPerformed(evt);
            }
        });
        nomorPeminjamanPengembalian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomorPeminjamanPengembalianKeyPressed(evt);
            }
        });

        jLabelNomorPeminjaman2.setText("Nomor Peminjaman");

        jLabelTanggalPeminjaman.setText("Tanggal Peminjaman");

        jLabelTanggalPengembalian.setText("Tanggal Pengembalian");

        jLabelKeterlambatan.setText("Keterlambatan");

        jLabelDenda.setText("Denda");

        prosesButton.setText("Proses");
        prosesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prosesButtonActionPerformed(evt);
            }
        });

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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        tabelTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelTransaksiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelTransaksi);

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

        nomorPeminjamanPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomorPeminjamanPeminjamanActionPerformed(evt);
            }
        });

        jLabelNomorPeminjaman.setText("Nomor Peminjaman");

        jLabel1.setText("Lama Peminjaman");

        jTextFieldLamaPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLamaPeminjamanActionPerformed(evt);
            }
        });
        jTextFieldLamaPeminjaman.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldLamaPeminjamanKeyTyped(evt);
            }
        });

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
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(pinjamButton)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jTextFieldLamaPeminjaman)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabelHari))
                                                .addComponent(biayaTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(jLabelNomorPeminjaman))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
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
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(249, 249, 249)
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
                .addGap(27, 27, 27)
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
        Conector.buka_koneksi();
        
        ResultSet rs = null;
        ResultSet in = null;
        ResultSet denda = null;
        
        String ktgr = String.valueOf(kategoriBukuComboBox.getSelectedItem());
        String judul = String.valueOf(judulBukuComboBox.getSelectedItem());
        String sql = "SELECT harga_sat from buku";
        String sql2 = "insert into dendaKeterlambatan from buku";
        String sql3 = "SELECT jml_buku from buku";
        try {
            PreparedStatement mStatement = koneksi.prepareStatement(sql);
            Statement state = koneksi.createStatement();
            rs =  state.executeQuery("select harga_sat from buku where kategori = '" +ktgr+ "' and judul ='" + judul + "'");
            while (rs.next()) {                
                harga = rs.getInt("harga_sat");
            }
            mStatement.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE); 
        }
        
        try {
            int tempjumlah = 0;
            PreparedStatement updateStatement = koneksi.prepareStatement(sql3);
            Statement state = koneksi.createStatement();
            rs = state.executeQuery("select jml_buku from buku where kategori = '" +ktgr+ "' and judul ='" + judul + "'");
            while (rs.next()) {                
                tempjumlah = rs.getInt("jml_buku");
            }
            
            String updatejmlbuku = "UPDATE `buku` SET `jml_buku`= " + (tempjumlah-1) + " WHERE kategori = '" +ktgr+ "' and judul ='" + judul + "'";
            PreparedStatement pst = koneksi.prepareStatement(updatejmlbuku);
            pst.execute();
            JOptionPane.showMessageDialog(null, "berhasil disimpan");
            pst.close();
        } catch (Exception e) {
            System.err.print(e);
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, Integer.parseInt(jTextFieldLamaPeminjaman.getText()));  // number of days to add
        String dt = sdf.format(c.getTime());  // dt is now the new date
        
        input.isiData(Integer.parseInt(nomorPeminjamanPeminjaman.getText()),
                      namaMahasiswaTextField.getText(),
                      String.valueOf(kategoriBukuComboBox.getSelectedItem()),
                      String.valueOf(judulBukuComboBox.getSelectedItem()),
                      Integer.parseInt(jTextFieldLamaPeminjaman.getText()),
                      sdf.format(date),
                      dt,
                      harga,
                      total
                      );
        LihatDataMahasiswa();
        
        try {
            buka_koneksi();
            Statement state = koneksi.createStatement();
            denda = state.executeQuery("select dendaKeterlambatan from buku where judul = '" 
                    + judul
                    + "' and kategori = '" + ktgr + "'");
            
            while (denda.next()) {                
                dendastrng = denda.getString("dendaKeterlambatan");
            }
            String sqlin = "INSERT INTO `datatransaksi`(`nomorPeminjam`, `nama`, `judul`, `tanggalpinjam`, `tanggalkembali`, `lamaPinjam`, `biaya`, `dendaKeterlambatan`)"
                    + " VALUES ("+ Integer.parseInt(nomorPeminjamanPeminjaman.getText()) + ",' "
                    + namaMahasiswaTextField.getText() +"', '"
                    + judulBukuComboBox.getSelectedItem() + "', "
                    + sdf2.format(date) + ", "
                    + sdf2.format(c.getTime()) + ", "
                    + Integer.parseInt(jTextFieldLamaPeminjaman.getText()) + ", "
                    + this.total + ", "
                    + Integer.parseInt(dendastrng) + ")";
            PreparedStatement mStatementIn = koneksi.prepareStatement(sqlin);
            mStatementIn.execute();
            mStatementIn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
      System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_pinjamButtonActionPerformed

    private void jRadioButtonPengembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPengembalianActionPerformed
        // TODO add your handling code here:
        tanggalKembaliTextField.setEnabled(false);
        tanggalPeminjamanTextField.setEnabled(false);
        nomorPeminjamanPengembalian.setEnabled(true);
        keterlambatanTextField.setEnabled(false);
        dendaTextField.setEnabled(false);
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
        new TransaksiGUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jRadioButtonPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPeminjamanActionPerformed
        nomorPeminjamanPeminjaman.setEnabled(false);
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
        pinjamButton.setEnabled(true);
        jButtonSave.setEnabled(false);
        jButtonCancel.setEnabled(false);
        
        nomorPeminjamanPeminjaman.setText(dateFormat.format(date)+String.format("%02d", code));
        isiComboBoxKategori();
    }//GEN-LAST:event_jRadioButtonPeminjamanActionPerformed

    private void kategoriBukuComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kategoriBukuComboBoxActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_kategoriBukuComboBoxActionPerformed

    private void kategoriBukuComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_kategoriBukuComboBoxItemStateChanged
        // TODO add your handling code here:
        judulBukuComboBox.removeAllItems();
        buka_koneksi();
        ResultSet rs = null;
        String ktgr = String.valueOf(kategoriBukuComboBox.getSelectedItem());
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
    }//GEN-LAST:event_kategoriBukuComboBoxItemStateChanged

    private void biayaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_biayaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_biayaTextFieldActionPerformed

    private void nomorPeminjamanPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomorPeminjamanPeminjamanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomorPeminjamanPeminjamanActionPerformed

    private void judulBukuComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_judulBukuComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_judulBukuComboBoxActionPerformed

    private void nomorPeminjamanPengembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomorPeminjamanPengembalianActionPerformed
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
    }//GEN-LAST:event_nomorPeminjamanPengembalianActionPerformed

    private void jTextFieldLamaPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLamaPeminjamanActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jTextFieldLamaPeminjamanActionPerformed

    private void jTextFieldLamaPeminjamanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldLamaPeminjamanKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextFieldLamaPeminjamanKeyTyped

    private void judulBukuComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_judulBukuComboBoxItemStateChanged
        // TODO add your handling code here:
                Conector.buka_koneksi();
                ResultSet rs = null;
                String ktgr = String.valueOf(kategoriBukuComboBox.getSelectedItem());
                String judul = String.valueOf(judulBukuComboBox.getSelectedItem());
                String sql = "SELECT harga_sat from buku";
                    
                try {
                    PreparedStatement mStatement = koneksi.prepareStatement(sql);
                    Statement state = koneksi.createStatement();
                    rs =  state.executeQuery("select harga_sat from buku where kategori = '" +ktgr+ "' and judul ='" + judul + "'");
                    while (rs.next()) {                
                        harga = rs.getInt("harga_sat");
                        biayaTextField.setText(harga + "");
                    }
                        
                    mStatement.close();
                } catch (Exception l) {
                    JOptionPane.showMessageDialog(null,"Failed to Connect to Database","Error Connection", JOptionPane.WARNING_MESSAGE); 
                }
    }//GEN-LAST:event_judulBukuComboBoxItemStateChanged

    private void tabelTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelTransaksiMouseClicked
        // TODO add your handling code here:
        boolean click =  tabelTransaksi.isEditing();
        if (click == false) { //Supaya tidak bisa mengedit tabel
            JOptionPane.showMessageDialog(this, "Cannot edit cell of table", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_tabelTransaksiMouseClicked

    private void nomorPeminjamanPengembalianKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomorPeminjamanPengembalianKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_nomorPeminjamanPengembalianKeyPressed

    private void prosesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prosesButtonActionPerformed
        // TODO add your handling code here:
        try {
            String sql1 = "SELECT judul from datatransaksi";
            String sql3 = "SELECT jml_buku from buku";
            
            int tempjumlah = 0;
            String judul = null;
            PreparedStatement getStatement = koneksi.prepareStatement(sql1);
            Statement state = koneksi.createStatement();
            ResultSet rs = state.executeQuery("select judul from datatransaksi where nomorPeminjam = '" + nomorPeminjamanPengembalian.getText() + "'");
            while (rs.next()) {             
                judul = rs.getString("judul");
            }
            
            Statement state2 = koneksi.createStatement();
            ResultSet rs2 = state2.executeQuery("select jml_buku from buku where judul = '" + judul + "'");
            while (rs2.next()) {             
                tempjumlah = rs2.getInt("jml_buku");
            }
            
            System.out.println(tempjumlah);
            PreparedStatement setStatement = koneksi.prepareStatement(sql3);
            String updatejmlbuku = "UPDATE `buku` SET `jml_buku`= " + (tempjumlah+1) + " WHERE judul ='" + judul + "'";
            PreparedStatement pst = koneksi.prepareStatement(updatejmlbuku);
            String deleteTransaksi = "DELETE FROM datatransaksi WHERE nomorPeminjam = '" + nomorPeminjamanPengembalian.getText() + "'";
            PreparedStatement pst2 = koneksi.prepareStatement(deleteTransaksi);
            pst.execute();
            pst2.execute();
            JOptionPane.showMessageDialog(null, "berhasil disimpan");
            pst.close();
            pst2.close();
        } catch (Exception e) {
            System.err.print(e);
        }
    }//GEN-LAST:event_prosesButtonActionPerformed

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
