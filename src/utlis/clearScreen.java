package utlis;

public class clearScreen {
    public static void run() {
        try {
            // Deteksi OS
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("windows")) {
                // Perintah untuk Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Perintah untuk Linux/Mac
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Gagal membersihkan layar: " + e.getMessage());
        }
    }
}
