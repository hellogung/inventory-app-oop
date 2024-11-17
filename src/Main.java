import utlis.clearScreen;
import view.Login;
import view.Menu;

public class Main {
    public static void main(String[] args) throws Exception {
        clearScreen.run();

        System.out.println("--- INVENTORY APP ---");

        if (Login.login()) {
            Menu.tampilkan();
        }

        System.out.println();
        System.out.println("--- PORGRAM BERAKHIR ---");
    }
}
