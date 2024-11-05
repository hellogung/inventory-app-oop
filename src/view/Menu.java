package view;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void tampilkan() {

        System.out.println("Menu:");
        System.out.println("1. Tampilkan Semua Produk");
        System.out.println("2. Tambah Produk");
        System.out.println("3. Ubah Produk");
        System.out.println("4. Hapus Produk");

        System.out.println("5. Lihat Semua Kategori dan Total Barang");
        System.out.println("6. Lihat Kategori Tertentu");
        System.out.println("7. Ubah Nama Kategori");

        System.out.println("8. Jual Barang");
        System.out.println("9. Beli Barang");

        System.out.println("10. Keluar");

        System.out.print("Pilih menu: ");

        String pilihanMenu = scanner.nextLine();

        // 1. Tampilkan semua produk
        // 2. Tambah Produk
        // 3. Ubah Produk
        // 4. Hapus Produk

        // 5. Lihat Semua Kategori dan Total Barang
        // 6. Lihat Kategori Tertentu
        // 7. Ubah Nama Kategori

        // 8. Jual Barang
        // 9. Beli Barang

        // 10. Keluar
    }
}
