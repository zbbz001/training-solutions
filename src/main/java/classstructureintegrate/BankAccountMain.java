package classstructureintegrate;

import java.util.Scanner;

public class BankAccountMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hogy hívják?");
        String accountOwnerA = scanner.nextLine();

        System.out.println("Mennyi pénzzel szeretné megnyiti a számlát?");
        int accountBalanceA = scanner.nextInt();

        BankAccount accountA = new BankAccount("000-000-001", accountOwnerA, accountBalanceA);
        System.out.println(accountA.getInfo());
        scanner.nextLine();
        System.out.println();


        System.out.println("Hogy hívják?");
        String accountOwnerB = scanner.nextLine();

        System.out.println("Mennyi pénzzel szeretné megnyiti a számlát?");
        int accountBalanceB = scanner.nextInt();

        BankAccount accountB = new BankAccount("900-900-900", accountOwnerB, accountBalanceB);
        System.out.println(accountB.getInfo());
        scanner.nextLine();
        System.out.println();


        System.out.println(accountOwnerA + ", mennyi szeretne utalni " + accountOwnerB + "-nek?");
        int transferAmount = scanner.nextInt();
        accountA.transfer(accountB, transferAmount);

        System.out.println(accountOwnerB + ", mennyi szeretne felvenni a számlájáról?");
        int withdraw = scanner.nextInt();
        accountB.withdraw(withdraw);
        scanner.nextLine();
        System.out.println();

        System.out.println("Persze, mindenki elfelejtett befizetni a számláját!");
        System.out.println("Vonjuk hát le tölük a 417 Ft-ot, és nézzük meg mi maradt!");
        accountA.withdraw(417);
        accountB.withdraw(417);
        System.out.println();

        System.out.println("Nap végi egyenlegek:");
        System.out.println(accountA.getInfo());
        System.out.println(accountB.getInfo());
        System.out.println();

    }
}
