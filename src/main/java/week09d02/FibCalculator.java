package week09d02;

public class FibCalculator {

    public long sumEvens(int bound) {
        long sum = 0;
        long a = 0;
        long b = 1;
        long c;

        while (sum + a < bound) {
            c = a + b;
            a = b;
            b = c;

            if (c % 2 == 0) {
                sum += c;
            }
        }

        return sum;
    }
}
