package controller;

import java.util.Scanner;

import model.Kategori;
import model.Produk;
import service.Inventory;

public class InventoryController {
    private Inventory inventory;
    private Scanner scanner;

    public InventoryController() {
        inventory = new Inventory();
        scanner = new Scanner(System.in);
    }

    public void tambahProduk() {
        System.out.print("Masukkan kode produk: ");
        String kode = scanner.nextLine();
        System.out.print("Masukkan nama produk: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan kategori produk: ");
        String kategori = scanner.nextLine();
        System.out.print("Masukkan stok produk: ");
        int stok = scanner.nextInt();
        System.out.print("Masukkan Harga satuan produk: ");
        double harga = scanner.nextDouble();
        scanner.nextLine();
        Produk produk = new Produk(kode, nama, kategori, stok, harga);
        inventory.tambahProduk(produk);
        inventory.tambahKategori(new Kategori(kategori));
    }

    public void tampilkanProduk() {
        inventory.tampilkanSemuaProduk();
    }

    public void cariProduk() {
        System.out.print("Masukkan kode produk yang dicari: ");
        String kode = scanner.nextLine();
        Produk produk = inventory.lihatProduk(kode);
        if (produk != null) {
            System.out.println("Produk ditemukan: " + produk);
        } else {
            System.out.println("Produk tidak ditemukan.");
        }
    }

    public void rubahProduk() {
        System.out.print("Masukkan kode produk yang ingin dirubah: ");
        String cekKode = scanner.nextLine();
        Produk oldProduk = inventory.lihatProduk(cekKode);

        if (oldProduk != null) {
            System.out.println("Produk ditemukan: " + oldProduk);
        } else {
            System.out.println("Produk tidak ditemukan.");
        }

        System.out.println("---------------------------------------------------------------");
        System.out.println("Silahkan masukkan data yang ingin dirubah");
        System.out.println();

        System.out.printf("Masukkan kode produk (%s): ", oldProduk.getKode());
        String kode = scanner.nextLine();
        kode = !"".equals(kode.trim()) ? kode : oldProduk.getKode();

        System.out.printf("Masukkan nama produk (%s): ", oldProduk.getNama());
        String nama = scanner.nextLine();
        nama = !"".equals(nama.trim()) ? nama : oldProduk.getNama();

        System.out.printf("Masukkan kategori produk (%s): ", oldProduk.getKategori());
        String kategori = scanner.nextLine();
        kategori = !"".equals(kategori.trim()) ? kategori : oldProduk.getKategori();

        System.out.printf("Masukkan stok produk (%s): ", oldProduk.getStok());
        String inputString = scanner.nextLine().replaceAll("[^0-9]", "");
        int stok = "".equals(inputString.trim()) ? oldProduk.getStok() : Integer.parseInt(inputString);

        System.out.printf("Masukkan Harga satuan produk (%s): ", oldProduk.getHarga());
        String inputString2 = scanner.nextLine().replaceAll("^[0-9]+\\.?[0-9]*$", "");
        double harga = "".equals(inputString2.trim()) ? oldProduk.getHarga() : Double.parseDouble(inputString2);

        Produk produk = new Produk(kode, nama, kategori, stok, harga);

        inventory.ubahProduk(cekKode, produk);
    }

    public void hapusProduk() {
        System.out.print("Masukkan kode produk yang ingin dihapus: ");
        String kodeProduk = scanner.nextLine();
        Produk produk = inventory.lihatProduk(kodeProduk);

        if (produk == null) {
            System.out.println("Produk tidak ditemukan.");
            return;
        }

        System.out.println(produk.toString());
        inventory.hapusProduk(kodeProduk);
        System.out.println("Produk .. berhasil dihapus");
    }

    public void lihatSemuaKategori() {
        inventory.tampilkanKategori();
    }

    public void lihatKategoriTertentu() {
        System.out.print("Masukkan kode produk: ");
        String kategori = scanner.nextLine();
        inventory.tampilkanKategoriTertentu(kategori);
    }

    public void ubahKategori() {
        System.out.print("Masukkan nama kategori sebelumnya: ");
        String kategoriLama = scanner.nextLine();
        System.out.print("Masukkan nama kategori yang ingin dirubah: ");
        String kategoriBaru = scanner.nextLine();

        inventory.ubahKategori(kategoriLama, kategoriBaru);
    }

    public void jualBarang() {
        System.out.print("Masukkan kode produk: ");
        String kodeProduk = scanner.nextLine();
        System.out.print("Masukkan jumlah stok yang dijual: ");
        int jumlah = Integer.parseInt(scanner.nextLine());

        inventory.transaksiPenjualan(kodeProduk, jumlah);
    }

    public void beliBarang() {
        System.out.print("Masukkan kode produk: ");
        String kodeProduk = scanner.nextLine();
        System.out.print("Masukkan jumlah stok yang dibeli: ");
        int jumlah = Integer.parseInt(scanner.nextLine());

        inventory.transaksiPembelian(kodeProduk, jumlah);
    }
}
