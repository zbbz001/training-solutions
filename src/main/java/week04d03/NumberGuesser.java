package week04d03;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {
    private static final int MAX_ROUNDS = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();

        int thoughtNumber = rnd.nextInt(100) + 1;
        int rounds = 1;

        System.out.println("Gondoltam egy számra 1-100 között, találd ki!");

        int tipNumber = 1;

        while (thoughtNumber != tipNumber && rounds <= MAX_ROUNDS) {
            System.out.print("Tipp " + rounds + ". kör:");

            try {
                tipNumber = scanner.nextInt();

                if (thoughtNumber > tipNumber && rounds <= MAX_ROUNDS) {
                    System.out.println("Nem talált, a gondolt szám nagyobb, próbáld újra!");
                } else if (thoughtNumber < tipNumber && rounds <= MAX_ROUNDS) {
                    System.out.println("Nem talált, a gondolt szám kisebb, próbáld újra!");
                }

                rounds++;
            } catch (Exception ime) {
                System.out.println("Na ez nem szám volt, próbáld újra!");
                scanner.nextLine();
            }
        }

        if (thoughtNumber == tipNumber) {
            System.out.println("Nyertél!");
        } else {
            System.out.println("Vesztettél! A gondolot szám: " + thoughtNumber);
        }


    }
}
