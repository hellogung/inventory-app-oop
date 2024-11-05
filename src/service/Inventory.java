package service;
import java.util.ArrayList;

import model.Kategori;
import model.Produk;

public class Inventory {
    // class Produk nya masih sementara
    private ArrayList<Produk> produkList;
    private ArrayList<Kategori> kategoriList;

    public Inventory() {
        produkList = new ArrayList<>();
        kategoriList = new ArrayList<>();
    }

    public boolean cekProduk(String kode) {
        for (int i = 0; i < produkList.size(); i++) {
            if (produkList.get(i).getKode().equalsIgnoreCase(kode)) {
                return true;
            }
        }
        return false;
    }

    public void tampilkanSemuaProduk() {
        if (produkList.isEmpty()) {
            System.out.println("Tidak ada produk.");
        } else {
            for (Produk produk : produkList) {
                System.out.println(produk);
            }
        }
    }

    public void tambahProduk(Produk produk) {
        String kode = produk.getKode();
        if (!this.cekProduk(kode)) {
            produkList.add(produk);
            System.out.println("Produk berhasil ditambahkan.");
            return;
        } else {
            System.out.println("Kode Produk harus unik " + kode);
            return;
        }
    }

    public Produk lihatProduk(String kode) {
        for (Produk produk : produkList) {
            if (produk.getKode().equalsIgnoreCase(kode)) {
                return produk;
            }
        }
        return null;
    }

    public void ubahProduk(String kode, Produk produkBaru) {
        String kodeBaru = produkBaru.getKode();
        for (int i = 0; i < produkList.size(); i++) {
            if (produkList.get(i).getKode().equalsIgnoreCase(kode)) {
                if (!this.cekProduk(kodeBaru)) {
                    produkList.set(i, produkBaru);
                    System.out.println("Produk berhasil diubah.");
                    return;
                } else {
                    System.out.println("Kode Produk harus unik " + kodeBaru);
                    return;
                }
            }
        }
        System.out.println("Produk tidak ditemukan.");
    }

    public void hapusProduk(String kode) {
        Produk produk = lihatProduk(kode);
        if (produk != null) {
            produkList.remove(produk);
            System.out.println("Produk berhasil dihapus.");
        } else {
            System.out.println("Produk tidak ditemukan.");
        }
    }
}
