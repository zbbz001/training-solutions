package week07d01;

public class Fibonacci {

    public long fib(int n) {
        long number1 = 0;
        long number2 = 1;
        long number3;
        int counter = 0;

        while (counter < n) {
            number3 = number1 + number2;
            number1 = number2;
            number2 = number3;
            counter++;
        }

        return number1;
    }
}
