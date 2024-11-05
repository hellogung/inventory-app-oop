import view.Menu;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("--- INVENTORY APP ---");
        Menu.tampilkan();
    }
}
