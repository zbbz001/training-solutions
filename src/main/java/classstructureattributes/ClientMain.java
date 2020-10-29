package classstructureattributes;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hogy hívják?");
        client.name = scanner.nextLine();

        System.out.println("Melyik évben született?");
        client.year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Mi a címe?");
        client.address = scanner.nextLine();

        System.out.println("Na nézzük!");
        System.out.println("A neve: " + client.name);
        System.out.println(client.year + ". évben született");
        System.out.println("A címe pedig: " + client.address);
    }
}