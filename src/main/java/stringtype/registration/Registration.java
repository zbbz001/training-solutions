package stringtype.registration;

import java.util.Scanner;

public class Registration {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserValidator userValidator = new UserValidator();

        System.out.println("Adja meg a nevét:");
        String userName = scanner.nextLine();
        System.out.println("Adja meg a jelszót:");
        String userPassword1 = scanner.nextLine();
        System.out.println("Adja meg a jelszót mégegyszer:");
        String userPassword2 = scanner.nextLine();
        System.out.println("Adja meg az email címet:");
        String userEmail = scanner.nextLine();

        System.out.println("Az ellenőrzés utána");
        System.out.println("a neve: " + (userValidator.isValidUsername(userName) ? "helyes" : "helytelen, nem lehet üres"));
        System.out.println("a jelszava:"  + (userValidator.isValidPassword(userPassword1, userPassword2) ? "helyes" : "helytelen, nem egyeznek a megadott jelszavak"));
        System.out.println("az email címe: " + (userValidator.isValidEmail(userEmail) ? "helyes" : "helytelen"));
    }
}
