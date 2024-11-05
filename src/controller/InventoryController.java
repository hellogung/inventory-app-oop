package controller;
import java.util.Scanner;

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
        Produk produk = new Produk(kode, nama, stok, harga, kategori);
        inventory.tambahProduk(produk);
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
        Produk produk = new Produk(kode, nama, stok, harga, kategori);

        inventory.ubahProduk(cekKode, produk);
    }
}
