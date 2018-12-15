package buku;
import java.util.ArrayList;
public class InputData {
    ArrayList<Item> ListMahasiswa;

    public InputData() {
        ListMahasiswa = new ArrayList();
    }

    public void isiData(int code, String nama, String kategori, String judul,
                        int lamaPinjam, String tanggalPinjam, String tanggalKembali,
                        int harga, int biaya){
        Item mhs = new Item(code, nama, kategori, judul, lamaPinjam, tanggalPinjam, tanggalKembali, harga, biaya);
        ListMahasiswa.add(mhs);
    }

    public ArrayList<Item> getData() {
        return ListMahasiswa;
    }
}