package view;

import java.util.Scanner;
import controller.InventoryController;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    private static InventoryController inventory = new InventoryController();

    public static void tampilkan() {

        boolean ulangi = true;

        while (ulangi) {
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

            try {
                System.out.println("Menu:");
                System.out.println("1. Tampilkan Semua Produk");
                System.out.println("2. Tambah Produk");
                System.out.println("3. Ubah Produk");
                System.out.println("4. Cari Produk");
                System.out.println("5. Hapus Produk (Maintenance)");

                System.out.println("6. Lihat Semua Kategori dan Total Barang (Maintenance)");
                System.out.println("7. Lihat Kategori Tertentu (Maintenance)");
                System.out.println("8. Ubah Nama Kategori (Maintenance)");

                System.out.println("9. Jual Barang (Maintenance)");
                System.out.println("10. Beli Barang (Maintenance)");

                System.out.println("11. Keluar");

                System.out.print("Pilih menu: ");
                int pilihanMenu = Integer.parseInt(scanner.nextLine());

                switch (pilihanMenu) {
                    case 1:
                        inventory.tampilkanProduk();
                        break;

                    case 2:
                        inventory.tambahProduk();
                        break;

                    case 3:
                        inventory.rubahProduk();
                        break;

                    case 4:
                        inventory.cariProduk();
                        break;

                    case 11:
                        ulangi = false;
                        ucapkanTerimakasih();
                        break;

                    default:
                        System.out.println("Pilih menu yang tersedia");
                        break;
                }

                if (ulangi) {
                    ulangi = isLanjut();
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Pilih menu dengan benar.");
                continue;
            }

        }
    }

    public static boolean isLanjut() {
        boolean ulangi = true;
        boolean lanjut = false;

        while (ulangi) {
            try {
                System.out.print("\nApakah ingin lanjut lagi ? (Y/N) = ");
                String jawaban = scanner.nextLine().toUpperCase();
                lanjut = jawaban.equals("Y");
                if (jawaban.equals("Y")) {
                    lanjut = true;
                    ulangi = false;
                } else if (jawaban.equals("N")) {
                    lanjut = false;
                    ulangi = false;
                    ucapkanTerimakasih();
                } else {
                    System.out.println("Pilih Y/N saja.");
                    ulangi = true;
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(e.getMessage());
            }
        }

        return lanjut;
    }

    public static void ucapkanTerimakasih() {
        System.out.println("\nTerima kasih. Sampai ketemu lagi :)");
    }
}
