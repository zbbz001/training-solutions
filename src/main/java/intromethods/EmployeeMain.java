package intromethods;

import java.util.Scanner;

public class EmployeeMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee("Cody Coder", 1999, 3581);

        System.out.println(employee.toString());
        System.out.println();
        System.out.println("Adja meg, hogy " + employee.getName() + " megkorra fizetés emelést kapott:");
        employee.raiseSalery(scanner.nextInt());
        System.out.println();
        System.out.println("Fizetés emelés után az adatok:");
        System.out.println(employee.toString());
    }
}
