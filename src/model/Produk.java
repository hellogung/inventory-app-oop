package model;

abstract class Item {
    public String kode;
    public String nama;
    public String kategori;
    public int stok;
    public double harga;
    public double totalNilai;

    public Item(String kode, String nama, String kategori, int stok, double harga) {
        this.kode = kode;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
        this.kategori = kategori;
        this.totalNilai = harga * stok;
    }

    public abstract String toString();
}

public class Produk extends Item {

    public Produk(String kode, String nama, String kategori, int stok, double harga) {
        super(kode, nama, kategori, stok, harga);
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public String getKategori() {
        return kategori;
    }

    public int getStok() {
        return stok;
    }

    public double getHarga() {
        return harga;
    }

    public double getTotalNilai() {
        return totalNilai;
    }

    public void tambahStok(int kuantitas) {
        stok += kuantitas;
    }

    public boolean kurangiStok(int kuantitas) {
        if (stok >= kuantitas) {
            stok -= kuantitas;
            return true;
        } else {
            System.out.println("Stok tidak cukup");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Produk{" +
                " kode='" + kode + '\'' +
                ", nama='" + nama + '\'' +
                ", kategori='" + kategori + '\'' +
                ", stok='" + stok + '\'' +
                ", harga='" + harga + '\'' +
                ", totalNilai=" + totalNilai +
                " }";
    }
}
