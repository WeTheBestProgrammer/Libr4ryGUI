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
    String jenisBuku;
    String judulBuku;
    int harga;

    public Item(String jenisBuku, String judulBuku, int harga) {
        this.jenisBuku = jenisBuku;
        this.judulBuku = judulBuku;
        this.harga = harga;
    }

    public String getJenisBuku() {
        return jenisBuku;
    }

    public void setJenisBuku(String jenisBuku) {
        this.jenisBuku = jenisBuku;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return this.jenisBuku;
    }
}