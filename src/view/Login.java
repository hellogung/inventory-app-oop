package view;

import java.util.Scanner;

import service.Auth;
import utlis.clearScreen;

public class Login {
    private static Scanner scanner = new Scanner(System.in);
    private static Auth auth = new Auth();

    public static boolean login() {
        boolean authenticated = false;
        boolean ulangi = true;

        while (ulangi) {
            try {
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();

                authenticated = auth.login(username, password);

                if (authenticated) {
                    ulangi = false;
                    clearScreen.run();
                    System.out.println("--- LOGIN BERHASIL ---");
                    System.out.println("Selamat datang admin");
                    System.out.println();
                } else {
                    System.out.println("Login gagal. Coba lagi.");
                    ulangi = isLanjut();
                }

            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
                ulangi = false;
            }
        }

        return authenticated;
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
}
