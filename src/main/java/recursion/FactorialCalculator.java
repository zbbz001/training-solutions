package recursion;

public class FactorialCalculator {

    public int getFactorial(int number) {
        if(number > 1) {
            return number * getFactorial(number - 1);
        }

        return number;
    }

}
