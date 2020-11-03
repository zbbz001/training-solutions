package introcontrol;

import java.util.Scanner;

public class UserMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Felhasználók listázása");
        System.out.println("2. Felhasználó felvétele");
        System.out.println("Többi: Kilépés");

        System.out.println();
        System.out.println("Válasszon menüpontot!");

        int menu = scanner.nextInt();

        if(menu == 1) {
            System.out.println("Felhasználók listázása");
        }

        if(menu == 2) {
            System.out.println("Felhasználó felvétele");
        }

    }
}
