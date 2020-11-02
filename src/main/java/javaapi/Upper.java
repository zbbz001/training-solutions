package javaapi;

import java.util.Scanner;

public class Upper {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Adjon meg egy szöveg, amit nagybetűssé tehetek:");

        String inputString = scanner.nextLine();

        System.out.println("Nagybetűsen a beadott szöveg így néz ki: " + inputString.toUpperCase());


    }
}
