package numbers;

import java.util.Scanner;

public class CircleMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Adja meg az 1. kör átmérőjét: ");
        Circle circleA = new Circle(scanner.nextInt());
        System.out.println(circleA);
        System.out.print("Adja meg az 2. kör átmérőjét: ");
        Circle circleB = new Circle(scanner.nextInt());
        System.out.println(circleB);
    }
}
