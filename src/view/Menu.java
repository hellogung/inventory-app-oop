package view;

import java.util.Scanner;
import controller.InventoryController;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    private static InventoryController inventory = new InventoryController();

    public static void tampilkan() {

        boolean ulangi = true;

        while (ulangi) {
            try {
                System.out.println("Menu:");
                System.out.println("1. Tampilkan Semua Produk");
                System.out.println("2. Tambah Produk");
                System.out.println("3. Ubah Produk");
                System.out.println("4. Cari Produk");
                System.out.println("5. Hapus Produk");

                System.out.println("6. Lihat Semua Kategori dan Total Barang");
                System.out.println("7. Lihat Kategori Tertentu");
                System.out.println("8. Ubah Nama Kategori");

                System.out.println("9. Jual Barang");
                System.out.println("10. Beli Barang");

                System.out.println("11. Keluar");

                System.out.print("\nPilih menu: ");
                int pilihanMenu = Integer.parseInt(scanner.nextLine());
                System.out.println();

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

                    case 5:
                        inventory.hapusProduk();
                        break;

                    case 6:
                        inventory.lihatSemuaKategori();
                        break;
                    case 7:
                        inventory.lihatKategoriTertentu();
                        break;
                    case 8:
                        inventory.ubahKategori();
                        break;
                    case 9:
                        inventory.jualBarang();
                        break;
                    case 10:
                        inventory.beliBarang();
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
