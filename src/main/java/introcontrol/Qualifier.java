package introcontrol;

import java.util.Scanner;

public class Qualifier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Adjon meg egy számot!");

        int inputNumber = scanner.nextInt();

        System.out.println(inputNumber > 100 ? "nagyobb, mint száz" : "száz, vagy kisebb");

    }
}
