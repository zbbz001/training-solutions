package finalmodifier;

import java.util.Arrays;
import java.util.List;

public class Week {
    public static final List<String> DAYNAMES = Arrays.asList("Monday", "Tuesday", "Thursday", "Wednesday", "Friday", "Saturday", "Sunday");
    public static final int A = 1;

    public static void main(String[] args) {
        final int noValue;

        System.out.println(DAYNAMES);
        DAYNAMES.set(0, "SUNDAY");
        DAYNAMES.set(1, "SUNDAY");
        DAYNAMES.set(2, "SUNDAY");
        DAYNAMES.set(3, "SUNDAY");
        DAYNAMES.set(4, "SUNDAY");
        DAYNAMES.set(5, "SUNDAY");
        System.out.println(DAYNAMES);

        //így már nem lehet új értéket adni
        //DAYNAMES = Arrays.asList("Monday", "Thursday", "Wednesday", "Friday", "Saturday", "Sunday");
    }
}
