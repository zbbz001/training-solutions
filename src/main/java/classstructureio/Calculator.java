package classstructureio;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Adjon meg egy számot: ");
        int szamA = scanner.nextInt();

        System.out.println("Adjon meg még egy számot: ");
        int szamB = scanner.nextInt();

        System.out.println(szamA + " + " + szamB);
        System.out.println(szamA + szamB);
    }
}
