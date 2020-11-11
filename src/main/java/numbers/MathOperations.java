package numbers;

import java.util.Scanner;

public class MathOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Mi az eredménye a 10 / 3 * 2 / 5 kifejezésnek?");
        double userResult = scanner.nextDouble();

        if(Math.abs((10.0/3.0*2.0/5.0) - userResult) < 1e-4) {
            System.out.println("ok");
        } else {
            System.out.println("nem ok");
        }
    }
}
