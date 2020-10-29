package classsctructuremethods;

import java.util.Scanner;

public class ClientMain {

    public static void main(String[] args) {
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hogy hívják?");
        client.setName(scanner.nextLine());
        System.out.println("Melyik évben született?");
        client.setYear(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Mi a címe?");
        client.setAddress(scanner.nextLine());
        System.out.println("Na nézzük mi tudunk!");
        System.out.println("A neve: " + client.getName());
        System.out.println(client.getYear() + ". évben született");
        System.out.println("A címe pedig: " + client.getAddress());
        System.out.println();
        System.out.println("Dehiszen már elköltözött, adja meg az új címét, de gyorsan!");
        client.migrate(scanner.nextLine());
        System.out.println("Na így már jó, címe helyesen: " + client.getAddress());
    }
}
