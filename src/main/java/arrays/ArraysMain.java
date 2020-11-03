package arrays;

import java.util.Arrays;
import java.util.List;

public class ArraysMain {


    public static void main(String[] args) {
        ArraysMain arraysMain = new ArraysMain();

        System.out.println(arraysMain.numberOfDaysAsString());
        System.out.println();
        System.out.println(arraysMain.daysOfWeek());
        System.out.println();
        System.out.println(arraysMain.multiplicationTableAsString(5));
        System.out.println();
        System.out.println(arraysMain.sameTempValues(
                new double[] {12.5, 11.0, 11.1, 11.4, 13.8, 14.4, 11.2, 10.4, 9.1, 10.0, 14.4, 15.9, 12.5, 11.2, 11.9, 12.4, 13.7, 14.5, 11.2, 11.7, 15.2, 10.1, 14.3, 11.9 },
                new double[] {12.5, 11.0, 11.1, 11.4, 13.8, 14.4, 11.2, 10.4, 9.1, 10.0, 14.0, 15.9, 12.5, 11.2, 11.9, 12.4, 13.7, 14.5, 11.2, 11.7, 15.2, 10.1, 14.3, 11.9 }));
        System.out.println();

        int[] bets = {5,61,9,77,11};
        int[] draws = {4,61,7,1,91};

        System.out.println(Arrays.toString(bets));

        System.out.println(arraysMain.wonLottery(bets, draws));

        System.out.println(Arrays.toString(bets));
        System.out.println();

        System.out.println(arraysMain.sameTempValuesDaylight(
                new double[] {12.5, 11.0, 11.1, 11.4, 13.8, 14.4, 11.2, 10.4, 9.1, 10.0, 14.4, 15.9, 12.5, 11.2, 11.9, 12.4, 13.7, 14.5, 11.2, 11.7, 15.2, 10.1, 14.3, 11.9},
                new double[] {12.5, 11.0, 11.1, 11.4, 13.8, 14.4, 11.2, 10.4, 9.1, 10.0, 14.4, 15.9, 12.5, 11.2, 11.9, 12.4, 13.7, 14.5, 11.2, 11.7, 15.2, 10.1}));

    }

    public String numberOfDaysAsString() {
        int[] numberOfDays = {31,28,31,30,31,30,31,31,30,31,30,31};

        return Arrays.toString(numberOfDays);
    }

    public List<String> daysOfWeek() {
        String[] daysOfWeek = {"Monday", "Tuesday", "Thursday", "Wednesday", "Friday", "Saturday", "Sunday"};

        return Arrays.asList(daysOfWeek);
    }

    public String multiplicationTableAsString(int size) {
        int[][] multiplicationTable = new int[size][];

        for(int i = 0; i < size; i++) {
            multiplicationTable[i] = new int[size];
            for(int j = 0; j < size; j++) {
                multiplicationTable[i][j] = (i + 1) * (j + 1);
            }
        }

        return Arrays.deepToString(multiplicationTable);
    }

    public String sameTempValues(double[] day, double[] anotherDay) {
        return Arrays.equals(day, anotherDay) ? "Mindkét napon azonos hőmérséklet volt!" : "Eltérő hőmérsékletek voltak a megadott napokon!";
    }

    public boolean wonLottery(int[] bets, int[] draws) {
        int[] sortedBets = Arrays.copyOf(bets, bets.length);
        int[] sortedDraws = Arrays.copyOf(draws, draws.length);

        Arrays.sort(sortedBets);
        Arrays.sort(sortedDraws);

        return Arrays.equals(sortedBets, sortedDraws);
    }

    public String sameTempValuesDaylight(double[] day, double[] anotherDay) {
        int numOfHours = Math.min(day.length, anotherDay.length);
        //int numOfHours = day.length <= anotherDay.length ? day.length : anotherDay.length;
        //ok késöbb olvastam el az egész feladatot :)

        double[] rangeOfDay = Arrays.copyOfRange(day, 0, numOfHours);
        double[] rangeOfAnotherDay = Arrays.copyOfRange(anotherDay, 0, numOfHours);

        return Arrays.equals(rangeOfDay, rangeOfAnotherDay) ? "Mindkét napon azonos hőmérséklet volt!" : "Eltérő hőmérsékletek voltak a megadott napokon!";
    }
}
