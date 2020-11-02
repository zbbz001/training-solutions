package statements;

import java.util.Scanner;

public class DivByThree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Adjon meg egy számot:");

        int inputNumber = scanner.nextInt();

        System.out.println("A megadott szám: " + inputNumber + ", ami hárommal osztható-e: " + (inputNumber % 3 == 0 ? "igen" : "nem"));
    }
}
