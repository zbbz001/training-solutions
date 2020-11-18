package week04;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();

        int thoughtNumber = rnd.nextInt(100) + 1;

        System.out.println("Gondoltam egy számra 1-100 között, találd ki!");

        int tipNumber = 0;

        while (thoughtNumber != tipNumber) {
            System.out.print("Tipp:");

            try {
                tipNumber = scanner.nextInt();

                if (thoughtNumber > tipNumber) {
                    System.out.println("Nem találd a gondolt szám nagyobb, próbáld újra!");
                } else if (thoughtNumber < tipNumber) {
                    System.out.println("Nem találd a gondolt szám kisebb, próbáld újra!");
                }
            } catch (Exception ime) {
                System.out.println("Na ez nem szám volt, próbáld újra!");
                scanner.nextLine();
            }
        }

        System.out.println("Nyertél");
    }
}
