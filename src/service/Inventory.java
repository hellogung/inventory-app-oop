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
                if (kode.equalsIgnoreCase(kodeBaru)) {
                    produkList.set(i, produkBaru);
                    System.out.println("Produk berhasil diubah.");
                    return;
                }

                if (!this.cekProduk(kodeBaru)) {
                    produkList.set(i, produkBaru);
                    System.out.println("Produk berhasil diubah.");
                    return;
                } else {
                    System.out.printf("kode produk '%s' sudah terpakai \n", kodeBaru);
                    return;
                }
            }
        }
        System.out.printf("Produk dengan kode %s tidak ditemukan \n", kode);
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

    // Memampilkan semua Kategori
    public void tampilkanKategori() {
        for (Kategori kategori : kategoriList) {
            System.out.println(kategori);
        }
    }

    // Mendapatkan detail kategori berdasarkan nama
    public Kategori detailKategori(String nama) {
        for (Kategori kategori : kategoriList) {
            if (kategori.getNama().equalsIgnoreCase(nama)) {
                return kategori;
            }
        }
        System.out.println("Kategori dengan nama : " + nama + ", tidak ditemukan.");
        return null;

    }

    // Mengubah nama Kategori
    public void ubahKategori(String namaLama, String namaBaru) {
        Kategori kategori = detailKategori(namaLama);
        if (kategori != null) {
            kategori.setNama(namaBaru);
            System.out.println("Kategori berhasil diubah menjadi: " + namaBaru);
        }
    }

    // Menjual produk dari stok
    // public void jualProduk(Produk produk, int qty) {
    //     if (produk.setStok(produk.getStok() - qty);
    //     System.out.println("Produk " +produk.getNama() + "berhasil dijual sebanyak " + qty + "unit");

    // }

    
    // Menambah kategori ke dalam inventory
    public void tambahKategori(Kategori kategori) {
        kategoriList.add(kategori);
    }
}
