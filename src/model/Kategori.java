package model;

import java.util.ArrayList;

// class Kategori
public class Kategori {
    private String nama;
    private ArrayList<Produk> produkList;

    public Kategori(String nama) {
        this.nama = nama;
        this.produkList = new ArrayList<>();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public ArrayList<Produk> getProdukList() {
        return produkList;
    }

    public void tambahProduk(Produk produk) {
        produkList.add(produk);
    }

    @Override
    public String toString() {
        return "Kategori: " + nama + ", Produk: " + produkList;
    }

}
