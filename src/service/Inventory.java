package service;

import java.util.ArrayList;

import model.Kategori;
import model.Produk;
import service.transaksi.Beli;
import service.transaksi.Jual;
import service.transaksi.Transaksi;

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
            tambahKategori(new Kategori(produk.getKategori()));
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
        int index = 1;
        System.out.println("Berikut list dari kategori:");
        for (Kategori kategori : kategoriList) {
            System.out.printf("%s. %s\n", index, kategori.getNama());
            index++;
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

    public void tampilkanKategoriTertentu(String kategori) {
        for (Produk produk : produkList) {
            if (produk.getKategori().equalsIgnoreCase(kategori)) {
                System.out.println(produk.toString());
            }
        }
    }

    // Mengubah nama Kategori
    public void ubahKategori(String namaLama, String namaBaru) {
        Kategori kategori = detailKategori(namaLama);
        if (kategori != null) {
            kategori.setNama(namaBaru);
            System.out.println("Kategori berhasil diubah menjadi: " + namaBaru);
        }
    }

    // Menambah kategori ke dalam inventory
    public void tambahKategori(Kategori kategori) {
        for (Kategori itemKategori : kategoriList) {
            if (itemKategori.getNama().equalsIgnoreCase(kategori.getNama())) {
                return;
            }
        }
        kategoriList.add(kategori);
    }

    // Transaksi Penjualan Produk
    public void transaksiPenjualan(String kode, int jumlah) {
        for (Produk produk : produkList) {
            if (!produk.getKode().equalsIgnoreCase(kode)) {
                System.out.println("Produk tidak ditemukan.");
                return;
            }
            Transaksi jual = new Jual(produk, jumlah);
            jual.proses();
        }
    }

    // Transaksi Pembelian
    public void transaksiPembelian(String kode, int jumlah) {
        for (Produk produk : produkList) {
            if (!produk.getKode().equalsIgnoreCase(kode)) {
                System.out.println("Produk tidak ditemukan.");
                return;
            }
            Transaksi beli = new Beli(produk, jumlah);
            beli.proses();
        }
    }
}
