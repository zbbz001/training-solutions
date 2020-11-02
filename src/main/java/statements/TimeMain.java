package statements;

import java.util.Scanner;

public class TimeMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Adja meg az első időpont óráját: ");
        int firstTimeHours = scanner.nextInt();
        System.out.println("Adja meg az első időpont percét: ");
        int firstTimeMinutes = scanner.nextInt();
        System.out.println("És végül, adja meg az első időpont másodperceit: ");
        int firstTimeSeconds = scanner.nextInt();
        Time firstTime = new Time(firstTimeHours, firstTimeMinutes, firstTimeSeconds);


        System.out.println("Adja meg a második időpont óráját: ");
        int secondTimeHours = scanner.nextInt();
        System.out.println("Adja meg a második időpont percét: ");
        int secondTimeMinutes = scanner.nextInt();
        System.out.println("És végül, adja meg a második időpont másodperceit: ");
        int secondTimeSeconds = scanner.nextInt();
        Time secondTime = new Time(secondTimeHours, secondTimeMinutes, secondTimeSeconds);


        System.out.println("Az első időpont: " + firstTime.toString() +", ami " + firstTime.getInMinutes() + " perc");
        System.out.println("A második időpont: " + secondTime.toString() +", ami " + secondTime.getInMinutes() + " perc");
        System.out.println("Az első időpont korábbi, mint a második: " + firstTime.earlierThan(secondTime));
        System.out.println("A második időpont korábbi, mint az első: " + secondTime.earlierThan(firstTime));

    }
}
