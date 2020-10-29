package classstructureio;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hogy hívják?");
        String nev = scanner.nextLine();
        System.out.println("Mi az email címe?");
        String email = scanner.nextLine();

        System.out.println("Na nézzük!");
        System.out.println("A neve: " + nev);
        System.out.println("Az email címe: " + email);
    }
}
