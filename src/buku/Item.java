/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buku;
/**
 *
 * @author Ahmad Musyadad A
 */
public class Item {
    int codePinjam, lamaPinjam, harga, biaya;
    String namaMahasiswa, kategoriBuku, judulBuku, tanggalPinjam, tanggalKembali;

    public Item(int codePinjam, String namaMahasiswa, String kategoriBuku, String judulBuku,
                int lamaPinjam, String tanggalPinjam, String tanggalKembali, int harga, int biaya) {
        this.codePinjam = codePinjam;
        this.lamaPinjam = lamaPinjam;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = tanggalKembali;
        this.harga = harga;
        this.biaya = biaya;
        this.namaMahasiswa = namaMahasiswa;
        this.kategoriBuku = kategoriBuku;
        this.judulBuku = judulBuku;
    }

    public int getCodePinjam() {
        return codePinjam;
    }

    public void setCodePinjam(int codePinjam) {
        this.codePinjam = codePinjam;
    }

    public int getLamaPinjam() {
        return lamaPinjam;
    }

    public void setLamaPinjam(int lamaPinjam) {
        this.lamaPinjam = lamaPinjam;
    }

    public String getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(String tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public String getTanggalKembali() {
        return tanggalKembali;
    }

    public void setTanggalKembali(String tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getBiaya() {
        return biaya;
    }

    public void setBiaya(int biaya) {
        this.biaya = biaya;
    }

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public void setNamaMahasiswa(String namaMahasiswa) {
        this.namaMahasiswa = namaMahasiswa;
    }

    public String getKategoriBuku() {
        return kategoriBuku;
    }

    public void setKategoriBuku(String kategoriBuku) {
        this.kategoriBuku = kategoriBuku;
    }


    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    @Override
    public String toString() {
        return this.kategoriBuku;
    }
}