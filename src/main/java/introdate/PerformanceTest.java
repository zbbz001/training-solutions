package introdate;

import java.time.LocalDate;
import java.time.LocalTime;

public class PerformanceTest {
    public static void main(String[] args) {

        Performance performance = new Performance("Deep Purple", LocalDate.of(1972, 01, 01), LocalTime.of(11,00), LocalTime.of(13,00));

        System.out.println(performance.getInfo());

    }
}
