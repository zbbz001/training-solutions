package introcontrol;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Adjon be egymás után öt számot");

        int sumNumber = 0;
        for (int i = 0; i < 5; i++) {
            sumNumber += scanner.nextInt();
        }

        System.out.println("A számok összege: " + sumNumber);
    }
}
