package meetingrooms;

import java.util.Scanner;

public class Controller {
    Scanner scanner = new Scanner(System.in);
    Office office;

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.readOffice();
        controller.printMenu();
        controller.runMenu();
    }

    public void readOffice() {
        office = new Office();

        System.out.print("A rögzíteni kívánt tárgyalók darabszáma: ");
        int numOfOffice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        for (int i = 0; i < numOfOffice; i++) {
            System.out.println("Adja meg a(z) " + (i + 1) + ". tárgyaló adatait!");
            System.out.print("  neve: ");
            String name = scanner.nextLine();
            System.out.print("  szélessége: ");
            int width = scanner.nextInt();
            System.out.print("  hosszúsága: ");
            int length = scanner.nextInt();
            System.out.println();

            office.addMeetingRoom(new MeetingRoom(name, length, width));
            scanner.nextLine();
        }
    }

    public void printMenu() {
        System.out.println("1. Tárgyalók sorrendben");
        System.out.println("2. Tárgyalók visszafele sorrendben");
        System.out.println("3. Minden második tárgyaló");
        System.out.println("4. Területek");
        System.out.println("5. Keresés pontos név alapján");
        System.out.println("6. Keresés névtöredék alapján");
        System.out.println("7. Keresés terület alapján");
        System.out.println("9. Kilépés");
        System.out.println();
        System.out.print("Válasszon menüpontot: ");
    }

    public void runMenu() {
        int menuNumber = -1;

        while (menuNumber != 9) {
            menuNumber = scanner.nextInt();
            scanner.nextLine();

            if (menuNumber == 0) {
                printMenu();
            } else if (menuNumber == 1) {
                System.out.println();
                System.out.println("--- Tárgyalók sorrendben --- ");
                office.printNames();
            } else if (menuNumber == 2) {
                System.out.println();
                System.out.println("--- Tárgyalók visszafele sorrendben ---");
                office.printNamesReverse();
            } else if (menuNumber == 3) {
                System.out.println();
                System.out.println("--- Minden második tárgyaló ---");
                office.printEventNames();
            } else if (menuNumber == 4) {
                System.out.println();
                System.out.println("--- Területek ---");
                office.printAreas();
            } else if (menuNumber == 5) {
                System.out.println();
                System.out.println("--- Keresés pontos név alapján ---");
                System.out.print("Mi neve az irodának amit keres: ");
                String name = scanner.nextLine();
                office.printMeetingRoomsWithName(name);
            } else if (menuNumber == 6) {
                System.out.println();
                System.out.println("--- Keresés névtöredék alapján ---");
                System.out.print("Az iroda nevéből adjon meg egy részletet: ");
                String name = scanner.nextLine();
                office.printMeetingRoomsContains(name);
            } else if (menuNumber == 7) {
                System.out.println();
                System.out.println("--- Keresés terület alapján ---");
                System.out.print("Az iroda területe megkkora legyen legalább: ");
                int area = scanner.nextInt();
                scanner.nextLine();
                office.printAreasLargerThan(area);
            } else if (menuNumber == 9) {
                System.out.println();
                System.out.println("Egy öröm volt, viszlát!");
                break;
            } else {
                System.out.println("!!! A menüpont nem létezik! !!!");
                System.out.print("Válasszon menüpontot, a menü újbóli lehíváshoz használja a: 0-t: ");
                continue;
            }

            if(menuNumber != 0) {
                System.out.println();
                System.out.print("Válasszon menüpontot, a menü újbóli lehíváshoz használja a: 0-t: ");
            }
        }
    }

}
