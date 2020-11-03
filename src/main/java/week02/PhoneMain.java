package week02;

import java.util.Scanner;

public class PhoneMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Adja meg a 'mem'-et legyen az bármi is");
        int memInput = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Adja meg a 'type'-ot, ami valami egész szám");
        String typeInput = scanner.nextLine();

        Phone phone = new Phone(typeInput, memInput);

        System.out.println("Ezt adta meg, mem: " + phone.getMem() + ", illetve type: " + phone.getType());

        System.out.println("Adja meg az új 'mem'-et legyen az bármi is");
        phone.setMem(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Adja meg az új 'type'-ot, ami valami egész szám");
        phone.setType(scanner.nextLine());

        System.out.println("Ezt adta meg másodjára, mem: " + phone.getMem() + ", illetve type: " + phone.getType());
    }
}
