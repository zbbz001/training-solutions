package algorithmsmax.integers;

import java.util.List;

public class IntegerMaxCalculator {

    public int max(List<Integer> integerList) {
        int max = Integer.MIN_VALUE;

        for (int i : integerList) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

}
