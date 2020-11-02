package statements;

import java.util.Scanner;

public class InvestMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Adja meg a befeketés összegét: ");
        int amount = scanner.nextInt();
        System.out.println("Adja meg a kamtlábat: ");
        int interestRate = scanner.nextInt();

        Investment investment = new Investment(amount, interestRate);

        System.out.println("Adja meg, hány nap hozamára kiváncs:");
        int investmentDays = scanner.nextInt();

        System.out.println("A hozam " + investmentDays + " nap utáni hozam: " + investment.getYield(investmentDays));

        System.out.println("Hány nap után zárja le a számlát:");
        int totalDays = scanner.nextInt();

        System.out.println("A hozammal növelt összeg " + totalDays + " nap után: " + investment.close(totalDays));

        System.out.println("A befektetés újbóli lezárása nem lehetséges, mert ebben az esetben a hozammal növelt összeg: " + investment.close(100));
    }
}
