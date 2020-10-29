package classsctructureintegrate;

public class BankAccountMain {

    public static void main(String[] args) {

        BankAccount customerA = new BankAccount("000-000-001", "Cody Coder", 888888);
        BankAccount customerB = new BankAccount("900-900-900", "Rusty Hook", 700700);


        System.out.println("Na nézzük kinek mennyi pénze van:");
        System.out.println(customerA.getInfo());
        System.out.println(customerB.getInfo());
        System.out.println();

        System.out.println("Adjunk mindenkinek 5555 Ft-ot, és nézzük meg újra az egyenleget");
        customerA.deposit(5555);
        customerB.deposit(5555);
        System.out.println(customerA.getInfo());
        System.out.println(customerB.getInfo());
        System.out.println();

        System.out.println("Persze, mindenki elfelejtett befizetni a számláját!");
        System.out.println("Vonjuk hát le tölük a 417 Ft-ot, és nézzük meg mi maradt!");
        customerA.withdraw(417);
        customerB.withdraw(417);
        System.out.println(customerA.getInfo());
        System.out.println(customerB.getInfo());
        System.out.println();

        System.out.println(customerA.getOwner() + " egy arany ember, kölcsön adott 9417 Ft-ot " + customerB.getOwner() + "-nak, és így a számlájuk:");
        customerA.transfer(customerB, 9417);
        System.out.println(customerA.getInfo());
        System.out.println(customerB.getInfo());
        System.out.println();
    }
}
