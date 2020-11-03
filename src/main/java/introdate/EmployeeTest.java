package introdate;

import stringtype.registration.UserValidator;

import java.util.Scanner;

public class EmployeeTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Adja meg a dolgozó nevét: ");
        String employeeName = scanner.nextLine();
        System.out.println("Adja meg születési évet: ");
        int employeeYearOfBirth = scanner.nextInt();
        System.out.println("hónapot ");
        int employeeMonthOfBirth = scanner.nextInt();
        System.out.println("napot: ");
        int employeeDayOfBirth = scanner.nextInt();

        Employee employee = new Employee(employeeYearOfBirth, employeeMonthOfBirth, employeeDayOfBirth, employeeName);

        System.out.println("A dolgozó adatainak rögzítése után,");
        System.out.println("a neve: " + employee.getName());
        System.out.println("a születési dátuma: "  + employee.getDateOfBirth());
        System.out.println("munkába állás időpontja: "  + employee.getBeginEmployment());

    }

}
